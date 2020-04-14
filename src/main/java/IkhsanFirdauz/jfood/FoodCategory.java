package IkhsanFirdauz.jfood;
/**
 * Enumeration class FoodCategory - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
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
