package com.adekus.studentadministratie.repositories;

import com.adekus.studentadministratie.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student,String> {
    @Query(value = "SELECT MAX(id) FROM Collegejaar")
    public Integer findMaxCollegejaar();

}
