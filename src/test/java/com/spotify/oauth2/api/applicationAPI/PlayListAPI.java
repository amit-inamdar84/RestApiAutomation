package com.spotify.oauth2.api.applicationAPI;

import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.ConfigLoader;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static com.spotify.oauth2.api.TokenManager.getToken;
import static com.spotify.oauth2.api.Route.USERS;
import static com.spotify.oauth2.api.Route.PLAYLISTS;

//These methods can be reused for all playlist API requests
public class PlayListAPI {
	//static String access_token = "BQAijS1jhlwg28Jjk7b5Uw9O9VGc20VVrnEw2LtJC1i2nhTF8HITpkOLctxIvKuE9_wvIE8Mw_2GjmZhbBmUXwkv62VxaOAK_iZy5sH4phuyWsh5M1Q7_AiYcZCIz-x3hrm3kXyg_bcjhv6sEugRwW0t8gNhYTw8BsIxhBQLkLDMf5qDAAvvLpr1atGx77BUy2Af9ntrEqqAmpKWFARUiBpu0PF7TmMlAShH9jT4ikohAanVQNrwv2NJCLPqNf8e_08guC8i2r4mVALY";
	
	@Step
	public static Response post(Playlist requestPlaylist) {
		return RestResource.post(USERS + "/" + ConfigLoader.getInstance().getUser() + PLAYLISTS, getToken(), requestPlaylist);
	}
	
	public static Response post(String token, Playlist requestPlaylist) {
		return RestResource.post(USERS + "/" + ConfigLoader.getInstance().getUser() + PLAYLISTS, token, requestPlaylist);
	}
	
	public static Response get(String playlistID) {
		return RestResource.get(PLAYLISTS + "/" +playlistID, getToken());
	}
	
	public static Response update(Playlist requestPlaylist, String playlistID) {
		return RestResource.update(PLAYLISTS + "/" +playlistID, getToken(), requestPlaylist);
	}

}
