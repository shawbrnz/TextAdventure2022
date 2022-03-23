/**
 * Write a description of class Main here.
 *
 * @BrendanShaw
 * @V5-23-3
 */
import java.util.Scanner;//Importing Scanner so keyboard inputs can be recorded.
public class Main
{
    final String[] ROOM_NAME={"First Room","Second Room","Third Room"};
    final int[] MOVE_EAST={1,2,1};
    final int[] MOVE_WEST={1,0,1};
    final int[] MOVE_NORTH={2,1,1};
    final int[] MOVE_SOUTH={2,0,1};
    final int[] MOVE_UP={1,0,1};
    final int[] MOVE_DOWN={1,0,-1};
    
    int currentRoom;
    
    final int WIN_ITEM=0;
    final int WIN_ROOM=2;
    final String WIN_MESSAGE="You Win!";
    
    String[] ITEM_NAME = {"First Item","Second Item"};
    int[] itemLocation = {1,0};
    
    boolean keepRunning = true;
    
    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        // initialise instance variables
        while (keepRunning){
            Scanner scanner = new Scanner(System.in);//Set up the scanner
            System.out.println("What do you want to do?");
            String scannerOutput=scanner.nextLine().toLowerCase();
            if (scannerOutput.equals("south")&&MOVE_SOUTH[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals("south"))){
                currentRoom=MOVE_SOUTH[currentRoom];
                System.out.println("You are at the "+ROOM_NAME[currentRoom]);
            }else if (scannerOutput.equals("north")&&MOVE_NORTH[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals("north"))){
                currentRoom=MOVE_NORTH[currentRoom];
                System.out.println("You are at the "+ROOM_NAME[currentRoom]);
            }else if (scannerOutput.equals("east")&&MOVE_EAST[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals("east"))){
                currentRoom=MOVE_EAST[currentRoom];
                System.out.println("You are at the "+ROOM_NAME[currentRoom]);
            }else if (scannerOutput.equals("west")&&MOVE_WEST[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals("west"))){
                currentRoom=MOVE_WEST[currentRoom];
                System.out.println("You are at the "+ROOM_NAME[currentRoom]);
            }else if (scannerOutput.equals("up")&&MOVE_UP[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals("up"))){
                currentRoom=MOVE_UP[currentRoom];
                System.out.println("You are at the "+ROOM_NAME[currentRoom]);
            }else if (scannerOutput.equals("down")&&MOVE_DOWN[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals("down"))){
                currentRoom=MOVE_DOWN[currentRoom];
                System.out.println("You are at the "+ROOM_NAME[currentRoom]);
            }else if ((scannerOutput.equals("end"))){
                System.out.println("End");
                keepRunning=false;
            }else if ((scannerOutput.equals("checkinventory"))){
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==-1){
                        System.out.println(ITEM_NAME[i]);
                    }}
            }else if ((scannerOutput.equals("lookaround"))){
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==currentRoom){
                        System.out.println(ITEM_NAME[i]);
                    }}
            }else if ((scannerOutput.equals("pickup"))){
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==currentRoom){
                        itemLocation[i]=-1;
                    }}
            }else if ((scannerOutput.equals("drop"))){
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==-1){
                        itemLocation[i]=currentRoom;
                    }}
            }else if ((scannerOutput.equals("command"))){
                //  -----Need to write--------     //
            }else{
                System.out.println("Invalid command");
            }
            if(itemLocation[WIN_ITEM]==WIN_ROOM){
                System.out.println(WIN_MESSAGE);
                keepRunning=false;
            }
        }
    }
}
