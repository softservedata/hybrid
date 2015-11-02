package com.softserve.edu.service;

import com.softserve.edu.atqc.tools.data.DataSource;
import com.softserve.edu.dao.UserDao;
import com.softserve.edu.entity.UserDB;
import com.softserve.edu.testData.IUsers;
//import com.softserve.edu.IUser;
import com.softserve.edu.testData.UserUtils;

public class UserService {
    private static volatile UserService instance = null;
    private UserDao userDao;
    private RoleService roleService;

    private UserService(DataSource dataSource) {
        userDao = UserDao.get(dataSource);
        roleService = RoleService.get(dataSource);
    }

    public static UserService get(DataSource dataSource) {
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null) {
                    instance = new UserService(dataSource);
                }
            }
        }
        return instance;
    }

    public IUsers getUserByLogin(String login) {
        UserDB userDB = userDao.getUserByLogin(login);
        return UserUtils.get().userDB2IUser(userDB, roleService.getRoleNameById(userDB.getRole()));
    }

    public String getUserFirstnameByLogin(String login) {
        UserDB userDB = userDao.getUserByLogin(login);
        return userDB.getFirstname();
    }

    public boolean deleteUsersByPartialLogin(String partialLogin) {
        return userDao.deleteUsersByPartialLogin(partialLogin);
    }

}
