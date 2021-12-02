package classwork;

import java.io.*;
import java.util.ArrayList;

class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String description;
    double cost;

    public Item(int id, String description, double cost) {
        this.id = id;
        this.description = description;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "classwork.Item{" +
                "description='" + description + '\'' +
                '}';
    }
}

class ShoppingCart implements Serializable {
    int cartID;
    ArrayList<Item> items;
    int itemCount;
    transient double cartTotal;

    public ShoppingCart() {
        cartID = 0;
        itemCount = 0;
        items = new ArrayList<>();
        cartTotal = 0;
    }

    void put(Item item) {
        items.add(item);
        itemCount++;
        cartTotal += item.cost;
    }

    @Override
    public String toString() {
        return "classwork.ShoppingCart{" +
                "cartID=" + cartID +
                ", items=" + items.toString() +
                ", itemCount=" + itemCount +
                ", cartTotal=" + cartTotal +
                '}';
    }

    public void serialize(String path) {
        try (FileOutputStream outputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ShoppingCart deserialize(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            ShoppingCart shoppingCart = (ShoppingCart) objectInputStream.readObject();
            for (var i : shoppingCart.items) {
                shoppingCart.cartTotal += i.cost;
            }
            return shoppingCart;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}

public class classwork_2 {
    public static void main(String... argv) {
        Item[] items = new Item[]{
                new Item(1, "Футболка", 100),
                new Item(2, "Шорты", 80),
                new Item(3, "Джинсы", 70),
                new Item(5, "Майка", 30),
                new Item(6, "Рубашка", 90),
                new Item(7, "Штаны", 110),
                new Item(8, "Пиджак", 120),
                new Item(9, "Кроссовки", 75),
                new Item(10, "Туфли", 85)
        };
        ShoppingCart shoppingCart = new ShoppingCart();
        for (var i : items) {
            shoppingCart.put(i);
        }
        shoppingCart.serialize(argv[0]);
        ShoppingCart decart = ShoppingCart.deserialize(argv[0]);
        if(decart!=null)
            System.out.println("После загрузки объект:\n"+decart.toString());
    }
}
