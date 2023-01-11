package api.automation.spotify.oauth2;

import api.automation.spotify.oauth2.service.PlaylistAPI;
import api.automation.spotify.oauth2.pojo.Error;
import api.automation.spotify.oauth2.pojo.Playlist;
import api.automation.spotify.oauth2.util.DataLoader;
import api.automation.spotify.oauth2.util.StatusCode;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static api.automation.spotify.oauth2.util.FakerUtil.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Epic("Spotify OAuth 2.0")
@Feature("Playlist API")
public class PlaylistTest extends ParallelRunCheckTest {

    @Story("Create a playlist story")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @TmsLink("test case link")
    @Issue("bug 12345678")
    @Description("this is the description...")
    @Test(description = "should be able to create a playlist")
    public void testNewPlaylistIsCreated() {
        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), false);
        Response response = PlaylistAPI.post(requestPlaylist);
        assertStatusCode(response.getStatusCode(), StatusCode.CODE_201);
        assertPlaylistsAreEqual(response.as(Playlist.class), requestPlaylist);
    }

    @Story("Get a playlist story")
    @Test
    public void testPlaylistIsObtained() {
        Playlist requestPlaylist = playlistBuilder("New Playlist 3", "New playlist 3 description", false);
        Response response = PlaylistAPI.get(DataLoader.getInstance().getGetPlaylistId());
        assertStatusCode(response.getStatusCode(), StatusCode.CODE_200);
        assertPlaylistsAreEqual(response.as(Playlist.class), requestPlaylist);
    }

    @Story("Update a playlist story")
    @Test
    public void testPlaylistIsUpdated() {
        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), false);
        Response response = PlaylistAPI.update(DataLoader.getInstance().getUpdatePlaylistId(), requestPlaylist);
        assertStatusCode(response.getStatusCode(), StatusCode.CODE_200);
    }

    @Story("Create a playlist story")
    @Test
    public void testNewPlaylistWithoutNameIsNotCreated() {
        Playlist requestPlaylist = playlistBuilder("", generateDescription(), false);
        Response response = PlaylistAPI.post(requestPlaylist);
        assertStatusCode(response.getStatusCode(), StatusCode.CODE_400);
        assertError(response.as(Error.class), StatusCode.CODE_400);
    }

    @Story("Create a playlist story")
    @Test
    public void testNewPlaylistWithExpiredTokenIsNotCreated() {
        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), false);
        Response response = PlaylistAPI.post(generateInvalidToken(), requestPlaylist);
        assertStatusCode(response.getStatusCode(), StatusCode.CODE_401);
        assertError(response.as(Error.class), StatusCode.CODE_401);
    }

    @Step
    private Playlist playlistBuilder(String name, String description, boolean isPublic) {
        return Playlist.builder()
                .name(name)
                .description(description)
                .isPublic(isPublic)
                .build();
    }

    @Step
    private void assertPlaylistsAreEqual(Playlist responsePlaylist, Playlist requestPlaylist) {
        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getIsPublic(), equalTo(requestPlaylist.getIsPublic()));
    }

    @Step
    private void assertStatusCode(int actualStatusCode, StatusCode statusCode) {
        assertThat(actualStatusCode, equalTo(statusCode.code));
    }

    private void assertError(Error responseError, StatusCode statusCode) {
        assertThat(responseError.getInnerError().getStatus(), equalTo(statusCode.code));
        assertThat(responseError.getInnerError().getMessage(), equalTo(statusCode.message));
    }
}
