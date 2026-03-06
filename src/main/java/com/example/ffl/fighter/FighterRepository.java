package com.example.ffl.fighter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FighterRepository extends JpaRepository<Fighter, Integer> {

    void deleteByName(String name);
    //find any player by their name,handles cases where user isn't found
    Optional<Fighter> findByName(String name);
}