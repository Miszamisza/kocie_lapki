package pl.kocie_stopki.kocie.controller.Registration;

import pl.kocie_stopki.kocie.entity.User;

public interface UserService {
    public User validateUser(User login);

    public void register(User user);
}
