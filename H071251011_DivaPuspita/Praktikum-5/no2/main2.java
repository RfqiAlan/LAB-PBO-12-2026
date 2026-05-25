public class main2 {
    public static void main(String[] args) {
        SmartLamp lamp = new SmartLamp("Philips", 10);
        SmartCCTV cctv = new SmartCCTV("Bardi", 5);
        SmartSpeaker speaker = new SmartSpeaker("Sony", 100);

        lamp.cekFungsi();
        lamp.infoPower();
        lamp.prosesPerintah("nyala ");

        System.out.println("\n");

        cctv.cekFungsi();
        cctv.infoPower();
        cctv.hubungkanWifi();
        cctv.prosesPerintah("nyalakan");

        System.out.println("\n");

        speaker.cekFungsi();
        speaker.infoPower();
        speaker.hubungkanWifi();
        speaker.prosesPerintah("memutar musik");
    }
}
