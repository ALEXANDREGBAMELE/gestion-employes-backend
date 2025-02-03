package com.example.gestionEmployerBackend.interfaces.rest;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionEmployerBackend.application.dtos.DepartmentDto;
import com.example.gestionEmployerBackend.application.service.IDepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final IDepartmentService departmentService;

    // Constructor-based dependency injection
    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // GET all departments with pagination and sorting
    @GetMapping("/getAll")
    public ResponseEntity<Page<DepartmentDto>> getAllDepartments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "ASC") String sortDir,
            @RequestParam(defaultValue = "id") String sort) {
        // Call service with pagination parameters
        Page<DepartmentDto> departments = departmentService.getAll(page, size, sortDir, sort);
        return ResponseEntity.ok(departments);
    }

    // GET a specific department by ID
    @GetMapping("/getByID/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
        DepartmentDto departmentDto = departmentService.getById(id);
        return ResponseEntity.ok(departmentDto);
    }

    // POST to create a new department
    @PostMapping("/create")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto createdDepartment = departmentService.create(departmentDto);
        return ResponseEntity.status(201).body(createdDepartment); // 201 for created resource
    }

    // PUT to update an existing department
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Long id,
            @RequestBody DepartmentDto departmentDto) {
        departmentDto.setId(id); // Setting the department ID for update
        DepartmentDto updatedDepartment = departmentService.update(departmentDto);
        return ResponseEntity.ok(updatedDepartment);
    }

    // DELETE a department
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.delete(id);
        return ResponseEntity.noContent().build(); // 204 for successful deletion
    }
}
