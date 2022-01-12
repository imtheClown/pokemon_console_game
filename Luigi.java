package pokemon_console_package;

import java.util.ArrayList;
/** Object representation of your classmate Luigi
 */
public class Luigi extends Trainer{

    public Luigi(){
        setName("Luigi");
    }
    @Override
    /** Let the object implement the battle mechanic of the game
     * @param visitor object of type Visitor that serves as the visitor of the class
     * @return an object of type Skill that serves as the attack mechanic of the trainer's Pokemon
     */
    public Skill useSkill(Visitor visitor) {
        return visitor.getSkill(super.getPokemon());
    }
    /** Returns the object of type Pokemon stored at the parent class' field Pokemon
     * @return an Object of type Pokemon unique to the object of Type Trainer
     */
    public Pokemon getPokemon() {
        return super.getPokemon();
    }
    /** Implementation of a method of the Interface
     * @param agatha instance of Agatha
     * @param character instance of Character
     * @return instance of Pokemon
     */
    @Override
    public Pokemon pokemonGenerator(Agatha agatha, Character character) {
        return null;
    }
    /** Implementation of a method of the Interface
     * @param brendan instance of Brendan
     * @param character instance of Character
     * @return instance of Pokemon
     */
    @Override
    public Pokemon pokemonGenerator(Brendan brendan, Character character) {
        return null;
    }

    /** Dynamically generates pokemon for the object of type Brendan that is based on the Pokemon of the parameter character
     * @param luigi instance of Luigi
     * @param character instance of Character
     * @return instance of Pokemon unique to Luigi
     */
    @Override
    public Pokemon pokemonGenerator(Luigi luigi, Character character) {
        PokemonFactory factory = new PokemonFactory();
        return factory.pokemonMaker(character, this);
    }

    /** Implementation of a method of the Interface
     * @param jerax instance of Jerax
     * @return instance of Pokemon
     */
    @Override
    public Pokemon pokemonGenerator(Jerax jerax) {
        return null;
    }
    /** Implementation of a method of the Interface
     * @param grassLandMaster instance of GrassLandmaster
     * @return instance of Pokemon
     */
    @Override
    public Pokemon pokemonGenerator(GrassLandMaster grassLandMaster) {
        return null;
    }
}
