package api.automation.spotify.oauth2;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PlaylistTest {
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;
    private static final String ACCESS_TOKEN = "BQA-8K1Accxm8_Ur-a6NRxH117f0JP-wP67dzjWpkVoLV7MRYgNXBfwOwLvRBUy6KRvChHUPZ35m4pTp_RPHaCqUP2z3Uzini9pKOMaaBGjgQaezX6ctcpK3MrDhVUdtvYSllq9BvWLHD85qXnPzZhdiYTe0nqZ4MfkkmReGCEbxV6FFI3eRsGRX75Vo_hriZAVu9S5ll20KWN_scRhe2gwOlVPaMCDvojC_uUT4d-lDZU9ESUvbZRagr-xlljL9qLCez-CWgP3TPSdn";

    @BeforeClass
    public void requestSpecAndResponseSpecInit() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://api.spotify.com")
                .setBasePath("/v1")
                .addHeader("Authorization", "Bearer " + ACCESS_TOKEN)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder()
                .log(LogDetail.ALL);
        responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void testNewPlaylistIsCreated() {
        Playlist requestPlaylist = new Playlist()
                .setName("New Playlist 3")
                .setDescription("New playlist 3 description")
                .setPublic(false);

        Playlist responsePlaylist = given(requestSpecification)
                .body(requestPlaylist)
                .when()
                .post("/users/31e5cr3v7kcgdthtkg5llzymuzl4/playlists")
                .then()
                .spec(responseSpecification)
                .statusCode(201)
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .as(Playlist.class);

        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.getPublic(), equalTo(requestPlaylist.getPublic()));
    }

    @Test
    public void testPlaylistIsObtained() {
        Playlist requestPlaylist = new Playlist()
                .setName("New Playlist 3")
                .setDescription("New playlist 3 description")
                .setPublic(false);

        Playlist responsePlaylist = given(requestSpecification)
                .when()
                .get("/playlists/5CIE2UNoQIIwsAiGYzCB9T")
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .as(Playlist.class);

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

        given(requestSpecification)
                .body(requestPlaylist)
                .when()
                .put("/playlists/1Vp1cvC7EGN24rb8d02HHe")
                .then()
                .spec(responseSpecification)
                .statusCode(200);
    }

    @Test
    public void testNewPlaylistWithoutNameIsNotCreated() {
        Playlist requestPlaylist = new Playlist()
                .setName("")
                .setDescription("New playlist 3 description")
                .setPublic(false);

        Error error = given(requestSpecification)
                .body(requestPlaylist)
                .when()
                .post("/users/31e5cr3v7kcgdthtkg5llzymuzl4/playlists")
                .then()
                .spec(responseSpecification)
                .statusCode(400)
                .contentType(ContentType.JSON)
                .extract()
                .as(Error.class);

        assertThat(error.getInnerError().getStatus(), equalTo(400));
        assertThat(error.getInnerError().getMessage(), equalTo("Missing required field: name"));
    }

    @Test
    public void testNewPlaylistWithExpiredTokenIsNotCreated() {
        Playlist requestPlaylist = new Playlist()
                .setName("")
                .setDescription("New playlist 3 description")
                .setPublic(false);

        Error error = given()
                .baseUri("https://api.spotify.com")
                .basePath("/v1")
                .header("Authorization", "Bearer " + "12345")
                .contentType(ContentType.JSON)
                .log().all()
                .body(requestPlaylist)
                .when()
                .post("/users/31e5cr3v7kcgdthtkg5llzymuzl4/playlists")
                .then()
                .spec(responseSpecification)
                .statusCode(401)
                .contentType(ContentType.JSON)
                .extract()
                .as(Error.class);

        assertThat(error.getInnerError().getStatus(), equalTo(401));
        assertThat(error.getInnerError().getMessage(), equalTo("Invalid access token"));
    }
}
