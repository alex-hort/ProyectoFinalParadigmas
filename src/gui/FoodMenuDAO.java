package gui;

import java.util.List;

public interface FoodMenuDAO {
    List<FoodItem> getAllFoodItems();
    void saveAllFoodItems(List<FoodItem> foodItems);
}

