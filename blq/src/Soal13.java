public class Soal13 {
    public static void main(String[] args) {
        int sudut1 = hitungSudut(3, 0);
        int sudut2 = hitungSudut(5, 30);
        int sudut3 = hitungSudut(2, 20);
        System.out.println("Sudut jam 3:00 -> " + sudut1);
        System.out.println("Sudut jam 5:30 -> " + sudut2);
        System.out.println("Sudut jam 2:20 -> " + sudut3);
    }

    static int hitungSudut(int jam, int menit) {
        if (jam == 12) {
            jam = 0;
        }

        int derajatMenit = 6 * menit;
        double derajatJam = (double)(30 * jam) + 0.5 * (double)menit;
        double selisih = Math.abs(derajatJam - (double)derajatMenit);
        return (int)Math.min(selisih, 360 - selisih);
    }
}
