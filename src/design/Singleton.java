package design;

public class Singleton {
    private static Singleton object;

    String value;

    private Singleton() {
        value = "Rishabh";
    }

    public static Singleton getInstance(){
        if(object == null) {
            object =  new Singleton();
            return object;
        } else {
            return object;
        }
    }
}


