import gui.FoodItem;
import gui.FoodMenu;
import gui.FoodMenuDAO;
import java.util.ArrayList;
import java.util.List;

public class XMLFoodMenuDAO implements FoodMenuDAO {
    private final String fileName;

    public XMLFoodMenuDAO(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        XMLPersistence persistence = new XMLPersistence();
        return persistence.loadMenuFromXML(fileName);
    }

    @Override
    public void saveAllFoodItems(List<FoodItem> foodItems) {

    }

    @Override
    public void saveAllFoodItems(List<FoodItem> foodItems) {
        XMLPersistence persistence = new XMLPersistence();
        persistence.saveMenuToXML(fileName, new ArrayList<>(foodItems));
    }
}