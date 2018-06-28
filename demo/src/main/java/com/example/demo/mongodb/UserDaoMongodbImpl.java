package com.example.demo.mongodb;

import com.example.demo.mybatis.UserEntity;
import com.example.demo.mybatis.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class UserDaoMongodbImpl implements UserDaoMongodb {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void saveUser(UserEntityMongodb user) {
        mongoTemplate.save(user);
    }

    @Override
    public UserEntityMongodb findUserByUserName(String userName) {
        Query query=new Query(Criteria.where("userName").is(userName));
        UserEntityMongodb user =  mongoTemplate.findOne(query , UserEntityMongodb.class);
        return user;
    }

    @Override
    public int updateUser(UserEntityMongodb user) {
        // 使用'id'作为关键值更新
        Query query=new Query(Criteria.where("id").is(user.getId()));
        Update update= new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,UserEntityMongodb.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);

        return 0;
    }

    @Override
    public void deleteUserById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,UserEntity.class);
    }
}
