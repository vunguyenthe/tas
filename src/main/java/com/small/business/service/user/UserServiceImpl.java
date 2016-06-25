package com.small.business.service.user;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.small.business.dao.user.UserDao;
import com.small.business.model.user.User;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private static List<User> userList = new ArrayList<User>();
    private static Long id = 0L;
    private static final Logger logger = LoggerFactory
            .getLogger(UserServiceImpl.class);
    @Autowired
    UserDao userDao;

    public List<User> getAllUser() {

        List<User> userList = userDao.getAllUser();
        return userList;
    }

    public User getUserById(Long id) {

        return userDao.getUserById(id);
    }

    public boolean addUser(User user) {

        user.setId(++id);
        return userDao.addUser(user);
    }

    public boolean deleteUserById(Long id) {

        boolean ret;
        ret = userDao.deleteUserById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        userList.clear();
        id = 0L;
        return userDao.deleteAll();
    }

    public String uploadFilePostMethod(MultipartFile file,
            HttpServletRequest request) {

        System.out.println("Upload file - post method");
        if (file != null) {

            try {
                InputStream inputStream = file.getInputStream();
                if (inputStream == null)
                    System.out.println("File inputstream is null");

                String pathUpDir = request.getSession().getServletContext()
                        .getRealPath("/")
                        + "resources/cv/";

                File upload = new File(pathUpDir + file.getOriginalFilename());
                file.transferTo(upload);
                String imagePath = pathUpDir + file.getOriginalFilename();
                System.out.println("imagePath ->" + imagePath);
                IOUtils.closeQuietly(inputStream);

            } catch (IOException ex) {
                logger.debug("uploadFilePostMethod got error: " + ex.getMessage());
                return "ERROR";
            }
        }

        return "SUCCESS";

    }

    public boolean updateUser(User user) {

        User foundUser = findUserById(user.getId());
        if (foundUser != null) {
            userList.remove(foundUser);
            userList.add(user);
        }
        return userDao.updateUser(user);

    }

    public User findUserById(Long id) {

        return userDao.getUserById(id);
    }

    public boolean validateUser(String user, String password) {

        return userDao.validateUser(user, password);
    }
}
