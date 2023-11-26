package gui;
// Clase abstracta para representar un ítem genérico en el menú de alimentos
abstract class MenuItem {
    private String itemName;
    private double itemPrice;

    public MenuItem(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    // Método abstracto para calcular el precio total basado en la cantidad
    public abstract double calculateTotalPrice(int quantity);
}

// Clase concreta que extiende de MenuItem para representar un tipo específico de alimento
class FoodItem extends MenuItem {
    public FoodItem(String itemName, double itemPrice) {
        super(itemName, itemPrice);
    }

    @Override
    public double calculateTotalPrice(int quantity) {
        return getItemPrice() * quantity;
    }
}

// Clase concreta que extiende de MenuItem para representar un tipo específico de bebida
class DrinkItem extends MenuItem {
    public DrinkItem(String itemName, double itemPrice) {
        super(itemName, itemPrice);
    }

    @Override
    public double calculateTotalPrice(int quantity) {
        // Se podría agregar alguna lógica específica para bebidas si es necesario
        return getItemPrice() * quantity;
    }
}
