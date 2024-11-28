package com.rockCode.project2.MVC.Architecture.services;

import com.rockCode.project2.MVC.Architecture.dto.EmployeeDTO;
import com.rockCode.project2.MVC.Architecture.entities.EmployeeEntity;
import com.rockCode.project2.MVC.Architecture.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeByID(Long employeeId) {
       EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).orElse(null);
       return modelMapper.map(employeeEntity,EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployee() {
       List<EmployeeEntity> employeeEntities =  employeeRepository.findAll();
       return employeeEntities
               .stream()
               .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
               .collect(Collectors.toList());
    }


    public EmployeeDTO createEmployee(EmployeeDTO input) {
        EmployeeEntity toSaveEmp = modelMapper.map(input,EmployeeEntity.class);
        EmployeeEntity employeeEntity = employeeRepository.save(toSaveEmp);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }
}
