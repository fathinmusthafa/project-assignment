public class Soal04 {
    public static void main(String[] args) {
        int n = 10;
        int count = 0;

        for(int angka = 2; count < n; ++angka) {
            boolean isPrima = true;
            if (angka > 1) {
                for(int i = 2; i * i <= angka; ++i) {
                    if (angka % i == 0) {
                        isPrima = false;
                        break;
                    }
                }
            } else {
                isPrima = false;
            }

            if (isPrima) {
                System.out.print(angka + " ");
                ++count;
            }
        }

    }
}
