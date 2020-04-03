import java.util.ArrayList;

/**
 * this class contain the database of Food
 *
 * @author Ikhsan Firdauz
 * @version 1.0
 * @since 27 - 2 - 2020
 */
public class DatabaseFood
{
    // instance variables - replace the example below with your own
    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<Food>();
    private static int lastId = 0;

    public static ArrayList<Food> getFoodDatabase()
    {
        return FOOD_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Food getFoodById(int id)
    {
        for (Food foods : FOOD_DATABASE)
        {
            if (foods.getId() == id)
            {
                return foods;
            }
        }
        return null;
    }

    public static ArrayList<Food> getFoodBySeller(int sellerId)
    {
        ArrayList<Food> foodList = new ArrayList<Food>();
        for (Food foods : FOOD_DATABASE)
        {
            if(foods.getSeller().getId() == sellerId)
            {
                foodList.add(foods);
            }
            else
            {
                foodList = null;
            }
        }
        return foodList;
    }

    public static ArrayList<Food> getFoodByCategory(FoodCategory foodCategory)
    {
        ArrayList<Food> foodList = new ArrayList<Food>();
        for (Food foods : FOOD_DATABASE)
        {
            if(foods.getCategory().equals(foodCategory))
            {
                foodList.add(foods);
            }
        }
        return foodList;
    }

    public static boolean addFood(Food food)
    {
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }

    public static boolean removeFood(int id)
    {
        for(Food foods : FOOD_DATABASE)
        {
            if(foods.getId() == id)
            {
                FOOD_DATABASE.remove(foods);
                return true;
            }
        }
        return true;
    }
} 
