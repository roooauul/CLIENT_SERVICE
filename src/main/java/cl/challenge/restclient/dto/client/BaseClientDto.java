package cl.challenge.restclient.dto.client;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import cl.challenge.restclient.shared.SystemConstants;
import cl.challenge.restclient.shared.validator.annotation.InLenghtRange;
import lombok.Data;

@Data
public class BaseClientDto extends ClientIdDto {
    @InLenghtRange(minLenght = SystemConstants.GENERIC_MIN_LENGHT, maxLenght = SystemConstants.GENERIC_MAX_LENGHT)
    @Pattern(regexp = SystemConstants.ALPHABETICAL_WITH_SPACES_REGEX, message = "Invalid name format")
	private String name;
    
    @InLenghtRange(minLenght = SystemConstants.GENERIC_MIN_LENGHT, maxLenght = SystemConstants.GENERIC_MAX_LENGHT)
    @Pattern(regexp = SystemConstants.ALPHABETICAL_WITH_SPACES_REGEX, message = "Invalid surname format")
	private String surname;
    
    @Min(SystemConstants.PHONE_MIN)
    @Max(SystemConstants.PHONE_MAX)
	private Long cellphone;
}
