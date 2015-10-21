package com.softserve.edu.oms.data;

import com.softserve.edu.oms.entity.UserDB;

public class UserUtils {
    private static volatile UserUtils instance = null;

    private UserUtils() {
    }

    public static UserUtils get() {
        if (instance == null) {
            synchronized (UserUtils.class) {
                if (instance == null) {
                    instance = new UserUtils();
                }
            }
        }
        return instance;
    }

    public IUser userDB2IUser(UserDB userDB, String roleName) {
        return User.get()
                .setLogin(userDB.getLogin())
                .setFirstname(userDB.getFirstname())
                .setLastname(userDB.getLastname())
                .setPassword(userDB.getPassword())
                .setEmail(userDB.getEmail())
                .setRegion("West")
                .setRole(roleName)
                .build();
    }

}
