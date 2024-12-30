package Persons;

public abstract class Guest {
    private String name;
    private int money;

    public Guest(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void pay(int amount) {
        this.money -= amount;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
}




