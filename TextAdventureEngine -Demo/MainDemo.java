/**
 * @BrendanShaw
 * @V8-25-3
 */
import java.io.File;//Allows file stuff
import java.io.FileWriter;//Allows the writing of files so saved.
import java.io.IOException;//Allows errors for files.
import java.util.Scanner;//Importing Scanner so keyboard inputs can be recorded.
public class MainDemo
{
    //Room varibles
    final String[] ROOM_NAME={
            "Three Paths",
            "The South Path",
            "The Southern Lookout",
            "The Dead End",
            "The Endless path",
            "The Stream", 
            "The Forked Bridge",
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
    final int[][] MOVE_DIRECTION={
            {-1,-1,3, -1, 5, 4, -1, 6},//East direction
            {-1,-1,-1,4,5,4,-1,-1},//West direction
            {7,0,-1, -1,-1,-1,7,-1},//North direction
            {1,2,-1,-1,-1,-1,2,0},//South direction
            {6,-1,-1,-1,-1,-1,-1,-1},//Up direction
            {-1,-1,-1,-1,-1,6,0,-1}};//Down direction
    int currentRoom;
    //Win conditions
    final int[] WIN_ITEM={1};
    final int WIN_ROOM=3;
    final String WIN_MESSAGE="You Place the magic box and you feel a sense of winning!";
    final String LOSE_MESSAGE="The End!";
    //Movement commands
    final String[] MOVE_COMMAND={
            "east",//East commands
            "west",//west commands
            "north",//north commands
            "south",//south commands
            "up",//up commands
            "down"};//down commands
    //Item commands
    final String INVENTORY_COMMAND="checkinventory";
    final String LOOK_COMMAND="lookaround";
    final String GRAB_COMMAND="pickup";
    final String DROP_COMMAND="drop";
    //Save commands
    final String EXIT_COMMAND="save";
    final String LOAD_COMMAND="load";
    final int FORCE_STOP=500;
    //Save varibles    
    final File SAVE_NAME=new File("save.txt");
    //Other commands
    final String QUIT_COMMAND="end";
    final String LIST_COMMAND="command";
    //Item varibles
    final String[] ITEM_NAME = {"Danger Sign","Magic-Box"};
    int[] itemLocation = {1,7};
    //Keep running
    boolean keepRunning = true;

    public MainDemo()
    {
        System.out.println("List of commands- "+LIST_COMMAND);
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
            String scannerOutput=scanner.nextLine().toLowerCase().replace(" ", "");
            boolean validCommand=false;
            //Movement commands
            for(int i=0; i<MOVE_DIRECTION.length;i++){
                if (scannerOutput.equals(MOVE_COMMAND[i])&&MOVE_DIRECTION[i][currentRoom]==-1){
                    System.out.println("You can't go there!");
                    validCommand=true;
                }
                else if(scannerOutput.equals(MOVE_COMMAND[i])){
                    currentRoom=MOVE_DIRECTION[i][currentRoom];
                    validCommand=true;
                }
            }//Item commands
            if ((scannerOutput.equals(INVENTORY_COMMAND))){
                boolean hasItem=false;
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==-1){
                        System.out.println(ITEM_NAME[i]);
                        hasItem=true;
                    }}
                if(!hasItem){
                    System.out.println("You find that your pockets are empty");
                }
            }else if ((scannerOutput.equals(LOOK_COMMAND))){
                boolean canSeeItem=false;
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==currentRoom){
                        System.out.println("You can see "+ITEM_NAME[i]);
                        canSeeItem=true;
                    }}
                if(!canSeeItem){
                    System.out.println("You can't see any items here");
                }
            }else if ((scannerOutput.equals(GRAB_COMMAND))){
                boolean pickUpItem=false;
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==currentRoom){
                        itemLocation[i]=-1;
                        System.out.println("You picked up "+ITEM_NAME[i]);
                        pickUpItem=true;
                    }}
                if(!pickUpItem){
                    System.out.println("You can't find any items to pickup");
                }
            }else if ((scannerOutput.equals(DROP_COMMAND))){
                boolean droppedItem=false;
                for (int i=0; i<itemLocation.length;i++){
                    if(itemLocation[i]==-1){
                        itemLocation[i]=currentRoom;
                        System.out.println("You dropped "+ITEM_NAME[i]);
                        droppedItem=true;
                    }}
                if(!droppedItem){
                    System.out.println("You don't have any items to drop");
                }
            }//Save commands
            else if(scannerOutput.equals(EXIT_COMMAND)){
                boolean writeAcess=true;
                try{
                    FileWriter fileWriter=new FileWriter(SAVE_NAME);
                    fileWriter.write(currentRoom+"");//+"" is required to make the save work
                    for (int i=0; i<itemLocation.length;i++){
                        fileWriter.write(","+itemLocation[i]);
                    }
                    fileWriter.close();
                }catch(IOException e){
                    System.out.println("I don't have writing acess");
                    writeAcess=false;
                }
                if(writeAcess){System.out.println("Saved");
                    keepRunning=false;}
            }else if(scannerOutput.equals(LOAD_COMMAND)){
                try{
                    Scanner fileScanner = new Scanner(SAVE_NAME);//Set up the scanner
                    String saveData[]=fileScanner.nextLine().split(",");
                    currentRoom=Integer.parseInt(saveData[0]);
                    for (int i=1; i<saveData.length-1;i++){
                        itemLocation[i-1]=Integer.parseInt(saveData[i]);
                    }
                }catch(Exception e){
                    System.out.println("The save file does not exist or has been modified");
                    e.printStackTrace();
                }
            }//Other commands
            else if ((scannerOutput.equals(QUIT_COMMAND))){
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
                //List the save commands
                System.out.println("Command to save and exit- " +EXIT_COMMAND);
                System.out.println("Command to load- " +LOAD_COMMAND);
                //List the other commands
                System.out.println("Command to give up- " +QUIT_COMMAND);
                System.out.println("Command to check commands- " +LIST_COMMAND);
            }
            //Failure command
            else if (!validCommand){
                System.out.println("Invalid command");
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