import java.util.ArrayList;

public class WildlifeToken {

    private final String animal;
    ArrayList<Integer> coordinates;

    public WildlifeToken(String animal) {
        this.animal = animal;
        this.coordinates = new ArrayList<Integer>(2);
        this.coordinates.add(null);
        this.coordinates.add(null);
    }

    public String getAnimalLetter() {
        return switch (this.animal) {
            case "Bear" -> "B";
            case "Hawk" -> "H";
            case "Elk" -> "E";
            case "Salmon" -> "S";
            case "Fox" -> "F";
            default -> "";
        };
    }

    public void setCoordinates(int x, int y) {
        this.coordinates.set(0, x);
        this.coordinates.set(1, y);
    }

    public Integer getX() {
        return this.coordinates.get(0);
    }
    public Integer getY() {
        return this.coordinates.get(1);
    }

}