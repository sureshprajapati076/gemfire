package com.example.gemfiree.domain;


import java.util.List;

public class ApiResponseDto {

    private List<RandomUser> results;

    public List<RandomUser> getResults() {
        return results;
    }

    public void setResults(List<RandomUser> results) {
        this.results = results;
    }

    public ApiResponseDto() {
    }

    public ApiResponseDto(List<RandomUser> results) {
        this.results = results;
    }
}
