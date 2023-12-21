import java.util.Scanner;

public class Soal20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input jarak awal
        System.out.print("Jarak awal: ");
        int initialDistance = scanner.nextInt();

        // Inisialisasi posisi A dan B
        int positionA = 0;
        int positionB = initialDistance;
        int winA = 0;
        int winB = 0;

        // Mulai suit
        while (positionA != positionB) {
            System.out.print("A: ");
            String moveA = scanner.next();

            System.out.print("B: ");
            String moveB = scanner.next();

            // Evaluasi hasil suit
            if (moveA.equals("B") && moveB.equals("G") ||
                    moveA.equals("K") && moveB.equals("B") ||
                    moveA.equals("G") && moveB.equals("K")) {
                // A menang
                positionA += 2;
                positionB += 1;
                winA++;
            } else if (moveB.equals("B") && moveA.equals("G") ||
                    moveB.equals("K") && moveA.equals("B") ||
                    moveB.equals("G") && moveA.equals("K")) {
                // B menang
                positionA -= 1;
                positionB -= 2;
                winB++;
            } else {
                // Seri, tidak ada perubahan posisi
            }

        }

        // Menentukan pemenang
        if (winA > winB) {
            System.out.println("Pemenang: A");
        }else if (winB > winA){
            System.out.println("Pemenang: B");
        } else {
            System.out.println("Draw");
        }

        scanner.close();
    }
}
