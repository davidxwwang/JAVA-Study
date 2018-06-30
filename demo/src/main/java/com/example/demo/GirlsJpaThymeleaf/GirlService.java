package com.example.demo.GirlsJpaThymeleaf;

import com.example.demo.GirlOperation.Girl;

import java.util.List;

public interface GirlService {

    public List<Girl> getGirlList();

    public Girl findGirlById(long id);

    public Girl save(Girl girl);

    public void edit(Girl girl);

    public void deleteGirlById(Integer id);



}
