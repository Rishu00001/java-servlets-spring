package com.example.jpa_relationships.controller;

import com.example.jpa_relationships.model.Department;
import com.example.jpa_relationships.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/department")
public class DepartmentController {
    DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){

        this.departmentService = departmentService;
    }

//    @PostMapping
//    public ResponseEntity<Department> createDepartment(
//            @RequestBody Department department){
//        Department response = departmentService.createDepartment(department);
//        return ResponseEntity.ok(response);
//    }

    @DeleteMapping("/{deptId}")
    public ResponseEntity<String> removeDepartment(
            @PathVariable Long deptId){

        departmentService.removeDepartment(deptId);
        return ResponseEntity.ok("Deleted");
    }













//    @PostMapping("/withStudent")
//    public ResponseEntity<Department> createDepartmentWithStudent(
//            @RequestBody Department department,
//            @RequestParam String studentName){
//        Department response = departmentService
//                .createDepartment(department,studentName);
//        return ResponseEntity.ok(response);
//    }

    @GetMapping("/{deptId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long deptId){
        Department departmentResponse =
                departmentService.getDepartmentById(deptId);
        return ResponseEntity.ok(departmentResponse);
    }
}
