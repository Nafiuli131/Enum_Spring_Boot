package com.example.Enum.Repository;

import com.example.Enum.Entity.ThreeParameterEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreeParamEmployeeRepository extends JpaRepository<ThreeParameterEmployee,Long> {
}
