package Ex3.Adapter;

public class TranslatorAdapter implements VietnameseTarget {

    private FrenchAdaptee adaptee;

    public TranslatorAdapter(FrenchAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void send(String words) {
        System.out.println("Reading words ...");
        System.out.println(words);
        String vietnameseWords = this.translate(words);
        System.out.println("Sending words ...");
        adaptee.receive(vietnameseWords);
    }

    private String translate(String vietnameseWords) {
        System.out.println("Translated!");
        return "Bonjour";
    }

}
