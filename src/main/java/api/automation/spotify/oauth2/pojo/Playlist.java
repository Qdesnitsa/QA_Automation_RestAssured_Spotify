package api.automation.spotify.oauth2.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist {
    @JsonProperty("collaborative")
    private Boolean collaborative;
    @JsonProperty("description")
    private String description;
    @JsonProperty("external_urls")
    private ExternalUrl externalUrls;
    @JsonProperty("followers")
    private Follower followers;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("images")
    private List<Object> images;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("primary_color")
    private Object primaryColor;
    @JsonProperty("public")
    private Boolean _public;
    @JsonProperty("snapshot_id")
    private String snapshotId;
    @JsonProperty("tracks")
    private Track tracks;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;

    public Playlist() {
    }

    public Playlist(Boolean collaborative, String description, ExternalUrl externalUrls, Follower followers,
                    String href, String id, List<Object> images, String name, Owner owner, Object primaryColor,
                    Boolean _public, String snapshotId, Track tracks, String type, String uri) {
        this.collaborative = collaborative;
        this.description = description;
        this.externalUrls = externalUrls;
        this.followers = followers;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.owner = owner;
        this.primaryColor = primaryColor;
        this._public = _public;
        this.snapshotId = snapshotId;
        this.tracks = tracks;
        this.type = type;
        this.uri = uri;
    }

    @JsonProperty("collaborative")
    public Boolean getCollaborative() {
        return collaborative;
    }

    @JsonProperty("collaborative")
    public void setCollaborative(Boolean collaborative) {
        this.collaborative = collaborative;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public Playlist setDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("external_urls")
    public ExternalUrl getExternalUrls() {
        return externalUrls;
    }

    @JsonProperty("external_urls")
    public void setExternalUrls(ExternalUrl externalUrls) {
        this.externalUrls = externalUrls;
    }

    @JsonProperty("followers")
    public Follower getFollowers() {
        return followers;
    }

    @JsonProperty("followers")
    public void setFollowers(Follower followers) {
        this.followers = followers;
    }

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("images")
    public List<Object> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Object> images) {
        this.images = images;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public Playlist setName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("owner")
    public Owner getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @JsonProperty("primary_color")
    public Object getPrimaryColor() {
        return primaryColor;
    }

    @JsonProperty("primary_color")
    public void setPrimaryColor(Object primaryColor) {
        this.primaryColor = primaryColor;
    }

    @JsonProperty("public")
    public Boolean getPublic() {
        return _public;
    }

    @JsonProperty("public")
    public Playlist setPublic(Boolean _public) {
        this._public = _public;
        return this;
    }

    @JsonProperty("snapshot_id")
    public String getSnapshotId() {
        return snapshotId;
    }

    @JsonProperty("snapshot_id")
    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    @JsonProperty("tracks")
    public Track getTracks() {
        return tracks;
    }

    @JsonProperty("tracks")
    public void setTracks(Track tracks) {
        this.tracks = tracks;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }
}
