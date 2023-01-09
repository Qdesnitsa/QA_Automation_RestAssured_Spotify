package api.automation.spotify.oauth2.api;

import api.automation.spotify.oauth2.pojo.Playlist;
import io.restassured.response.Response;

import static api.automation.spotify.oauth2.api.Route.PLAYLISTS;
import static api.automation.spotify.oauth2.api.Route.USERS;
import static api.automation.spotify.oauth2.api.TokenManager.getToken;

public class PlaylistAPI {

    //documentation: https://developer.spotify.com/documentation/web-api/reference/#/operations/create-playlist
    public static Response post(Playlist requestPlaylist) {
        return RestResource.post(USERS + "/31e5cr3v7kcgdthtkg5llzymuzl4" + PLAYLISTS, getToken(), requestPlaylist);
    }

    //documentation: https://developer.spotify.com/documentation/web-api/reference/#/operations/create-playlist
    public static Response post(String token, Playlist requestPlaylist) {
        return RestResource.post(USERS + "/31e5cr3v7kcgdthtkg5llzymuzl4" + PLAYLISTS, token, requestPlaylist);
    }

    //documentation: https://developer.spotify.com/documentation/web-api/reference/#/operations/get-playlist
    public static Response get(String playlistId) {
        return RestResource.get(PLAYLISTS + "/" + playlistId, getToken());
    }

    //documentation: https://developer.spotify.com/documentation/web-api/reference/#/operations/change-playlist-details
    public static Response update(String playlistId, Playlist requestPlaylist) {
        return RestResource.update(PLAYLISTS + "/" + playlistId, getToken(), requestPlaylist);
    }
}
