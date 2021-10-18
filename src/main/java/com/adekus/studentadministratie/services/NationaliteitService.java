package com.adekus.studentadministratie.services;

import com.adekus.studentadministratie.domain.Nationaliteit;
import com.adekus.studentadministratie.repositories.NationaliteitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NationaliteitService {
    private final NationaliteitRepository nationaliteitRepository;

    public NationaliteitService(NationaliteitRepository nationaliteitRepository) {
        this.nationaliteitRepository = nationaliteitRepository;
    }

    public List<Nationaliteit> listAll(){
        return nationaliteitRepository.findAll();
    }

    public void save(Nationaliteit nationaliteit){
        nationaliteitRepository.save(nationaliteit);
    }

    public Nationaliteit get(int id){
        return nationaliteitRepository.findById(id).get();
    }

    public void delete(int id){
        nationaliteitRepository.deleteById(id);
    }
}
