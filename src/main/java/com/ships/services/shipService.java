package com.ships.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.repositories.shipInterface ;
@Service
public class shipService {

	@Autowired
	private shipInterface shipInterface;
	
	public ArrayList<Ship> getShip(){
		return (ArrayList<Ship>) shipInterface.findAll();
	}
}
