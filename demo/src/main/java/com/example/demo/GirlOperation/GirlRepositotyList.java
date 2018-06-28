package com.example.demo.GirlOperation;


import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface GirlRepositotyList  extends PagingAndSortingRepository<Girl, Integer> {

    public List<Girl> findByAgeIsBefore(Integer age);
}
