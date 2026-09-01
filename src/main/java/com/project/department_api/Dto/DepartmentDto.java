package com.project.department_api.Dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;


@JsonPropertyOrder({
        "id",
        "title",
        "isActive",
        "createdAt"
})

@Data
public class DepartmentDto {

    private Long id;

    @NotBlank(message = "Department title cannot be blank")
    @Size(min = 2, max = 50, message = "Title must be between 2 and 50 characters")
    private String title;

    @NotNull(message = "isActive cannot be null")
    private Boolean isActive;

    private LocalDateTime CreatedAt;


}
