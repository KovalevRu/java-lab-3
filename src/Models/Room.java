package Models;



import Enum.RoomType;
import java.util.List;

public class Room {
    private String roomNumber;
    private boolean isOccupied;
    private List<Furniture> furnitureList;
    private RoomType roomType;

    public Room(String roomNumber, List<Furniture> furnitureList, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.furnitureList = furnitureList;
        this.roomType = roomType;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }
}

