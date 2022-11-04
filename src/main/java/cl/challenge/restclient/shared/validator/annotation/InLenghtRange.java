package cl.challenge.restclient.shared.validator.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;

import cl.challenge.restclient.shared.validator.RangeLenghtValidator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = RangeLenghtValidator.class)
@Documented
public @interface InLenghtRange {
    String message() default "Value must be {minLenght} and {maxLenght} characters long";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    int minLenght();

    int maxLenght();
}
