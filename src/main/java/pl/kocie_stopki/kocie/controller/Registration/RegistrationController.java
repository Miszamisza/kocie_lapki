package pl.kocie_stopki.kocie.controller.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kocie_stopki.kocie.controller.validator.UserRegiterValidator;
import pl.kocie_stopki.kocie.entity.User;
import pl.kocie_stopki.kocie.services.UserService;


@RestController
public class RegistrationController {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService userService;

    @PostMapping(value = "/registeruser")
    public void registerAction(User user, BindingResult result) throws Exception {
        User userExist = userService.findUserByEmail(user.getEMail());

        new UserRegiterValidator().emailExist(userExist, result);

        new UserRegiterValidator().validate(user, result);
        if (result.hasErrors()) {
            String e = "Email or user is not correct";
            throw new Exception(e);
        }
        else {
            userService.saveUser(user);
        }
    }

}

