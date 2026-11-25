package gr.aegean.icsd.news;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
         System.out.println("APP_NAME=" + readAppName());

        NewsService service = new NewsService(SampleData.createNews());

        // Πρώτη εκτέλεση πριν από την προσθήκη της βιβλιοθήκης JSON.
        printJson("Published news", service.getPublishedNews());
        for (News item : service.getPublishedNews()) {
            System.out.println(item.getId() + " - " + item.getTitle());
        }
  printJson("Search: TECHNOLOGY", service.searchPublishedByTitle("TECHNOLOGY"));
printJson("Search: volcano", service.searchPublishedByTitle("volcano")); 
 }

    // Έτοιμη ανάγνωση ρυθμίσεων από resource του classpath.
    private static String readAppName() {
        Properties settings = new Properties();
        try (InputStream input = Main.class.getResourceAsStream("/workshop.properties")) {
            if (input == null) {
                throw new IllegalStateException("Resource not found: /workshop.properties");
            }
            settings.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (IOException error) {
            throw new IllegalStateException("Cannot read resource: /workshop.properties", error);
        }
        String appName = settings.getProperty("app.name");
        if (appName == null || appName.isBlank()) {
            throw new IllegalStateException("Missing property: app.name");
        }
        return appName;
    }
    private static void printJson(String label, Object value) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    System.out.println(label + ":");
    System.out.println(gson.toJson(value));
}
}
