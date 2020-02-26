package design;

public class Main {
    public static void main(String[] args) {
        Singleton o1 = Singleton.getInstance();
        System.out.println(o1.value);
        Singleton o2 = Singleton.getInstance();
        System.out.println(o2.value);
    }
}
