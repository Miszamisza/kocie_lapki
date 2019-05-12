package pl.kocie_stopki.kocie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kocie_stopki.kocie.entity.User;
import pl.kocie_stopki.kocie.repository.UserRepository;

@Service("/userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEMail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setLogin(user.getLogin());
        user.setPassword(user.getPassword());
        user.setEMail(user.getEMail());
        user.setActive(false);
        user.setAdmin(false);
        userRepository.save(user);
    }

}
