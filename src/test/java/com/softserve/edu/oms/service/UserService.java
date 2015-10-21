package com.softserve.edu.oms.service;

import com.softserve.edu.atqc.tools.data.DataSource;
import com.softserve.edu.oms.dao.UserDao;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserUtils;
import com.softserve.edu.oms.entity.UserDB;

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

    public IUser getUserByLogin(String login) {
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
