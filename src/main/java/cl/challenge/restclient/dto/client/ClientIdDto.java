package cl.challenge.restclient.dto.client;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import cl.challenge.restclient.shared.SystemConstants;
import cl.challenge.restclient.shared.validator.annotation.InLenghtRange;
import cl.challenge.restclient.shared.validator.annotation.ValidRut;
import lombok.Data;

@Data
public class ClientIdDto {
    @NotNull
    @NotBlank
    @InLenghtRange(minLenght = 2, maxLenght = 100)
    @Pattern(regexp = SystemConstants.EMAIL_REGEX, message = "Invalid email format")
	private String email;
    
    @NotNull
    @NotBlank
    @InLenghtRange(minLenght = 2, maxLenght = 10)
    @ValidRut
    private String rut;
}
