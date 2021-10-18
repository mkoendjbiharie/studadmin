package com.adekus.studentadministratie.repositories;

import com.adekus.studentadministratie.domain.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District,Integer> {
}
