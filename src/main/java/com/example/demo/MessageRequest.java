package com.example.demo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
// jackson (JSON serialization/deserialization library for java)
// jackson require no-arg constructor for deserialization
@NoArgsConstructor
public class MessageRequest {

	@Getter private String message;
}
