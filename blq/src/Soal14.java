import java.util.Scanner;

public class Soal14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] deret = new int[]{3, 4, 5, 6, 7};

        System.out.print("deret : ");
        for(int i = 0; i < deret.length; ++i) {
            System.out.print(deret[i] + " ");
        }

        System.out.println();
        System.out.print("N: ");
        int n = input.nextInt();

        if (n > deret.length - 1) {
            System.out.println("N melebihi panjang deret");
        } else {
            System.out.println();
            System.out.print("N = " + n + " -> ");

            for(int j = 1; j <= n; ++j) {
                int wadah = deret[0];
                for(int i = 0; i < deret.length - 1; ++i) {
                    deret[i] = deret[i + 1];
                }

                deret[deret.length - 1] = wadah;
                if (j == n) {
                    for(int i = 0; i < deret.length; ++i) {
                        System.out.print(deret[i] + " ");
                    }
                }
            }
        }

        input.close();
    }
}
