package pokemon_console_package;

public class GrassLandMaster extends Trainer{
    /** Let the object implement the battle mechanic of the game
     * @param visitor object of type Visitor that serves as the visitor of the class
     * @return an object of type Skill that serves as the attack mechanic of the tranier's Pokemon
     */
    @Override
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
    /** Implementation of a method of the Interface
     * @param luigi instance of Luigi
     * @param character instance of Character
     * @return instance of Pokemon
     */
    @Override
    public Pokemon pokemonGenerator(Luigi luigi, Character character) {
        return null;
    }
    /** Implementation of a method of the Interface
     * @param jerax instance of Jerax
     * @return instance of Pokemon
     */
    @Override
    public Pokemon pokemonGenerator(Jerax jerax) {
        return null;
    }

    /** Dynamically generates pokemon for the object of type Agatha that is based on the Pokemon of the parameter character
     * @param grassLandMaster an instance of GrassLandMaster
     * @return instance of Pokemon unique to Agatha
     */

    @Override
    public Pokemon pokemonGenerator(GrassLandMaster grassLandMaster) {
        return null;
    }

}
