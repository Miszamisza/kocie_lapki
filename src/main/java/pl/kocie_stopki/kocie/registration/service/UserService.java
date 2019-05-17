package pl.kocie_stopki.kocie.registration.service;

import pl.kocie_stopki.kocie.entity.User;
/**
 * Thic class is service for regisstration process
 */
public interface UserService {

    User register(User user) throws Exception;

}
