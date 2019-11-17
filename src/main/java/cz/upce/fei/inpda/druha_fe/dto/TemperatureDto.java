package cz.upce.fei.inpda.druha_fe.dto;

public class TemperatureDto {

    private long roomId;
    private double temperature;

    public TemperatureDto() {
    }

    public TemperatureDto(long roomId, double temperature) {
        this.roomId = roomId;
        this.temperature = temperature;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
