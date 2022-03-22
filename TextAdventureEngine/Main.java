/**
 * Write a description of class Main here.
 *
 * @BrendanShaw
 * @V4-16-3
 */
import java.util.Scanner;//Importing Scanner so keyboard inputs can be recorded.
public class Main
{
    String[] roomName={"First Room","Second Room","Third Room"};
    final int[] MOVE_EAST={1,2,1};
    final int[] MOVE_WEST={1,0,1};
    final int[] MOVE_NOST={2,1,1};
    final int[] MOVE_EAEST={2,0,1};
    final int[] MOVE_EAEFST={1,0,1};
    final int[] MOVE_EAAST={1,0,-1};
    int currentRoom;
    boolean keepRunning = true;
    int[] itemLocation = {1,0};
    String[] itemName = {"First Item","Second Item"};
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
            if (scannerOutput.equals("south")&&roomMoveSouth[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals("south"))){
                currentRoom=roomMoveSouth[currentRoom];
                System.out.println(currentRoom);
            }else if (scannerOutput.equals("north")&&roomMoveNorth[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals("north"))){
                currentRoom=roomMoveNorth[currentRoom];
                System.out.println(currentRoom);
            }else if (scannerOutput.equals("east")&&roomMoveEast[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals("east"))){
                currentRoom=roomMoveEast[currentRoom];
                System.out.println(currentRoom);
            }else if (scannerOutput.equals("west")&&roomMoveWest[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals("west"))){
                currentRoom=roomMoveWest[currentRoom];
                System.out.println(currentRoom);
            }else if (scannerOutput.equals("up")&&roomMoveUp[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals("up"))){
                currentRoom=roomMoveUp[currentRoom];
                System.out.println(currentRoom);
            }else if (scannerOutput.equals("down")&&roomMoveDown[currentRoom]==-1){
                System.out.println("You can't go there!");
            }else if ((scannerOutput.equals("down"))){
                currentRoom=roomMoveDown[currentRoom];
                System.out.println(currentRoom);
            }else if ((scannerOutput.equals("end"))){
                System.out.println("End");
                keepRunning=false;
            }else if ((scannerOutput.equals("checkinventory"))){
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==-1){
                        System.out.println(itemName[i]);
                    }}
            }else if ((scannerOutput.equals("lookaround"))){
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==currentRoom){
                        System.out.println(itemName[i]);
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
            }else{
                System.out.println("Invalid command");
            }
        }
    }
}
