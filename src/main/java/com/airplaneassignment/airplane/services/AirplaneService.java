package com.airplaneassignment.airplane.services;

import com.airplaneassignment.airplane.models.Airplane;
import com.airplaneassignment.airplane.repositories.AirplaneRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    /**
     * Get an airplane by model number
     * @param modelNo The model number to search in the database
     * @return Airplane object by model number
     */
    public Airplane findByModelNo(Long modelNo) {
        return this.airplaneRepository.findById(modelNo).get();
    }

    /**
     * Get all airplanes from the database
     * @return A list of Airplanes
     */
    public List<Airplane> findAll() {
        return this.airplaneRepository.findAll();
    }

    /**
     * Add Airplane to database and commit (flush)
     * @param airplane The airplane to save
     * @return the saved object
     */
    public Airplane add(Airplane airplane) {
        return this.airplaneRepository.saveAndFlush(airplane);
    }

    /**
     * Delete an airplane based on it's model nubmer
     * @param modelNo the model number
     */
    public void deleteByModelNo(Long modelNo) {
        this.airplaneRepository.deleteById(modelNo);
    }

    /**
     * Update an Airplane object if it exists in database
     * @param airplane
     * @return
     * @throws NotFoundException
     */
    public Airplane update(Airplane airplane) throws NotFoundException {
        Airplane airplaneUpdatable = this.findByModelNo(airplane.getModelNo());
        if (airplaneUpdatable == null) throw new NotFoundException("Airplane not found in database");
        return this.airplaneRepository.saveAndFlush(airplane);
    }
}
