import java.util.HashMap;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private Map<String, String> directionsList = new HashMap<>();

    public Room(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription(){
        return description;
    }

    public String getDirectionsList(String direction) {
        return directionsList.get(direction);
    }

    public void setDirectionsList(String direction, String directionDescription) {
        this.directionsList.put(direction, directionDescription);
    }
    
}
