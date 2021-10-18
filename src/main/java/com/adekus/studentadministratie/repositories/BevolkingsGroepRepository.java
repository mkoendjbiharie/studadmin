package com.adekus.studentadministratie.repositories;

import com.adekus.studentadministratie.domain.Bevolkingsroep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BevolkingsGroepRepository extends JpaRepository<Bevolkingsroep,Integer> {
    //@Override
    //public List<Bevolkingsroep> findAllByOrderByBevolkingsGroepAsc();
    //public  List<Bevolkingsroep> findAllOrderByNaamAsc();
    //public  List<Bevolkingsroep> findBevolkingsroepByNaamOrderByNaamAsc();
}
