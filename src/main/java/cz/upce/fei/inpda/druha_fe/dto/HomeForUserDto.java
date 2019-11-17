package cz.upce.fei.inpda.druha_fe.dto;

public class HomeForUserDto {

    private long id;

    public HomeForUserDto() {
    }

    public HomeForUserDto(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
