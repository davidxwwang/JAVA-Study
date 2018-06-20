package com.example.demo;


import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface GirlRepositotyList  extends PagingAndSortingRepository<Girl, Integer> {

    public List<Girl> findByAgeIsBefore(Integer age);
}
