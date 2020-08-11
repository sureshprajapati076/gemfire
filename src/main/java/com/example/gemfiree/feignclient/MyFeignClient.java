package com.example.gemfiree.feignclient;

import com.example.gemfiree.domain.ApiResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "demo", url = "https://randomuser.me/")
public interface MyFeignClient {


    @GetMapping(value = "api")
    ApiResponseDto getRandomUsers(@RequestParam Integer results);

}
