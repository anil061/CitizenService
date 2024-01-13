package com.learn.microservices.CitizenService.repositories;

import com.learn.microservices.CitizenService.Entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {
    public List<Citizen> findByVaccinationCenterId(Integer id);
}
