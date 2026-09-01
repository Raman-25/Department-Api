package com.project.department_api.Entity;

import com.project.department_api.Repositiories.DepartementRepositiories;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "department")
public class DepartmentEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Boolean isActive;
    private LocalDateTime CreatedAt;

}
