package com.spotify.oauth2.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.Test;

import com.spotify.oauth2.api.StatusCode;
import com.spotify.oauth2.api.applicationAPI.PlayListAPI;
import com.spotify.oauth2.pojo.ErrorRoot;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.DataLoader;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static com.spotify.oauth2.utils.FakerUtils.generateName;
import static com.spotify.oauth2.utils.FakerUtils.generateDescription;;

public class PlaylistTests extends BaseTest{
	@Story("As a user, should be able to create a new playlist so that I can add songs to it")
	@Link("https://example.org")
	@Link(name = "allure", type= "myLink")
	@TmsLink("12345")
	@Issue("1234567")
	@Description("This test case will create a new spotify playlist")
	@Test(description = "Create a new spotify playlist")
	public void createPlaylist() {
		Playlist requestPlaylist = playListBuilder(generateName(), generateDescription(), false);
		
		Response response = PlayListAPI.post(requestPlaylist);
		assertStatusCode(response.statusCode(), StatusCode.CODE_201.getCode());
		
		assertPlaylistEqual(response.as(Playlist.class), requestPlaylist);
		          
	}
	
	@Test(description = "Get a spotify playlist")
	public void get_A_Playlist() {
		Playlist requestPlaylist = playListBuilder("Modern Playlist", "Updated playlist", false);

		Response response = PlayListAPI.get(DataLoader.getInstance().getGetPlaylistId());
		assertStatusCode(response.statusCode(), StatusCode.CODE_200.getCode());
		assertPlaylistEqual(response.as(Playlist.class), requestPlaylist);	          
	}
	
	@Test(description = "Update a spotify playlist")
	public void update_playlist() {
		Playlist requestPlaylist = playListBuilder("Modern Playlist", "Updated playlist", false);
		
		Response response = PlayListAPI.update(requestPlaylist, DataLoader.getInstance().getUpdatePlaylistId());
		assertStatusCode(response.statusCode(), StatusCode.CODE_200.getCode());
		
	}
	
	//Need to practice more negative scenarios
	@Test(description = "Create empty playlist")
	public void createEmptyPlaylist() {
		Playlist requestPlaylist = playListBuilder("", generateDescription(), false);
		
		Response response = PlayListAPI.post(requestPlaylist);
		assertStatusCode(response.statusCode(), StatusCode.CODE_400.getCode());
		
		assertError(response.as(ErrorRoot.class), StatusCode.CODE_400.getCode(), StatusCode.CODE_400.getMsg());
	}
	
	@Test(description = "Create playlist with expired token")
	public void create_Playlist_With_ExpiredToken() {
		String access_token = "12345";
		Playlist requestPlaylist = playListBuilder(generateName(), generateDescription(), false);
		
		Response response = PlayListAPI.post(access_token, requestPlaylist);
		assertStatusCode(response.statusCode(), StatusCode.CODE_401.getCode());
		
		assertError(response.as(ErrorRoot.class), StatusCode.CODE_401.getCode(), StatusCode.CODE_401.getMsg());
	}
	
	@Step
	public Playlist playListBuilder(String name, String description, boolean ispublic) {
		return Playlist.builder().
		name(name).
		description(description).
		_public(ispublic).
		build();
	}
	
	@Step
	public void assertPlaylistEqual(Playlist responsePlaylist, Playlist requestPlaylist) {
		assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
		assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
		assertThat(responsePlaylist.get_public(), equalTo(requestPlaylist.get_public()));
	}
	
	@Step
	public void assertStatusCode(int actualStatusCode, int expectedStatusCode) {
		assertThat(actualStatusCode, equalTo(expectedStatusCode));
	}
	
	public void assertError(ErrorRoot responseError, int expectedStatusCode, String expectedMessage) {
		assertThat(responseError.getError().getStatus(), equalTo(expectedStatusCode));
		assertThat(responseError.getError().getMessage(), equalTo(expectedMessage));
	}
}
