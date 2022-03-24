/**
 * @BrendanShaw
 * @V7-25-3
 */
import java.util.Scanner;//Importing Scanner so keyboard inputs can be recorded.
public class Main
{
    //Room varibles
    final String[] ROOM_NAME={
            "Three Paths","The South Path","The Southern Lookout",
            "The Dead End","The Endless path","The Stream", "The Forked Bridge",
            "Northern Lookout"};
    final String[] ROOM_DESCRIPTION={
            "You see three paths, one going north, one going straight up a hill and one going south",
            "The south path just keeps going south. You can keep going south or back north",
            "While the last steps up the lookout was hard, but from here you can see the entire near by area. It also looks like the path that goes east",
            "After about 100 meters, the path disappears off a cliff. The only way out is back west",
            "No matter how far you go the path keeps going",
            "You notice the same stream over and over again. It looks like it might go somewhere down stream", 
            "You can see a bridge that has three paths coming off of it. There is a path going south with a sign with a skull and crossbones, there is a path going north and a path that follows the river downhill",
            "While the last steps up the lookout was hard, but from here you can see the entire near by area. It also looks like there are two paths, one that goes back south and the other that goes east"};
    final int[] MOVE_EAST={-1,-1,3, -1, 5, 4, -1, 6};
    final int[] MOVE_WEST={-1,-1,-1,4,5,4,-1,-1};
    final int[] MOVE_NORTH={7,0,-1, -1,-1,-1,7,-1};
    final int[] MOVE_SOUTH={1,2,-1,-1,-1,-1,2,0};
    final int[] MOVE_UP={6,-1,-1,-1,-1,-1,-1,-1};
    final int[] MOVE_DOWN={-1,-1,-1,-1,-1,6,0,-1};
    int currentRoom;
    //Win conditions
    final int WIN_ITEM=1;
    final int WIN_ROOM=3;
    final String WIN_MESSAGE="You Place the magic box and you feel a sense of winning!";
    final String LOSE_MESSAGE="The End!";
    //Movement commands
    final String EAST_COMMAND="east";
    final String WEST_COMMAND="west";
    final String SOUTH_COMMAND="south";
    final String NORTH_COMMAND="north";
    final String UP_COMMAND="up";
    final String DOWN_COMMAND="down";
    //Item commands
    final String INVENTORY_COMMAND="checkinventory";
    final String LOOK_COMMAND="lookaround";
    final String GRAB_COMMAND="pickup";
    final String DROP_COMMAND="drop";
    //Other commands
    final String END_COMMAND="end";
    final String LIST_COMMAND="command";
    //Item varibles
    final String[] ITEM_NAME = {"Danger Sign","Magic-Box"};
    int[] itemLocation = {1,7};
    //Keep running
    boolean keepRunning = true;

    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        // initialise instance variables
        while (keepRunning){
            //Tells the player where they are and what directions they can go
            System.out.println("You are at "+ROOM_NAME[currentRoom]);
            System.out.println(ROOM_DESCRIPTION[currentRoom]);
            String allowedDirections="";
            if(!(MOVE_EAST[currentRoom]==-1)){allowedDirections+="east ";}
            if(!(MOVE_WEST[currentRoom]==-1)){allowedDirections+="west ";}
            if(!(MOVE_SOUTH[currentRoom]==-1)){allowedDirections+="south ";}
            if(!(MOVE_NORTH[currentRoom]==-1)){allowedDirections+="north ";}
            if(!(MOVE_UP[currentRoom]==-1)){allowedDirections+="up ";}
            if(!(MOVE_DOWN[currentRoom]==-1)){allowedDirections+="down ";}
            if(!allowedDirections.equals("")){
                System.out.println("You can go "+allowedDirections);}
            else{//If you somehow get stuck, you lose instead of being stuck. 
                System.out.println(LOSE_MESSAGE);
                keepRunning=false;
            }
            //Reads input
            Scanner scanner = new Scanner(System.in);//Set up the scanner
            System.out.println("What do you want to do?");
            String scannerOutput=scanner.nextLine().toLowerCase();
            //Movement commands
            if (scannerOutput.equals(SOUTH_COMMAND)&&MOVE_SOUTH[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals(SOUTH_COMMAND))){
                currentRoom=MOVE_SOUTH[currentRoom];
            }else if (scannerOutput.equals(NORTH_COMMAND)&&MOVE_NORTH[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals(NORTH_COMMAND))){
                currentRoom=MOVE_NORTH[currentRoom];
            }else if (scannerOutput.equals(EAST_COMMAND)&&MOVE_EAST[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals(EAST_COMMAND))){
                currentRoom=MOVE_EAST[currentRoom];
            }else if (scannerOutput.equals(WEST_COMMAND)&&MOVE_WEST[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals(WEST_COMMAND))){
                currentRoom=MOVE_WEST[currentRoom];
            }else if (scannerOutput.equals(UP_COMMAND)&&MOVE_UP[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals(UP_COMMAND))){
                currentRoom=MOVE_UP[currentRoom];
            }else if (scannerOutput.equals(DOWN_COMMAND)&&MOVE_DOWN[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals(DOWN_COMMAND))){
                currentRoom=MOVE_DOWN[currentRoom];
            }//Item commands
            else if ((scannerOutput.equals(INVENTORY_COMMAND))){
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==-1){
                        System.out.println(ITEM_NAME[i]);
                    }}
            }else if ((scannerOutput.equals(LOOK_COMMAND))){
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==currentRoom){
                        System.out.println("You can see "+ITEM_NAME[i]);
                    }}
            }else if ((scannerOutput.equals(GRAB_COMMAND))){
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==currentRoom){
                        itemLocation[i]=-1;
                    }}
            }else if ((scannerOutput.equals(DROP_COMMAND))){
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==-1){
                        itemLocation[i]=currentRoom;
                    }}
            }//Other commands
            else if ((scannerOutput.equals(END_COMMAND))){
                System.out.println(LOSE_MESSAGE);
                keepRunning=false;
            }else if ((scannerOutput.equals(LIST_COMMAND))){
                //Lists the movement commands
                System.out.println("Command to move east- " +EAST_COMMAND);
                System.out.println("Command to move west- " +WEST_COMMAND);
                System.out.println("Command to move south- " +SOUTH_COMMAND);
                System.out.println("Command to move north- " +NORTH_COMMAND);
                System.out.println("Command to move up- " +UP_COMMAND);
                System.out.println("Command to move down- " +DOWN_COMMAND);
                //Lists the item commands
                System.out.println("Command to check you inventory- " +INVENTORY_COMMAND);
                System.out.println("Command to look around- " +LOOK_COMMAND);
                System.out.println("Command to pick up items in room- " +GRAB_COMMAND);
                System.out.println("Command to look around- " +LOOK_COMMAND);
                //List the other commands
                System.out.println("Command to give up- " +END_COMMAND);
                System.out.println("Command to check commands- " +LIST_COMMAND);
            }else{
                System.out.println("Invalid command");
            }
            //Win condition
            if(itemLocation[WIN_ITEM]==WIN_ROOM){
                System.out.println(WIN_MESSAGE);
                keepRunning=false;
            }
        }
    }
}
