package pl.kocie_stopki.kocie.registration.validator;

import pl.kocie_stopki.kocie.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PassMatch, Object> {

    @Override
    public void initialize(PassMatch constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        User user = (User) obj;
        return user.getPassword().equals(user.getConfirmPassword());
    }

}