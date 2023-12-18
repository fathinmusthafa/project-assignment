public class Soal05 {
    public static void main(String[] args) {

        int n = 10;
        int[] fibonaci = new int[n];

        int kiri = 0;
        int kanan = 1;
        int fibo = 0;

        for(int i = 0; i < n; i++) {
            kiri = kanan;
            kanan = fibo;
            fibonaci[i] = fibo;
            fibo = kiri + kanan;
        }

        for (int i : fibonaci) {
            System.out.print(i + " ");
        }
    }
}
