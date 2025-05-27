public class Guitar implements Playable {
    private String brand;
    private int strings;
    private String type; 
   
    public Guitar(String brand, int strings, String type) {
        this.brand = brand;
        this.strings = strings;
        this.type = type;
    }

   
    @Override
    public void play() {
        System.out.println("Playing the " + type + " guitar: Strumming the strings...");
    }

       @Override
    public void stop() {
        System.out.println("Stopping the guitar: Muting the strings...");
    }

   
    public void displayDetails() {
        System.out.println("\nGuitar Details:");
        System.out.println("--------------");
        System.out.println("Brand: " + brand);
        System.out.println("Number of Strings: " + strings);
        System.out.println("Type: " + type);
    }

   
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStrings() {
        return strings;
    }

    public void setStrings(int strings) {
        this.strings = strings;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}