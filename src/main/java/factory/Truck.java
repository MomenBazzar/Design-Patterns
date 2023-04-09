package factory;

public class Truck implements Vehicle {

    @Override
    public void wheels() {
        System.out.println("I have 10 wheels, I'm the boss of wheels");
    }
}
