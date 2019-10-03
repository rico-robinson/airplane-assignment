package com.airplaneassignment.airplane.controllers;

import com.airplaneassignment.airplane.models.Airplane;
import com.airplaneassignment.airplane.services.AirplaneService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST API Controller class handling application endpoints for the Airplane object
 */
@RestController
@RequestMapping("/api/v1/airplanes")
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    /**
     * Get all Airplanes through AirplaneService
     * @return All airplanes
     */
    @RequestMapping ( value = "/get", method = RequestMethod.GET )
    public Iterable<Airplane> getAllAirplanes() {
        return this.airplaneService.findAll();
    }

    @RequestMapping ( value = "/get/{modelNo}", method = RequestMethod.GET )
    public Airplane getAirplaneByModelNo(@PathVariable Long modelNo) {
        return this.airplaneService.findByModelNo(modelNo);
    }

    /**
     * Add a new airplane
     * @param airplane The airplane
     * @return The airplane object if created successfully
     */
    @RequestMapping ( value = "/add", method = RequestMethod.POST )
    public Airplane addAirplane(@RequestBody Airplane airplane) {
        return this.airplaneService.add(airplane);
    }

    /**
     * Update Airplane details
     * @param airplane The airplane to be updated including the new information
     * @return The successfully updated object
     * @throws NotFoundException If Airplane can't be found
     */
    @RequestMapping ( value = "/update", method = RequestMethod.POST )
    public Airplane updateAirplane(@RequestBody Airplane airplane) throws NotFoundException {
        return this.airplaneService.update(airplane);
    }

    @RequestMapping( value = "/delete/{modelNo}", method = RequestMethod.DELETE)
    public void deleteByModelNo(@PathVariable Long modelNo) {
        this.airplaneService.deleteByModelNo(modelNo);
    }
}