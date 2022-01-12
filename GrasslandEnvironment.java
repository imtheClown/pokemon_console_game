package pokemon_console_package;

import java.util.ArrayList;

/** Class that enables the player to battle wild Pokemons
 * Offers two types: Forest and the Rocky Mountain
 */
public class GrasslandEnvironment implements Environment{
    private Character character;
    public Character getCharacter(){
        return this.character;
    }

    /** Implementation of a method in the interface
     * @param trainer an instance of Trainer
     * @param character an instance of Charcter
     * @return an instance of Character
     */
    @Override
    public Character battle(Trainer trainer, Character character) {
        return null;
    }

    /**An implementation of a battle mechanic againsta a wild Pokemon
     * @param grassLandMaster an instance of class GrassLandMaster
     * @param character an instance of Character
     * @return an instance of Character
     */
    @Override
    public Character battle(GrassLandMaster grassLandMaster, Character character) {
        this.character = character;
        grassLandMaster.setPokemon(pokemonCreator(character));
        BattleArena arena = new BattleArena();
        PokemonVisitor visitor = new PokemonVisitor();
        Pokemon yourPokemon = this.character.getPokemon();
        Pokemon enemyPokemon = grassLandMaster.getPokemon();
        System.out.printf("You were attacked by a wild %-10s Level: %-5d type: ", grassLandMaster.getPokemon().getName(),enemyPokemon.getLevel());
        for(int i = 0; i < grassLandMaster.getPokemon().getTypes().size(); i++){
            System.out.printf("%s ", grassLandMaster.getPokemon().getTypes().get(i));
        }
        System.out.print("\nYour " + yourPokemon.getName() + " level is:" + yourPokemon.getLevel() +" \n");
        System.out.print("\n");
        System.out.print("Engage(1)\nRun(2)");
        int choice = Auxiliary.choiceMaker(2);
        if (choice == 2){
            System.out.print("You ran away from the wild Pokemon\n");
            Auxiliary.enterPresser();
            System.out.print("\n");
            return this.character;

        }
        System.out.print("You engaged in a Pokemon battle\n");
        Auxiliary.enterPresser();
        System.out.print("********************\n");
        while (yourPokemon.getCurrentHP() != 0 & enemyPokemon.getCurrentHP() != 0){
            System.out.printf("Your Pokemon's HP:  %d%n", yourPokemon.getCurrentHP());
            System.out.printf("Enemy Pokemon's HP: %d%n", enemyPokemon.getCurrentHP());
            Auxiliary.enterPresser();
            Skill skill1 = this.character.useSkill(visitor);
            Skill skill2 = grassLandMaster.useSkill(visitor);
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
            System.out.print("********************\n");
        }
        if (yourPokemon.getCurrentHP() <= 0){
            System.out.print("Your Pokemon Fainted!\n");
            Auxiliary.enterPresser();
            System.out.print("You whited out!\n");
            Auxiliary.enterPresser();
            System.out.print("You lost 50 bucks while you are unconscious\n");
            Auxiliary.enterPresser();
            this.character.setMoney(this.character.getMoney()- 50);
            this.character.setPokemon(yourPokemon);
            return this.character;
        }
        if (enemyPokemon.getCurrentHP() <= 0){
            System.out.print("Wild "+ enemyPokemon.getName() +  " fainted!\n");
            Auxiliary.enterPresser();
            System.out.print("You defeated wild " + enemyPokemon.getName() + "\n");
            Auxiliary.enterPresser();
            yourPokemon.setExp(yourPokemon.getExp()+arena.expCalculator(enemyPokemon.getLevel(), yourPokemon.getLevel(),grassLandMaster));
            yourPokemon = yourPokemon.levelUp();
            this.character.setPokemon(yourPokemon);
        }
        return  this.character;

    }

    /** Tutorial battle against a wild ninjask
     * @param character an instance of class Character
     * @return an instance of class Character
     */
    public Pokemon tutorialBattle(Character character){
        BattleArena arena = new BattleArena();
        PokemonVisitor visitor = new PokemonVisitor();
        ArrayList<Skill> enemySkillSet = new ArrayList<>();
        enemySkillSet.add(new Scratch());
        Pokemon yourPokemon = character.getPokemon();
        Pokemon enemyPokemon = new Ninjask(5);
        enemyPokemon.setSkillset(enemySkillSet);

        System.out.print("You engaged in a Pokemon battle\n");
        Auxiliary.enterPresser();
        System.out.print("Enemy Pokemon type: ");
        for (int i = 0; i < enemyPokemon.getTypes().size(); i++){
            System.out.print(enemyPokemon.getTypes().get(i) + " ");
        }
        System.out.print("\n");
        Auxiliary.enterPresser();
        while (yourPokemon.getCurrentHP() != 0 & enemyPokemon.getCurrentHP() != 0){
            System.out.printf("Your Pokemon's HP:  %d%n", yourPokemon.getCurrentHP());
            System.out.printf("Enemy Pokemon's HP: %d%n", enemyPokemon.getCurrentHP());
            Skill skill1 = character.useSkill(visitor);
            Skill skill2 = visitor.getSkill(enemyPokemon);
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
        if (yourPokemon.getCurrentHP() <= 0){
            System.out.print("Your Pokemon Fainted!\n");
            Auxiliary.enterPresser();
            System.out.print("You whited out!\n");
            Auxiliary.enterPresser();
            return yourPokemon;
        }
        if (enemyPokemon.getCurrentHP() <= 0){
            System.out.print("Wild "+ enemyPokemon.getName() +  " fainted!\n");
            Auxiliary.enterPresser();
            System.out.print("You defeated wild " + enemyPokemon.getName() + "\n");
            Auxiliary.enterPresser();
            yourPokemon.setExp(arena.expCalculator(enemyPokemon.getLevel(), yourPokemon.getLevel()));
            yourPokemon = yourPokemon.levelUp();
        }
        return yourPokemon;
    }

    /**Creates pokemon for the instance of GrassLandMaster
     * Pokemon created is relative to your choice of environment; Forest or Rocky Mountain
     * @param character an instance of class Character
     * @return an instance of a sub-class of Pokemon
     */
    @Override
    public Pokemon pokemonCreator(Character character) {
        PokemonFactory factory = new PokemonFactory();
        int pokemonNumber = 0;
        int level = 1 + Auxiliary.randomizer(character.getPokemon().getLevel()+5);
        Pokemon newPokemon;
        System.out.print("Where do you want to go?\n");
        System.out.print("1.Forest\n2.Rock Mountain\n");
        int choice = Auxiliary.choiceMaker(2);
        if (choice == 1){
            System.out.print("You entered the forest\n");
            Auxiliary.enterPresser();
            pokemonNumber = Auxiliary.randomizer(2);
        }
        if (choice == 2){
            System.out.print("You entered the Rocky Mountain\n");
            Auxiliary.enterPresser();
            pokemonNumber = Auxiliary.randomizer(3);
        }
        newPokemon = factory.pokemonMaker(choice, pokemonNumber,level);
        return newPokemon;
    }
}
