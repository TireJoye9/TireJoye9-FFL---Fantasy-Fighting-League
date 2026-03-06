package com.example.ffl.fighter;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


//contains business logic
@Component
public class FighterService {

    private final FighterRepository fighterRepository;


    public FighterService(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    private List<Fighter> getFighters() {
        return fighterRepository.findAll();
    }

    public List<Fighter> getPlayerByNationality(String searchText) {
        return fighterRepository.findAll().stream()
                .filter(f -> f.getNationality().equals(searchText))
                .collect(Collectors.toList());
    }

    public List<Fighter> getFightersByName(String name) {
        return  fighterRepository.findAll().stream()
                .filter(f -> f.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    //String searchtext for seach bar fucntionality
    public List<Fighter> getFightersByWeightClass(String searchText) {
        return fighterRepository.findAll().stream()
                .filter(f -> f.getWeightClass().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    //Might change to just Repository method for searching
    public List<Fighter> getFightersByMartialArt(String searchText) {
        return fighterRepository.findAll().stream()
                .filter(f-> f.getMartialArt().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    //Gonna leave height as I might change it to inches.
    public List<Fighter> getFightersByHeight(Integer searchText) {
        return fighterRepository.findAll().stream()
                .filter(f ->f.getHeight().equals(searchText))
                .collect(Collectors.toList());
    }

    public Fighter addFighter(Fighter fighter) {
        fighterRepository.save(fighter);
        return fighter;
    }

    public Fighter updateFighter(Fighter updatedFighter) {
        Optional<Fighter> existingFighter = fighterRepository.findByName(updatedFighter.getName());

        if (existingFighter.isPresent()) {
            Fighter fighterToUpdate = existingFighter.get();
            fighterToUpdate.setName(updatedFighter.getName());
            fighterToUpdate.setWeightClass(updatedFighter.getWeightClass());
            fighterToUpdate.setMartialArt(updatedFighter.getMartialArt());
            fighterToUpdate.setHeight(updatedFighter.getHeight());
            fighterToUpdate.setNationality(updatedFighter.getNationality());

            fighterRepository.save(fighterToUpdate);
            return fighterToUpdate;
        }
        // nothing was found in the data base
        return null;
        }

        //Maintains data integrity during delete
        @Transactional
        Fighter deleteFighter(String name) {
        fighterRepository.deleteByName(name);
            return null;
        }
}
