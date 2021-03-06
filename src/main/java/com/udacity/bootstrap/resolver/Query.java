package com.udacity.bootstrap.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.exception.DogNotFoundException;
import com.udacity.bootstrap.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }

    public Dog findDogBreedById(Long id){
        Optional<Dog> optional_dog = dogRepository.findById(id);
        if (optional_dog.isPresent()){
            return optional_dog.get();
        }else{
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
