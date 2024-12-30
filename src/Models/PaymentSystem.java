package Models;

import Exceptions.InsufficientFundsException;
import Persons.Guest;

public class PaymentSystem {
    public boolean makePayment(Guest guest, int amount) throws InsufficientFundsException {
        if (guest.getMoney() >= amount) {
            guest.pay(amount);
            System.out.println(guest.getName() + " оплатил " + amount + " сантиков.");
            return true;
        } else {
            throw new InsufficientFundsException("У " + guest.getName() + " недостаточно денег для оплаты!");
        }
    }
}

