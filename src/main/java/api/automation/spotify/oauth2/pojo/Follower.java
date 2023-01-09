package api.automation.spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Follower {
    @JsonProperty("href")
    private Object href;
    @JsonProperty("total")
    private Integer total;

    public Follower() {
    }

    public Follower(Object href, Integer total) {
        this.href = href;
        this.total = total;
    }

    @JsonProperty("href")
    public Object getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(Object href) {
        this.href = href;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }
}
