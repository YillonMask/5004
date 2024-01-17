/**
 *CS 5004 Spring 5004
 * Xinrui Yi
 */

/**
 * This class represents shoe. Shoe has a type, color, brand and size.
 */
public class Shoe {
    private String type;
    private String color;
    private String brand;
    private double size;

    /**
     * This construct a shoe class which provided with type, color brand and size
     *
     * @param type the type given to the shoe
     * @param color the color given to the shoe
     * @param brand the brand given to the shoe
     * @param size the size given to the shoe
     */
    public Shoe(String type, String color, String brand, double size){
        this.type = type;
        this.color = color;
        this.brand = brand;
        this.size = size;
    }

    /**
     * This method returns the type of the shoe
     *
     * @return the type of the shoe
     */
    public String getType(){
        return this.type;
    }

    /**
     * This method returns the color of the shoe
     *
     *  @return the color of the shoe
     */
    public String getColor(){
        return this.color;
    }

    /**
     * This methods returns the brand of the shoe
     *
     * @return the brand of the shoe
     */
    public String getBrand(){
        return this.brand;
    }

    /**
     * This method returns the size of the shoe
     *
     * @return the size of the shoe
     */
    public double getSize(){
        return this.size;
    }

    /**
     * This method return string representation of the attributes of the shoe
     *
     * @return all the attributes of the shoe
     */
    public String toString(){
    //return String.format("The type of the shoe is %s, the color is %s, the brand is %s and the size is %.1f"
    //                , this.type, this.color, this.brand, this.size);
        return "The type of the shoe " + type + " the color is " + color + " the brand is " + brand + " and the size is " + size +"\n";
    }

    /**
     * This is the main function
     * @param args the parameters
     */
    public static void main(String[] args) {
        Shoe NewBalance = new Shoe("Running", "Grey", "NewBalance", 8.5);
        Shoe Nike = new Shoe("Basketball", "Black", "Nike", 9);
        System.out.print(NewBalance);
        System.out.print(Nike);
}

}
