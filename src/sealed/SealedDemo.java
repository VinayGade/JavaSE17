package sealed;


//sealed interface TrafficLight{}    // since all Red, Green and Yellow lights are in same file.
sealed interface TrafficLight permits FlashingLight, RedLight, GreenLight, YellowLight{
}

//since FlashingLight is in some other file
//TrafficLight MUST permits all its implementations...

final class RedLight implements TrafficLight{
    RedLight(){
        System.out.println("Red Light...");
    }
}

final class GreenLight implements TrafficLight{
    GreenLight(){
        System.out.println("Green Light...");
    }
}

final class YellowLight implements TrafficLight{
    YellowLight(){
        System.out.println("Yellow Light...");
    }
}

//* put all sealed class final implementations in same file if class definitions are small...

public class SealedDemo{
    public static void main(String[] args) {

        TrafficLight red = new RedLight();
        TrafficLight green = new GreenLight();
        TrafficLight yellow = new YellowLight();

        TrafficLight flashing = new FlashingLight();

    }
}