package com.adekus.studentadministratie.services;

import com.adekus.studentadministratie.domain.Collegejaar;
import com.adekus.studentadministratie.repositories.CollegejaarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CollegejaarService {
    private final CollegejaarRepository collegejaarRepository;

    public CollegejaarService(CollegejaarRepository collegejaarRepository) {
        this.collegejaarRepository = collegejaarRepository;
    }

    public List<Collegejaar> listAll(){
        return collegejaarRepository.findAll();
    }

    public void save(Collegejaar collegejaar){
        collegejaarRepository.save(collegejaar);
    }

    public void delete(int id){
        collegejaarRepository.deleteById(id);
    }

    public Collegejaar get(int id){
        return collegejaarRepository.findById(id).get();
    }

    public Integer findMaxCollegejaar(){
        //System.out.println("Max collegejaar "+collegejaarRepository.findMaxCollegejaar());
        return collegejaarRepository.findMaxCollegejaar();
    }
}
