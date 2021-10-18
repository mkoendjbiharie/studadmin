package com.adekus.studentadministratie.services;
/*
 * In this class, we inject an instance of PersoonRepository via private field 
 * using @Autowired annotation. At runtime, Spring Data JPA will generate a proxy 
 * instance of PersoonRepository and inject it to the instance of PersoonService 
 * class.
 * 
 * You might see this service class is redundant as it delegates all the calls to 
 * PersoonRepository. In fact, the business logic would be more complex over time, 
 * e.g. calling two or more repository instances.
 */

import com.adekus.studentadministratie.domain.Persoon;
import com.adekus.studentadministratie.repositories.PersoonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersoonService {
	private final PersoonRepository repoPersoon;

	public PersoonService(PersoonRepository repoPersoon) {
		this.repoPersoon = repoPersoon;
	}

	public List<Persoon> listAll(){
		return repoPersoon.findAllByOrderByNaamAscVoornaam1Asc();
	}
	
	public void save(Persoon persoon) {
		repoPersoon.save(persoon);
	}

	public Persoon get(long id) {
		return repoPersoon.findById(id).get();
	}

	public void delete(long id) {
		repoPersoon.deleteById(id);
	}

	public void edit(Persoon persoon){repoPersoon.save(persoon);}
}
