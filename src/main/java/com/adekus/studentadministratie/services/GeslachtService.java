package com.adekus.studentadministratie.services;

import com.adekus.studentadministratie.domain.Geslacht;
import com.adekus.studentadministratie.repositories.GeslachtRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GeslachtService {
    private final GeslachtRepository geslachtRepository;

    public GeslachtService(GeslachtRepository geslachtRepository){
        this.geslachtRepository = geslachtRepository;
    }

    public List<Geslacht> listAll(){
        return geslachtRepository.findAll();
    }

    public void delete(int id){
        geslachtRepository.deleteById(id);
    }

    public void save(Geslacht geslacht){
        geslachtRepository.save(geslacht);
    }

    public Geslacht get(int id){
        return geslachtRepository.findById(id).get();
    }
}
