package cl.challenge.restclient.shared.validator;

import lombok.SneakyThrows;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cl.challenge.restclient.shared.validator.annotation.ValidRut;

public class RutValidator implements ConstraintValidator<ValidRut, String> {
	
    @Override
    public void initialize(ValidRut constraintAnnotation) {
    	
    }
    
    @SneakyThrows
    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
    	return field != null && this.validRut(field);
    }
    
	private Boolean validRut(String rut) {
		Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
		Matcher matcher = pattern.matcher(rut);
		if (!matcher.matches()) return false;
		String[] stringRut = rut.split("-");
		return stringRut[1].toLowerCase().equals(this.dv(stringRut[0]));
	}
	
	private String dv(String rut) {
		int m = 0, s = 1;
		for (int t = Integer.parseInt(rut); t!=0; t = (int) Math.floor(t /= 10)) {
			s = (s + t%10 * (9-m++%6)) % 11;
		}
		return (s > 0) ? String.valueOf(s-1) : "k";
	}
}
