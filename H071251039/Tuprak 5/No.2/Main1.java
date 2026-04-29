public class Main1 {
    public static void main(String[] args) {

        SmartLamp lamp = new SmartLamp("Philips", 10);
        System.out.println("=== SMART LAMP ===");
        lamp.cekFungsi();
        lamp.infoPower();
        lamp.prosesPerintah("NYALA");

        System.out.println();

        SmartCCTV cctv = new SmartCCTV("Xiaomi", 15);
        System.out.println("=== SMART CCTV ===");
        cctv.cekFungsi();
        cctv.infoPower();
        cctv.hubungkanWiFi();

        System.out.println();

        SmartSpeaker speaker = new SmartSpeaker("JBL", 30);
        System.out.println("=== SMART SPEAKER ===");
        speaker.cekFungsi();
        speaker.infoPower();
        speaker.hubungkanWiFi();
        speaker.prosesPerintah("PLAY");
    }
}
