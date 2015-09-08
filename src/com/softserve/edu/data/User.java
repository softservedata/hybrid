package com.softserve.edu.data;

interface ILogin {
    IFirstname setLogin(String login);
}

interface IFirstname {
    ILastname setFirstname(String firstname);
}

interface ILastname {
    IPassword setLastname(String lastname);
}

interface IPassword {
    IEmail setPassword(String password);
}

interface IEmail {
    IRegion setEmail(String email);
}

interface IRegion {
    IRole setRegion(String region);
}

interface IRole {
    IBuild setRole(String role);
}

interface IBuild {
    IUser build();
}

public class User implements ILogin, IFirstname, ILastname, IPassword,
        IEmail, IRegion, IRole, IBuild, IUser {
    String login;
    String firstname;
    String lastname;
    String password;
    String email;
    String region;
    String role;

    private User(){
    }

//    public User(String login, String firstname, String lastname,
//            String password, String email, String region, String role) {
//        this.login = login;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.password = password;
//        this.email = email;
//        this.region = region;
//        this.role = role;
//    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static ILogin get() {
        return new User();
    }

    public IFirstname setLogin(String login) {
        this.login = login;
        return this;
    }

    public ILastname setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public IPassword setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public IEmail setPassword(String password) {
        this.password = password;
        return this;
    }

    public IRegion setEmail(String email) {
        this.email = email;
        return this;
    }

    public IRole setRegion(String region) {
        this.region = region;
        return this;
    }

    public IBuild setRole(String role) {
        this.role = role;
        return this;
    }

    public IUser build() {
        return this;
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public String getLogin() {
        return login;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRegion() {
        return region;
    }

    public String getRole() {
        return role;
    }

}
