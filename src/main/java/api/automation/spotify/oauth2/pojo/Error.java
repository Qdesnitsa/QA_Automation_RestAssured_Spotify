package api.automation.spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {
    @JsonProperty("error")
    private InnerError innerError;

    public Error() {
    }

    public Error(InnerError innerError) {
        this.innerError = innerError;
    }

    @JsonProperty("error")
    public InnerError getInnerError() {
        return innerError;
    }

    @JsonProperty("error")
    public void setInnerError(InnerError innerError) {
        this.innerError = innerError;
    }
}
