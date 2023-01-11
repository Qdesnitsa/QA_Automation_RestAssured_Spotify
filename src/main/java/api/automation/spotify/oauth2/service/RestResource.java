package api.automation.spotify.oauth2.service;

import io.restassured.response.Response;

import java.util.Map;

import static api.automation.spotify.oauth2.util.Route.API;
import static api.automation.spotify.oauth2.util.Route.TOKEN;
import static api.automation.spotify.oauth2.service.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post(String path, String token, Object requestPlaylist) {
        return given(getRequestSpec())
                //.header("Authorization", "Bearer " + token)
                .auth()
                .oauth2(token)
                .body(requestPlaylist)
                .when()
                .post(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response postAccount(Map<String, String> formParams) {
        return given(getAccountRequestSpec())
                .formParams(formParams)
                .when()
                .post(API + TOKEN)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response get(String path, String token) {
        return given(getRequestSpec())
                //.header("Authorization", "Bearer " + token)
                .auth()
                .oauth2(token)
                .when()
                .get(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response update(String path, String token, Object requestPlaylist) {
        return given(getRequestSpec())
                //.header("Authorization", "Bearer " + token)
                .auth()
                .oauth2(token)
                .body(requestPlaylist)
                .when()
                .put(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }
}
