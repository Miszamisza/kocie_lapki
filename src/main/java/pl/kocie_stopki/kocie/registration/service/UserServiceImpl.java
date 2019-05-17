package pl.kocie_stopki.kocie.registration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kocie_stopki.kocie.entity.User;
import pl.kocie_stopki.kocie.repository.OrderRepo;
import pl.kocie_stopki.kocie.repository.UserRepo;

/**
 * This class is service implementation for registration process
 */

@Service("/userService")
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    /** * This method queues the email for sending. *
     * @param user User will be register
     * @return Saved user **/
    public User register(User user) throws Exception {

        if (emailExist(user.getEmail())) {
            throw new Exception(
                    "This eMail is already use");
        }
        user = new User();
        user.setEmail(user.getEmail());
        user.getLogin(user.getLogin());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(false);
        user.setIsadmin(false);
        return userRepo.save(user);

    }
    /** * This method queues the email for sending. *
     * @param email Function check that email already exsist in database
     * @return True if user exist **/
    private boolean emailExist(String email) {
        User user = userRepo.findByemail(email);
        return user != null;
    }


}
