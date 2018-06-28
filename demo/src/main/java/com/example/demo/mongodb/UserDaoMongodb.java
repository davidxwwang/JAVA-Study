package com.example.demo.mongodb;


public interface UserDaoMongodb {

    public void saveUser(UserEntityMongodb user);

    public UserEntityMongodb findUserByUserName(String userName);

    public int updateUser(UserEntityMongodb user);

    public void deleteUserById(Long id);
}
