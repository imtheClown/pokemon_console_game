package pokemon_console_package;

import java.util.ArrayList;

/**Visitor class
 * A one stop battle-evolution class that holds methods that are necessary for instance of Trainer, Character and Pokemon
 */
public class PokemonVisitor implements Visitor{
    /** Let the player choose what skill from his Pokemon skillsets will be used by his Pokemon during battle
     * @param character an instance of class character/main character
     * @return an instance of Skill which serves as the attacking move of the player's Pokemon
     */
    @Override
    public Skill getSkill(Character character) {
        int choice;
        ArrayList<Skill> skillSet = character.getPokemon().getSkillSet();
        Pokemon yourPokemon = character.getPokemon();
        System.out.print("What will " + character.getPokemon().getName()+ " do? \n");
        System.out.printf("%-15s %-15s%n", "index","Skill name");
        for (int i = 0; i < skillSet.size(); i++){
            System.out.printf("%-15d %-15s type: %s\n",i+1,skillSet.get(i).getName(),skillSet.get(i).getType());
        }
        choice= Auxiliary.choiceMaker(skillSet.size());
        Skill returnable = skillSet.get(choice-1);
        return returnable;
    }

    /** Returns the attacking moves of opponent's Pokemon which are randomly generated from their skillSets
     * @param pokemon an instance of class Pokemon
     * @return an instance of class Skill which serves as the attacking move of the enemy Pokemon
     */
    @Override
    public Skill getSkill(Pokemon pokemon) {
        Skill pokemonSkill = pokemon.getSkill(Auxiliary.randomizer(pokemon.getSkillSet().size()) - 1);
        return pokemonSkill;
    }

    /** Returns a skill that the object Treeko can learn
     * @param treeko an instance of Treeko
     * @return an instance of class Skill that corresponds to the level of the Pokemon Treeko
     */
    @Override
    public Skill skillGenerator(Treeko treeko) {
        switch (treeko.getLevel()){
            case 9:
                return new QuickAttack();
            case 13:
                return new MegaDrain();
            case 21:
                return new GigaDrain();
            case 29:
                return new Slam();
            case 37:
                return new EnergyBall();
        }
        return null;
    }
    /** Returns a skill that the object Grovyle can learn
     * @param grovyle an instance of Grovyle
     * @return an instance of class Skill that corresponds to the level of the Pokemon Grovyle
     */
    @Override
    public Skill skillGenerator(Grovyle grovyle) {
        switch (grovyle.getLevel()){
            case 23:
                return new LeafBlade();
            case 33:
                return new Slam();
            case 43:
                return new XScissor();
            case 58:
                return new LeafStorm();
        }
        return null;
    }
    /** Returns a skill that the object Sceptile can learn
     * @param sceptile an instance of Sceptile
     * @return an instance of class Skill that corresponds to the level of the Pokemon Sceptile
     */
    @Override
    public Skill skillGenerator(Sceptile sceptile) {
        switch (sceptile.getLevel()){
            case 39:
                return new XScissor();
            case 57:
                return new LeafStorm();
        }
        return null;
    }
    /** Returns a skill that the object Torchic can learn
     * @param torchic an instance of Torchic
     * @return an instance of class Skill that corresponds to the level of the Pokemon Torchic
     */
    @Override
    public Skill skillGenerator(Torchic torchic) {
        switch (torchic.getLevel()){
            case 14:
                return new Peck();
            case 19:
                return new FlameCharge();
            case 23:
                return new QuickAttack();
            case 37:
                return new Slash();
            case 46:
                return new FlameThrower();
        }
        return null;
    }
    /** Returns a skill that the object Combusken can learn
     * @param combusken an instance of Combusken
     * @return an instance of class Skill that corresponds to the level of the Pokemon Combusken
     */
    @Override
    public Skill skillGenerator(Combusken combusken) {
        switch (combusken.getLevel()){
            case 20:
                return new FlameCharge();
            case 23:
                return new QuickAttack();
            case 42:
                return new Slash();
            case 53:
                return new SkyUppercut();
            case 58:
                return new FlareBlitz();
        }
        return null;
    }
    /** Returns a skill that the object Blaziken can learn
     * @param blaziken an instance of Treeko
     * @return an instance of class Skill that corresponds to the level of the Pokemon Blaziken
     */
    @Override
    public Skill skillGenerator(Blaziken blaziken) {
        switch (blaziken.getLevel()){
            case 38:
                return new FlameThrower();
            case 44:
                return new Slash();
            case 50:
                return new BraveBird();
            case 57:
                return new SkyUppercut();
            case 63:
                return new FlareBlitz();
        }
        return null;
    }
    /** Returns a skill that the object Mudkip can learn
     * @param mudkip an instance of Mudkip
     * @return an instance of class Skill that corresponds to the level of the Pokemon Mudkip
     */
    @Override
    public Skill skillGenerator(Mudkip mudkip) {
        switch (mudkip.getLevel()){
            case 9:
                return new MudSlap();
            case 16:
                return new MudShot();
            case 25:
                return new RockThrow();
            case 36:
                return new TakeDown();
            case 41:
                return new HydroPump();
        }
        return null;
    }
    /** Returns a skill that the object Marshtomp can learn
     * @param marshtomp an instance of Marshtomp
     * @return an instance of class Skill that corresponds to the level of the Pokemon Marshtomp
     */
    @Override
    public Skill skillGenerator(Marshtomp marshtomp) {
        switch (marshtomp.getLevel()){
            case 22:
                return  new MudBomb();
            case 28:
                return new RockSlide();
            case 38:
                return new MuddyWater();
            case 42:
                return new TakeDown();
            case 48:
                return new EarthQuake();
        }
        return null;
    }
    /** Returns a skill that the object Swampert can learn
     * @param swampert an instance of Swampert
     * @return an instance of class Skill that corresponds to the level of the Pokemon Swampert
     */
    @Override
    public Skill skillGenerator(Swampert swampert) {
        switch (swampert.getLevel()){
            case 39:
                return new MuddyWater();
            case 44:
                return new TakeDown();
            case 51:
                return new EarthQuake();
            case 63:
                return new HammerArm();
        }
        return null;
    }

