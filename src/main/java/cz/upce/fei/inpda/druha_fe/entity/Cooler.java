package cz.upce.fei.inpda.druha_fe.entity;

public class Cooler {

    private long id;
    private Home home;
    private double power = 0;

    public Cooler() {
    }

    public Cooler(long id, Home home, double power) {
        this.id = id;
        this.home = home;
        this.power = power;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }
}
