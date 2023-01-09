package api.automation.spotify.oauth2;

import api.automation.spotify.oauth2.api.PlaylistAPI;
import api.automation.spotify.oauth2.pojo.Error;
import api.automation.spotify.oauth2.pojo.Playlist;
import api.automation.spotify.oauth2.util.DataLoader;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PlaylistTest {

    @Test
    public void testNewPlaylistIsCreated() {
        Playlist requestPlaylist = playlistBuilder("New Playlist 33", "Short description", false);

        Response response = PlaylistAPI.post(requestPlaylist);
        assertStatusCode(response.getStatusCode(), 201);
        assertPlaylistsAreEqual(response.as(Playlist.class), requestPlaylist);
    }

    @Test
    public void testPlaylistIsObtained() {
        Playlist requestPlaylist = playlistBuilder("New Playlist 3", "New playlist 3 description", false);

        Response response = PlaylistAPI.get(DataLoader.getInstance().getGetPlaylistId());
        assertStatusCode(response.getStatusCode(), 200);
        assertPlaylistsAreEqual(response.as(Playlist.class), requestPlaylist);
    }

    @Test
    public void testPlaylistIsUpdated() {
        Playlist requestPlaylist = playlistBuilder("New Playlist 5", "New playlist 5 description", false);

        Response response = PlaylistAPI.update(DataLoader.getInstance().getUpdatePlaylistId(), requestPlaylist);
        assertStatusCode(response.getStatusCode(), 200);
    }

    @Test
    public void testNewPlaylistWithoutNameIsNotCreated() {
        Playlist requestPlaylist = playlistBuilder("", "New playlist 3 description", false);

        Response response = PlaylistAPI.post(requestPlaylist);
        assertStatusCode(response.getStatusCode(), 400);
        assertError(response.as(Error.class), 400, "Missing required field: name");
    }

    @Test
    public void testNewPlaylistWithExpiredTokenIsNotCreated() {
        String invalidToken = "12345";
        Playlist requestPlaylist = playlistBuilder("", "New playlist 3 description", false);

        Response response = PlaylistAPI.post(invalidToken, requestPlaylist);
        assertStatusCode(response.getStatusCode(), 401);
        assertError(response.as(Error.class), 401, "Invalid access token");
    }

    private Playlist playlistBuilder(String name, String description, boolean isPublic) {
        return Playlist.builder()
                .name(name)
                .description(description)
                .isPublic(isPublic)
                .build();
    }

    private void assertPlaylistsAreEqual(Playlist responsePlaylist, Playlist requestPlaylist) {
        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getIsPublic(), equalTo(requestPlaylist.getIsPublic()));
    }

    private void assertStatusCode(int actualStatusCode, int expectedStatusCode) {
        assertThat(actualStatusCode, equalTo(expectedStatusCode));
    }

    private void assertError(Error responseError, int expectedStatusCode, String expectedMessage) {
        assertThat(responseError.getInnerError().getStatus(), equalTo(expectedStatusCode));
        assertThat(responseError.getInnerError().getMessage(), equalTo(expectedMessage));
    }
}
