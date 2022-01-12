package pokemon_console_package;

/**General framework for enemy Trainers
 */
public abstract class Trainer implements Visitable {
    private Pokemon pokemon;
    private String name;

    /** Stores an instance of Pokemon at field pokemon
     * @param pokemon an instance of Pokemon
     */
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    /** Returns the instace of Pokemon stored at the field pokemon
     * @return
     */
    public Pokemon getPokemon() {
        return pokemon;
    }
    /**
     * Stores an instance of String at field name
     * @param name an instance of String
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Returns the instance of String stored at the field name
     * @return
     */
    public String getName(){
        return name;
    }
}
