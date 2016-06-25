package com.small.business.dao.user;

import java.util.List;

import com.small.business.model.user.User;

public interface UserDao {

    public List<User> getAllUser();

    public User getUserById(Long id);

    public boolean addUser(User People);

    public boolean deleteUserById(Long id);

    public boolean deleteAll();

    public boolean updateUser(User People);

    public boolean validateUser(String user, String password);
}
