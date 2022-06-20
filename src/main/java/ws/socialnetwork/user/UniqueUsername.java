package ws.socialnetwork.user;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUsernameValidator.class)
public @interface UniqueUsername {
    //Bean validation
    String message() default "{app.constraint.user.username.uniqueUsername.Message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
