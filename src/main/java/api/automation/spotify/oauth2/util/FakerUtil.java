package api.automation.spotify.oauth2.util;

import com.github.javafaker.Faker;

public class FakerUtil {
    private static final String NAME_PATTERN = "[A-Za-z0-9 ,_-]{10}";
    private static final String DESCRIPTION_PATTERN = "[A-Za-z0-9 ,_-+@./#&]{20}";
    private static final String INVALID_TOKEN_PATTERN = "[A-Za-z0-9]{10}";
    public static String generateName() {
        Faker faker = new Faker();
        return "Playlist " + faker.regexify(NAME_PATTERN);
    }

    public static String generateDescription() {
        Faker faker = new Faker();
        return "Description " + faker.regexify(DESCRIPTION_PATTERN);
    }

    public static String generateInvalidToken() {
        Faker faker = new Faker();
        return faker.regexify(INVALID_TOKEN_PATTERN);
    }
}
