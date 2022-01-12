package pokemon_console_package;

/** Class that determines the effectivity of a Pokemon skill to a Pokemon
 * Effectivity is determined by the interaction of the skill's type and the Pokemon's type
 */
public class PokemonTypes{
    /** Returns amount of damage that is dependent on the interaction of the Dark type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int darkType(String skillType){
        if (skillType.equals("Fighting") | skillType.equals("Bug") | skillType.equals("Fairy")){
            return 2;
        }
        if(skillType.equals("Dark") | skillType.equals("Ghost")){
            return -2;
        }
        if(skillType.equals("Psychic")){
            return 0;
        }
        return 1;

    }
    /** Returns amount of damage that is dependent on the interaction of the Normal type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int normalType(String skillType){
        if (skillType.equals("Fighting")){
            return 2;
        }
        if(skillType.equals("Ghost")){
            return 0;
        }
        return 1;
    }
    /** Returns amount of damage that is dependent on the interaction of the Fighting type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int fightingType(String skillType){
        if(skillType.equals("Flying") | skillType.equals("Psychic") | skillType.equals("Fairy")){
            return  2;
        }
        if(skillType.equals("Rock") | skillType.equals("Bug")| skillType.equals("Dark")){
            return -2;
        }
        return 1;
    }
    /** Returns amount of damage that is dependent on the interaction of the Flying type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int flyingType(String skillType){
        if(skillType.equals("Rock") | skillType.equals("Ice")| skillType.equals("Electric")){
            return 2;
        }
        if (skillType.equals("Ground")){
            return 0;
        }
        return 1;
    }
    /** Returns amount of damage that is dependent on the interaction of the Poison type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int poisonType(String skillType){
        if(skillType.equals("Ground") | skillType.equals("Pyschic")){
            return 2;
        }
        if(skillType.equals("Fighting") | skillType.equals("Bug") | skillType.equals("Poison") | skillType.equals("Grass") | skillType.equals("Fairy")){
            return -2;
        }
        return 1;
    }
    /** Returns amount of damage that is dependent on the interaction of the Ground type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int groundType(String skillType){
        if(skillType.equals("Grass") | skillType.equals("Water") | skillType.equals("Ice")){
            return 2;
        }
        if(skillType.equals("Poison")| skillType.equals("Rock")){
            return  -2;
        }
        if(skillType.equals("Electric")){
            return 0;
        }
        return 1;
    }
    /** Returns amount of damage that is dependent on the interaction of the Rock type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int rockType(String skillType){
        if(skillType.equals("Steel")| skillType.equals("Water")| skillType.equals("Grass")|skillType.equals("Fighting")){
            return 2;
        }
        if(skillType.equals("Normal")| skillType.equals("Flying")| skillType.equals("Poison")| skillType.equals("Fire")){
            return -2;
        }
        return 1;
    }
    /** Returns amount of damage that is dependent on the interaction of the Bug type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int bugType(String skillType) {
        if (skillType.equals("Flying") | skillType.equals("Rock") | skillType.equals("Fire")) {
            return 2;
        }
        if (skillType.equals("Fighting") | skillType.equals("Ground") | skillType.equals("Grass")) {
            return -2;
        }
        return 1;
    }
    /** Returns amount of damage that is dependent on the interaction of the Ghost type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int ghostType(String skillType, int damageTaken){
        if(skillType.equals("Ghost")| skillType.equals("Dark")){
            return 2;
        }
        if(skillType.equals("Poison") | skillType.equals("Bug")){
            return -2;
        }
        if(skillType.equals("Normal") | skillType.equals("Fighting")){
            return 0;
        }
        return 1;
    }
    /** Returns amount of damage that is dependent on the interaction of the Steel type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @param damageTaken amount of damage the skill can induce normally.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int steelType(String skillType, int damageTaken){
        if(skillType.equals("Fighting") | skillType.equals("Ground") | skillType.equals("Fire")){
            return  2;
        }
        if(skillType.equals("Poison")){
            return 0;
        }
        if(skillType.equals("Ghost")| skillType.equals("Water") | skillType.equals("Electric") | skillType.equals("Dark")){
            return 1;
        }
        return -2;

    }
    /** Returns amount of damage that is dependent on the interaction of the Fire type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int fireType(String skillType){
        if(skillType.equals("Ground")| skillType.equals("Rock")| skillType.equals("Water")){
            return 2;
        }
        if(skillType.equals("Bug") | skillType.equals("Steel") | skillType.equals("Fire")| skillType.equals("Grass")| skillType.equals("Ice") | skillType.equals("Fairy")){
            return -2;
        }
        return 1;
    }
    /** Returns amount of damage that is dependent on the interaction of the Water type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int waterType(String skillType){
        if(skillType.equals("Electric") | skillType.equals("Grass")){
            return 2;
        }
        if(skillType.equals("Steel")| skillType.equals("Fire")| skillType.equals("Water")){
            return -2;
        }
        return 1;
    }
    /** Returns amount of damage that is dependent on the interaction of the Grass type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int grassType(String skillType){
        if(skillType.equals("Flying")| skillType.equals("Poison")| skillType.equals("Bug")| skillType.equals("Fire")| skillType.equals("Ice")){
            return 2;
        }
        if(skillType.equals("Water")| skillType.equals("Ground")| skillType.equals("Electric") | skillType.equals("Grass")){
            return -2;
        }
        return 1;
    }
    /** Returns amount of damage that is dependent on the interaction of the Electric type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int electricType(String skillType, int damageTaken){
        if(skillType.equals("Ground")){
            return 2;
        }
        if(skillType.equals("Flying") | skillType.equals("Steel")| skillType.equals("Electric")){
            return -2;
        }
        return 1;
    }
    /** Returns amount of damage that is dependent on the interaction of the Psychic type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int psychicType(String skillType, int damageTaken){
        if(skillType.equals("Bug")| skillType.equals("Ghost")|skillType.equals("Dark")){
            return 2;
        }
        if(skillType.equals("Fighting")| skillType.equals("Psychic")){
            return -2;
        }
        return 1;
    }
    /** Returns amount of damage that is dependent on the interaction of the Ice type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int iceType(String skillType){
        if(skillType.equals("Steel")| skillType.equals("Rock")| skillType.equals("Fire")){
            return 2;
        }
        if (skillType.equals("Ice")){
            return -2;
        }
        return 1;
    }
    /** Returns amount of damage that is dependent on the interaction of the Dragon type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int dragonType(String skillType){
        if(skillType.equals("Ice")| skillType.equals("Dragon")| skillType.equals("Fairy")){
            return 2;
        }
        if(skillType.equals("Fire")| skillType.equals("Electric")| skillType.equals("Water")| skillType.equals("Grass")){
            return -2;
        }
        return 1;
    }
    /** Returns amount of damage that is dependent on the interaction of the Fairy type Pokemon and Pokemon skills of all types.
     * @param skillType type of skill used by the attacking Pokemon.
     * @return integer that will be deducted from the defending Pokemons's HP.
     */
    int fairyType(String skillType){
        if(skillType.equals("Poison")| skillType.equals("Steel")){
            return 2;
        }
        if(skillType.equals("Dragon")){
            return 0;
        }
        if(skillType.equals("Fighting")| skillType.equals("Dark")| skillType.equals("Bug")){
            return -2;
        }
        return 1;
    }
}