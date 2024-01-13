package com.learn.microservices.CitizenService.Controller;

import com.learn.microservices.CitizenService.Entity.Citizen;
import com.learn.microservices.CitizenService.repositories.CitizenRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
Logger logger = LoggerFactory.getLogger(CitizenController.class);
    @Autowired
    private CitizenRepo repo;

    @RequestMapping(path = "/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @RequestMapping(path = "/id/{id}")
    public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id) {
        logger.info("CitizenId :" + id);
        List<Citizen> citizensList = repo.findByVaccinationCenterId(id);

        return new ResponseEntity<List<Citizen>>(citizensList, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen) {
        logger.info("New Citizen Details " + newCitizen);
        Citizen citizen = repo.save(newCitizen);
        return new ResponseEntity<>(citizen, HttpStatus.OK);
    }
}