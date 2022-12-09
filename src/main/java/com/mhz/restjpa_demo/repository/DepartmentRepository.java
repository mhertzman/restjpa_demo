package com.mhz.restjpa_demo.repository;

import com.mhz.restjpa_demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
