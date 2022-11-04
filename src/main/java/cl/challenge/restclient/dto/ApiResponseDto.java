package cl.challenge.restclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiResponseDto {
	private Object data;
    private String message;
    private boolean error = true;
}
