package api.automation.spotify.oauth2.api;

import io.restassured.response.Response;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class TokenManager {
    private static String accessToken;
    private static Instant expiryTime;

    public static String getToken() {
        try {
            if (accessToken == null || Instant.now().isAfter(expiryTime)) {
                Response response = renewToken();
                accessToken = response.path("access_token");
                int expiryDurationInSeconds = response.path("expires_in");
                expiryTime = Instant.now().plusSeconds(expiryDurationInSeconds);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to get token.");
        }
        return accessToken;
    }

    private static Response renewToken() {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("client_id", "0e0a3053d3234e8a980d6c8928bea5a4");
        formParams.put("client_secret", "03a98d9358dc4a99ab8cc9e9a6e4c070");
        formParams.put("grant_type", "refresh_token");
        formParams.put("refresh_token", "AQAJkBEu1iy5NRHN1Axfwv0Z2wjyDHVg4rkkfPv5uoeMw42QImL9JjVYC65aQ9abTchPy_1PcdpWl6T0t0RymjGFMUe3AI63wVYallyzs0c1-Yk_-MicR7lHh8Gdk7c5g_c");

        Response response = RestResource.postAccount(formParams);

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Renew token failed.");
        }
        return response;
    }
}
