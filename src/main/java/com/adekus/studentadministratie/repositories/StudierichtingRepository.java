package com.adekus.studentadministratie.repositories;

import com.adekus.studentadministratie.domain.Studierichting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudierichtingRepository extends JpaRepository<Studierichting,String> {
}
