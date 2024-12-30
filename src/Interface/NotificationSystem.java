package Interface;

import Models.Room;

public interface NotificationSystem {
    void sendMessage(String message, Room room);
}
