package com.softserve.edu.atqc.tools.data;

import java.sql.Driver;

public final class DataSource {
    private Driver jdbcDriver;
    private String url;
    private String username;
    private String password;

    // TODO Create Factory, Builder
    public DataSource(Driver jdbcDriver, String url, String username, String password) {
        this.jdbcDriver = jdbcDriver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void setJdbcDriver(Driver jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Driver getJdbcDriver() {
        return jdbcDriver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
