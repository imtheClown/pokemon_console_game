package pokemon_console_package;

/** Object representation of the Player
 */
public class Character implements Visitable{
    private String name;
    private Pokemon pokemon;
    private int money;
    private int defeateTrainers;

    /** Consctructor of the object Character
     * @param name
     */
    public Character(String name){
        this.name = name;
    }

    /** Returns the String stored at the field name
     * @return instance of String
     */
    public String getName(){
        return name;
    }

    /** Stores an object of type Pokemon at the field Pokemon
     * @param pokemon an instance of Type Pokemon
     */
    public void setPokemon(Pokemon pokemon){
        this.pokemon = pokemon;
    }

    public int getDefeateTrainers() {
        return defeateTrainers;
    }

    public void setDefeateTrainers(int defeateTrainers) {
        this.defeateTrainers = defeateTrainers;
    }

    /** Stores an int value at the field money
     * @param money primitive type of int
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /** Returns the int stored at the field money
     * @return primitive type of int
     */
    public int getMoney() {
        return money;
    }

    /** Returns the object of type Pokemon stored at the field pokemon
     * @return an instance of Pokemon
     */
    public Pokemon getPokemon() {
        return pokemon;
    }
    /** Let the object implement the battle mechanic of the game
     * @param visitor object of type Visitor that serves as the visitor of the class
     * @return an object of type Skill that serves as the attack mechanic of the trainer's Pokemon
     */
    @Override
    public Skill useSkill(Visitor visitor) {
        return visitor.getSkill(this);
    }
    /** Implementation of a method of the Interface
     * @param brendan of Brendan
     * @param character instance of Character
     * @return instance of Pokemon
     */
    @Override
    public Pokemon pokemonGenerator(Brendan brendan, Character character) {
        return null;
    }
    /** Implementation of a method of the Interface
     * @param grassLandMaster instance of GrassLandMaster
     * @return instance of Pokemon
     */

    @Override
    public Pokemon pokemonGenerator(GrassLandMaster grassLandMaster) {
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
     * @param agatha instance of agatha
     * @param character instance of Character
     * @return instance of Pokemon
     */
    @Override
    public Pokemon pokemonGenerator(Agatha agatha, Character character) {
        return null;
    }
}
