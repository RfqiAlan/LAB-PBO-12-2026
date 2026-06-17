public class Monitoring extends Thread {

    private final Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {

        try {

            while (!isInterrupted()) {

                int stok = gudang.getStok();
                int kapasitas = gudang.getKapasitasMaksimal();
                int persen = (stok * 100) / kapasitas;
                int jumlahBar = persen / 5;

                StringBuilder bar = new StringBuilder();

                for (int i = 0; i < 20; i++) {

                    if (i < jumlahBar) {
                        bar.append("#");
                    } else {
                        bar.append("-");
                    }
                }

                System.out.println(
                        "\nStatus Gudang: ["
                        + bar
                        + "] "
                        + persen
                        + "%");

                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {

            System.out.println(
                    "Sistem Gudang berhenti dengan aman.");
        }
    }
}