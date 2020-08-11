package com.example.gemfiree.controller;

import com.example.gemfiree.domain.ApiResponseDto;
import com.example.gemfiree.domain.RandomUser;
import com.example.gemfiree.feignclient.MyFeignClient;
import com.example.gemfiree.repository.RandomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    RandomUserRepository randomUserRepository;


    @Autowired
    MyFeignClient myFeignClient;


    @GetMapping("/fetch")
    public ApiResponseDto fetchAll(@RequestParam Integer results) {




        List<RandomUser> result = randomUserRepository.findAll();
        if (!result.isEmpty()) {

            return new ApiResponseDto(result);
        }


        ApiResponseDto apiResponseDto = myFeignClient.getRandomUsers(results);

        randomUserRepository.saveAll(apiResponseDto.getResults());
        return apiResponseDto;


    }
}
