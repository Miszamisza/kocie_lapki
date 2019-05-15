package pl.kocie_stopki.kocie.registration.validator;

import pl.kocie_stopki.kocie.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PassMatch, Object> {

    private PassMatch passMatch;

    @Override
    public void initialize(PassMatch passMatch) {
        this.passMatch = passMatch;
    }

    /** * This method queues the email for sending. *
     * @param obj User
     * @param context validator context
     * @return True if passwords are the same **/
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        User user = (User) obj;
        return user.getPassword().equals(user.getConfirmPassword());
    }

}