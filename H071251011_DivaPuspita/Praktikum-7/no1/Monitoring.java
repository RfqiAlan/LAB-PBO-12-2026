public class Monitoring implements Runnable {
    private final Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int stok = gudang.getStok();
                int kapasitas = gudang.getkapasitasMaksimal();
                int persen = (stok * 100) / kapasitas;

                int filled = persen / 10;
                if (filled < 0) filled = 0;
                if (filled > 10) filled = 10;

                String status = "[" + "#".repeat(filled) + "-".repeat(10 - filled) + "] " + persen + "%";
                System.out.println("\nStatus Gudang: " + status);
                Thread.sleep(1000);
            }
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
