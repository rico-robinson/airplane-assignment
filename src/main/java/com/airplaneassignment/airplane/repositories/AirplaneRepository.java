package com.airplaneassignment.airplane.repositories;

import com.airplaneassignment.airplane.models.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository  extends JpaRepository<Airplane, Long> {}
