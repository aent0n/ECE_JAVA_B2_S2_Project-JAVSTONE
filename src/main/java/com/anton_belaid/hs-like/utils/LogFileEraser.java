package com.anton_belaid.hs_like.utils;

import java.io.FileWriter;
import java.io.IOException;

public class LogFileEraser {
    public static void eraseLogFile(String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, false); // false means not append
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while trying to erase the log file.");
            e.printStackTrace();
        }
    }
}