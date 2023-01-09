package api.automation.spotify.oauth2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExternalUrls__1 {
    @JsonProperty("spotify")
    private String spotify;

    public ExternalUrls__1() {
    }

    public ExternalUrls__1(String spotify) {
        this.spotify = spotify;
    }

    @JsonProperty("spotify")
    public String getSpotify() {
        return spotify;
    }

    @JsonProperty("spotify")
    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }
}
