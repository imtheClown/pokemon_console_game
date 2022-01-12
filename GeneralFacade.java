package pokemon_console_package;

import java.util.Scanner;

/** A Facade class that calls almost all other classes
 * Class where instance of Character is created
 * Class where the Pokemon of the main character is created
 */
public class GeneralFacade {
    PokemonFactory factory;

    public GeneralFacade() {
        this.factory = new PokemonFactory();
    }

    /**Calls other methods in the same class
     * Creates objects
     * Acts as a "General Facade"
     */
    public void gameOn() {
        PokemonFactory factory = new PokemonFactory();
        Scanner sc = new Scanner(System.in);
        Character mainCharacter;
        String name;
        System.out.print("What is your name?\n");
        name = sc.nextLine();
        System.out.print("So your name is " + name + "?\n");
        int yesOrNo = Auxiliary.choiceMaker(0);
        if (yesOrNo != 1) {
            gameOn();
        }
        mainCharacter = new Character(name);
        mainCharacter.setDefeateTrainers(4);
        mainCharacter.setMoney(500);
        System.out.print("Welcome to the world of Pokemon " + name + "!\n");
        Auxiliary.enterPresser();
        System.out.print("Here humans and Pokemon lives side by side\n");
        Auxiliary.enterPresser();
        System.out.print("Do you want a Pokemon?\n");
        yesOrNo = Auxiliary.choiceMaker(0);
        if (yesOrNo != 1) {
            System.out.print("Ah I see\n");
            Auxiliary.enterPresser();
            System.out.print("You don't want to become a trainer\n");
            Auxiliary.enterPresser();
            System.out.print("It's time for you to leave this world of Pokemon\n");
            Auxiliary.enterPresser();
            System.out.print("Until our next meeting " + name + "\n");
            Auxiliary.enterPresser();
            System.exit(0);
        }
        mainCharacter = pokemonCreator(mainCharacter);
        mainCharacter = tutorial(mainCharacter);
        System.out.print("That was impressive!\n");
        Auxiliary.enterPresser();
        System.out.print("I am looking forward to your journey but right now I must go\n");
        Auxiliary.enterPresser();
        mainCharacter = pokemonCenter(mainCharacter);
        Auxiliary.enterPresser();
        System.out.print("New Chapter unlock!\n");
        Auxiliary.enterPresser();
        mainCharacter = environmentChooser(mainCharacter);


    }

    /**Creates an instance of a sub-class of Pokemon for the player
     * @param mainCharacter an instance of the class Character
     * @return an instance Character
     */
    public Character pokemonCreator(Character mainCharacter) {
        System.out.print("Choose from the following\n");
        System.out.printf("1. %-20s Type: Grass%n", "Treeko");
        System.out.printf("2. %-20s Type: Fire%n", "Torchic");
        System.out.printf("3. %-20s Type: Water%n", "Mudkip");
        int choice = Auxiliary.choiceMaker(3);
        mainCharacter.setPokemon(factory.pokemonMaker(0, choice, 5));
        System.out.print("You received " + mainCharacter.getPokemon().getName() + "!\n");
        Auxiliary.enterPresser();
        System.out.print("Now you have your own Pokemon!\n");
        Auxiliary.enterPresser();
        System.out.print("You are now a Trainer!\n");
        Auxiliary.enterPresser();
        return mainCharacter;
    }

    /**Introduces how to game works to the player
     * @param character an instance of class character
     * @return an instance of class Character
     */
    public Character tutorial(Character character) {
        GrasslandEnvironment environment = new GrasslandEnvironment();
        System.out.print("Since you are now an official trainer, you must know the basics of Pokemon battles\n");
        Auxiliary.enterPresser();
        System.out.print("HP is the necessary damage the Pokemon needed to receive for it to faint\n");
        Auxiliary.enterPresser();
        System.out.print("Skill is what causes damage to the opposing Pokemon\n");
        Auxiliary.enterPresser();
        System.out.print("Level represents the strength of the Pokemon\n");
        Auxiliary.enterPresser();
        System.out.print("It would be better if this would be in a Pokemon Battle!\n");
        Auxiliary.enterPresser();
        System.out.print("Battle me " + character.getName() + "!\n");
        Auxiliary.enterPresser();
        character.setPokemon(environment.tutorialBattle(character));
        if(character.getPokemon().getCurrentHP() <= 0){
            Pokemon yourPokemon = character.getPokemon();
            yourPokemon.setCurrentHP(yourPokemon.getCurrentHP());
            character.setPokemon(yourPokemon);
            return tutorial(character);
        }
        return character;
    }

