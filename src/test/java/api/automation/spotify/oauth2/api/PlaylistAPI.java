package api.automation.spotify.oauth2.api;

import api.automation.spotify.oauth2.pojo.Playlist;
import api.automation.spotify.oauth2.util.ConfigLoader;
import io.restassured.response.Response;

import static api.automation.spotify.oauth2.api.Route.PLAYLISTS;
import static api.automation.spotify.oauth2.api.Route.USERS;
import static api.automation.spotify.oauth2.api.TokenManager.getToken;

public class PlaylistAPI {

    //documentation: https://developer.spotify.com/documentation/web-api/reference/#/operations/create-playlist
    public static Response post(Playlist requestPlaylist) {
        return RestResource.post(USERS + "/" + ConfigLoader.getInstance().getUserId() + PLAYLISTS, getToken(), requestPlaylist);
    }

    //documentation: https://developer.spotify.com/documentation/web-api/reference/#/operations/create-playlist
    public static Response post(String token, Playlist requestPlaylist) {
        return RestResource.post(USERS + "/" + ConfigLoader.getInstance().getUserId() + PLAYLISTS, token, requestPlaylist);
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
