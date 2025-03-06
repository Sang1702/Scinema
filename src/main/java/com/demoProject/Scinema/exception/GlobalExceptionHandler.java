package com.demoProject.Scinema.exception;

import com.demoProject.Scinema.dto.request.ApiResponse;
import jakarta.validation.ConstraintViolation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler
{
    private static final String MIN_ATTRIBUTE = "min";

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handlingRuntimeException(Exception e) {
        log.error("Unhandled Exception: ", e); // ✅ In lỗi ra console để debug

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(e.getMessage()); // ✅ Trả về lỗi thật để dễ debug

        return ResponseEntity.badRequest().body(apiResponse);
    }


    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException e)
    {
        ErrorCode  errorCode = e.getErrorCode();
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return ResponseEntity.status(errorCode.getStatusCode())
                .body(apiResponse);
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    ResponseEntity<ApiResponse> handingAccessDeniedException(AccessDeniedException e)
    {
        ErrorCode errorCode = ErrorCode.UNAUTHORIZED;

        return ResponseEntity.status(errorCode.getStatusCode()).body(
                ApiResponse.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build()
                );
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingValidation(MethodArgumentNotValidException e)
    {
        String enumKey = e.getFieldError().getDefaultMessage();

        ErrorCode errorCode = ErrorCode.INVALID_KEY;
        Map<String, Object> attributes = null;
        try
        {
            errorCode = ErrorCode.valueOf(enumKey);

            var constraintViolations = e.getBindingResult()
                    .getAllErrors().getFirst().unwrap(ConstraintViolation.class);

            attributes =  constraintViolations.getConstraintDescriptor().getAttributes();

            log.info(attributes.toString());
        }catch (IllegalArgumentException ex)
        {

        }

        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(Objects.nonNull(attributes) ?
                mapAttribute(errorCode.getMessage(), attributes)
                : errorCode.getMessage());

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    ResponseEntity<ApiResponse> handleDatabaseException(DataIntegrityViolationException e) {
        log.error("Database Constraint Violation: ", e);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ErrorCode.DATABASE_ERROR.getCode());
        apiResponse.setMessage("Database constraint violation: " + e.getMessage()); // ✅ Hiển thị lỗi thật

        return ResponseEntity.badRequest().body(apiResponse);
    }


    private String mapAttribute(String message, Map<String, Object> attributes)
    {
        String minValue = String.valueOf(attributes.get(MIN_ATTRIBUTE));

        return message.replace("{" + MIN_ATTRIBUTE + "}", minValue);
    }

}
