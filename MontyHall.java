
import java.util.Scanner;

public class MontyHall {

    //Declaring things here, makes them fields. They are accesible everywhere in the class.
    public static Scanner kb = new Scanner(System.in); 

    public static void main(String[] args) {

        //model the doors as ints

        int carDoor = (int) (Math.random() * 3 + 1); //the car is behind door 3 

        int userDoor = getUserDoor();
        // Reveal a goat 

        int goatDoor = revealDoor(carDoor, userDoor);

        System.out.println("There is a goat behind door number " + goatDoor);

        boolean swap = getUserSwap();

        
        if (swap == true) {
            userDoor = newDoor(userDoor, goatDoor);
            System.out.println("Your new door number is " + userDoor); }
        else {
            userDoor= userDoor;
            System.out.println("You decided to stay. Your door number is still " + userDoor); }

        String object = " ";


        if (userDoor == carDoor) 
             object = "car";
        else
             object = "goat";

        
        if (object.equals("goat")) {
            System.out.println("Sorry, behind Door #" + userDoor + " is a " + object); 
            System.out.println("(_( \n/_/'_____/)\n\"  l      l\n   l\"\"\"\"\"\"l");}
        else { 
            System.out.println("CONGRATS! behind door # "  + userDoor + " is a " + object); 
            System.out.println("  ______\n ll_ll_\\`.__\n(   _    _ _\\\n=`-(_)--(_)-'");}
        }

      

    /** Method as the user whether they want to swap their or not.
    *
    * @return Returns a boolean whether the user wants to swap. (true to swap, false to stay)

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
    * @returm number of a door containing a goat
    */
    public static int revealDoor(int invalid1, int invalid2) {
        
        for (int revealDoor = 1; revealDoor< 4; revealDoor++) {

            if (revealDoor != invalid1 && revealDoor != invalid2) {
                return revealDoor;}
                
                }
        
        //javac needs to know that *something* is always returned

        return -1; }

     public static int getUserDoor() {
    
        System.out.println("Choose a door between 1-3: ");
        String input = kb.nextLine();
        return Integer.parseInt(input);  }

    
    public static int newDoor(int userDoor, int goatDoor) {
        
        for (int newDoor =1; newDoor <4; newDoor++) {
            if (newDoor != userDoor && newDoor != goatDoor) 
                 return newDoor;  } 
                 
                 return -1;}


}