    /**Enables the player to choose between classroom and grassland as a context of battle
     * @param character an instance of Character
     * @return an instance of Character
     */
    public Character environmentChooser(Character character) {
        while (character.getPokemon().getCurrentHP() != 0) {
            System.out.print("Where do you want to go?\n");
            System.out.print("1.Grassland\n2.Classroom\n");
            int choice = Auxiliary.choiceMaker(2);
            if (choice == 1) {
                GrasslandEnvironment grassLand = new GrasslandEnvironment();
                GrassLandMaster enemyTrainer = new GrassLandMaster();
                character = grassLand.battle(enemyTrainer, character);
            }
            if (choice == 2) {
                ClassRoomEnvironment classRoom = new ClassRoomEnvironment(character.getDefeateTrainers(), character);
                Trainer enemyTrainer = classRoom.whosNext();
                character = classRoom.battle(enemyTrainer, character);
            }
            character = pokemonCenter(character);

        }
        return  character;
    }

    /**Acts as the Pokemon Center
     * Heals your Pokemon if they fainted or by your choice however it should be noted that the player should have money
     * @param character an instance of class Character
     * @return an instance of class Character
     */
    public Character pokemonCenter(Character character){
        int choice;
        Pokemon mainPokemon = character.getPokemon();
        if (mainPokemon.getCurrentHP() == 0 & character.getMoney() != 0){
            System.out.print("You are currently at the Pokemon Center\n");
            Auxiliary.enterPresser();
            System.out.print("Healing your Pokemon please wait...\n");
            Auxiliary.enterPresser();
            System.out.print("Your Pokemon is fully healed!\n");
            mainPokemon.setCurrentHP(mainPokemon.getBaseHP());
            Auxiliary.enterPresser();
            character.setPokemon(mainPokemon);
            return character;
        }
        if (mainPokemon.getCurrentHP() != 0 & mainPokemon.getCurrentHP() <mainPokemon.getBaseHP() & character.getMoney()!= 0){
            System.out.print("Your Pokemon is not at it's perfect health\n");
            Auxiliary.enterPresser();
            System.out.print("Restore your Pokemon to it's perfect health?\n");
            choice = Auxiliary.choiceMaker(0);
            if (choice == 0){
                System.out.print("Your pokemon is not restored to it's perfect health\n");
                Auxiliary.enterPresser();
                return character;
            }
            else {
                System.out.print("Healing your Pokemon please wait...\n");
                Auxiliary.enterPresser();
                System.out.print("Your Pokemon is fully healed!\n");
                mainPokemon.setCurrentHP(mainPokemon.getBaseHP());
                Auxiliary.enterPresser();
                character.setPokemon(mainPokemon);
                return character;
            }
        }
        if (mainPokemon.getCurrentHP() <= 0 & character.getMoney() <= 0){
            System.out.print("It seems that you have no potential of being a great trainer\n");
            Auxiliary.enterPresser();
            System.out.print("You are broke, are you willing to sell your Pokemon?\n");
            choice = Auxiliary.choiceMaker(0);
            if (choice == 1){
                System.out.print("You have sold your pokemon for 5 bucks\n");
                Auxiliary.enterPresser();
                System.out.print("You are no longer a Pokemon trainer\n");
                Auxiliary.enterPresser();
                System.out.print("Exiting the game...\n");
                Auxiliary.enterPresser();
                System.exit(0);
            }
            else {
                System.out.print("Your love for your Pokemon touched Nurse Joy's heart!\n");
                Auxiliary.enterPresser();
                System.out.print("Nurse Joy healed your Pokemon!\n");
                mainPokemon.setCurrentHP(mainPokemon.getBaseHP());
                character.setPokemon(mainPokemon);
                Auxiliary.enterPresser();
                return character;
            }
        }
        if (mainPokemon.getCurrentHP() < mainPokemon.getBaseHP() & character.getMoney() <= 0){
            System.out.print("Due to lack of potential and funds you cannot heal your injure Pokemon at the Pokemon center\n");
            Auxiliary.enterPresser();
        }
        return character;
    }

    /**Prints the general instruction for the game
     */
    public void generalInstructions(){
        System.out.print("******General Instructions******\n");
        Auxiliary.enterPresser();
        System.out.print("Make sure to read this\n");
        Auxiliary.enterPresser();
        System.out.print("Enter 1 for YES and 0 for NO\n");
        Auxiliary.enterPresser();
        System.out.print("IF there is any corresponding number next to a choice enter the number ONLY\n");
        Auxiliary.enterPresser();
        System.out.print("Always watch out for what is asked\n");
        Auxiliary.enterPresser();
        System.out.print("That is all lad!\n");
        System.out.print("*********************************\n");
        Auxiliary.enterPresser();

    }
}


