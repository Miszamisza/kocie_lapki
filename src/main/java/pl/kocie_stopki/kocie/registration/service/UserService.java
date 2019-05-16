package pl.kocie_stopki.kocie.registration.service;

import pl.kocie_stopki.kocie.entity.User;

public interface UserService {

    User register(User user) throws Exception;

}
