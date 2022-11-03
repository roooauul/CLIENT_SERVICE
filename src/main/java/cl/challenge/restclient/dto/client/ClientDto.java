package cl.challenge.restclient.dto.client;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import cl.challenge.restclient.shared.SystemConstants;
import cl.challenge.restclient.shared.validator.annotation.InLenghtRange;
import lombok.Data;

@Data
public class ClientDto {
    @NotNull
    @NotBlank
    @InLenghtRange(minLenght = 2, maxLenght = 30)
	private String name;
    
    @NotNull
    @NotBlank
    @InLenghtRange(minLenght = 2, maxLenght = 30)
	private String surname;
    
    @NotNull
    @NotBlank
    @InLenghtRange(minLenght = 2, maxLenght = 100)
    @Pattern(regexp = SystemConstants.EMAIL_REGEX, message = "Invalid email format")
	private String email;
    
    @NotNull
    @Min(100000000)
    @Max(999999999)
	private Long cellphone;
}
