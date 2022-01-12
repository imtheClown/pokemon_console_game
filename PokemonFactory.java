package pokemon_console_package;

import java.util.ArrayList;

/**Factory Class
 * Enables dynamic creation of Pokemons relative to the player's pokemon and in the case of wild Pokemon, chances
 */
public class PokemonFactory {
    /** Creates an instance of a sub-class of class Pokemon
     * Creates pokemon for the player
     * Creates pokemon for the class GrassLandMaster
     * @param choice int that determines if it is player's Pokemon the method is creating or it is of GrassLandMaster
     * @param pokemon int that refers to what Pokemon the method is going to create
     * @param pokemonLevel int that refers to the level of instance of sub-class of class Pokemon
     * @return an instance of sub-class of class Pokemon
     */
    public Pokemon pokemonMaker(int choice, int pokemon, int pokemonLevel){
        ArrayList<Skill> skillSet = new ArrayList<>();
        Pokemon returnablePokemon;
        if(choice == 0){
            if(pokemon == 1){
                skillSet.add(new Pound());
                skillSet.add(new RazorLeaf());
                returnablePokemon = new Treeko(5);
                returnablePokemon.setSkillset(skillSet);
                return returnablePokemon;
            }
            if(pokemon == 2){
                skillSet.add(new Scratch());
                skillSet.add(new Ember());
                returnablePokemon = new Torchic(5);
                returnablePokemon.setSkillset(skillSet);
                return returnablePokemon;

            }
            if (pokemon == 3){
                skillSet.add(new Tackle());
                skillSet.add(new WaterGun());
                returnablePokemon = new Mudkip(5);
                returnablePokemon.setSkillset(skillSet);
                return  returnablePokemon;
            }
        }
        Pokemon newPokemon;
        ArrayList<Skill> newSkillSet = new ArrayList<>();
        if(choice == 1){
            if(pokemon == 1){
                newPokemon = new Beautifly(pokemonLevel);
                newSkillSet.add(new MegaDrain());
                newSkillSet.add(new GigaDrain());
                newPokemon.setSkillset(newSkillSet);
                return newPokemon;
            }
            if(pokemon == 2){
                newPokemon = new Ninjask(pokemonLevel);
                newSkillSet.add(new FuryCutter());
                newSkillSet.add(new Tackle());
                newPokemon.setSkillset(newSkillSet);
                return newPokemon;

            }
        }
        if (choice == 2){
            if(pokemon == 1 ){
                newPokemon = new Geodude(pokemonLevel);
                newSkillSet.add(new RockSlide());
                newSkillSet.add(new MudShot());
                newSkillSet.add(new Tackle());
                newPokemon.setSkillset(newSkillSet);
                return newPokemon;
            }
            if(pokemon == 2){
                newPokemon = new Graveler(pokemonLevel);
                newSkillSet.add(new RockSlide());
                newSkillSet.add(new EarthQuake());
                newSkillSet.add(new Slam());
                newPokemon.setSkillset(newSkillSet);
                return newPokemon;
            }
            if(pokemon == 3){
                newPokemon = new Golem(pokemonLevel);
                newSkillSet.add(new RockThrow());
                newSkillSet.add(new EarthQuake());
                newSkillSet.add(new Tackle());
                newSkillSet.add(new Slam());
                newPokemon.setSkillset(newSkillSet);
                return newPokemon;
            }
        }
        return null;
    }

