package com.udacity.bootstrap.web;

import com.udacity.bootstrap.service.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    private IDogService dogService;

    @Autowired
    public DogController(IDogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping(path = "/dogs-breed")
    public ResponseEntity<List<String>> findAllBreeds(){
        List<String> breeds = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(breeds, HttpStatus.OK);
    }
    @GetMapping(path = "/dogs-breed/{dog_id}")
    public ResponseEntity<String> findDogBreedById(@PathVariable Long dog_id){
      //  try{
            String breed = dogService.retrieveDogBreedById(dog_id);
            return new ResponseEntity<String>(breed, HttpStatus.OK);
//        } catch (DogNotFoundException e) {
//            return new ResponseEntity<String>("Id doesn't exist", HttpStatus.NOT_FOUND);
//        }
    }
    @GetMapping(path = "/dogs-names")
    public ResponseEntity<List<String>> findAllDogNames(){
        List<String> dog_names = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(dog_names, HttpStatus.OK);
    }

}
