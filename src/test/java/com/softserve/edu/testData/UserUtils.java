package com.softserve.edu.testData;

import com.softserve.edu.entity.UserDB;

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

    public IUsers userDB2IUser(UserDB userDB, String roleName) {
        return User.get()
                .setLogin(userDB.getLogin())
                
                .setPassword(userDB.getPassword())
                
                .build();
    }

}
