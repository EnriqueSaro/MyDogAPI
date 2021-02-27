package com.udacity.bootstrap.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogNotFoundException extends  RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();
    public DogNotFoundException(){
    }
    public DogNotFoundException(String message, Long invalid_location_id){
        super(message);
        extensions.put("InvalidLocationId",invalid_location_id);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }
}
