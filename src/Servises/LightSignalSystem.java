package Servises;

import Interface.NotificationSystem;
import Models.Room;

public class LightSignalSystem implements NotificationSystem {
    public void sendMessage(String message, Room room) {
        System.out.println("В номере " + room.getRoomNumber() + " замигала надпись: " + message);
    }
}
