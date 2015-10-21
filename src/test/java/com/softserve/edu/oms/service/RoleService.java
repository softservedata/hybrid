package com.softserve.edu.oms.service;

import com.softserve.edu.atqc.tools.data.DataSource;
import com.softserve.edu.oms.dao.RoleDao;

public class RoleService {
    private static volatile RoleService instance = null;
    private RoleDao roleDao;

    private RoleService(DataSource dataSource) {
        roleDao = RoleDao.get(dataSource);
    }

    public static RoleService get(DataSource dataSource) {
        if (instance == null) {
            synchronized (RoleService.class) {
                if (instance == null) {
                    instance = new RoleService(dataSource);
                }
            }
        }
        return instance;
    }

    public String getRoleNameById(long id) {
        return roleDao.getRoleById(id).getRoleName();
    }

}