    /** Generates a Pokemon for instance of Brendan relative to the player's Pokemon
     * @param character instance of class Character
     * @param brendan instance of class Brendan
     * @return an instance of sub-class of class Pokemon
     */
    public Pokemon pokemonMaker(Character character, Brendan brendan){
        ArrayList<String> myList = character.getPokemon().getTypes();
        String type = "";
        Pokemon pokemon = new Treeko(1);
        for(int i = 0; i < myList.size(); i++ ){
            if(myList.get(i).equals("Fire")){
                type = "Fire";
            }
            if(myList.get(i).equals("Water")){
                type = "Water";
            }
            if(myList.get(i).equals("Grass")){
                type = "Grass";
            }
        }
        ArrayList<Skill> skillSet = new ArrayList<>();
        if (type.equals("Grass")){
            pokemon = new Mudkip(10);
            skillSet.add(new Pound());
            skillSet.add(new WaterGun());
            pokemon.setSkillset(skillSet);
        }
        if(type.equals("Water")){
            pokemon = new Torchic(10);
            skillSet.add(new Scratch());
            skillSet.add(new Ember());
            pokemon.setSkillset(skillSet);
        }
        if(type.equals("Fire")){
            pokemon = new Treeko(10);
            skillSet.add(new Tackle());
            skillSet.add(new RazorLeaf());
            pokemon.setSkillset(skillSet);
        }
        return pokemon;
    }
    /** Generates a Pokemon for instance of Luigi relative to the player's Pokemon
     * @param character instance of class Character
     * @param luigi instance of class Luigi
     * @return an instance of sub-class of class Pokemon
     */
    public Pokemon pokemonMaker(Character character, Luigi luigi){
        ArrayList<String> myList = character.getPokemon().getTypes();
        String type = "";
        Pokemon pokemon = new Treeko(1);
        for(int i = 0; i < myList.size(); i++ ){
            if(myList.get(i).equals("Fire")){
                type = "Fire";
            }
            if(myList.get(i).equals("Water")){
                type = "Water";
            }
            if(myList.get(i).equals("Grass")){
                type = "Grass";
            }
        }
        ArrayList<Skill> skillSet = new ArrayList<>();
        if (type.equals("Grass")){
            pokemon = new Combusken(20);
            skillSet.add(new Scratch());
            skillSet.add(new Ember());
            skillSet.add(new FlameCharge());
            pokemon.setSkillset(skillSet);
        }
        if(type.equals("Water")){
            pokemon = new Grovyle(20);
            skillSet.add(new Tackle());
            skillSet.add(new RazorLeaf());
            skillSet.add(new MegaDrain());
            pokemon.setSkillset(skillSet);
        }
        if(type.equals("Fire")){
            pokemon = new Marshtomp(20);
            skillSet.add(new Pound());
            skillSet.add(new WaterGun());
            skillSet.add(new MudBomb());
            pokemon.setSkillset(skillSet);
        }
        return pokemon;
    }
    /** Generates a Pokemon for instance of Agatha relative to the player's Pokemon
     * @param character instance of class Character
     * @param agatha instance of class Agatha
     * @return an instance of sub-class of class Pokemon
     */
    public Pokemon pokemonMaker(Character character, Agatha agatha){
        ArrayList<String> myList = character.getPokemon().getTypes();
        String type = "";
        Pokemon pokemon = new Treeko(1);
        for(int i = 0; i < myList.size(); i++ ){
            if(myList.get(i).equals("Fire")){
                type = "Fire";
            }
            if(myList.get(i).equals("Water")){
                type = "Water";
            }
            if(myList.get(i).equals("Grass")){
                type = "Grass";
            }
        }
        ArrayList<Skill> skillSet = new ArrayList<>();
        if (type.equals("Grass")){
            pokemon = new Grovyle(30);
            skillSet.add(new Tackle());
            skillSet.add(new MegaDrain());
            skillSet.add(new GigaDrain());
            skillSet.add(new RazorLeaf());
            pokemon.setSkillset(skillSet);
        }
        if(type.equals("Water")){
            pokemon = new Marshtomp(30);
            skillSet.add(new Pound() );
            skillSet.add(new MudShot());
            skillSet.add(new WaterGun());
            skillSet.add(new RockThrow());
            pokemon.setSkillset(skillSet);
        }
        if(type.equals("Fire")){
            pokemon = new Combusken(30);
            skillSet.add(new Scratch());
            skillSet.add(new FlameCharge());
            skillSet.add(new SkyUppercut());
            skillSet.add(new Ember());
            pokemon.setSkillset(skillSet);
        }
        return pokemon;
    }
    /** Generates a Pokemon for instance of Jerax
     * @param jerax instance of class Jerax
     * @return an instance of sub-class of class Pokemon
     */
    public Pokemon pokemonMaker(Jerax jerax){
        Pokemon pokemon = new Golem(40);
        ArrayList<Skill> skillSet = new ArrayList<>();
        skillSet.add(new EarthQuake());
        skillSet.add(new RockSlide());
        skillSet.add(new Slash());
        skillSet.add(new Slam());
        pokemon.setSkillset(skillSet);
        return pokemon;
    }
}
