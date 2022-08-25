package com.spotify.oauth2.tests;


import org.testng.annotations.Test;

import com.spotify.oauth2.api.applicationAPI.PlayListAPI;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.DataLoader;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
//Moved this code to PlaylistTests.java as taught by tutor. Need to revisit later how handle token renewal issue with separate test class files.

public class UpdatePlaylist {
	/*
	 * 
	 * @Test public void update_playlist() { Playlist requestPlaylist = new
	 * Playlist(). setName("Modern Playlist"). setDescription("Updated playlist").
	 * setPublic(false);
	 * 
	 * Response response = PlayListAPI.update(requestPlaylist,
	 * DataLoader.getInstance().getUpdatePlaylistId());
	 * assertThat(response.statusCode(), equalTo(200));
	 * 
	 * }
	 * 
	 */}
