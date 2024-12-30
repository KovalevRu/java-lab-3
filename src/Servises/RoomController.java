package Servises;

import Exceptions.InsufficientFundsException;
import Interface.NotificationSystem;
import Models.PaymentSystem;
import Models.Room;
import Persons.Guest;


public class RoomController {
    private NotificationSystem notificationSystem;

    public RoomController(NotificationSystem notificationSystem) {
        this.notificationSystem = notificationSystem;
    }

    public void receiveSignal(Room room) {
        this.notificationSystem.sendMessage("Сантик", room);
    }

    public boolean pay(Room room, Guest guest, PaymentSystem paymentSystem)  {
        if (guest.getMoney() >= 50){
            try{
                return paymentSystem.makePayment(guest, 50);
            }catch (RuntimeException | InsufficientFundsException e){
                System.out.println(e.getMessage());
                return false;
            }
        }else{
            System.out.println("У " + guest.getName() + " не достаточно средств для оплаты!");
            return false;
        }
    }
}