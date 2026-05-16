import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {

    private List<LogEntry> logs = new ArrayList<>();
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    static class LogEntry {
        String borrowTime;
        String returnTime;
        String title;
        String member;

        LogEntry(String borrowTime, String title, String member) {
            this.borrowTime = borrowTime;
            this.title      = title;
            this.member     = member;
            this.returnTime = "-";
        }
    }

    public void logBorrow(abstractLibraryitem item, String memberName) {
        String time = LocalDateTime.now().format(FORMATTER);
        logs.add(new LogEntry(time, item.getTitle(), memberName));
    }

    public void logReturn(abstractLibraryitem item, String memberName) {
        String time = LocalDateTime.now().format(FORMATTER);
        for (int i = logs.size() - 1; i >= 0; i--) {
            LogEntry log = logs.get(i);
            if (log.title.equals(item.getTitle())
                    && log.member.equals(memberName)
                    && log.returnTime.equals("-")) {
                log.returnTime = time;
                return;
            }
        }
    }

    public String getLogs() {
        if (logs.isEmpty()) return "Belum ada log aktivitas.";

        // Kolom: No | Judul | Member | Dipinjam Pada | Dikembalikan Pada
        int noW      = 4;
        int titleW   = 28;
        int memberW  = 16;
        int timeW    = 21;

        String border = "+"
            + "-".repeat(noW)    + "+"
            + "-".repeat(titleW) + "+"
            + "-".repeat(memberW)+ "+"
            + "-".repeat(timeW)  + "+"
            + "-".repeat(timeW)  + "+";

        StringBuilder sb = new StringBuilder();
        sb.append(border).append("\n");
        sb.append(String.format("| %-" + (noW-2)     + "s | %-" + (titleW-2)  + "s | %-" + (memberW-2)
                + "s | %-" + (timeW-2) + "s | %-" + (timeW-2) + "s |%n",
                "No", "Judul", "Member", "Dipinjam Pada", "Dikembalikan Pada"));
        sb.append(border).append("\n");

        int no = 1;
        for (LogEntry log : logs) {
            sb.append(String.format("| %-" + (noW-2)     + "d | %-" + (titleW-2)  + "s | %-" + (memberW-2)
                    + "s | %-" + (timeW-2) + "s | %-" + (timeW-2) + "s |%n",
                    no++, log.title, log.member, log.borrowTime, log.returnTime));
        }
        sb.append(border).append("\n");
        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
    }
}