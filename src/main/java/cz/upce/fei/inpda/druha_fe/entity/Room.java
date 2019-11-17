package cz.upce.fei.inpda.druha_fe.entity;

import java.util.Random;

public class Room {

    private long id;
    private String name;
    private Home home;
    private static Random random = new Random();
    private double actualTemperature = 0, requiredTemperature = 0;

    public Room() {
    }

    public Room(long id, String name, Home home, double actualTemperature, double requiredTemperature) {
        this.id = id;
        this.name = name;
        this.home = home;
        this.actualTemperature = actualTemperature;
        this.requiredTemperature = requiredTemperature;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public static Random getRandom() {
        return random;
    }

    public static void setRandom(Random random) {
        Room.random = random;
    }

    public double getActualTemperature() {
        return actualTemperature;
    }

    public void setActualTemperature(double actualTemperature) {
        this.actualTemperature = actualTemperature;
    }

    public double getRequiredTemperature() {
        return requiredTemperature;
    }

    public void setRequiredTemperature(double requiredTemperature) {
        this.requiredTemperature = requiredTemperature;
    }
}