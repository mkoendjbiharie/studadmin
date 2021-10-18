package com.adekus.studentadministratie.services;

import com.adekus.studentadministratie.domain.Burgelijkestaat;
import com.adekus.studentadministratie.repositories.BurgelijkeStaatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BurgelijkeStaatservice {
    private final BurgelijkeStaatRepository burgelijkeStaatRepository;

    public BurgelijkeStaatservice(BurgelijkeStaatRepository burgelijkeStaatRepository) {
        this.burgelijkeStaatRepository = burgelijkeStaatRepository;
    }

    public List<Burgelijkestaat> listAll(){
        return burgelijkeStaatRepository.findAll();
    }

    public void save(Burgelijkestaat burgelijkeStaat){
        burgelijkeStaatRepository.save(burgelijkeStaat);
    }

    public Burgelijkestaat get(int id){
        return burgelijkeStaatRepository.findById(id).get();
    }

    public void delete(int id){
        burgelijkeStaatRepository.deleteById(id);
    }
}
