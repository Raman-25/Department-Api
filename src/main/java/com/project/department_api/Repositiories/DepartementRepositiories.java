package com.project.department_api.Repositiories;

import com.project.department_api.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepositiories extends JpaRepository<DepartmentEntity,Long> {

    boolean existsByTitle(String title);

}
