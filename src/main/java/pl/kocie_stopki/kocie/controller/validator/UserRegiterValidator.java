package pl.kocie_stopki.kocie.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.kocie_stopki.kocie.controller.Utils.AppUtils;
import pl.kocie_stopki.kocie.entity.User;

public class UserRegiterValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    public void emailExist(User user, Errors errors) {
        if (user != null) {
            errors.rejectValue("email", "email is already in database", "email is already in database");
        }
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        ValidationUtils.rejectIfEmpty(errors, "login", "error.login.empty");
        ValidationUtils.rejectIfEmpty(errors, "name", "error.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "error.userPassword.empty");

        if (!user.getEMail().equals(null)) {
            boolean isMatch = AppUtils.checkEmailOrPassword(Patterns.EMAIL_PATTERN, user.getEMail());
            if(!isMatch) {
                errors.rejectValue("eMail", "e-mail id not correct", "e-mail id not correct");
        }
        }

        if (!user.getPassword().equals(null)) {
            boolean isMatch = AppUtils.checkEmailOrPassword(Patterns.PASSWORD_PATTERN, user.getPassword());
            if(!isMatch) {
                errors.rejectValue("password", "password id not correct","pasword id not correct");
            }
        }
    }
}