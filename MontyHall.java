
import java.util.Scanner;


 /**
 * This class represents a program that 
 * simulates the Monty Hall Problem.
 * @author Lindsey Yu
 * @version 1
 */



public class MontyHall {
    

    

     /**
      * Main method calls the getUserDoor, revealDoor, getUserSwap, and newDoor methods
      * @param args Standard array of commandline String arguments. Not used in this program.
      */    

    public static void main(String[] args) {

        if (args.length == 0) {
            interactiveGame(); }
        else {

            //Figure out how many sims to run
            int numSims = Integer.parseInt(args[0]);
            System.out.println("Going to run " + numSims + " Simulations.");

            simulateGame(numSims);

        
        }

    }


    /**
    * Runs the simulations of the games for x amount of times
    *@param games the number of games the program will be runnning
    */ 

    public static void simulateGame(int games){


        int swapGames = 0;
        int swapWins = 0;
        int stayGames = 0;
        int stayWins = 0;

        int userDoor;
        boolean swapOrStay;
        boolean result;


        while (games > 0) {

            //Run a single simulation in here
           userDoor = (int) (Math.random() * 3 + 1);
           swapOrStay = Math.random() > 0.5; //Generate a random booloean
           result = simulateSingleGame(userDoor, swapOrStay);


            if (swapOrStay) {
               swapGames ++;
               if (result) {
                   swapWins++; 
               }
            }

            else {
                stayGames++;
                if (result) {
                    stayWins++;
                }
            }

            games--;
        }

        double swapSuccessRate = (double) swapWins/ swapGames;

        double staySuccessRate = (double) stayWins / stayGames; 

        System.out.println("You won: " + swapSuccessRate * 100 + ( "% of all the games where you swapped."));
        System.out.println("You won: " + staySuccessRate  * 100 + ("% of all the games where you stayed."));
        



    }




/**  Simulates a single game of Monty Hall$
*Simulates a single game of Monty Hall
*@param userDoor the door the user wants to played
*@param swapOrStay Whther the uswer wants to swap dooor or keep the same door
@return Whether the user wins
*/ 

public static boolean simulateSingleGame(int userDoor, boolean swapOrStay) {

    //cjoose a randomm car door
    int carDoor = (int) (Math.random() * 3 +1);


    //Open a goat door
    int revealedDoor = revealDoor(carDoor, userDoor);

    //Swap is necessary
    if (swapOrStay) {
        userDoor = newDoor(userDoor, revealedDoor);
    }

    //Return whether they won

    return userDoor == carDoor; 
    
}


   /**
    * Simulates a Monty Hal Game as played by the user 
    */

        public static void interactiveGame() {


            

        //model the doors as ints

        int carDoor = (int) (Math.random() * 3 + 1); //the car is behind door 3 

        int userDoor = getUserDoor();
        // Reveal a goat 

        int goatDoor = revealDoor(carDoor, userDoor);

        System.out.println("There is a goat behind door number " + goatDoor);

        boolean swap = getUserSwap();

        
        if (swap == true) { 
            userDoor = newDoor(userDoor, goatDoor);
            System.out.println("Okay, your new door number is " + userDoor + "."); }
        else {
            userDoor= userDoor;
            System.out.println("You decided to stay. Your door number is still " + userDoor + "."); }

        String object = " "; //create object string


        if (userDoor == carDoor) 
             object = "car";
        else
             object = "goat";

        
        if (object.equals("goat")) { //ASCII art!
            System.out.println("Sorry, behind Door #" + userDoor + " is a " + object); 
            System.out.println("(_( \n/_/'_____/)\n\"  l      l\n   l\"\"\"\"\"\"l");}
        else { 
            System.out.println("CONGRATS! behind door # "  + userDoor + " is a " + object); 
            System.out.println("  ______\n ll_ll_\\`.__\n(   _    _ _\\\n=`-(_)--(_)-'");}
        }

 

    public static Scanner kb = new Scanner(System.in); 


    /** This method asks the user whether they want to swap their or not.
    *
    * @return Returns a boolean whether the user wants to swap or not. (true to swap, false to stay)
    */

    public static boolean getUserSwap() {

        System.out.println("Would you like to switch your door? (Yes or No): ");

        String answer = kb.nextLine(); 

        if (answer.equals("yes") || answer.equals("Yes"))
            return true;
        else
            return false; }



    /**
    * This method calcs and teturns a door for the host to reveals as not the GP door
    * @param invalid1 A door that the host cannot open
    * @param invalid2 A door ths the host cannot open
    * @return number of a door containing a goat
    */
    public static int revealDoor(int invalid1, int invalid2) {
        
        for (int revealDoor = 1; revealDoor< 4; revealDoor++) {

            if (revealDoor != invalid1 && revealDoor != invalid2) {
                return revealDoor;}
                
                }
        
        //javac needs to know that *something* is always returned

        return -1; }
    

    /**
    * This method asks the user to choose a door number
    * @return number of a door picked by user
    */
     public static int getUserDoor() {
    
        System.out.println("Choose a door between 1-3: ");
        String input = kb.nextLine();
        return Integer.parseInt(input);  }


    
    /**
    * This method switches the userDoor to the only other open door (not the goat door or the user door)
    * @param userDoor the original door the user picked
    * @param goatDoor the door the program revealed that contains a goat
    * @return the number of the new user door after they switched
    */

    public static int newDoor(int userDoor, int goatDoor) {
        
        for (int newDoor =1; newDoor <4; newDoor++) {
            if (newDoor != userDoor && newDoor != goatDoor) 
                 return newDoor;  } 
                 
                 return -1;}


}