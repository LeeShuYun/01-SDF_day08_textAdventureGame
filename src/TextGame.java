import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class TextGame {
    private String startPoint = "";
    private Map<String, Room> roomMap = new HashMap<>();
    private Room currentLoc;
    private Boolean isGameRunning = false; 
    
    //read the text file and set up the rooms first
    public void prepGame(String filePath){
        // get input from player
        String fileName = args[0];
        System.out.printf("Processing %s\n", fileName);

        //read the text file line by line
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
    
        while ((line = br.readLine()) != null){
            line  = br.readLine();
            
            //process the spaces between the lines
            //if line is a blank line we skip and go to the next
            if (line.equals("\n")){
                continue;
            }
            String[] words = line.trim().split(" ");
            String roomID = words[1];
            //check if it's the start point...
            if (words[0].equalsIgnoreCase("start:")){
                this.startPoint = words[1];
            }
            //create Room objects once we recognise there's something there
            if (words[0].equalsIgnoreCase("room:")){
                
                line  = br.readLine(); //name
                String roomName = textParser(line);
                line  = br.readLine(); //description
                String descriptionData = textParser(line);
                descriptionData.replace("<break>", "\n");
                //we make a Room object
                Room newRoom = new Room(roomName, descriptionData);
                //while there's still direction data to be read and haven't hit the empty line
                while (!line.equals("\n")){
                    line  = br.readLine();
                    String[] directionSplit = line.trim().split(" ");
                    String direction = directionSplit[1];
                    String directionData = textParser(line);
                    newRoom.setDirectionsList(direction, directionData);
                }
                //dump the finished Room into the RoomMap
                this.roomMap.put(roomName, newRoom);

            }
        } //end the reading
        br.close();
        fr.close();
    }
    //text Parser takes a whole string and gives back everything except the first word
    public String textParser(String line){
        String[] words = line.trim().split(" ");
        //copying array elements to make the room name  
        String[] roomNameList = new String[words.length - 1];
        for (int i = 0; i < roomNameList.length;i++){
            roomNameList[i] = words[1 + i];
        }
        String data = String.join(" ", roomNameList);
        return data;
    }

    public Optional<Room> getRoom(String direction){
        if (rooms.containsKey(direction)){

        }
    }
    //actual game loop
    public void startGame(){
        //set the current location Room
        this.currentLoc = this.roomMap[this.startPoint];
        
        //open game loop
        while(!isGameRunning){
            if ()
            // check direction switch
            // >look 
            // >go north 
            // switch over to the room
            
        }
    }
        
    
} 
