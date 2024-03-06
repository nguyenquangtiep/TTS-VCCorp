package Ex3.Singleton;

public class ThreadSafeLazyInitializedSingleton {

    private static volatile ThreadSafeLazyInitializedSingleton instance;

    private ThreadSafeLazyInitializedSingleton() {
        System.out.println("Thread Safe Lazy Initialization");
    }

    public static synchronized ThreadSafeLazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeLazyInitializedSingleton();
        }
        return instance;
    }

}
