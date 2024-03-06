package Ex2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("Enter URL: ");

            String url = sc.nextLine();

            if (url.equals("exit")) break;

            System.out.println(isValidUrl(url));
        }
    }

    static boolean isValidUrl(String url) {
        String pattern = "http(s)?:\\/\\/(www\\.)?[\\w]+(\\.[a-z]{2,6})+(\\/[^\\s]*)*";
        return Pattern.matches(pattern, url);
    }

}
