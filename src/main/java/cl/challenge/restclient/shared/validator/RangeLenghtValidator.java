package cl.challenge.restclient.shared.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cl.challenge.restclient.shared.validator.annotation.InLenghtRange;

public class RangeLenghtValidator implements ConstraintValidator<InLenghtRange, String> {
	
    private int minLenght;
    private int maxLenght;
	
    @Override
    public void initialize(InLenghtRange constraintAnnotation) {
        this.minLenght = constraintAnnotation.minLenght();
        this.maxLenght = constraintAnnotation.maxLenght();
    }
    
    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
    	if (field == null || field.equals("null")) { return true; }
    	
    	int fieldLenght = field.length();
    	
    	return this.minLenght <= fieldLenght && this.maxLenght >= fieldLenght;
    }

}
