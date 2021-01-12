package com.part.vehicle.service;

import com.part.vehicle.model.Part;
import com.part.vehicle.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PartService {
    @Autowired
    private PartRepository partRepository;
    private Part partDetails;

    public Part savePart(Part part) { return partRepository.save(part); }
    //save all
    public List<Part> saveParts(List<Part> parts){
        return partRepository.saveAll(parts);
    }
    public List<Part> getParts(){
        return partRepository.findAll();
    }
    public Optional<Part> getPartById(Long id){
        return partRepository.findById(id);
    }
    public Part getPartByPartName(String partName){
        return partRepository.findByPartName(partName);
    }

    public Long deletePart(Long id) {
        partRepository.deleteById(id);
        return id;
    }
    public Part updatePart(Part part)
    {
        Optional<Part> exisitingPart = partRepository.findById(part.getId());
        exisitingPart.get().setPartName(part.getPartName());
        exisitingPart.get().setPrice(part.getPrice());

        return partRepository.save(exisitingPart.get());
    }
}
