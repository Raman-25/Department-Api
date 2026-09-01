package com.project.department_api.Service;


import com.project.department_api.Dto.DepartmentDto;
import com.project.department_api.Entity.DepartmentEntity;
import com.project.department_api.Exceptions.DuplicateResourceException;
import com.project.department_api.Exceptions.ResourceNotFoundException;
import com.project.department_api.Repositiories.DepartementRepositiories;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartementRepositiories departementRepositiories;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartementRepositiories departementRepositiories, ModelMapper modelMapper) {
        this.departementRepositiories = departementRepositiories;
        this.modelMapper = modelMapper;
    }

    public DepartmentDto getDepartmentById(Long id){

      DepartmentEntity departmentEntity = departementRepositiories.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("Department With Id " + id +" Not Exist"));

          return modelMapper.map(departmentEntity,DepartmentDto.class);
    }

    public List<DepartmentDto> getDepartementList(){

        List<DepartmentEntity> departmentEntities = departementRepositiories.findAll();
        return departmentEntities
                .stream()
                .map(departmentEntity ->modelMapper.map(departmentEntity,DepartmentDto.class)).
                collect(Collectors.toList());

    }

    public DepartmentDto CreateNewDepartment(DepartmentDto inputDepartment){

        DepartmentEntity toSavedepartmentEntity = modelMapper.map(inputDepartment,DepartmentEntity.class);

        if(departementRepositiories.existsByTitle(toSavedepartmentEntity.getTitle())){
            throw new DuplicateResourceException("Department Already Exist");
        }

        toSavedepartmentEntity.setCreatedAt(LocalDateTime.now());
        DepartmentEntity SavedDepartmentEntity = departementRepositiories.save(toSavedepartmentEntity);

        return modelMapper.map(SavedDepartmentEntity,DepartmentDto.class);
    }

    public DepartmentDto UpdateDepartmentById(Long id , DepartmentDto departmentDto){

        DepartmentEntity departmentEntity = modelMapper.map(departmentDto,DepartmentEntity.class);

        if(departementRepositiories.existsByTitle(departmentEntity.getTitle())){
            throw new DuplicateResourceException("Department Already Exist");
        }

        departementRepositiories.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Department With Id " + id +" Not Exist"));

        departmentEntity.setId(id);
        departmentEntity.setCreatedAt(LocalDateTime.now());
        DepartmentEntity ToSaveDepartmentEntity = departementRepositiories.save(departmentEntity);
        return modelMapper.map(ToSaveDepartmentEntity,DepartmentDto.class);

    }

    public void DeleteDepartmentById (Long id){

        departementRepositiories.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Department With Id " + id +" Not Exist"));
        departementRepositiories.deleteById(id);

    }





}
