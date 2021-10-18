package com.adekus.studentadministratie.repositories;

import com.adekus.studentadministratie.domain.Straat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StraatRepository extends JpaRepository<Straat,Integer> {

    public List<Straat> findAllByOrderByNaamAsc();
}
