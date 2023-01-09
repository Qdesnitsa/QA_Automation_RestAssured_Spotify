package api.automation.spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Follower {
    @JsonProperty("href")
    private Object href;
    @JsonProperty("total")
    private Integer total;
}
