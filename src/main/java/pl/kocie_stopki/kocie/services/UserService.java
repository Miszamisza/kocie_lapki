package pl.kocie_stopki.kocie.services;

import org.springframework.stereotype.Service;
import pl.kocie_stopki.kocie.entity.User;
import pl.kocie_stopki.kocie.repository.UserRepository;

@Service
public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);



}
