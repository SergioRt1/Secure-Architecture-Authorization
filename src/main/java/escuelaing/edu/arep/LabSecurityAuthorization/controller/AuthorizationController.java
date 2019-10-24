package escuelaing.edu.arep.LabSecurityAuthorization.controller;

import escuelaing.edu.arep.LabSecurityAuthorization.services.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/authorization")
public class AuthorizationController {

    private AuthorizationService authorizationService;

    public AuthorizationController(AuthorizationService userService) {
        this.authorizationService = userService;
    }

    @GetMapping("/admin/{apiKey}")
    public Boolean isAuthorizeAsAdmin(@PathVariable String apiKey) {
        try {
            return authorizationService.isAuthorizeAsAdmin(apiKey);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/user/{apiKey}")
    public Boolean isAuthorizeAsUser(@PathVariable String apiKey) {
        try {
            return authorizationService.isAuthorizeAsUser(apiKey);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
