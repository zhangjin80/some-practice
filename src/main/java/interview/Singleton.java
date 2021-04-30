package interview;

public class Singleton {
    private volatile static Singleton single;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (single == null) {
            synchronized(Singleton.class) {
                if (single == null) {
                    single = new Singleton();
                }
            }
        }


        return single;
    }
}
