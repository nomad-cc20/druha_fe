package cz.upce.fei.inpda.druha_fe.entity;

import java.util.List;

public class Home {

    private long id;
    private List<User> users;
    private Cooler cooler;
    private Heater heater;
    private List<Room> rooms;

    public Home() {
    }

    public Home(long id, List<User> users, Cooler cooler, Heater heater, List<Room> rooms) {
        this.id = id;
        this.users = users;
        this.cooler = cooler;
        this.heater = heater;
        this.rooms = rooms;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Cooler getCooler() {
        return cooler;
    }

    public void setCooler(Cooler cooler) {
        this.cooler = cooler;
    }

    public Heater getHeater() {
        return heater;
    }

    public void setHeater(Heater heater) {
        this.heater = heater;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
