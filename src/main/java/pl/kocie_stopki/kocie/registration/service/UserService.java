package pl.kocie_stopki.kocie.registration.service;

import org.springframework.security.core.userdetails.UserDetails;
import pl.kocie_stopki.kocie.entity.User;

public interface UserService {
    User register(User user) throws Exception;

    UserDetails loadUserByUsername(String username);

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
