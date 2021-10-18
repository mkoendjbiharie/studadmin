package com.adekus.studentadministratie.repositories;

import com.adekus.studentadministratie.domain.Persoon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * JpaRepository defines standard CRUD methods, plus JPA-specific operations. 
 * We don’t have to write implementation code because Spring Data JPA will 
 * generate necessary code at runtime, in form of proxy instances.

So the purpose of writing the repository interface is to tell Spring Data JPA 
about the domain type (Product) and ID type (Long) to work with.
 */
public interface PersoonRepository extends JpaRepository<Persoon,Long> {
    public List<Persoon> findAllByOrderByNaamAscVoornaam1Asc();
}
