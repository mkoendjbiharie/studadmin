package com.adekus.studentadministratie.repositories;

import com.adekus.studentadministratie.domain.Nationaliteit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationaliteitRepository extends JpaRepository<Nationaliteit,Integer> {
}
