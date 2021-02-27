package com.udacity.bootstrap.service;

import com.udacity.bootstrap.entity.Dog;

import java.util.List;
import java.util.Optional;

public interface IDogService {
    public List<String> retrieveDogBreed();

    //public Dog retrieveDogById(Long id);

    public List<String> retrieveDogNames();

    String retrieveDogBreedById(Long dog_id);
}
