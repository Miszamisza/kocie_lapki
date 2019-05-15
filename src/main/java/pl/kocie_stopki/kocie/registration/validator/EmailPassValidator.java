package pl.kocie_stopki.kocie.registration.validator;

import pl.kocie_stopki.kocie.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailPassValidator implements ConstraintValidator<EmailPass, Object> {

    private EmailPass emailPass;

    @Override
    public void initialize(EmailPass emailPass) {
        this.emailPass = emailPass;
    }

    /** * This method queues the email for sending. *
     * @param obj User
     * @param context validator context
     * @return True if emails are the same **/
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        User user = (User) obj;
        return user.getPassword().equals(user.getConfirmEmail());
    }
}
