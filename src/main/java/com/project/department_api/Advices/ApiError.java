package com.project.department_api.Advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@Data
public class ApiError {

    private HttpStatus status;
    private String message;
    private String path;
}
