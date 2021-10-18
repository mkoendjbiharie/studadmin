package com.adekus.studentadministratie.repositories;

import com.adekus.studentadministratie.domain.Faculteit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaculteitRepository extends JpaRepository<Faculteit,String> {
}
