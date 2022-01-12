package pokemon_console_package;

import java.util.ArrayList;

/** A Facade that enables battle with your classmates
 * Dynamically creates Pokemon of your opponents based on your Pokemon
 * Dynamically determines who among your classmates you are going to battle
 */
public class ClassRoomEnvironment implements Environment{
    Character character;
    int trainerLeft;
    public ClassRoomEnvironment(int numbers, Character character){
        this.trainerLeft = numbers;
        this.character = character;
    }

    /**Enables the battle mechanic between the player and his classmates
     * @param trainer an instance of class Trainer
     * @param character an instance of class Character
     * @return an instance of class Character
     */
    @Override
    public Character battle(Trainer trainer, Character character) {
        PokemonVisitor visitor = new PokemonVisitor();
        BattleArena arena = new BattleArena();
        trainer.setPokemon(pokemonCreator(character));
        Pokemon yourPokemon = this.character.getPokemon();
        Pokemon enemyPokemon = trainer.getPokemon();
        System.out.print("Classmate you can challenge: " + trainer.getName() + "\n");
        Auxiliary.enterPresser();
        System.out.printf("Pokemon: %-15sLevel: %-15d%nType: ", enemyPokemon.getName(), enemyPokemon.getLevel());
        ArrayList<String> types = enemyPokemon.getTypes();
        for (int i = 0; i < types.size(); i++){
            System.out.print(types.get(i) + " ");
        }
        System.out.print("\nYour " + yourPokemon.getName() + " level is:" + yourPokemon.getLevel() +" \n");
        System.out.print("Challenge?\n");
        int choice = Auxiliary.choiceMaker(0);
        if (choice == 0){
            return this.character;
        }
        System.out.print("You challenged trainer "+ trainer.getName() +" \n");
        System.out.print("********************\n");
        while (yourPokemon.getCurrentHP() != 0 & enemyPokemon.getCurrentHP() != 0){
            System.out.printf("Your Pokemon's HP:  %d%n", yourPokemon.getCurrentHP());
            System.out.printf("Enemy Pokemon's HP: %d%n", enemyPokemon.getCurrentHP());
            Skill skill1 = this.character.useSkill(visitor);
            Skill skill2 = trainer.useSkill(visitor);
            if (yourPokemon.getSpeed() > enemyPokemon.getSpeed()){
                enemyPokemon.setCurrentHP(enemyPokemon.getCurrentHP() - arena.attack(enemyPokemon,skill1,yourPokemon));
                if (enemyPokemon.getCurrentHP() <= 0){
                    break;
                }
                yourPokemon.setCurrentHP(yourPokemon.getCurrentHP()- arena.attack(yourPokemon, skill2, enemyPokemon));
                if (yourPokemon.getCurrentHP() <= 0){
                    break;
                }
            }
            else {
                yourPokemon.setCurrentHP(yourPokemon.getCurrentHP()- arena.attack(yourPokemon, skill2, enemyPokemon));
                if (yourPokemon.getCurrentHP() <= 0) {
                    break;
                }
                enemyPokemon.setCurrentHP(enemyPokemon.getCurrentHP() - arena.attack(enemyPokemon,skill1,yourPokemon));
                if (enemyPokemon.getCurrentHP() <= 0) {
                    break;
                }
            }
        }
        System.out.print("********************\n");
        if (yourPokemon.getCurrentHP() <= 0){
            System.out.print("Your Pokemon Fainted!\n");
            System.out.print("You whited out!\n");
            System.out.print("You lost 100 bucks to Trainer! " + trainer.getName() + "\n");
            this.character.setMoney(this.character.getMoney()- 50);
            yourPokemon.setCurrentHP(0);
            this.character.setPokemon(yourPokemon);
            return this.character;
        }
        if (enemyPokemon.getCurrentHP() <= 0){
            System.out.print("Enemy "+ enemyPokemon.getName() +  " fainted!\n");
            yourPokemon.setExp(arena.expCalculator(enemyPokemon.getLevel(), yourPokemon.getLevel())+ yourPokemon.getExp());
            yourPokemon = yourPokemon.levelUp();
            System.out.print("You defeated trainer " +trainer.getName() + "!\n");
            System.out.print("You earned 100 bucks!\n");
            this.character.setMoney(this.character.getMoney()+ 100);
            this.character.setPokemon(yourPokemon);
            this.character.setDefeateTrainers(this.character.getDefeateTrainers() - 1);
        }
        return this.character;
    }

    /**An implementation of the method at the interface
     * @param grassLandMaster an instance of class GrassLandmaster
     * @param character an instance of class Character
     * @return an instance of class Character
     */
    @Override
    public Character battle(GrassLandMaster grassLandMaster, Character character) {
        return null;
    }

    /**Enables the creation of an instance of a sub-class of class Pokemon by calling the visitor on the instance of sub-class of Trainer
     * @param character
     * @return
     */
    @Override
    public Pokemon pokemonCreator(Character character) {
        Pokemon newPokemon = null;
        switch (this.trainerLeft){
            case  1:
                Jerax jerax = new Jerax();
                newPokemon = jerax.pokemonGenerator(jerax);
                return newPokemon;
            case 2:
                Agatha agatha = new Agatha();
                newPokemon = agatha.pokemonGenerator(agatha,character);
                return newPokemon;
            case 3:
                Luigi luigi = new Luigi();
                newPokemon = luigi.pokemonGenerator(luigi,character);
                return newPokemon;
            case 4:
                Brendan brendan = new Brendan();
                newPokemon = brendan.pokemonGenerator(brendan,character);
                return newPokemon;
        }
        return newPokemon;
    }

    /**Returns a sub-class of class Trainer
     * Determines the trainer that you can battle next if you wanted to battle at the classroom
     * @return an instnace of sub-class of Trainer
     */
    public Trainer whosNext(){
        switch (this.trainerLeft){
            case 1:
                return new Jerax();
            case 2:
                return new Agatha();
            case 3:
                return new Luigi();
            case 4:
                return new Brendan();
        }
        return null;
    }
}
