/**
 * @BrendanShaw
 * @V6-24-3
 */
import java.util.Scanner;//Importing Scanner so keyboard inputs can be recorded.
public class Main
{
    //Room varibles
    final String[] ROOM_NAME={"First Room","Second Room","Third Room"};
    final int[] MOVE_EAST={1,2,1};
    final int[] MOVE_WEST={1,0,1};
    final int[] MOVE_NORTH={2,1,1};
    final int[] MOVE_SOUTH={2,0,1};
    final int[] MOVE_UP={1,0,1};
    final int[] MOVE_DOWN={1,0,-1};
    int currentRoom;
    //Win conditions
    final int WIN_ITEM=0;
    final int WIN_ROOM=2;
    final String WIN_MESSAGE="You Win!";
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
    final String[] ITEM_NAME = {"First Item","Second Item"};
    int[] itemLocation = {1,0};
    //Keep running
    boolean keepRunning = true;
    
    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        // initialise instance variables
        while (keepRunning){
            //Tells player what directions they can go
            String allowedDirections="";
            if(!(MOVE_EAST[currentRoom]==-1)){allowedDirections+="east ";}
            if(!(MOVE_WEST[currentRoom]==-1)){allowedDirections+="west ";}
            if(!(MOVE_SOUTH[currentRoom]==-1)){allowedDirections+="south ";}
            if(!(MOVE_NORTH[currentRoom]==-1)){allowedDirections+="north ";}
            if(!(MOVE_UP[currentRoom]==-1)){allowedDirections+="up ";}
            if(!(MOVE_DOWN[currentRoom]==-1)){allowedDirections+="down ";}
            if(!allowedDirections.equals("")){
                System.out.println("You can go "+allowedDirections);}
            else{//If you somehow get stuck, you lose instead of being stuck
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
                System.out.println("You are at the "+ROOM_NAME[currentRoom]);
            }else if (scannerOutput.equals(NORTH_COMMAND)&&MOVE_NORTH[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals(NORTH_COMMAND))){
                currentRoom=MOVE_NORTH[currentRoom];
                System.out.println("You are at the "+ROOM_NAME[currentRoom]);
            }else if (scannerOutput.equals(EAST_COMMAND)&&MOVE_EAST[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals(EAST_COMMAND))){
                currentRoom=MOVE_EAST[currentRoom];
                System.out.println("You are at the "+ROOM_NAME[currentRoom]);
            }else if (scannerOutput.equals(WEST_COMMAND)&&MOVE_WEST[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals(WEST_COMMAND))){
                currentRoom=MOVE_WEST[currentRoom];
                System.out.println("You are at the "+ROOM_NAME[currentRoom]);
            }else if (scannerOutput.equals(UP_COMMAND)&&MOVE_UP[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals(UP_COMMAND))){
                currentRoom=MOVE_UP[currentRoom];
                System.out.println("You are at the "+ROOM_NAME[currentRoom]);
            }else if (scannerOutput.equals(DOWN_COMMAND)&&MOVE_DOWN[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals(DOWN_COMMAND))){
                currentRoom=MOVE_DOWN[currentRoom];
                System.out.println("You are at the "+ROOM_NAME[currentRoom]);
            }//Item commands
            else if ((scannerOutput.equals(INVENTORY_COMMAND))){
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==-1){
                        System.out.println(ITEM_NAME[i]);
                    }}
            }else if ((scannerOutput.equals(LOOK_COMMAND))){
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==currentRoom){
                        System.out.println(ITEM_NAME[i]);
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
