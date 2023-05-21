package com.example.Enum.Repository;

import com.example.Enum.Entity.EmployeeStringEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeStringRepository extends JpaRepository<EmployeeStringEnum,Long> {
}
