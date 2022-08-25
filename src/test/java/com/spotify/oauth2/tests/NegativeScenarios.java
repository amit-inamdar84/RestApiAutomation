package com.spotify.oauth2.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

import com.spotify.oauth2.api.applicationAPI.PlayListAPI;
import com.spotify.oauth2.pojo.ErrorRoot;
import com.spotify.oauth2.pojo.Playlist;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.spotify.oauth2.api.SpecBuilder.getRequestSpec;
import static com.spotify.oauth2.api.SpecBuilder.getResponseSpec;
//Moved this code to PlaylistTests.java as taught by tutor. Need to revisit later how handle token renewal issue with separate test class files.

public class NegativeScenarios {
	/*
	 * //Need to practice more negative scenarios
	 * 
	 * @Test public void createEmptyPlaylist() { Playlist requestPlaylist = new
	 * Playlist(). setName(""). setDescription("Updated playlist").
	 * setPublic(false);
	 * 
	 * Response response = PlayListAPI.post(requestPlaylist);
	 * assertThat(response.statusCode(), equalTo(400));
	 * 
	 * ErrorRoot responseError = response.as(ErrorRoot.class);
	 * assertThat(responseError.getError().getStatus(), equalTo(400));
	 * assertThat(responseError.getError().getMessage(),
	 * equalTo("Missing required field: name"));
	 * 
	 * body("error.status", equalTo(400), "error.message",
	 * equalTo("Missing required field: name"));
	 * 
	 * }
	 * 
	 * @Test public void create_Playlist_With_ExpiredToken() { String access_token =
	 * "12345"; Playlist requestPlaylist = new Playlist().
	 * setName("Automated Playlist").
	 * setDescription("New rest assured playlist for learning"). setPublic(false);
	 * 
	 * Response response = PlayListAPI.post(access_token, requestPlaylist);
	 * assertThat(response.statusCode(), equalTo(401));
	 * 
	 * ErrorRoot responseError = response.as(ErrorRoot.class);
	 * assertThat(responseError.getError().getStatus(), equalTo(401));
	 * assertThat(responseError.getError().getMessage(),
	 * equalTo("Invalid access token"));
	 * 
	 * body("error.status", equalTo(401), "error.message",
	 * equalTo("Invalid access token"));
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 */}
