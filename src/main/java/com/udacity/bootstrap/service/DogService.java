package com.udacity.bootstrap.service;

import com.udacity.bootstrap.exception.DogNotFoundException;
import com.udacity.bootstrap.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService implements IDogService {
    @Autowired
    private DogRepository dogRepository;

    public List<String> retrieveDogBreed(){
        return dogRepository.findAllBreed();
    }
    public String retrieveDogBreedById(Long id){
        Optional<String> optional_breed = Optional.ofNullable( dogRepository.findBreedById(id) );
        String breed = optional_breed.orElseThrow(DogNotFoundException::new);
        return breed;
    }
    public List<String> retrieveDogNames(){
        return dogRepository.findAllName();
    }
}
