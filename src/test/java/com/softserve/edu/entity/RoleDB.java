package com.softserve.edu.entity;

public class RoleDB {

    public static enum RoleDBQueries {
        GET_ROLE_BY_ID("SELECT ID, RoleName FROM dbo.Roles WHERE ID = '%s';"),
        GET_ROLE_BY_PARTIAL_ROLE_NAME("SELECT ID, RoleName FROM dbo.Roles WHERE RoleName LIKE '%s%%';"),
        GET_ALL_ROLES("SELECT ID, RoleName FROM dbo.Roles;");
        private String query;

        private RoleDBQueries(String query) {
            this.query = query;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    private Long id;
    private String roleName;

    public RoleDB(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    // setters - - - - -

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    // getters - - - - -

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

}
