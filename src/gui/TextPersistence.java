package gui;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextPersistence {
    public void saveMenuToCSV(String fileName, String[] items, Double[] prices) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Item,Price\n"); // Escribir encabezados

            for (int i = 0; i < items.length; i++) {
                writer.write(items[i] + "," + prices[i] + "\n"); // Escribir cada línea del menú
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

