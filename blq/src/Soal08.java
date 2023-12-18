public class Soal08 {
    public static void main(String[] args) {
        int[] deret = new int[]{1, 2, 4, 7, 8, 6, 9};
        System.out.println("Nilai penjumlahan dari 4 komponen deret: ");
        System.out.println("Nilai minimal: " + minSum(deret));
        System.out.println("Nilai maksimal: " + maxSum(deret));
    }

    static int minSum(int[] deret) {
        int n = 4;
        int min = 0;

        for(int j = 0; j < deret.length; ++j) {
            for(int i = 0; i < deret.length - 1; ++i) {
                int temp = deret[i];
                if (deret[i] > deret[i + 1]) {
                    deret[i] = deret[i + 1];
                    deret[i + 1] = temp;
                }
            }
        }

        for(int i = 0; i < n; ++i) {
            min += deret[i];
        }

        return min;
    }

    static int maxSum(int[] deret) {
        int n = 4;
        int max = 0;

        for(int j = 0; j < deret.length; ++j) {
            for(int i = 0; i < deret.length - 1; ++i) {
                int temp = deret[i];
                if (deret[i] < deret[i + 1]) {
                    deret[i] = deret[i + 1];
                    deret[i + 1] = temp;
                }
            }
        }

        for(int i = 0; i < n; ++i) {
            max += deret[i];
        }

        return max;
    }
}
