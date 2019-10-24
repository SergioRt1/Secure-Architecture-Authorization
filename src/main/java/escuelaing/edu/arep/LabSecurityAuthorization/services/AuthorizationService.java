package escuelaing.edu.arep.LabSecurityAuthorization.services;

import escuelaing.edu.arep.LabSecurityAuthorization.repositories.AuthorizationRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    private final AuthorizationRepository authorizationRepository;

    public AuthorizationService(AuthorizationRepository authorizationRepository) {
        this.authorizationRepository = authorizationRepository;
    }

    public boolean isAuthorizeAsAdmin(String apiKey) {
        return authorizationRepository.isAuthorizeAsAdmin(apiKey);
    }

    public boolean isAuthorizeAsUser(String apiKey) {
        return authorizationRepository.isAuthorizeAsUser(apiKey);
    }
}
