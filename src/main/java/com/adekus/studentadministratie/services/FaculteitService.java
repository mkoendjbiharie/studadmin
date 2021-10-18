package com.adekus.studentadministratie.services;

import com.adekus.studentadministratie.domain.Faculteit;
import com.adekus.studentadministratie.domain.Studierichting;
import com.adekus.studentadministratie.repositories.FaculteitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FaculteitService {
    private final FaculteitRepository faculteitRepository;
    private List<Studierichting> studierichtingList;

    public FaculteitService(FaculteitRepository faculteitRepository) {
        this.faculteitRepository = faculteitRepository;
    }

    public Faculteit get(String id){
        return faculteitRepository.findById(id).get();
    }

    public void save(Faculteit faculteit){
        faculteitRepository.save(faculteit);
    }

    public List<Faculteit> listAll(){
        return faculteitRepository.findAll();
    }

    public void delete(String id){
        faculteitRepository.deleteById(id);
    }
}
