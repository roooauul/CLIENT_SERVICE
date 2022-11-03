package cl.challenge.restclient.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.telemetry.ExceptionTelemetry;

import cl.challenge.restclient.dto.ApiResponseDto;
import cl.challenge.restclient.shared.SystemConstants;
import cl.challenge.restclient.shared.exception.SystemException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GeneralExceptionHandler {
	
    @Autowired
    private TelemetryClient telemetryClient;
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponseDto handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        List<String> processedErrors = new ArrayList<>();
        
        ex.getBindingResult().getFieldErrors().forEach(error -> {
        	processedErrors.add(error.getCode());
            if (errors.containsKey(error.getField())) {
                errors.put(error.getField(), String.format("%s, %s", errors.get(error.getField()), error.getDefaultMessage()));
            } else {
                errors.put(error.getField(), error.getDefaultMessage());
            }
        });
        
        ex.getBindingResult().getAllErrors().forEach(error -> {
        	if (!processedErrors.contains(error.getCode())) {
        		errors.put(error.getObjectName(), error.getDefaultMessage());
        	}
        });
        
    	telemetryClient.trackException(new ExceptionTelemetry(ex));
        
        return new ApiResponseDto(errors, SystemConstants.API_VALIDATION_ERROR, true);
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
    public ApiResponseDto handleValidationExceptions(HttpMessageNotReadableException ex) {
        Map<String, String> errors = new HashMap<>();
        
        errors.put("error_message", "Unrecognized field");
        
        telemetryClient.trackException(new ExceptionTelemetry(ex));
        
        return new ApiResponseDto(errors, SystemConstants.API_VALIDATION_ERROR, true);
    }
	
	@ResponseStatus(value= HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoHandlerFoundException.class)
	public ApiResponseDto requestHandlingNoHandlerFound(NoHandlerFoundException ex) {
        Map<String, String> errors = new HashMap<>();
                
        errors.put("timestamp", new Date().toString());
        errors.put("error", "Not Found");
        errors.put("message", "No message available");
        
        telemetryClient.trackException(new ExceptionTelemetry(ex));
        
        return new ApiResponseDto(errors, SystemConstants.API_RESOURCE_NOT_FOUND_ERROR, true);
	}
	
	@ResponseStatus(value= HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ApiResponseDto requestHandlingNoHandlerFound(MethodArgumentTypeMismatchException ex) {
        Map<String, String> errors = new HashMap<>();
                
        errors.put("timestamp", new Date().toString());
        errors.put("error", "Required value");
        errors.put("message", "Invalid value in path");
        
        telemetryClient.trackException(new ExceptionTelemetry(ex));
        
        return new ApiResponseDto(errors, SystemConstants.API_INVALID_PATH_ERROR, true);
	}
	
	@ResponseStatus(value= HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	public ApiResponseDto requestBindException(BindException ex) {
        Map<String, String> errors = new HashMap<>();
        List<String> processedErrors = new ArrayList<>();
        
        ex.getBindingResult().getFieldErrors().forEach(error -> {
        	processedErrors.add(error.getCode());
            if (errors.containsKey(error.getField())) {
                errors.put(error.getField(), String.format("%s, %s", errors.get(error.getField()), error.getDefaultMessage()));
            } else {
                errors.put(error.getField(), error.getDefaultMessage());
            }
        });
        
        telemetryClient.trackException(new ExceptionTelemetry(ex));
        
        return new ApiResponseDto(errors, SystemConstants.API_VALIDATION_ERROR, true);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(SystemException.class)
    public ApiResponseDto handleValidationExceptions(SystemException ex) {

        Map<String, Object> errors = new HashMap<>();
        
        errors.put("error_message", ex.getMessage());
        errors.put("error_detail", ex.getCauseError());
        errors.put("error_code", ex.getInternalCode());
        
        telemetryClient.trackException(new ExceptionTelemetry(ex));
        
        return new ApiResponseDto(errors, SystemConstants.API_VALIDATION_ERROR, true);
    }
}
