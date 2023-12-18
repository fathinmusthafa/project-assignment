public class Soal19 {
    public static void main(String[] args) {
        String kalimat1 = "Sphinx of black quartz, judge my vow";
        String kalimat2 = "Brawny gods just flocked up to quiz and vex him";
        String kalimat3 = "Check back tomorrow; I will see if the book has arrived.";
        System.out.println(kalimat1 + " " + isPangram(kalimat1));
        System.out.println(kalimat2 + " " + isPangram(kalimat2));
        System.out.println(kalimat3 + " " + isPangram(kalimat3));
    }

    static String isPangram(String kalimat) {
        String hasil = "";
        kalimat = kalimat.toLowerCase();

        for(char i = 'a'; i <= 'z'; ++i) {
            if (!kalimat.contains(String.valueOf(i))) {
                hasil = "bukan pangram";
                break;
            }

            hasil = "merupakan pangram";
        }

        return hasil;
    }
}
