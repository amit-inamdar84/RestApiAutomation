package com.spotify.oauth2.api;

import static com.spotify.oauth2.api.SpecBuilder.getRequestSpec;
import static com.spotify.oauth2.api.SpecBuilder.getResponseSpec;
import static com.spotify.oauth2.api.SpecBuilder.getResponseSpecWithoutContentType;
import static com.spotify.oauth2.api.SpecBuilder.getAccountRequestSpec;
import static io.restassured.RestAssured.given;
import static com.spotify.oauth2.api.Route.API;
import static com.spotify.oauth2.api.Route.TOKEN;

import java.util.HashMap;

import io.restassured.response.Response;

//These methods can be reused for all requests in general
public class RestResource {
	public static Response post(String path, String token, Object requestPlaylist) {
		return   given(getRequestSpec()).
			     body(requestPlaylist).
			     auth().oauth2(token).
			     //header("Authorization","Bearer " +token).//Can pass above method as well.
			when().post(path).
			then().spec(SpecBuilder.getResponseSpec()).
			     extract().
			     response();
	}
	
	public static Response get(String path, String token) {
		        return given(getRequestSpec()).
		        		auth().oauth2(token).
		        		//header("Authorization","Bearer " +token).
				when().get(path).
				then().spec(getResponseSpec()).
				     extract().
				     response();
	}
	
	public static Response update(String path, String token, Object requestPlaylist) {
		return given(getRequestSpec()).
		           body(requestPlaylist).
		           auth().oauth2(token).
		           //header("Authorization","Bearer " +token).
		    when().put(path).
		    then().spec(getResponseSpecWithoutContentType()).
		    extract().
		    response();
	}
	
	public static Response postAccount(HashMap<String, String> formParams) {
                return given(getAccountRequestSpec()).
        		formParams(formParams).
        		when().post(API + TOKEN).
        		then().spec(SpecBuilder.getResponseSpec()).
        		extract().
        		response();
	}

}
