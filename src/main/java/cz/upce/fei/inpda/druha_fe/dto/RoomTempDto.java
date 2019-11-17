package cz.upce.fei.inpda.druha_fe.dto;

public class RoomTempDto {

    private long roomId;
    private String name;

    public RoomTempDto() {
    }

    public RoomTempDto(long roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
