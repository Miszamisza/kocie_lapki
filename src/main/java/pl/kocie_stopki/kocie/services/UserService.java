package pl.kocie_stopki.kocie.services;

import pl.kocie_stopki.kocie.entity.User;

public interface UserService {
    public User findUserByEmail(String email);

    void saveUser(User user);
}
