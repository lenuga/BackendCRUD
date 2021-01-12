package com.part.vehicle.controller;


import com.part.vehicle.model.Part;
import com.part.vehicle.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parts")
@CrossOrigin(value ="http://localhost:4200")
public class PartController {
    @Autowired
    private PartService partService;

    @PostMapping("/addpart")
    public Part addPart(@RequestBody Part part) { return partService.savePart(part); }
    @PostMapping("/addParts")
    public List<Part> addParts(@RequestBody List<Part> parts) { return partService.saveParts(parts); }
    @GetMapping("/parts")
    public List<Part> findAllParts(){
        return partService.getParts();
    }
    @GetMapping("/{id}")
    public Optional<Part> findById(@PathVariable(value="id") Long id) {return partService.getPartById(id);}
    @GetMapping("/part/{name}")
    public Part findByPartName(@PathVariable(value = "name") String partName) {return partService.getPartByPartName(partName); }
    @PutMapping("/update")
    public Part updatePart(@RequestBody Part part){
        return partService.updatePart(part);
    }
    @DeleteMapping("/delete/{id}")
    public Long deletePart(@PathVariable(value="id") Long id) { return partService.deletePart(id); }
}
