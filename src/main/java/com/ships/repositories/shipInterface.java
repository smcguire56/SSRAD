package com.ships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ships.model.Ship;

@Repository
public interface shipInterface extends CrudRepository<Ship, Long>{

}
