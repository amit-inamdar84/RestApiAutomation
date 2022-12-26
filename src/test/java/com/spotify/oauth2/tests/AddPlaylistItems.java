package com.spotify.oauth2.tests;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
//Practice of concepts learned in the course.
public class AddPlaylistItems {
	@Test
	public void addItemsToPlaylist() {
		Header header = new Header("Content-Type", "application/json");
		String token="Bearer BQDUo2X77fDbji979N5XX1T9EcmYJ294gKR4GSijhYG0m8YGhjjw0Vs6HXs5ed5lXMkiza0SL6_fH-XkciQyc02Rlr1ZSfbL8-RUmbXwYuPzIuUvtEyuqBuIRAU17xrZW5_k_b79SEOQJ6RKrnHZQz1IDICkLmC9h3lBcTBLE95m9wHoxvgMNnpbEN-9QCB60n2dczWQtwu_2nnK3v8mpppNy6gLSheWWjxInZFfRSKA9GdOm9WozXgK8U1EQpjEz3KjVzrKSpPl06zR";
		String payload="{\r\n"
				+ "  \"uris\": [\r\n"
				+ "    \"spotify:track:4iV5W9uYEdYUVa79Axb7Rh\"\r\n"
				+ "  ],\r\n"
				+ "  \"position\": 0\r\n"
				+ "}";
		Response response = given().
		        baseUri("https://api.spotify.com/v1").
		        header("Authorization" , token).
		        header(header).
		        //contentType(ContentType.JSON).
		        body(payload).
		        log().all().
		when().
		        post("/playlists/2DS6oEwmhMy86d0YOzFp9I/tracks").
		then().
		        log().all().
                assertThat().
                statusCode(201).
                extract().
                response();
		System.out.println("Printing response:-----" +response.asString());
		System.out.println("Extracting single field:----"+response.path("snapshot_id"));
	}
	
	@Test
	public void addItemsToPlaylist1() {
		String token="Bearer BQDUo2X77fDbji979N5XX1T9EcmYJ294gKR4GSijhYG0m8YGhjjw0Vs6HXs5ed5lXMkiza0SL6_fH-XkciQyc02Rlr1ZSfbL8-RUmbXwYuPzIuUvtEyuqBuIRAU17xrZW5_k_b79SEOQJ6RKrnHZQz1IDICkLmC9h3lBcTBLE95m9wHoxvgMNnpbEN-9QCB60n2dczWQtwu_2nnK3v8mpppNy6gLSheWWjxInZFfRSKA9GdOm9WozXgK8U1EQpjEz3KjVzrKSpPl06zR";
		String payload="{\r\n"
				+ "  \"uris\": [\r\n"
				+ "    \"spotify:track:11dFghVXANMlKmJXsNCbNl\"\r\n"
				+ "  ],\r\n"
				+ "  \"position\": 0\r\n"
				+ "}";
		Headers extractHeader = given().
		        baseUri("https://api.spotify.com/v1").
		        header("Authorization" , token).
		        contentType(ContentType.JSON).
		        body(payload).
		        log().all().
		when().
		        post("/playlists/2DS6oEwmhMy86d0YOzFp9I/tracks").
		then().
		        log().all().
                assertThat().
                statusCode(201).
                extract().
                headers();
		System.out.println("Extract response header name: "+extractHeader.get("date").getName());
		System.out.println("Extract response header value: "+extractHeader.get("date").getValue());
		
		for(Header header: extractHeader) {
			System.out.print("Header name: "+header.getName()+ " , ");
			System.out.println("Header value: "+header.getValue());
		}
		
	}

}
