public class Piano implements Playable {
    private String brand;
    private int keys;
    private String type; 

   
    public Piano(String brand, int keys, String type) {
        this.brand = brand;
        this.keys = keys;
        this.type = type;
    }

       @Override
    public void play() {
        System.out.println("Playing the " + type + " piano: Pressing the keys...");
    }

       public void displayDetails() {
        System.out.println("\nPiano Details:");
        System.out.println("-------------");
        System.out.println("Brand: " + brand);
        System.out.println("Number of Keys: " + keys);
        System.out.println("Type: " + type);
    }

    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getKeys() {
        return keys;
    }

    public void setKeys(int keys) {
        this.keys = keys;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}