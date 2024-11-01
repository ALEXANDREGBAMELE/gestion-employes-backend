package com.example.gestionEmployerBackend.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionEmployerBackend.application.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * @PostMapping("/employees/create")
     * public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto
     * employeeDto) {
     * return ResponseEntity.ok(employeeService.save(employeeDto));
     * }
     * 
     * @GetMapping("/employees")
     * public ResponseEntity<ApiResponse<PaginatedResponse<EmployeeDto>>>
     * getAllEmployees(
     * 
     * @RequestParam(defaultValue = "0") int page,
     * @RequestParam(defaultValue = "10") int size
     *                            ) {
     * 
     *                            PaginatedResponse<EmployeeDto> employees =
     *                            employeeService.getAllEmployees(page, size);
     *                            // Création de l'objet ApiStatus
     *                            ApiStatus statut = new ApiStatus("200", "SUCCESS",
     *                            "Employees retrieved successfully");
     * 
     *                            // Création de la réponse API avec statut et
     *                            données
     *                            ApiResponse<PaginatedResponse<EmployeeDto>>
     *                            response = new ApiResponse<>(statut, employees);
     * 
     *                            // Retour de la réponse API
     *                            return ResponseEntity.ok(response);
     *                            }
     *                            //return
     *                            ResponseEntity.ok(employeeService.getAllEmployees());
     * 
     * 
     *                            @GetMapping("/employees/{id}")
     *                            public ResponseEntity<EmployeeDto>
     *                            getEmployeeById(@PathVariable Long id) {
     *                            return
     *                            ResponseEntity.ok(employeeService.getEmployeeById(id));
     *                            }
     * 
     *                            @PutMapping("/employees/update/{id}")
     *                            public ResponseEntity<EmployeeDto> updateEmployee(
     * @PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
     *               return ResponseEntity.ok(employeeService.updateEmployee(id,
     *               employeeDto));
     *               }
     **/
    @DeleteMapping("/employees/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get")
    public String get() {
        return "Hello world je change un instant";
    }
}
