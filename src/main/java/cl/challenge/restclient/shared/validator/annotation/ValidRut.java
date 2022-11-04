package cl.challenge.restclient.shared.validator.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;

import cl.challenge.restclient.shared.validator.RutValidator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = RutValidator.class)
@Documented
public @interface ValidRut {
    String message() default "Invalid RUT.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

