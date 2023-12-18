import java.util.Scanner;

public class Soal09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan N: ");
        int N = scanner.nextInt();
        System.out.print("N = " + N + " -> ");

        for(int i = 1; i <= N; ++i) {
            int multiple = N * i;
            System.out.print(multiple + " ");
        }

        System.out.println();
    }
}
