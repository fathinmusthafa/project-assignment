import java.util.Scanner;

public class Soal10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input : ");
        String nama = input.nextLine();
        String[] arrNama = nama.split(" ");

        for(int i = 0; i < arrNama.length; ++i) {
            String awalan = "";
            String akhiran = "";
            String bintang = "";

            for(int j = 0; j < arrNama[i].length() - 2; ++j) {
                bintang = bintang + "*";
            }

            awalan = arrNama[i].substring(0, 1);
            akhiran = arrNama[i].substring(arrNama[i].length() - 1);
            System.out.print("output: " + awalan + bintang + akhiran + " ");
        }

        input.close();
    }
}
