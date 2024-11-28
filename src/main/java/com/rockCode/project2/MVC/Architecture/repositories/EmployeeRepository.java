package com.rockCode.project2.MVC.Architecture.repositories;

import com.rockCode.project2.MVC.Architecture.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
