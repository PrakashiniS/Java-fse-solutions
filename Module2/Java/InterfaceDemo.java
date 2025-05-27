public class InterfaceDemo {
    public static void main(String[] args) {
        System.out.println("Interface Implementation Demonstration");
        System.out.println("===================================");

       
        Guitar guitar = new Guitar("Fender", 6, "electric");
        Piano piano = new Piano("Yamaha", 88, "grand");

       
        guitar.displayDetails();
        piano.displayDetails();

       
        System.out.println("\nPlaying the Instruments:");
        System.out.println("----------------------");
        
       
        Playable.tune();
        
        
        System.out.println("\nGuitar:");
        guitar.play();
        guitar.stop();

        System.out.println("\nPiano:");
        piano.play();
        piano.stop(); 
       
        System.out.println("\nDemonstrating Polymorphism:");
        System.out.println("-------------------------");
        
       
        Playable[] instruments = new Playable[2];
        instruments[0] = guitar;
        instruments[1] = piano;

        for (Playable instrument : instruments) {
            System.out.println("\nPlaying next instrument...");
            instrument.play();
        }
    }
} 