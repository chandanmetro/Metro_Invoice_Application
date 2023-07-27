package com.metro.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoginLogger {
    private static final String LOG_FILE_PATH = "C:\\Users\\chandan.kumar\\Desktop\\Metro-app-finalDemo\\Metro_App\\logs";

    public static void log(String username, String ipAddress) {
        try (FileWriter writer = new FileWriter(LOG_FILE_PATH, true)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String logEntry = timestamp + " - User: " + username + ", IP Address: " + ipAddress + "\n";
            writer.write(logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
