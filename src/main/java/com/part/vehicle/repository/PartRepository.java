package com.part.vehicle.repository;

import com.part.vehicle.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Long> {

    Part findByPartName(String partName);
}
