package com.adekus.studentadministratie.services;

import com.adekus.studentadministratie.domain.Studierichting;
import com.adekus.studentadministratie.repositories.StudierichtingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudierichtingService {
    private final StudierichtingRepository studierichtingRepository;

    public StudierichtingService(StudierichtingRepository studierichtingRepository) {
        this.studierichtingRepository = studierichtingRepository;
    }

    public void save(Studierichting studierichting){
        studierichtingRepository.save(studierichting);
    }

    public Studierichting get(String id){
        return studierichtingRepository.findById(id).get();
    }

    public List<Studierichting> listAll(){
        return studierichtingRepository.findAll();
    }

    public void delete(String id){
        studierichtingRepository.deleteById(id);
    }
}
