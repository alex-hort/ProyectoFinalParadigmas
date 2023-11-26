import gui.FoodMenu;
import gui.FoodMenuDAO;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVFoodMenuDAO implements FoodMenuDAO {
    private final String fileName;

    public CSVFoodMenuDAO(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> foodItems = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    FoodItem item = new FoodItem();
                    item.setName(parts[0].trim());
                    item.setPrice(Double.parseDouble(parts[1].trim()));
                    foodItems.add(item);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return foodItems;
    }

    @Override
    public void saveAllFoodItems(List<FoodItem> foodItems) {

    }

    @Override
    public void saveAllFoodItems(List<FoodItem> foodItems) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (FoodItem item : foodItems) {
                writer.write(item.getName() + "," + item.getPrice() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

