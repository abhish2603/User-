package com.dailybuffer.SpringBoot.tutorial.service;

import com.dailybuffer.SpringBoot.tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentByID(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchdepartmentByName(String departmentName);
}
