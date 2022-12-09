package com.mhz.restjpa_demo.service;

// Java Program to Illustrate DepartmentServiceImpl File

// Importing required classes
import java.util.List;
import java.util.Objects;

import com.mhz.restjpa_demo.entity.Department;
import com.mhz.restjpa_demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Annotation
@Service

// Class
public class DepartmentServiceImpl
        implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Save operation
    @Override
    public Department saveDepartment(Department department)
    {
        return departmentRepository.save(department);
    }

    // Read operation
    @Override public List<Department> fetchDepartmentList()
    {
        return (List<Department>)
                departmentRepository.findAll();
    }

    // Update operation
    @Override
    public Department
    updateDepartment(Department department,
                     Long departmentId)
    {
        Department depDB
                = departmentRepository.getReferenceById(departmentId);

        if (Objects.nonNull(department.getName())
                && !"".equalsIgnoreCase(
                department.getName())) {
            depDB.setName(
                    department.getName());
        }

        depDB.setActive(department.getActive());

        return departmentRepository.save(depDB);
    }

    // Delete operation
    @Override
    public void deleteDepartmentById(Long departmentId)
    {
        departmentRepository.deleteById(departmentId);
    }
}

