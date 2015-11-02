package com.softserve.edu.entity;

public final class UserDB {
    
    public static enum UserDBQueries {
        INSERT_USER_BY_LOGIN("INSERT INTO dbo.Users (Login, Password, FirstName, LastName, Email, RegionRef, RoleRef) VALUES ('%s', '%s', '%s', '%s', '%s', %s, %s);"),
        GET_USER_BY_LOGIN("SELECT ID, Login, Password, FirstName, LastName, Email, RegionRef, RoleRef FROM dbo.Users WHERE Login = '%s';"),
        GET_ALL_USERS("SELECT ID, Login, Password, FirstName, LastName, Email, RegionRef, RoleRef FROM dbo.Users;"),
        DELETE_USER_BY_ID("DELETE dbo.Users WHERE ID='%s';"),
        DELETE_USER_BY_PARTIAL_LOGIN("DELETE dbo.Users WHERE Login LIKE '%s%%';");
        private String query;

        private UserDBQueries(String query) {
            this.query = query;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    private Long id;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private Long region;
    private Long role;

    // TODO Create Factory, Builder
    public UserDB(Long id, String login, String password, String firstname, String lastname, String email, Long region,
            Long role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.region = region;
        this.role = role;
    }

    // setters - - - - -

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegion(Long region) {
        this.region = region;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    // getters - - - - -

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Long getRegion() {
        return region;
    }

    public Long getRole() {
        return role;
    }

}
