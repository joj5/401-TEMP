package com.asac.security.web;

import com.asac.security.domain.Department;
import com.asac.security.infrastructure.DepartmentRepository;
import com.asac.security.infrastructure.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    @Autowired
    DepartmentService departmentService;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @PostMapping("/departments")
    ResponseEntity<Department> newDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(departmentRepository.save(department), HttpStatus.CREATED);
    }

    @GetMapping("/departments/exams")
    String showExamResults() {
        departmentService.calculateExamMarks();
        return "exams";
    }
}
