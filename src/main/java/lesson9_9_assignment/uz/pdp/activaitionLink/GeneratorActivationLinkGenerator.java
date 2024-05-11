package lesson9_9_assignment.uz.pdp.activaitionLink;

import java.util.UUID;

public class GeneratorActivationLinkGenerator {
    private static final String BASE_URL = "https://example.com/activate";

    public static String activateLink(Long userId){
        // Generate a unique token (UUID)
        String token= UUID.randomUUID().toString();
        // Store the token in the database, associating it with the user identified by userId

        // Construct the activation link with the token as a parameter
        return BASE_URL + "?token=" + token + "&userId=" + userId;
    }
}
