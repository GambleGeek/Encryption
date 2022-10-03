package adis.kerimov;

public class Main {

    public static void main(String[] args) {

        int key = 5;
        int key2 = 1;

        String text = "Heute ich mochte nach Berlin fahren!";
        String textToDecrypt = "Bjhfsjn";

        System.out.println(text);

        charEncryption(text, key);
        System.out.println("\n");

        System.out.println(textToDecrypt);
        charDecryption(textToDecrypt, key2);


    }



        static void charEncryption(String text, int key){
            char[] chars = text.toCharArray();

            for (char c : chars) {
                c += key;
                System.out.print(c);
            }
        }

        static void charDecryption(String text, int key){
            char[] chars = text.toCharArray();

            for (char c : chars) {
                c -= key;
                System.out.print(c);
            }
        }
    }

