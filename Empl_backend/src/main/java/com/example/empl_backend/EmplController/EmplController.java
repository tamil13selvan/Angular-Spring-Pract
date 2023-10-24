package com.example.empl_backend.EmplController;

import com.example.empl_backend.EmplRepo.EmplRepository;
import com.example.empl_backend.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class EmplController {

    @Autowired
    private EmplRepository emplRepository;
    @GetMapping("/employeesAll")
    @CrossOrigin(origins="http://localhost:4200")
    public List<Employee> getAllEmployees(){
        return emplRepository.findAll();
    }

    @PostMapping("/save")
    @CrossOrigin(origins="http://localhost:4200")
    public Employee createEmployee(@RequestBody Employee employee){

        return emplRepository.save(employee);
    }

    @GetMapping("/employees/{id}")
    @CrossOrigin(origins="http://localhost:4200")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){

        Employee employee = emplRepository.findById(id).orElse(new Employee());
        return ResponseEntity.ok(employee);

    }

    @PutMapping("/employees/{id}")
    @CrossOrigin(origins="http://localhost:4200")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee employee = emplRepository.findById(id).orElse(new Employee());

        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setExperience(employeeDetails.getExperience());
        employee.setTech(employeeDetails.getTech());

        Employee updatedEmployee = emplRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

     @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
         Employee employee = emplRepository.findById(id).orElse(new Employee());
         emplRepository.delete(employee);

         Map<String, Boolean> response = new HashMap<>();
         response.put("deleted", Boolean.TRUE);
         return ResponseEntity.ok(response);
     }



}
