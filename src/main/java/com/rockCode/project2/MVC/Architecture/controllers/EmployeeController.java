package com.rockCode.project2.MVC.Architecture.controllers;

import com.rockCode.project2.MVC.Architecture.dto.EmployeeDTO;
import com.rockCode.project2.MVC.Architecture.entities.EmployeeEntity;
import com.rockCode.project2.MVC.Architecture.repositories.EmployeeRepository;
import com.rockCode.project2.MVC.Architecture.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Dispature Servelet will map url
@RestController()
@RequestMapping(path = "/employees")
public class EmployeeController {
//    @GetMapping("/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "Secret message: dhdhbfdj#4nk%%dns";

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    //    @GetMapping("/{employeeId}")
//    public EmployeeDTO getEmployeeByID(@PathVariable Long employeeId){
//        return new EmployeeDTO(employeeId, "Sree Ram", "sreeramchray@gmail.com", 24, LocalDate.of(2024,1,1),true);
//    }
    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeByID(@PathVariable Long employeeId){
        return employeeService.getEmployeeByID(employeeId);
    }


//    @GetMapping
//    public String getEmployee(@RequestParam(required = false) String age){
//        return "Hi my age is :" + age;
//    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployee(@RequestParam(required = false) Integer age){
        return employeeService.getAllEmployee();
    }

//    @PostMapping
//    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO input){
//        return input;
//    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO input){
        return employeeService.createEmployee(input);
    }
}
