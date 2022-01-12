package pokemon_console_package;

import java.util.ArrayList;

/** Class that is necessary in the battle mechanic of the game
 * Calculates the damage than an attacking Pokemon can deal to it's opponent
 */
public class BattleArena {
    /**Implements the attack mechanic of the game
     * @param pokemon an instance of sub-class Pokemon
     * @param skillused an instance of a sub-class of class Skill
     * @param attackingPokemon an instance of sub-class of Pokemon
     * @return int that represents the damage dealt by the skill of the attacking pokemon to the defending Pokemon
     */
    int attack(Pokemon pokemon, Skill skillused, Pokemon attackingPokemon){
        System.out.print(attackingPokemon.getName() + " used " + skillused.getName()+  "!\n");
        Auxiliary.enterPresser();
        int damage = overAllDamageCalculator(pokemon,skillused, attackingPokemon);
        System.out.print(pokemon.getName() +" received "+ damage +" damage!\n");
        Auxiliary.enterPresser();
        return damage;
    }

    /**Calculates the effectivity of the skill used against the defending Pokemon
     * @param defendingPokemon an instance of sub-class of class Pokemon
     * @param skillUsed an instance of sub-class of class Skill
     * @return double that represents the effectivity of the skill used
     */
    double typeDamageCalculcator(Pokemon defendingPokemon, Skill skillUsed){
        ArrayList<String> typeSet = defendingPokemon.getTypes();
        PokemonTypes typChart = new PokemonTypes();
        int damage = 0;
        double accumulatedDamage = 1.0;
        String type;
        for (int i = 0; i < typeSet.size(); i++){
            type = typeSet.get(i);
            switch(type){
                case "Fire":
                    damage = typChart.fireType(skillUsed.getType());
                    break;
                case "Water":
                    damage = typChart.waterType(skillUsed.getType());
                    break;
                case "Grass":
                    damage = typChart.grassType(skillUsed.getType());
                    break;
                case "Ground":
                    damage = typChart.groundType(skillUsed.getType());
                    break;
                case "Fighting":
                    damage = typChart.fightingType(skillUsed.getType());
                    break;
                case "Rock":
                    damage = typChart.rockType(skillUsed.getType());
                    break;
                case "Flying":
                    damage = typChart.flyingType(skillUsed.getType());
                    break;
                case "Bug":
                    damage = typChart.bugType(skillUsed.getType());
                    break;
            }
            if (damage == 0){
                return 0;
            }
            if (damage == -2){
                accumulatedDamage/=2;
            }
            if (damage == 2){
                accumulatedDamage *= 2;
            }
        }
        return accumulatedDamage;
    }

    /**Calculates the damage the attacking Pokemon can deal against the defending Pokemon
     * @param defendingPokemon instance of sub-class of class Pokemon
     * @param skillUsed an instance of sub-class of class Skill
     * @param attackingPokemon an instance of sub-class of class Pokemon
     * @return int that represents the total damage the attacking Pokemon can deal using the skillUsed agaainst the defending Pokemon
     */
    int overAllDamageCalculator(Pokemon defendingPokemon, Skill skillUsed, Pokemon attackingPokemon){
        double effectivity = typeDamageCalculcator(defendingPokemon,skillUsed);
        if (effectivity == 2.0 | effectivity == 4.0){
            System.out.print("It is very effective!\n");
        }
        if (effectivity == 0.5 | effectivity == 0.25){
            System.out.print("It is not effective\n");
        }
        int damage = ((((2*attackingPokemon.getLevel())/5 + 2)*skillUsed.getDamage()*attackingPokemon.getDamage()/defendingPokemon.getDefense())/50+2);
        Double stab = 1.0;

        if (attackingPokemon.getTypes().equals(skillUsed.getType())){
            stab = 1.5;
        }
        double totalDamage = damage * stab * effectivity;
        return (int) Math.round(totalDamage);
    }

    /**Calculates the exp earned after battle by a victorious Pokemon
     * @param yourLevel level of player's Pokemon
     * @param enemyLevel level of enemy's Pokemon
     * @param grassLandMaster used for method overloading
     * @return an int that represents the EXP earned
     */
    int expCalculator(int yourLevel, int enemyLevel, GrassLandMaster grassLandMaster){
        double expGain = ((0.8*(yourLevel * yourLevel* yourLevel)* enemyLevel)/7);
        return (int) Math.round(expGain);
    }
    /**Calculates the exp earned after battle by a victorious Pokemon
     * @param yourLevel level of player's Pokemon
     * @param enemyLevel level of enemy's Pokemon
     * @return an int that represents the EXP earned
     */
    int expCalculator(int yourLevel, int enemyLevel) {
        double expGain = ((1.5 * (0.8 * (yourLevel * yourLevel * yourLevel) * enemyLevel)) / 7);
        return (int) Math.round(expGain);
    }
}
