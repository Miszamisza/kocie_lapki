package pl.kocie_stopki.kocie.registration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kocie_stopki.kocie.entity.User;
import pl.kocie_stopki.kocie.repository.UserRepository;
/**
 * This class is service implementation for registration process
 */

@Service("/userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /** * This method queues the email for sending. *
     * @param user User will be register
     * @return Saved user **/
    public User register(User user) throws Exception {

        if (emailExist(user.getEMail())) {
            throw new Exception(
                    "This eMail is already use");
        }
        user = new User();
        user.setEMail(user.getEMail());
        user.getLogin(user.getLogin());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(false);
        user.setAdmin(false);
        return userRepository.save(user);

    }
    /** * This method queues the email for sending. *
     * @param email Function check that email already exsist in database
     * @return True if user exist **/
    private boolean emailExist(String email) {
        User user = userRepository.findByEMail(email);
        return user != null;
    }


}
