package com.project.department_api.Controller;



import com.project.department_api.Dto.DepartmentDto;
import com.project.department_api.Service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/department")
public class DepartmentController {


    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {this.departmentService = departmentService;}



    @GetMapping("{DepartmentId}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable(name="DepartmentId")Long id){

        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getDepartementList(){

       return ResponseEntity.ok(departmentService.getDepartementList());

    }

    @PostMapping
    public ResponseEntity<DepartmentDto> CreateNewDepartment(@Valid @RequestBody DepartmentDto inputDepartment){

        DepartmentDto CreatedDepartment = departmentService.CreateNewDepartment(inputDepartment);

        return new ResponseEntity<>(CreatedDepartment,HttpStatus.CREATED);

    }

    @PutMapping(path = "/{DepartmentId}")
    public ResponseEntity<DepartmentDto> UpdateDepartmentById( @PathVariable(name = "DepartmentId") Long id, @Valid @RequestBody DepartmentDto departmentDto){


        return ResponseEntity.ok(departmentService.UpdateDepartmentById(id, departmentDto));

    }

    @DeleteMapping(path = "/{DepartmentId}")
    public ResponseEntity<Void> DeleteDepartmentById (@PathVariable(name = "DepartmentId") Long id){

        departmentService.DeleteDepartmentById(id);

        return ResponseEntity.noContent().build();
    }





}
