package com.adekus.studentadministratie.services;

import com.adekus.studentadministratie.domain.District;
import com.adekus.studentadministratie.repositories.DistrictRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DistrictService {
    private final DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public List<District> listAll(){
        return districtRepository.findAll();
    }

    public void save(District district){
        districtRepository.save(district);
    }

    public District get(int id){
        return districtRepository.findById(id).get();
    }

    public void delete(int id){
        districtRepository.deleteById(id);
    }
}
