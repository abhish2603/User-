package com.dailybuffer.SpringBoot.tutorial.controller;

import com.dailybuffer.SpringBoot.tutorial.entity.Department;
import com.dailybuffer.SpringBoot.tutorial.service.DepartmentNotFoundException;
import com.dailybuffer.SpringBoot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside savedepartment of Department Controller");
        return departmentService.saveDepartment(department);

    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchdepartment of Department Controller");
        return departmentService.fetchDepartmentList();

    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentByID(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentByID(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentByID(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentByID(departmentId);
        return "Department deleted Successfully";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchdepartmentByName(departmentName);
    }

}
