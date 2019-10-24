package escuelaing.edu.arep.LabSecurityAuthorization.repositories;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class AuthorizationRepository {

    private final Set<String> adminApiKeys;
    private final Set<String> userApiKeys;

    public AuthorizationRepository() {
        this.adminApiKeys = new HashSet<>();
        this.userApiKeys = new HashSet<>();

        userApiKeys.add("user1");
        userApiKeys.add("user2");
        adminApiKeys.add("admin");
    }


    public boolean isAuthorizeAsAdmin(String apiKey) {
        return adminApiKeys.contains(apiKey);
    }

    public boolean isAuthorizeAsUser(String apiKey) {
        return userApiKeys.contains(apiKey);
    }

}
