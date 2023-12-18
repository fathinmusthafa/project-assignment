public class Soal17 {
    public static void main(String[] args) {
        String input = "N N T N N N T T T T T N T T T N T N";
        String[] arrJalan = input.split(" ");
        int mdpl = 0;
        int perjalanan = 0;
        int gunung = 0;
        int lembah = 0;

        for(int i = 0; i < arrJalan.length; ++i) {
            if (arrJalan[i].equalsIgnoreCase("N")) {
                ++mdpl;
            } else if (arrJalan[i].equalsIgnoreCase("T")) {
                --mdpl;
            }

            if (mdpl > 0) {
                perjalanan = 1;
            } else if (mdpl < 0) {
                perjalanan = -1;
            }

            if (perjalanan == 1 && mdpl == 0) {
                ++gunung;
                perjalanan = 0;
            } else if (perjalanan == -1 && mdpl == 0) {
                ++lembah;
                perjalanan = 0;
            }
        }

        System.out.println("Gunung: " + gunung);
        System.out.println("Lembah: " + lembah);
    }
}
