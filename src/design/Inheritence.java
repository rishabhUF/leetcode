package design;

class Vehicle {
    String name = "RIshabh";

    public Vehicle(String name ) {
        System.out.println("In the Vehicle constructor " + name);
    }
    public void say() {
        System.out.println("hello " + name);
    }
}
public class Inheritence extends Vehicle{
    public Inheritence() {
        super("RISHABH");
        System.out.println("This is Inheritence constructor call");
    }

    public static void main(String[] args) {
        Inheritence in = new Inheritence();
        Vehicle v = new Vehicle("JAY SHAH");
    }
}
