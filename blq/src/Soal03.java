import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Soal03 {
    public static void main(String[] args) {
        String masuk = "28/01/2020 07:30:34";
        String keluar = "29/01/2020 07:31:35";
        long selisih = 0, hari = 0, jam = 0, menit = 0, detik =0;

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

        try {
            Date dateMasuk = format.parse(masuk);
            Date dateKeluar = format.parse(keluar);

            selisih = dateKeluar.getTime() - dateMasuk.getTime();
            hari = TimeUnit.MILLISECONDS.toDays(selisih);
            jam = TimeUnit.MILLISECONDS.toHours(selisih) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(selisih));
            menit = TimeUnit.MILLISECONDS.toMinutes(selisih) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(selisih));
            detik = TimeUnit.MILLISECONDS.toSeconds(selisih) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(selisih));

            System.out.println("hari : " + hari);
            System.out.println("jam : " + jam);
            System.out.println("menit : " + menit);
            System.out.println("detik : " + detik);

            int harga = 0;

            if(menit > 0 && detik > 0) {
                jam++;
                if(jam <= 8){
                    harga = 1_000 * (int)jam;
                }else if (jam > 8 && jam <= 24){
                    harga = 8_000;
                } else {
                    harga = 15_000;
                }
            }

            if (jam > 24) {
                hari++;

            }

            if (hari > 0 || jam > 24) {

                harga = harga + (15_000*(int)hari);
            }


            System.out.println("tarif parkir: " + harga);



        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
