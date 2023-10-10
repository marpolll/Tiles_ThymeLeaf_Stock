package com.marpol.thtest.exec;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import groovy.util.logging.Slf4j;

@Slf4j
public class Exec {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://api.bithumb.com/public/ticker/ALL_KRW"))
				.header("accept", "application/json")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(response.body());
	}
	

}
