package api.automation.spotify.oauth2.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Value
//@Getter
//@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist {
    @JsonProperty("collaborative")
    Boolean collaborative;
    @JsonProperty("description")
    String description;
    @JsonProperty("external_urls")
    ExternalUrl externalUrls;
    @JsonProperty("followers")
    Follower followers;
    @JsonProperty("href")
    String href;
    @JsonProperty("id")
    String id;
    @JsonProperty("images")
    List<Object> images;
    @JsonProperty("name")
    String name;
    @JsonProperty("owner")
    Owner owner;
    @JsonProperty("primary_color")
    Object primaryColor;
    @JsonProperty("public")
    Boolean isPublic;
    @JsonProperty("snapshot_id")
    String snapshotId;
    @JsonProperty("tracks")
    Track tracks;
    @JsonProperty("type")
    String type;
    @JsonProperty("uri")
    String uri;
}
