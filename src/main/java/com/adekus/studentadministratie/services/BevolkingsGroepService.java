package com.adekus.studentadministratie.services;

import com.adekus.studentadministratie.domain.Bevolkingsroep;
import com.adekus.studentadministratie.repositories.BevolkingsGroepRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BevolkingsGroepService {
    private final BevolkingsGroepRepository bevolkingsGroepRepository;

    public BevolkingsGroepService(BevolkingsGroepRepository bevolkingsGroepRepository) {
        this.bevolkingsGroepRepository = bevolkingsGroepRepository;
    }

    public List<Bevolkingsroep> listAll(){
        return bevolkingsGroepRepository.findAll();
    }

    public void save(Bevolkingsroep bevolkingsGroep){
        bevolkingsGroepRepository.save(bevolkingsGroep);
    }

    public Bevolkingsroep get(int id){
        return bevolkingsGroepRepository.findById(id).get();
    }

    public void delete(int id){
        bevolkingsGroepRepository.deleteById(id);
    }
}
