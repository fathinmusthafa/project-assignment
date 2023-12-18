public class Soal07 {
    public static void main(String[] args) {
        int[] deret = new int[]{8, 7, 0, 2, 7, 1, 7, 6, 3, 0, 7, 1, 3, 4, 6, 1, 6, 4, 3};
        System.out.println("Nilai mean : " + mean(deret));
        System.out.println("Nilai median : " + median(deret));
        System.out.println("Nilai modus : " + modus(deret));
    }

    static double mean(int[] deret) {
        int total = 0;

        for(int i = 0; i < deret.length; ++i) {
            total += deret[i];
        }

        double hasil = (double)total / (double)deret.length;
        return hasil;
    }

    static double median(int[] deret) {
        for (int i = 0; i < deret.length; i++) {
            for (int j = 0; j < deret.length; j++) {
                if (deret[j] > deret[i]) {
                    int temp = deret[j];
                    deret[j] = deret[i];
                    deret[i] = temp;
                }
            }
        }

        double hasil = 0;
        int el = 0;
        if(deret.length % 2 == 1){
            el = (deret.length+1)/2;
            hasil = deret[el-1];


        } else if (deret.length % 2 == 0){
            el = deret.length/2;
            hasil = (deret[el-1]+deret[el])/2;

        }
        return hasil;
    }

    static int modus(int[] deret) {
        int[] kemunculan = new int[deret.length];

        for (int i = 0; i < deret.length; i++) {
            for (int j = 0; j < deret.length; j++) {
                if (deret[j] > deret[i]) {
                    int wadah = deret[j];
                    deret[j] = deret[i];
                    deret[i] = wadah;
                }
            }
        }

        for (int i = 0; i < deret.length; i++) {
            for (int j = 0; j < deret.length; j++) {
                if (deret[i] == deret[j]) {
                    kemunculan[i]++;
                }
            }
        }

        int maxKemunculan = 0;
        int itemTerbanyak = 0;
        for (int j = 0; j < deret.length; j++) {
            for (int i = 0; i < deret.length; i++) {
                if (kemunculan[i] > maxKemunculan) {
                    maxKemunculan = kemunculan[i];
                    itemTerbanyak = deret[i];
                }
            }
        }

        return itemTerbanyak;
    }
}
