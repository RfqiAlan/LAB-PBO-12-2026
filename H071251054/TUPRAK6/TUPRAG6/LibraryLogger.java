import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LibraryLogger {

    private ArrayList<String> logs;

    // Menyimpan data lengkap untuk tampilan tabel
    // Format tiap entry: [borrowTime, title, memberName, returnTime]
    private ArrayList<String[]> logData;

    private static final DateTimeFormatter FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LibraryLogger() {
        logs = new ArrayList<>();
        logData = new ArrayList<>();
    }

    // Method umum untuk log aktivitas (tetap dipertahankan)
    public String logActivity(String activity) {
        String time = LocalDateTime.now().format(FORMAT);
        String log = time + " - " + activity;
        logs.add(log);
        return log;
    }

    // Log saat item dipinjam
    public void logBorrow(String itemType, String itemTitle, String memberName) {
        String time = LocalDateTime.now().format(FORMAT);
        logs.add(time + " [" + itemType + "] " + itemTitle + " dipinjam oleh " + memberName);
        logData.add(new String[]{time, itemTitle, memberName, "-"});
    }

    // Log saat item dikembalikan - update entry yang sudah ada
    public void logReturn(String itemTitle, String memberName) {
        String time = LocalDateTime.now().format(FORMAT);
        logs.add(time + " " + itemTitle + " dikembalikan oleh " + memberName);

        // Cari entry peminjaman yang belum dikembalikan, update returnTime
        for (String[] data : logData) {
            if (data[1].equals(itemTitle) && data[2].equals(memberName) && data[3].equals("-")) {
                data[3] = time;
                break;
            }
        }
    }

    // getLogs() mengembalikan format tabel seperti di tugas
    public String getLogs() {
        if (logData.isEmpty()) {
            return "Belum ada log aktivitas.";
        }

        String line = "+---------------------+------------------------------+---------------+---------------------+";
        StringBuilder sb = new StringBuilder();
        sb.append(line).append("\n");
        sb.append(String.format("| %-19s | %-28s | %-13s | %-19s |",
                "Dipinjam pada", "Judul", "Member", "Dikembalikan pada")).append("\n");
        sb.append(line).append("\n");
        for (String[] data : logData) {
            sb.append(String.format("| %-19s | %-28s | %-13s | %-19s |",
                    data[0], data[1], data[2], data[3])).append("\n");
        }
        sb.append(line).append("\n");
        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
        logData.clear();
    }

    public ArrayList<String> getLogList() {
        return logs;
    }
}