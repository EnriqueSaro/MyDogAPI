package com.udacity.bootstrap.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.repository.DogRepository;
import com.udacity.bootstrap.exception.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class Mutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed){
       long rows_deleted = dogRepository.deleteByBreed(breed);
       if ( rows_deleted > 0)
            return true;
       else
           return false;
    }

    public Dog updateDogName(String new_name, Long id){
        Optional<Dog> dog = dogRepository.findById(id);
        if (dog.isPresent()){
            Dog updated_dog = dog.get();
            updated_dog.setName(new_name);
            return dogRepository.save(updated_dog);
        }else{
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
