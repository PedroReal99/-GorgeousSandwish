package com.isep.gorgeoussandwich.repository;

import com.isep.gorgeoussandwich.model.Sandwich;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SandwichRepository extends JpaRepository<Sandwich, Long> {
	

}