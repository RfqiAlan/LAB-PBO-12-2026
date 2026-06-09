import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private List<String[]> logs;

    public LibraryLogger() { 
        this.logs = new ArrayList<>();
    }

    public void logBorrow(String timestamp, String judul, String memberName) {
        logs.add(new String[]{timestamp, judul, memberName, "-"});
    }

    public void logReturn(String judul, String returnTime) { 
        for (String[] log : logs) {
            if (log[1].equals(judul) && log[3].equals("-")) {
                log[3] = returnTime;
                break;
            }
        }
    }

    public String getLogs() { 
        if (logs.isEmpty()) {
            return "Tidak ada log aktivitas.";
        }

        String border = "+---------------------+--------------------------------+-----------------+---------------------+";
        String hasil = border + "\n";
        hasil += String.format("| %-19s | %-30s | %-15s | %-19s |%n", "Dipinjam pada", "Judul", "Member", "Dikembalikan pada");
        hasil += border + "\n";

        for (String[] log : logs) {
            hasil += String.format("| %-19s | %-30s | %-15s | %-19s |%n", log[0], log[1], log[2], log[3]);
        }

        hasil += border;
        return hasil;
    }

    public void clearLogs() {
        logs.clear();
    }
}