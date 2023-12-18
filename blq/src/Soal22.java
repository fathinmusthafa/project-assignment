public class Soal22 {
    public static void main(String[] args) {

        int[] arrLilin = {3, 3, 9, 6, 7, 8, 23};

        int n1 = 1;
        int n2 = 1;
        int n3;

        int[] fibonacci = new int[arrLilin.length];
        for (int i = 0; i < arrLilin.length; i++) {
            fibonacci[i] = n1;
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }

        double waktuLeleh = 0;
        double fastest = Double.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < arrLilin.length; i++) {
            waktuLeleh = (double) arrLilin[i] / fibonacci[i];
            if (waktuLeleh < fastest) {
                fastest = waktuLeleh;
                index = i;
            }
        }

        System.out.println("Lilin yang paling pertama habis adalah lilin dengan panjang "+ arrLilin[index] +" meleleh dalam waktu "+ (int)fastest + " detik");
    }
}
