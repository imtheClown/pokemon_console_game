package pokemon_console_package;

/**Framework of the visitable classes.
 * Pokemon Visitor class is enabled by this
 */
public interface Visitable {
    public Skill useSkill(Visitor visitor);
    public Pokemon pokemonGenerator(Brendan brendan, Character character);
    public Pokemon pokemonGenerator(Luigi luigi, Character character);
    public Pokemon pokemonGenerator(Agatha agatha, Character character);
    public Pokemon pokemonGenerator(Jerax jerax);
    public Pokemon pokemonGenerator(GrassLandMaster grassLandMaster);
}
