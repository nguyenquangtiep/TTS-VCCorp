package Ex3.Singleton;

public class EagerInitializedSingleton {

    private static final EagerInitializedSingleton INSTANCE = new EagerInitializedSingleton();

    // Private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton() {
        System.out.println("Eager Initialization");
    }

    public static EagerInitializedSingleton getInstance() {
        return INSTANCE;
    }

}
