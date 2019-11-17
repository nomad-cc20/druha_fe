package cz.upce.fei.inpda.druha_fe.dto;

import cz.upce.fei.inpda.druha_fe.entity.Room;

public class RoomDto {

    private long id;
    private long homeId;
    private String name;
    private double actualTemperature;
    private double requiredTemperature;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.homeId = room.getId();
        this.name = room.getName();
        this.actualTemperature = room.getActualTemperature();
        this.requiredTemperature = room.getRequiredTemperature();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHomeId() {
        return homeId;
    }

    public void setHomeId(long homeId) {
        this.homeId = homeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
