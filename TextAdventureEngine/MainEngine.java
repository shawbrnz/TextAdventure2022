/**
 * @BrendanShaw
 * @V8-25-3
 */
import java.util.Scanner;//Importing Scanner so keyboard inputs can be recorded.
public class MainEngine
{
    //Room varibles
    final String[] ROOM_NAME={"First Room","Second Room","Third Room"};
    final String[] ROOM_DESCRIPTION={
            "Starting room",
            "Another room",
            "More of the same Room"};
    final int[][] MOVE_DIRECTION={{1,2,1},//East direction
            {1,0,1},//West direction
            {1,1,1},//North direction
            {2,-1,-1},//South direction
            {2,1,0},//Up direction
            {-1,0,1}};//Down direction
    int currentRoom;
    //Win conditions
    final int[] WIN_ITEM={0};
    final int WIN_ROOM=2;
    final String WIN_MESSAGE="You Win!";
    final String LOSE_MESSAGE="The End!";
    //Movement commands
    final String[] MOVE_COMMAND={"east",//East commands
            "west",//west commands
            "south",//south commands
            "north",//north commands
            "up",//up commands
            "down"};//down commands
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

    public MainEngine()
    {
        // initialise instance variables
        while (keepRunning){
            //Tells the player where they are and what directions they can go
            System.out.println("You are at "+ROOM_NAME[currentRoom]);
            System.out.println(ROOM_DESCRIPTION[currentRoom]);
            String allowedDirections="";
            for(int i=0; i<MOVE_DIRECTION.length;i++){
                if(!(MOVE_DIRECTION[i][currentRoom]==-1)){allowedDirections+=MOVE_COMMAND[i]+" ";}
            }
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
            for(int i=0; i<MOVE_DIRECTION.length;i++){
                if (scannerOutput.equals(MOVE_COMMAND[i])&&MOVE_DIRECTION[i][currentRoom]==-1){
                    System.out.println("You can't go there!");}
                else if(scannerOutput.equals(MOVE_COMMAND[i])){
                    currentRoom=MOVE_DIRECTION[i][currentRoom];
                }
            }//Item commands
            if ((scannerOutput.equals(INVENTORY_COMMAND))){
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
                System.out.println("Command to move east- " +MOVE_COMMAND[0]);
                System.out.println("Command to move west- " +MOVE_COMMAND[1]);
                System.out.println("Command to move south- " +MOVE_COMMAND[2]);
                System.out.println("Command to move north- " +MOVE_COMMAND[3]);
                System.out.println("Command to move up- " +MOVE_COMMAND[4]);
                System.out.println("Command to move down- " +MOVE_COMMAND[5]);
                //Lists the item commands
                System.out.println("Command to check you inventory- " +INVENTORY_COMMAND);
                System.out.println("Command to look around- " +LOOK_COMMAND);
                System.out.println("Command to pick up items in room- " +GRAB_COMMAND);
                System.out.println("Command to look around- " +LOOK_COMMAND);
                //List the other commands
                System.out.println("Command to give up- " +END_COMMAND);
                System.out.println("Command to check commands- " +LIST_COMMAND);
            }
            //Win condition
            for(int i=0; i<WIN_ITEM.length;i++){
                if(itemLocation[WIN_ITEM[i]]==WIN_ROOM){
                    System.out.println(WIN_MESSAGE);
                    keepRunning=false;
                }}
        }
    }
}
