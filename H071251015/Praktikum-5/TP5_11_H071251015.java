public class MainSmartHome{
    public static void main(String[] args) {

        // Instansiasi ketiga perangkat
        SmartLamp lampu = new SmartLamp("Philips Hue", 10);
        smartcctv cctv = new smartcctv("Hikvision", 15);
        smartspeaker speaker = new smartspeaker("Google Nest", 30);

        // --- SmartLamp ---
        System.out.println("=== Smart Lamp ===");
        lampu.cekFungsi();
        lampu.infoPower();
        lampu.prosesperintah("NYALA");

        System.out.println();

        // --- SmartCCTV ---
        System.out.println("=== Smart CCTV ===");
        cctv.cekFungsi();
        cctv.infoPower();
        cctv.hubungkanwifi();

        System.out.println();

        // --- SmartSpeaker: akses method dari abstract class + kedua interface ---
        System.out.println("=== Smart Speaker ===");
        speaker.cekFungsi();           // dari PerangkatElektronik (abstract class)
        speaker.infoPower();           // dari PerangkatElektronik (method konkrit)
        speaker.hubungkanwifi();       // dari InteraksiInternet
        speaker.prosesperintah("Putar Musik Jazz"); // dari KontrolSuara
    }
}