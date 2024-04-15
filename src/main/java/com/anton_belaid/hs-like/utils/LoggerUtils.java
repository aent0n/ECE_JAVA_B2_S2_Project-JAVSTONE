package com.anton_belaid.hs_like.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LoggerUtils {

    private static final String LOG_FILE_PATH = "game.log";

    public static void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
}