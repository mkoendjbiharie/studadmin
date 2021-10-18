package com.adekus.studentadministratie.services;

import com.adekus.studentadministratie.domain.Vooropleiding;
import com.adekus.studentadministratie.repositories.VooropleidingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VooropleidingService {
    private final VooropleidingRepository vooropleidingRepository;

    public VooropleidingService(VooropleidingRepository vooropleidingRepository) {
        this.vooropleidingRepository = vooropleidingRepository;
    }

    public List<Vooropleiding> listAll(){
        return vooropleidingRepository.findAll();
    }

    public void delete(String id){
        vooropleidingRepository.deleteById(id);
    }

    public void save(Vooropleiding vooropleiding){
        vooropleidingRepository.save(vooropleiding);
    }

    public Vooropleiding get(String id){
        return vooropleidingRepository.findById(id).get();
    }
}
