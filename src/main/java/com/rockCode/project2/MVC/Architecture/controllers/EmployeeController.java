package com.rockCode.project2.MVC.Architecture.controllers;

import com.rockCode.project2.MVC.Architecture.dto.EmployeeDTO;
import com.rockCode.project2.MVC.Architecture.entities.EmployeeEntity;
import com.rockCode.project2.MVC.Architecture.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Dispature Servelet will map url
@RestController()
@RequestMapping(path = "/employees")
public class EmployeeController {
//    @GetMapping("/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "Secret message: dhdhbfdj#4nk%%dns";

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    @GetMapping("/{employeeId}")
//    public EmployeeDTO getEmployeeByID(@PathVariable Long employeeId){
//        return new EmployeeDTO(employeeId, "Sree Ram", "sreeramchray@gmail.com", 24, LocalDate.of(2024,1,1),true);
//    }
    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeByID(@PathVariable Long employeeId){
        return employeeRepository.findById(employeeId).orElse(null);
    }


//    @GetMapping
//    public String getEmployee(@RequestParam(required = false) String age){
//        return "Hi my age is :" + age;
//    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployee(@RequestParam(required = false) Integer age){
        return employeeRepository.findAll();
    }

//    @PostMapping
//    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO input){
//        return input;
//    }

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity input){
        return employeeRepository.save(input);
    }
}
