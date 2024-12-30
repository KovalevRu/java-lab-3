import Enum.RoomType;
import Exceptions.InsufficientFundsException;
import Interface.NotificationSystem;
import Models.*;
import Persons.*;
import Servises.LightSignalSystem;
import Servises.RoomController;
import Servises.RoomController.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем гостиницу
        Hotel hotel = new Hotel("Экономическая");

        // Создаем мебель для комнаты
        List<Furniture> furniture = new ArrayList<>();
        furniture.add(new Table());
        furniture.add(new Chair());
        furniture.add(new Chair());
        furniture.add(new Wardrobe());
        furniture.add(new Sink());
        furniture.add(new Mirror());
        furniture.add(new Television());

        // Создаем номер
        Room room1 = new Room("101", furniture, RoomType.STANDARD);
        // Чтобы проверить ситуацию, когда нет номеров, можно закомментировать строку добавления номера
        hotel.addRoom(room1);


        // Создаем гостей
        Guest neznaika = new Neznaika(50);
        Guest kozlik = new Kozlik(50);

        // Создаем вывеску
        Signboard signboard = new Signboard("Самые дешевые номера на свете");
        System.out.println("Прочитали на вывеске: " + signboard.getText());

        // Гости оплачивают номер
        PaymentSystem paymentSystem = new PaymentSystem();
        boolean isPaid1 = false;
        boolean isPaid2 = false;
        try{
            isPaid1 = paymentSystem.makePayment(neznaika, 50);
            isPaid2 = paymentSystem.makePayment(kozlik, 50);
        }catch (InsufficientFundsException e){
            System.out.println(e.getMessage());
        }

        if (isPaid1 && isPaid2) {
            Room room = hotel.findAvailableRoom();
            if (room != null) {
                System.out.println("Получили номер: " + room.getRoomNumber());
                room.setOccupied(true);

                System.out.println("В номере: ");
                for (Furniture f: room.getFurnitureList()){
                    System.out.println(" - " + f.getName());
                }


                NotificationSystem lightSignalSystem = new LightSignalSystem();
                RoomController roomController = new RoomController(lightSignalSystem);
                roomController.receiveSignal(room);
                MetalTongue metalTongue = new MetalTongue();
                metalTongue.slideOut();
            }else{
                System.out.println("Извините, свободных номеров нет.");
            }
        }


    }
}