    /**Returns an instance of sub-class of class Pokemon if instance of class Mudkip has the right level
     * @param mudkip instance of Mudkip
     * @return an instance of sub-Class of Pokemon
     */
    @Override
    public Pokemon evolve(Mudkip mudkip) {
        if(mudkip.getLevel() >= 16){
            Pokemon newPokemon = new Marshtomp(mudkip.getLevel());
            newPokemon.setSkillset(mudkip.getSkillSet());
            newPokemon.setCurrentHP(mudkip.getCurrentHP());
            return newPokemon;
        }
        return null;
    }
    /**Returns an instance of sub-class of class Pokemon if instance of class Marshtomp has the right level
     * @param marshtomp instance of Marshtomp
     * @return an instance of sub-Class of Pokemon
     */
    @Override
    public Pokemon evolve(Marshtomp marshtomp) {
        if(marshtomp.getLevel() >= 36){
            Pokemon newPokemon = new Swampert(marshtomp.getLevel());
            newPokemon.setCurrentHP(marshtomp.getCurrentHP());
            newPokemon.setSkillset(marshtomp.getSkillSet());
            return newPokemon;
        }
        return null;
    }
    /**Returns an instance of sub-class of class Pokemon if instance of class Treeko has the right level
     * @param treeko instance of Treeko
     * @return an instance of sub-Class of Pokemon
     */
    @Override
    public Pokemon evolve(Treeko treeko) {
        if(treeko.getLevel() >= 16){
            Pokemon newPokemon = new Grovyle(treeko.getLevel());
            newPokemon.setSkillset(treeko.getSkillSet());
            newPokemon.setCurrentHP(treeko.getCurrentHP());
            return newPokemon;
        }
        return null;
    }
    /**Returns an instance of sub-class of class Pokemon if instance of class Grovyle has the right level
     * @param grovyle instance of Grovyle
     * @return an instance of sub-Class of Pokemon
     */
    @Override
    public Pokemon evolve(Grovyle grovyle) {
        if(grovyle.getLevel() >= 36){
            Pokemon newPokemon = new Sceptile(grovyle.getLevel());
            newPokemon.setSkillset(grovyle.getSkillSet());
            newPokemon.setCurrentHP(grovyle.getCurrentHP());
            return newPokemon;
        }
        return null;
    }
    /**Returns an instance of sub-class of class Pokemon if instance of class Torchic has the right level
     * @param torchic instance of Torchic
     * @return an instance of sub-Class of Pokemon
     */
    @Override
    public Pokemon evolve(Torchic torchic) {
        if(torchic.getLevel() >= 16){
            Pokemon newPokemon = new Combusken(torchic.getLevel());
            newPokemon.setSkillset(torchic.getSkillSet());
            newPokemon.setCurrentHP(torchic.getCurrentHP());
            return newPokemon;
        }
        return null;
    }
    /**Returns an instance of sub-class of class Pokemon if instance of class Combusken has the right level
     * @param  combusken instance of Combusken
     * @return an instance of sub-Class of Pokemon
     */
    @Override
    public Pokemon evolve(Combusken combusken) {
        if(combusken.getLevel() >= 36){
            Pokemon newPokemon = new Blaziken(combusken.getLevel());
            newPokemon.setSkillset(combusken.getSkillSet());
            newPokemon.setCurrentHP(combusken.getCurrentHP());
            return newPokemon;
        }
        return null;
    }

    /** Enables learning of new skill of the instance of Pokemon
     * If the learned skills is already 4, asks the user to delete a move to learn the newSkill
     * @param pokemon an instance of sub-class of Pokemon that will learn a new skill
     * @param newSkill instance of sub-class of Skill that the pokemon can learn at the current level
     * @return
     */
    @Override
    public ArrayList<Skill> skillSetMaker(Pokemon pokemon, Skill newSkill) {
        int choice;
        ArrayList<Skill> skillSet = new ArrayList<>();
        skillSet.addAll(pokemon.getSkillSet());
        if(skillSet.size() >= 4){
            System.out.print("Your " + pokemon.getName() + " wanted to learn "+ newSkill.getName()+ " type: " + newSkill.getType() + " damage: " + newSkill.getDamage()+  "\n");
            System.out.print("Your Pokemon has already 4 moves\n");
            System.out.print("Delete a move to learn\n" + newSkill.getName()+ "? \n");
            choice = Auxiliary.choiceMaker(0);
            if(choice == 1){
                System.out.print("What move you wanted to delete?\n");
                for(int i = 0; i < skillSet.size(); i++){
                    System.out.print((i+1) + "----------" + " " + skillSet.get(i).getName() + " (Type: " + skillSet.get(i).getType()+" )" + "damage: " + skillSet.get(i).getDamage()+  " \n" );
                }
                choice = Auxiliary.choiceMaker(skillSet.size())-1;
                System.out.print(skillSet.get(choice).getName() +" was successfully deleted\n");
                skillSet.remove(choice);
            }
            else {
                System.out.print("Your Pokemon did not learned " + newSkill.getName() + "\n");
                return skillSet;
            }
        }
        System.out.print("Your pokemon successfully learned " + newSkill.getName() + "! \n");
        skillSet.add(newSkill);
        return skillSet;
    }
}
