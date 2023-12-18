public class Soal15 {
    public static void main(String[] args) {
        String inputTime = "11:59:64AM";
        int jam = Integer.parseInt(inputTime.substring(0, 2));
        int menit = Integer.parseInt(inputTime.substring(3, 5));
        int detik = Integer.parseInt(inputTime.substring(6, 8));
        String periode = inputTime.substring(8, 10);
        if (periode.equals("PM")) {
            if (jam < 12) {
                jam += 12;
            } else if (jam == 12) {
                jam -= 0;
            }
        } else if (periode.equals("AM")) {
            if (jam < 12) {
                jam -= 0;
            } else if (jam == 12) {
                jam -= 12;
            }
        }

        if (detik > 59) {
            ++menit;
            detik -= 60;
        }

        if (menit > 59) {
            ++jam;
            menit -= 60;
        }

        if (jam > 23) {
            jam -= 24;
        }

        String outputTime = String.format("%02d:%02d:%02d", jam, menit, detik);
        System.out.println("Format 12: " + inputTime);
        System.out.println("Format 24: " + outputTime);
    }
}
