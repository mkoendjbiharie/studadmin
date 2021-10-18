package com.adekus.studentadministratie.repositories;

import com.adekus.studentadministratie.domain.Collegejaar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CollegejaarRepository extends JpaRepository<Collegejaar, Integer> {
    @Query(value = "SELECT MAX(id) FROM Collegejaar")
    public int findMaxCollegejaar();

    public List<Collegejaar> findAllByOrderByIdDesc();
}
