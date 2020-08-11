package com.example.gemfiree.repository;

import com.example.gemfiree.domain.RandomUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RandomUserRepository extends CrudRepository<RandomUser, String> {
    @Override
    List<RandomUser> findAll();
}
