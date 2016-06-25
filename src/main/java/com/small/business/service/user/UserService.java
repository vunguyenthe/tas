package com.small.business.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.small.business.model.user.User;

public interface UserService {

    public List<User> getAllUser();

    public boolean validateUser(String user, String password);

    public User getUserById(Long id);

    public boolean addUser(User User);

    public boolean deleteUserById(Long id);

    public boolean deleteAll();

    public boolean updateUser(User user);

    public String uploadFilePostMethod(MultipartFile file,
            HttpServletRequest request);

}
