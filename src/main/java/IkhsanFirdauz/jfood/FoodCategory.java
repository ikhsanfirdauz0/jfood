package IkhsanFirdauz.jfood;
/**
 * Enumerated Class that hold every possible food category that can be inputted into Food Class object foodCategory field
 * @author Ikhsan Firdauz
 * @version 1.0
 * @since 27 - 2 - 2020
 */
public enum FoodCategory
{
    Beverages("Beverages"),
    Coffee("Coffee"),
    Western("Western"),
    Snacks("Snacks"),
    Rice("Rice"),
    Noodles("Noodles"),
    Bakery("Bakery"),
    Japanese("Japanese");
    
    private String status;
    
    FoodCategory(String status)
    {
        this.status = status;
    }
    
    public String toString()
    {
        return status;
    }
}
