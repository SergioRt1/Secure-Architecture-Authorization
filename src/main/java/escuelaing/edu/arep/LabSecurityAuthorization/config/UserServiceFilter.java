package escuelaing.edu.arep.LabSecurityAuthorization.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class UserServiceFilter implements Filter {

    private final String usersServiceApiKey;

    public UserServiceFilter(@Value("${user-service.api-key}") String usersServiceApiKey) {
        this.usersServiceApiKey = usersServiceApiKey;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;

            String apiKey = req.getHeader("api-key");
            if (apiKey == null || !apiKey.equals(usersServiceApiKey)) {
                resp.reset();
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            } else {
                chain.doFilter(req, resp);
            }
        }
    }
}

