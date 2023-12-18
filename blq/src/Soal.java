public class Soal {
    public static void main(String[] args) {

        int[] array = {1, 2, 4, 7, 8, 6, 9};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < (array.length-3); i++) {
            int summary = array[i] + array[i+1] + array[i+2] + array[i+3];

            if (summary < min) {
                min = summary;
            }
            if (summary > max) {
                max = summary;
            }
        }

        System.out.println("Nilai Minimal dari penjumlahan 4 komponen deret adalah: " + min);
        System.out.println("Nilai Maksimal dari penjumlahan 4 komponen deret adalah: " + max);
    }
}
