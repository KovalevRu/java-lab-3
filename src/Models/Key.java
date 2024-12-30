package Models;


public class Key {
    private int keyNumber;
    private Room room;

    public Key(int keyNumber, Room room) {
        this.keyNumber = keyNumber;
        this.room = room;
    }

    public int getKeyNumber() {
        return keyNumber;
    }

    public Room getRoom() {
        return room;
    }
}

