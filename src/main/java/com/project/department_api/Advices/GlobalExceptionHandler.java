package com.project.department_api.Advices;


import com.project.department_api.Exceptions.DuplicateResourceException;
import com.project.department_api.Exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handelResourceNotFound(ResourceNotFoundException ex,
                                                                 HttpServletRequest request){


        ApiError apiError =ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        ApiResponse<ApiError> apiResponse = new ApiResponse<>(apiError);
        return new ResponseEntity<>(apiResponse, apiError.getStatus());
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiResponse<?>> handelDuplicateResource (DuplicateResourceException ex,
                                                                   HttpServletRequest request){

        ApiError apiError =ApiError.builder()
                .status(HttpStatus.CONFLICT)
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        ApiResponse<ApiError> apiResponse = new ApiResponse<>(apiError);

        return new ResponseEntity<>(apiResponse, apiError.getStatus());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<ApiError>> handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        String message = ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        ApiError apiError = ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(message)
                .path(request.getRequestURI())
                .build();

        ApiResponse<ApiError> apiResponse = new ApiResponse<>(apiError);

        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }


}
