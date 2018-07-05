package com.example.demo.GirlOperation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//Jpa
public interface GirlRepositoty extends JpaRepository<Girl,Integer> {

    //通过年龄来查询
    public List<Girl> findByAge(Integer age);

    public Girl findByGirlID(Long id);


    public List<Girl> findByAgeAndEmail(Integer age, String email);


//    //分页
    public Page<Girl> findByAge(Integer age, Pageable pageable);
//

    public void deleteGirlByAge(Integer age);

    public void deleteGirlByGirlID(Integer id);


}
