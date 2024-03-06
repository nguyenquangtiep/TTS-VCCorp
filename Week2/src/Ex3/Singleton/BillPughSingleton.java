package Ex3.Singleton;

public class BillPughSingleton {

    private BillPughSingleton() {
        System.out.println("Bill Pugh Initialization");
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

}
