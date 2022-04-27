package com.example.demo.config;

import org.springframework.kafka.core.KafkaTemplate;

import twitter4j.*;

public class TwitterClient {

	private KafkaTemplate<String, String> kafkaTemplate;
	private String keyword;
	
	public TwitterClient (KafkaTemplate<String, String> kafkaTemplate, String keyword){
		this.kafkaTemplate = kafkaTemplate;
		this.keyword = keyword;
	}
	
	private StatusListener listener = new StatusListener() {
	    public void onStatus(Status status) {
	    	kafkaTemplate.send("twitter", status.getText());
	    }
	    @Override
	    public void onScrubGeo(long userId, long upToStatusId) {}

	    @Override
	    public void onStallWarning(StallWarning stallWarning) {}

	    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
	    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
	    public void onException(Exception ex) {
	        ex.printStackTrace();
	    }
	};
	
	public void getFilteredTweets() throws TwitterException {	
		TwitterStreamFactory tsf = new TwitterStreamFactory(); 
		TwitterStream twitterStream = tsf.getInstance();
		twitterStream.addListener(listener);
		FilterQuery query = new FilterQuery(keyword);
		twitterStream.filter(query);
	}
	    
}
