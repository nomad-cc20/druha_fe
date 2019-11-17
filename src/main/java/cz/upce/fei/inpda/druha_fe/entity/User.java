package cz.upce.fei.inpda.druha_fe.entity;

import java.util.List;

public class User {

    private long id;
    private String username, password;
    private RoleENum role;
    private List<Home> homes;

    public User() {
    }

    public User(long id, String username, String password, RoleENum role, List<Home> homes) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.homes = homes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleENum getRole() {
        return role;
    }

    public void setRole(RoleENum role) {
        this.role = role;
    }

    public List<Home> getHomes() {
        return homes;
    }

    public void setHomes(List<Home> homes) {
        this.homes = homes;
    }
}
