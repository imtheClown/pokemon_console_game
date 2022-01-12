package pokemon_console_package;
import java.util.*;

/** Class composed of static methods that are necessary in getting user inputs for choices and creating breaks every print statement in order for the user to get along with the game
 */
public class Auxiliary {
    /**Returns choice for the player
     * @param choice determines the number of choices for the player
     * @return an in that represents the choice of the player
     */
    static int choiceMaker(int choice){
        Scanner sc = new Scanner(System.in);
        int yourChoice;
        try {
            yourChoice = sc.nextInt();
        }catch (Exception e){
            System.out.print("You entered a non-integer\nTry again\n");
            yourChoice = choiceMaker(choice);
        }
        if(choice == 0){
            while (yourChoice > 1 | yourChoice < 0){
                System.out.print("Your choice is invalid for a YES and NO\nTry Again\n");
                yourChoice = sc.nextInt();
            }
            return yourChoice;
        }
        else{
            while (yourChoice < 1 | yourChoice > choice ){
                System.out.print("The choice you entered is out of bounds\nTry again\n");
                yourChoice = sc.nextInt();
            }
        }
        return yourChoice;

    }

    /**Generates random integer
     * @param upperBound an integer that serves as the ceiling of the value the method can generate
     * @return an instance of int
     */
    static int randomizer(int upperBound){
        Random rand = new Random();
        int randomInt = rand.nextInt(upperBound+ 1);
        while (randomInt == 0){
            randomInt = rand.nextInt(upperBound + 1);
        }
        return randomInt;
    }

    /**Method that preserves the flow of the whole program and makes sure that the printing at stdout is not too fast for the Player
     */
    static void enterPresser(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Press enter to proceed");
        String justPress = sc.nextLine();
        System.out.print("\n");
    }
}
