package pokemon_console_package;

/** Class that runs the game
 * @author Jonathan Calugas
 */
public class Main {
    public static void main(String[] args) {
        GeneralFacade facade = new GeneralFacade();
        facade.generalInstructions();
        facade.gameOn();


    }
}
