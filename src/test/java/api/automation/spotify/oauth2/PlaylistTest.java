package api.automation.spotify.oauth2;

import api.automation.spotify.oauth2.api.PlaylistAPI;
import api.automation.spotify.oauth2.pojo.Error;
import api.automation.spotify.oauth2.pojo.Playlist;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PlaylistTest {

    @Test
    public void testNewPlaylistIsCreated() {
        Playlist requestPlaylist = new Playlist()
                .setDescription("Some description")
                .setName("New Playlist 33")
                .setPublic(false);

        Response response = PlaylistAPI.post(requestPlaylist);
        assertThat(response.getStatusCode(), equalTo(201));

        Playlist responsePlaylist = response.as(Playlist.class);

        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getPublic(), equalTo(requestPlaylist.getPublic()));
    }

    @Test
    public void testPlaylistIsObtained() {
        Playlist requestPlaylist = new Playlist()
                .setName("New Playlist 3")
                .setDescription("New playlist 3 description")
                .setPublic(false);

        Response response = PlaylistAPI.get("5CIE2UNoQIIwsAiGYzCB9T");
        assertThat(response.getStatusCode(), equalTo(200));

        Playlist responsePlaylist = response.as(Playlist.class);

        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.getPublic(), equalTo(requestPlaylist.getPublic()));
    }

    @Test
    public void testPlaylistIsUpdated() {
        Playlist requestPlaylist = new Playlist()
                .setName("New Playlist 5")
                .setDescription("New playlist 5 description")
                .setPublic(false);

        Response response = PlaylistAPI.update("1Vp1cvC7EGN24rb8d02HHe", requestPlaylist);
        assertThat(response.getStatusCode(), equalTo(200));
    }

    @Test
    public void testNewPlaylistWithoutNameIsNotCreated() {
        Playlist requestPlaylist = new Playlist()
                .setName("")
                .setDescription("New playlist 3 description")
                .setPublic(false);

        Response response = PlaylistAPI.post(requestPlaylist);
        assertThat(response.getStatusCode(), equalTo(400));

        Error error = response.as(Error.class);

        assertThat(error.getInnerError().getStatus(), equalTo(400));
        assertThat(error.getInnerError().getMessage(), equalTo("Missing required field: name"));
    }

    @Test
    public void testNewPlaylistWithExpiredTokenIsNotCreated() {
        String invalidToken = "12345";
        Playlist requestPlaylist = new Playlist()
                .setName("")
                .setDescription("New playlist 3 description")
                .setPublic(false);

        Response response = PlaylistAPI.post(invalidToken, requestPlaylist);
        assertThat(response.getStatusCode(), equalTo(401));

        Error error = response.as(Error.class);

        assertThat(error.getInnerError().getStatus(), equalTo(401));
        assertThat(error.getInnerError().getMessage(), equalTo("Invalid access token"));
    }
}
