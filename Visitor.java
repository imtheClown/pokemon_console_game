package pokemon_console_package;

import java.util.ArrayList;

/** Framework of the visitor class
 *
 */
public interface Visitor {
    public Skill getSkill(Pokemon pokemon);
    public Skill getSkill(Character character);
    public Skill skillGenerator(Blaziken blaziken);
    public Skill skillGenerator(Combusken combusken);
    public Skill skillGenerator(Torchic torchic);
    public Skill skillGenerator(Treeko treeko);
    public Skill skillGenerator(Grovyle grovyle);
    public Skill skillGenerator(Sceptile sceptile);
    public Skill skillGenerator(Mudkip mudkip);
    public Skill skillGenerator(Marshtomp marshtomp);
    public Skill skillGenerator(Swampert swampert);
    public Pokemon evolve(Torchic torchic);
    public Pokemon evolve(Combusken combusken);
    public Pokemon evolve(Treeko treeko);
    public Pokemon evolve(Grovyle grovyle);
    public Pokemon evolve(Mudkip mudkip);
    public Pokemon evolve(Marshtomp marshtomp);
    public ArrayList<Skill> skillSetMaker(Pokemon pokemon, Skill newSkill);

}
