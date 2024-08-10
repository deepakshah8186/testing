package factorypattern;

public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Car implementation");
    }
}
