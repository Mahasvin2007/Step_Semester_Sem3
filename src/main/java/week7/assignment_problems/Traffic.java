class TrafficLight {
    private String color;
    private final String lightId;

    public TrafficLight(String lightId) {
        this.lightId = lightId;
        this.color = "RED";
    }

    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }

        System.out.println("Current Color: " + color);
    }

    public String getColor() {
        return color;
    }

    public String getLightId() {
        return lightId;
    }
}

public class Traffic {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");

        System.out.println(t.getColor());

        t.next();
        t.next();
        t.next();
    }
}