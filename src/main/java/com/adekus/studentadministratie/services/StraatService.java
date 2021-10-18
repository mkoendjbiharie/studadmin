package com.adekus.studentadministratie.services;

import com.adekus.studentadministratie.domain.Straat;
import com.adekus.studentadministratie.repositories.StraatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StraatService {
    private final StraatRepository straatRepository;

    public StraatService(StraatRepository straatRepository) {
        this.straatRepository = straatRepository;
    }

    public List<Straat> listAll(){
        return straatRepository.findAllByOrderByNaamAsc();
    }

    public Straat get(int id){
        return straatRepository.findById(id).get();
    }

    public void save(Straat straat){
        straatRepository.save(straat);
    }

    public void delete(int id){
        straatRepository.deleteById(id);
    }
}
