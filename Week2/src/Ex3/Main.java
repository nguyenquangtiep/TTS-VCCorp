package Ex3;

import Ex3.Adapter.FrenchAdaptee;
import Ex3.Adapter.TranslatorAdapter;
import Ex3.Adapter.VietnameseTarget;
import Ex3.ChainOfResponsibility.AppLogger;
import Ex3.ChainOfResponsibility.LogLevel;
import Ex3.ChainOfResponsibility.Logger;
import Ex3.Factory.Bank;
import Ex3.Factory.BankFactory;
import Ex3.Factory.BankType;
import Ex3.Singleton.*;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        implementSingletonPattern();

        implementFactoryPattern();

        implementChainOfResponsibility();

        implementAdapter();

    }

    static void implementSingletonPattern() throws IOException, ClassNotFoundException {
        // Eager Initialization
        EagerInitializedSingleton eagerInitializedSingleton = EagerInitializedSingleton.getInstance();

        // Static Block Initialization
        StaticBlockSingleton staticBlockSingleton = StaticBlockSingleton.getInstance();

        // Lazy Initialization
        LazyInitializedSingleton lazyInitializedSingleton = LazyInitializedSingleton.getInstance();

        // Thread Safe Lazy Initialization
        ThreadSafeLazyInitializedSingleton threadSafeLazyInitializedSingleton = ThreadSafeLazyInitializedSingleton.getInstance();

        // Double Check Locking Initialization
        DoubleCheckLockingSingleton doubleCheckLockingSingleton = DoubleCheckLockingSingleton.getInstance();

        // Singleton Serialization Test
        SerializedSingleton serializedSingleton1 = SerializedSingleton.getInstance();
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("SingletonSerializedTest.txt"));
        out.writeObject(serializedSingleton1);
        out.writeObject(enumSingleton1);
        out.close();

        // De-serialize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("SingletonSerializedTest.txt"));
        SerializedSingleton serializedSingleton2 = (SerializedSingleton) in.readObject();
        EnumSingleton enumSingleton2 = (EnumSingleton) in.readObject();
        in.close();

        System.out.println("serializedSingleton1 hashCode=" + serializedSingleton1.hashCode());
        System.out.println("serializedSingleton2 hashCode=" + serializedSingleton2.hashCode());
        System.out.println("enumSingleton1 hashCode=" + enumSingleton1.hashCode());
        System.out.println("enumSingleton2 hashCode=" + enumSingleton2.hashCode());
    }

    static void implementFactoryPattern() {
        Bank bank = BankFactory.getBank(BankType.TPBANK);
        System.out.println(bank.getBankName());
    }

    static void implementChainOfResponsibility() {
        Logger logger = AppLogger.getLogger();

        System.out.println("=== Info level ===");
        logger.log(LogLevel.INFO, "Info message");

        System.out.println("=== Debug level ===");
        logger.log(LogLevel.DEBUG, "Debug message");

        System.out.println("=== Error level ===");
        logger.log(LogLevel.ERROR, "Error message");

        System.out.println("=== Fatal level ===");
        logger.log(LogLevel.FATAL, "Fatal message");
    }

    static void implementAdapter() {
        VietnameseTarget client = new TranslatorAdapter(new FrenchAdaptee());
        client.send("Xin chào");
    }

}
