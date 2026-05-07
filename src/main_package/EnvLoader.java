package main_package;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EnvLoader {

    public static void load(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                // skip empty lines and comments
                if (line.isEmpty() || line.startsWith("#")) continue;

                String[] parts = line.split("=", 2);
                if (parts.length != 2) continue;

                String key = parts[0].trim();
                String value = parts[1].trim();

                // remove optional surrounding quotes
                value = stripQuotes(value);

                // store as system property
                System.setProperty(key, value);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load .env file: " + filePath, e);
        }
    }

    private static String stripQuotes(String value) {
        if (value == null) return null;

        value = value.trim();

        if (value.startsWith("\"") && value.endsWith("\"") && value.length() >= 2) {
            return value.substring(1, value.length() - 1);
        }

        return value;
    }
}