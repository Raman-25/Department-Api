package com.project.department_api.Advices;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@JsonPropertyOrder({
        "success",
        "data",
        "apiError"
})

@Data
public class ApiResponse<T>{

    private boolean success;

    private T data;

    private ApiError apiError;


    public ApiResponse() {
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
        this.success = true;
    }

    public ApiResponse(ApiError apiError) {
        this();
        this.apiError = apiError;
        this.success = false;
    }

    public ApiResponse(boolean success) {
        this();
        this.success = success;
    }
}
