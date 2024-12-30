package Models;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private List<Room> rooms;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public Room findAvailableRoom() {
        for (Room room : rooms) {
            if (room.isAvailable()) {
                return room;
            }
        }
        return null; // Номер не найден
    }

    public String getName() {
        return name;
    }
}
