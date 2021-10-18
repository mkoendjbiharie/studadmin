package com.adekus.studentadministratie.repositories;

import com.adekus.studentadministratie.domain.Burgelijkestaat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurgelijkeStaatRepository extends JpaRepository<Burgelijkestaat,Integer> {
}
