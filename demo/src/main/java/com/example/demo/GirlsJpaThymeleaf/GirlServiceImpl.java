package com.example.demo.GirlsJpaThymeleaf;

import com.example.demo.GirlOperation.Girl;
import com.example.demo.GirlOperation.GirlRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

// 业务层
@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlRepositoty girlRepository;


    @Override
    public List<Girl> getGirlList() {
        return girlRepository.findAll();
    }

    @Override
    public Girl findGirlById(long id) {
        return girlRepository.findByGirlID(id);
    }

    @Override
    public Girl save(Girl girl) {
        return girlRepository.save(girl);
    }

    @Override
    public void edit(Girl girl) {
        girlRepository.save(girl);

    }

    @Override
    @Transactional
    public void deleteGirlById(Integer id) {
        girlRepository.deleteGirlByGirlID(id);

    }


}
