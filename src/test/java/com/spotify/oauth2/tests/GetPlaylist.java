package com.spotify.oauth2.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

import com.spotify.oauth2.api.applicationAPI.PlayListAPI;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.DataLoader;

import io.restassured.response.Response;
//Moved this code to PlaylistTests.java as taught by tutor. Need to revisit later how handle token renewal issue with separate test class files.

public class GetPlaylist {
	/*
	 * 
	 * @Test public void get_A_Playlist() { Playlist requestPlaylist = new
	 * Playlist(). setName("Modern Playlist"). setDescription("Updated playlist").
	 * setPublic(false);
	 * 
	 * Response response =
	 * PlayListAPI.get(DataLoader.getInstance().getGetPlaylistId());
	 * assertThat(response.statusCode(), equalTo(200)); Playlist responsePlaylist =
	 * response.as(Playlist.class);
	 * 
	 * assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
	 * assertThat(responsePlaylist.getDescription(),
	 * equalTo(requestPlaylist.getDescription()));
	 * assertThat(responsePlaylist.getPublic(),
	 * equalTo(requestPlaylist.getPublic()));
	 * 
	 * }
	 * 
	 */}
