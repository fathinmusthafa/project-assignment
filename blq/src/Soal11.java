import java.util.Scanner;

public class Soal11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] arrInput = input.split("");
        String bintang = "";

        for(int i = 0; i < arrInput.length / 2; ++i) {
            bintang +=  "*";
        }

        System.out.println("Output: ");

        for(int i = arrInput.length - 1; i >= 0; --i) {
            System.out.println(bintang + arrInput[i] + bintang);
        }

        scanner.close();
    }
}
