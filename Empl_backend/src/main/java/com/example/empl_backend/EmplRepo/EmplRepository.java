package com.example.empl_backend.EmplRepo;

import com.example.empl_backend.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplRepository extends JpaRepository<Employee, Long> {
}
