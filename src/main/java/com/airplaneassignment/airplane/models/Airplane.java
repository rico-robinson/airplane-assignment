package com.airplaneassignment.airplane.models;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The airplane pojo
 */
@Entity(name = "airplane")
public class Airplane {

    /**
     * Primary key for the Database must be set by application
     * Model numbers are unique by definition
     */
    @Id
    @Column(name = "modelNo", updatable = false, nullable = false)
    private Long modelNo;

    private int fuelLevel;

    @Column
    @NonNull
    private String brand;

    @Column
    @NonNull
    private String type;

    /**
     * Empty constructor for jpa
     */
    public Airplane() {
    }

    public Airplane(Long modelNo, int fuelLevel, String brand, String type) {
        this.modelNo = modelNo;
        this.brand = brand;
        this.fuelLevel = fuelLevel;
        this.type = type;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public Long getModelNo() {
        return modelNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
