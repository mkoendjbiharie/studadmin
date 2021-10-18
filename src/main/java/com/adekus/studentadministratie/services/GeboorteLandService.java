package com.adekus.studentadministratie.services;

import com.adekus.studentadministratie.domain.Geboorteland;
import com.adekus.studentadministratie.repositories.GeboortelandRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GeboorteLandService {
    private final GeboortelandRepository geboortelandRepository;

    public GeboorteLandService(GeboortelandRepository geboortelandRepository) {
        this.geboortelandRepository = geboortelandRepository;
    }

    public List<Geboorteland> listAll(){
        return geboortelandRepository.findAll();
    }

    public void save(Geboorteland geboorteLand){
        geboortelandRepository.save(geboorteLand);
    }

    public Geboorteland get(int id) {
        return geboortelandRepository.findById(id).get();
    }

    public void delete(int id){
        geboortelandRepository.deleteById(id);
    }

}
