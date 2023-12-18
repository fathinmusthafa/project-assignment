public class Soal16 {
    public static void main(String[] args) {
        int[] arrHarga = new int[]{42000, 50000, 30000, 70000, 30000};
        boolean[] containIkan = new boolean[]{true, false, false, false, false};
        int[] hargaPerOrang = new int[arrHarga.length];
        int hargaTotal = 0;

        for(int i = 0; i < arrHarga.length; ++i) {
            hargaTotal = arrHarga[i] + arrHarga[i] * 15 / 100;
            System.out.println(hargaTotal);
            if (containIkan[i]) {
                hargaPerOrang[i] = hargaTotal / 3;
            } else {
                hargaPerOrang[i] = hargaTotal / 4;
            }
        }

        for(int i = 1; i < 5; ++i) {
            int iuaran = 0;
            if (i == 1) {
                for(int j = 1; j < hargaPerOrang.length; ++j) {
                    iuaran += hargaPerOrang[j];
                }
            } else {
                for(int j = 0; j < hargaPerOrang.length; ++j) {
                    iuaran += hargaPerOrang[j];
                }
            }

            System.out.println("iuran " + i + ": " + iuaran);
        }

    }
}
