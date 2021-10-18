package com.adekus.studentadministratie.services;

import com.adekus.studentadministratie.domain.Collegejaar;
import com.adekus.studentadministratie.domain.Maxnummers;
import com.adekus.studentadministratie.domain.Studierichting;
import com.adekus.studentadministratie.repositories.MaxNummersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaxNummersService {
    private final MaxNummersRepository maxNummersRepository;

    public MaxNummersService(MaxNummersRepository maxNummersRepository) {
        this.maxNummersRepository = maxNummersRepository;
    }

    public List<Maxnummers> listAll(){
        return maxNummersRepository.findAll();
    }

    public void save(Maxnummers maxNummers){
        maxNummersRepository.save(maxNummers);
    }

    public void delete(int id){
        maxNummersRepository.deleteById(id);
    }

    public Maxnummers get(int id){
        return maxNummersRepository.findById(id).get();
    }

    public Long findMaxByCollegejaarAndStudierichting(String studierichting, Long collegejaar){
        return maxNummersRepository.findMaxByCollegejaarAndStudierichting(collegejaar,studierichting);
    }

    public void updateMaxNummers(Long collegejaar,String studierichting,Long max){
        maxNummersRepository.updateMaxnummers(collegejaar,studierichting,max);
    }

    public void insertNewMaxNummer(Long collegejaar,String studierichting,Long max){
        maxNummersRepository.insertNewMaxnummer(collegejaar,studierichting,max);
    }
}
