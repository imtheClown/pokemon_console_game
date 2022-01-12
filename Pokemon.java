package pokemon_console_package;

import java.util.ArrayList;
public abstract class Pokemon implements PokemonVisitable{
    private int damage;
    private int baseExp;
    private int exp;
    private int baseHP;
    private int currentHP;
    private int defense;
    private int speed;
    private int level;
    private String name;
    private ArrayList<String> types = new ArrayList<String>();
    private ArrayList<Skill> skillSet = new ArrayList<Skill>();

    /** Returns the value stored at the field HP
     * @return an integer which serves as the base HP (full HP of the Pokemon).
     */
    int getBaseHP(){
        return baseHP;
    }

    /** Gives new value or if the field HP is empty stores new value at the field HP.
     * @param newBaseHP the new base HP to be stored at field HP.
     */
    void setBaseHP(int newBaseHP){
        baseHP = newBaseHP;
    }

    /** Returns the value stored at the field currentHP which represents the current HP of the Pokemon.
     * @return integer that represents the current Hit Points of the Pokemon.
     */
    int getCurrentHP(){
        return currentHP;
    }

    /** Stores new value at the field currentHp.
     * @param newCurrentHp represents the new value of the field currentHp.
     */
    void setCurrentHP(int newCurrentHp){
        currentHP = newCurrentHp;
    }

    /** Store new string value at the field name.
     * @param newName represents the new String value to be stored at the field name.
     */
    void setName(String newName){
        name = newName;
    }

    /** Returns the value stored at the field name.
     * @return String that stored at field name which represents the name of the object Trainer.
     */
    String getName(){
        return name;
    }

    /** Stores new value at the field types.
     * @param newtypes is an arraylist since some of the Pokemons do have dual types.
     */
    void setTypes(ArrayList<String> newtypes){
        types.addAll(newtypes);
    }

    /** Returns the value stored at the field Types.
     * @return an Arraylist that stores string value of Pokemon type/s.
     */
    ArrayList<String> getTypes(){
        return types;
    }

    /** Sets new value at the field skillSet.
     * @param newSkillSet is an Arraylist of type Skills which represents all the skills a Pokemon can use during battle.
     */
    void setSkillset(ArrayList<Skill> newSkillSet){
        if(skillSet.size() != 0){
            skillSet.clear();
        }
        skillSet.addAll(newSkillSet);
    }

    /** Returns the value stored at the field skillSet.
     * @return an arraylist of type Skills.
     */
    ArrayList<Skill> getSkillSet(){
        return skillSet;
    }

    /** Returns a specific object of type Skill.
     * @param index refers to the index of the skill to be returned.
     * @return an object of type Skill.
     */
    Skill getSkill(int index){
        return skillSet.get(index);
    }

    /** Sets new value to the field speed.
     * @param newSpeed represents the value to be stored at the field speed.
     */
    void setSpeed(int newSpeed){
        speed = newSpeed;
    }

    /** Returns the value stored at the field speed.
     * @return an integer that represents the speed of the Pokemon.
     */
    int getSpeed(){
        return speed;
    }

    /** Sets new value to the field defense.
     * @param newDefense is the new value to be stored at the field defense.
     */
    void setDefense(int newDefense){
        defense = newDefense;
    }

    /** Returns the value stored at the field defense.
     * @return integer that represents the defense stat of the Pokemon.
     */
    int getDefense(){
        return defense;
    }

    /** Stores new value at the field level.
     * @param newLevel represents the new level stat of the Pokemon.
     */
    void setLevel(int newLevel){
        level = newLevel;
    }

    /** Returns the value stored at the field level.
     * @return integer that represents the level stat of the Pokemon.
     */
    int getLevel(){
        return level;
    }

    /** Sets the new value for the field exp.
     * @param newExp represents the value of the stat exp of the Pokemon.
     */
    void setExp(int newExp){
        exp = newExp;
    }

    /** Returns the value stored at the field exp.
     * @return integer that represents the exp stat of the Pokemon.
     */
    int getExp(){
        return exp;
    }

    /** Sets new value to the field baseExp.
     * @param newExp represents the new value in which would be the maximum value the field exp would have before levelling up and reset.
     */
    void setBaseExp(int newExp){
        baseExp = newExp;
    }

    /** Returns the value stored at the field baseExp.
     * @return an integer that represents the basis for the field exp to determine level-up.
     */
    int getBaseExp(){
        return baseExp;
    }

    /** Sets new value for the field damage.
     * @param newDamage represents the new value to be stored at the field damage.
     */
    void setDamage(int newDamage){
        damage = newDamage;
    }

    /** Returns the value stored at the field damage.
     * @return an integer that represents the damage stat of the Pokemon.
     */
    int getDamage(){
        return damage;
    }

    @Override
    public Pokemon levelUp() {
        return null;
    }
}


/** a subclass of Pokemon that holds the stats of a Treeko.
 */
class Treeko extends Pokemon{
    public Treeko(int level){
        ArrayList<String> type = new ArrayList<>();
        type.add("Grass");
        setBaseHP(40 + level * 2);
        setCurrentHP(40 +level * 2);
        setDefense(35 + level);
        setSpeed(70 + level/2);
        setName("Treeko");
        setTypes(type);
        setLevel(level);
        setExp(0);
        setBaseExp(50 + level);
        setDamage(45 + level + 100);
    }

    @Override
    public Pokemon levelUp() {
        Pokemon newPokemon;
        PokemonVisitor visitor = new PokemonVisitor();
        while(this.getExp() >= this.getBaseExp()){
            System.out.print("Your " + this.getName() + " was raised to level" + (this.getLevel()+1) + "\n");
            Auxiliary.enterPresser();
            this.setBaseHP(this.getBaseHP() + 2);
            this.setCurrentHP(this.getCurrentHP()+ 2);
            this.setDefense(this.getDefense()+ 1);
            this.setSpeed(this.getSpeed()+ 1);
            this.setLevel(this.getLevel()+1);
            this.setExp(this.getExp()-this.getBaseExp());
            double baseExp = (0.8*(this.getLevel()*this.getLevel()*this.getLevel()));
            this.setBaseExp((int)baseExp);
            Skill newSkill = visitor.skillGenerator(this);
            if(newSkill != null){
                this.setSkillset(visitor.skillSetMaker(this,newSkill));
            }
        }
        newPokemon = visitor.evolve(this);
        if(newPokemon != null){
            System.out.printf("Your %s wanted to evolve to %s%n", this.getName(), newPokemon.getName() );
            Auxiliary.enterPresser();
            System.out.print("Evolve your Pokemon?\n");
            int choice = Auxiliary.choiceMaker(0);
            if(choice == 1){
                System.out.print("Congratulations!\n");
                Auxiliary.enterPresser();
                System.out.print("Your "+ this.getName() +" evolved to " + newPokemon.getName() +"!\n");
                Auxiliary.enterPresser();
                return newPokemon;
            }
            System.out.print("Your " + this.getName() + " did not evolved\n");
            Auxiliary.enterPresser();
        }
        return this;
    }
}
/** a subclass of Pokemon that holds the stats of a Grovyle.
 */
class Grovyle extends Pokemon{
    public Grovyle(int level){
        ArrayList<String> type = new ArrayList<>();
        type.add("Grass");
        setBaseHP(50);
        setCurrentHP(50);
        setDefense(45);
        setSpeed(85);
        setName("Grovyle");
        setTypes(type);
        setLevel(level);
        setExp(0);
        setBaseExp(50 + level);
        setDamage(65 + level);
        //arraylist of the class skills
    }

    @Override
    public Pokemon levelUp() {
        Pokemon newPokemon;
        PokemonVisitor visitor = new PokemonVisitor();
        while(this.getExp() >= this.getBaseExp()){
            System.out.print("Your " + this.getName() + " was raised to level" + (this.getLevel()+1) + "\n");
            Auxiliary.enterPresser();
            this.setBaseHP(this.getBaseHP() + 2);
            this.setCurrentHP(this.getCurrentHP()+ 2);
            this.setDefense(this.getDefense()+ 1);
            this.setSpeed(this.getSpeed()+ 1);
            this.setExp(this.getExp()-this.getBaseExp());
            this.setLevel(this.getLevel()+1);
            double baseExp = (0.8*(this.getLevel()*this.getLevel()*this.getLevel()));
            this.setBaseExp((int)baseExp);
            Skill newSkill = visitor.skillGenerator(this);
            if(newSkill != null){
                this.setSkillset(visitor.skillSetMaker(this,newSkill));
            }
        }
        newPokemon = visitor.evolve(this);
        if(newPokemon != null){
            System.out.printf("Your %s wanted to evolve to %s%n", this.getName(), newPokemon.getName() );
            Auxiliary.enterPresser();
            System.out.print("Evolve your Pokemon?\n");
            int choice = Auxiliary.choiceMaker(0);
            if(choice == 1){
                System.out.print("Congratulations!\n");
                Auxiliary.enterPresser();
                System.out.print("Your "+ this.getName() +" evolved to " + newPokemon.getName() +"!\n");
                Auxiliary.enterPresser();
                return newPokemon;
            }
            System.out.print("Your " + this.getName() + " did not evolved\n");
            Auxiliary.enterPresser();
        }
        return this;
    }
}
/** a subclass of Pokemon that holds the stats of a Sceptile.
 */
class Sceptile extends Pokemon{
    public Sceptile(int level){
        ArrayList<String> type = new ArrayList<>();
        type.add("Grass");
        setBaseHP(70 + level * 4);
        setCurrentHP(70 + level * 4);
        setDefense(65 + level);
        setSpeed(120 + level/2);
        setName("Grovyle");
        setTypes(type);
        setLevel(level);
        setExp(0);
        setBaseExp(50 + level);
        setDamage(85 + level);
        //arraylist of the class skills
    }

    @Override
    public Pokemon levelUp() {
        Pokemon newPokemon;
        PokemonVisitor visitor = new PokemonVisitor();
        while(this.getExp() >= this.getBaseExp()){
            System.out.print("Your " + this.getName() + " was raised to level" + (this.getLevel()+1) + "\n");
            Auxiliary.enterPresser();
            this.setBaseHP(this.getBaseHP() + 2);
            this.setCurrentHP(this.getCurrentHP()+ 2);
            this.setDefense(this.getDefense()+ 1);
            this.setSpeed(this.getSpeed()+ 1);
            this.setExp(this.getExp()-this.getBaseExp());
            this.setLevel(this.getLevel()+1);
            double baseExp = (0.8*(this.getLevel()*this.getLevel()*this.getLevel()));
            this.setBaseExp((int)baseExp);
            Skill newSkill = visitor.skillGenerator(this);
            if(newSkill != null){
                this.setSkillset(visitor.skillSetMaker(this,newSkill));
            }
        }
        return this;
    }
}
/** a subclass of Pokemon that holds the stats of a Torchic.
 */
class Torchic extends Pokemon{
    public Torchic(int level) {
        ArrayList<String> type = new ArrayList<>();
        type.add("Fire");
        setBaseHP(45 + level * 2);
        setCurrentHP(45 + level * 2);
        setDefense(40 + level);
        setSpeed(45 + level / 2);
        setName("Torchic");
        setTypes(type);
        setLevel(level);
        setExp(0);
        setBaseExp(50 + level);
        setDamage(60 + level);
    }
        @Override
        public Pokemon levelUp() {
            Pokemon newPokemon;
            PokemonVisitor visitor = new PokemonVisitor();
            while(this.getExp() >= this.getBaseExp()){
                System.out.print("Your " + this.getName() + " was raised to level " + (this.getLevel()+1) + "\n");
                Auxiliary.enterPresser();
                this.setBaseHP(this.getBaseHP() + 2);
                this.setCurrentHP(this.getCurrentHP()+ 2);
                this.setDefense(this.getDefense()+ 1);
                this.setSpeed(this.getSpeed()+ 1);
                this.setExp(this.getExp()-this.getBaseExp());
                this.setLevel(this.getLevel()+1);
                double baseExp = (0.8*(this.getLevel()*this.getLevel()*this.getLevel()));
                this.setBaseExp((int)baseExp);
                Skill newSkill = visitor.skillGenerator(this);
                if(newSkill != null){
                    this.setSkillset(visitor.skillSetMaker(this,newSkill));
                }
            }
            newPokemon = visitor.evolve(this);
            if(newPokemon != null){
                System.out.printf("Your %s wanted to evolve to %s%n", this.getName(), newPokemon.getName() );
                Auxiliary.enterPresser();
                System.out.print("Evolve your Pokemon?\n");
                int choice = Auxiliary.choiceMaker(0);
                if(choice == 1){
                    System.out.print("Congratulations!\n");
                    Auxiliary.enterPresser();
                    System.out.print("Your "+ this.getName() +" evolved to " + newPokemon.getName() +"!\n");
                    Auxiliary.enterPresser();
                    return newPokemon;
                }
                System.out.print("Your " + this.getName() + " did not evolved\n");
                Auxiliary.enterPresser();
            }
            return this;
        }
}
/** a subclass of Pokemon that holds the stats of a Combusken.
 */
class Combusken extends Pokemon{
    public Combusken(int level){
        ArrayList<String> type = new ArrayList<>();
        type.add("Fire");
        type.add("Fighting");
        setBaseHP(60 + level * 3);
        setCurrentHP(60 + level * 2);
        setDefense(60 + level);
        setSpeed(55 + level/2 );
        setName("Combusken");
        setTypes(type);
        setLevel(level);
        setExp(0);
        setBaseExp(50 + level);
        setDamage(85 + level);
        //arraylist of the class skills
    }

    @Override
    public Pokemon levelUp() {
        Pokemon newPokemon;
        PokemonVisitor visitor = new PokemonVisitor();
        while(this.getExp() >= this.getBaseExp()){
            System.out.print("Your " + this.getName() + " was raised to level " + (this.getLevel()+1) + "\n");
            Auxiliary.enterPresser();
            this.setBaseHP(this.getBaseHP() + 2);
            this.setCurrentHP(this.getCurrentHP()+ 2);
            this.setDefense(this.getDefense()+ 1);
            this.setSpeed(this.getSpeed()+ 1);
            this.setExp(this.getExp()-this.getBaseExp());
            this.setLevel(this.getLevel()+1);
            double baseExp = (0.8*(this.getLevel()*this.getLevel()*this.getLevel()));
            this.setBaseExp((int)baseExp);
            Skill newSkill = visitor.skillGenerator(this);
            if(newSkill != null){
                this.setSkillset(visitor.skillSetMaker(this,newSkill));
            }
        }
        newPokemon = visitor.evolve(this);
        if(newPokemon != null){
            System.out.printf("Your %s wanted to evolve to %s%n", this.getName(), newPokemon.getName() );
            Auxiliary.enterPresser();
            System.out.print("Evolve your Pokemon?\n");
            int choice = Auxiliary.choiceMaker(0);
            if(choice == 1){
                System.out.print("Congratulations!\n");
                Auxiliary.enterPresser();
                System.out.print("Your "+ this.getName() +" evolved to " + newPokemon.getName() +"!\n");
                Auxiliary.enterPresser();
                return newPokemon;
            }
            System.out.print("Your " + this.getName() + " did not evolved\n");
            Auxiliary.enterPresser();
        }
        return this;
    }

}
/** a subclass of Pokemon that holds the stats of a Blaziken.
 */
class Blaziken extends Pokemon{
    public Blaziken(int level){
        ArrayList<String> type = new ArrayList<>();
        type.add("Fire");
        type.add("Fighting");
        setBaseHP(80 + level * 4);
        setCurrentHP(80 + level * 4);
        setDefense(70 + level);
        setSpeed(80 + level/2);
        setName("Blaziken");
        setTypes(type);
        setLevel(level);
        setExp(0);
        setBaseExp(50 + level);
        setDamage(120 + level);
        //arraylist of the class skills
    }
    @Override
    public Pokemon levelUp() {
        PokemonVisitor visitor = new PokemonVisitor();
        while(this.getExp() >= this.getBaseExp()){
            System.out.print("Your " + this.getName() + " was raised to level " + (this.getLevel()+1) + "\n");
            Auxiliary.enterPresser();
            this.setBaseHP(this.getBaseHP() + 2);
            this.setCurrentHP(this.getCurrentHP()+ 2);
            this.setDefense(this.getDefense()+ 1);
            this.setSpeed(this.getSpeed()+ 1);
            this.setExp(this.getExp()-this.getBaseExp());
            this.setLevel(this.getLevel()+1);
            double baseExp = (0.8*(this.getLevel()*this.getLevel()*this.getLevel()));
            this.setBaseExp((int)baseExp);
            Skill newSkill = visitor.skillGenerator(this);
            if(newSkill != null){
                this.setSkillset(visitor.skillSetMaker(this,newSkill));
            }
        }
        return this;
    }
}
/** a subclass of Pokemon that holds the stats of a Mudkip.
 */
class Mudkip extends Pokemon{
    public Mudkip(int level){
        ArrayList<String> type = new ArrayList<>();
        type.add("Water");
        setBaseHP(50 + level * 2);
        setCurrentHP(50 + level * 2);
        setDefense(50 + level);
        setSpeed(40 + level/2);
        setName("Mudkip");
        setTypes(type);
        setLevel(level);
        setExp(0);
        setBaseExp(50 + level);
        setDamage(70 + level);
    }

    @Override
    public Pokemon levelUp() {
        Pokemon newPokemon;
        PokemonVisitor visitor = new PokemonVisitor();
        while(this.getExp() >= this.getBaseExp()){
            System.out.print("Your " + this.getName() + " was raised to level " + (this.getLevel()+1) + "\n");
            Auxiliary.enterPresser();
            this.setBaseHP(this.getBaseHP() + 2);
            this.setCurrentHP(this.getCurrentHP()+ 2);
            this.setDefense(this.getDefense()+ 1);
            this.setSpeed(this.getSpeed()+ 1);
            this.setExp(this.getExp()-this.getBaseExp());
            this.setLevel(this.getLevel()+1);
            double baseExp = (0.8*(this.getLevel()*this.getLevel()*this.getLevel()));
            this.setBaseExp((int)baseExp);
            Skill newSkill = visitor.skillGenerator(this);
            if(newSkill != null){
                this.setSkillset(visitor.skillSetMaker(this,newSkill));
            }
        }
        newPokemon = visitor.evolve(this);
        if(newPokemon != null){
            System.out.printf("Your %s wanted to evolve to %s%n", this.getName(), newPokemon.getName() );
            Auxiliary.enterPresser();
            System.out.print("Evolve your Pokemon?\n");
            int choice = Auxiliary.choiceMaker(0);
            if(choice == 1){
                System.out.print("Congratulations!\n");
                Auxiliary.enterPresser();
                System.out.print("Your "+ this.getName() +" evolved to " + newPokemon.getName() +"!\n");
                Auxiliary.enterPresser();
                return newPokemon;
            }
            System.out.print("Your " + this.getName() + " did not evolved\n");
            Auxiliary.enterPresser();
        }
        return this;
    }

}
/** a subclass of Pokemon that holds the stats of a Marhstomp.
 */
class Marshtomp extends Pokemon{
    public Marshtomp(int level){
        ArrayList<String> type = new ArrayList<>();
        type.add("Water");
        type.add("Ground");
        setBaseHP(70 + level * 3);
        setCurrentHP(70 + level * 3);
        setDefense(70 + level);
        setSpeed(50 + level/2);
        setName("Marshtomp");
        setTypes(type);
        setLevel(level);
        setExp(0);
        setBaseExp(50 + level);
        setDamage(85 + level);
        //arraylist of the class skills
    }

    @Override
    public Pokemon levelUp() {
        Pokemon newPokemon;
        PokemonVisitor visitor = new PokemonVisitor();
        while(this.getExp() >= this.getBaseExp()){
            System.out.print("Your " + this.getName() + " was raised to level " + (this.getLevel()+1) + "\n");
            Auxiliary.enterPresser();
            this.setBaseHP(this.getBaseHP() + 2);
            this.setCurrentHP(this.getCurrentHP()+ 2);
            this.setDefense(this.getDefense()+ 1);
            this.setSpeed(this.getSpeed()+ 1);
            this.setExp(this.getExp()-this.getBaseExp());
            this.setLevel(this.getLevel()+1);
            double baseExp = (0.8*(this.getLevel()*this.getLevel()*this.getLevel()));
            this.setBaseExp((int)baseExp);
            Skill newSkill = visitor.skillGenerator(this);
            if(newSkill != null){
                this.setSkillset(visitor.skillSetMaker(this,newSkill));
            }
        }
        newPokemon = visitor.evolve(this);
        if(newPokemon != null){
            System.out.printf("Your %s wanted to evolve to %s%n", this.getName(), newPokemon.getName() );
            Auxiliary.enterPresser();
            System.out.print("Evolve your Pokemon?\n");
            int choice = Auxiliary.choiceMaker(0);
            if(choice == 1){
                System.out.print("Congratulations!\n");
                Auxiliary.enterPresser();
                System.out.print("Your "+ this.getName() +" evolved to " + newPokemon.getName() +"!\n");
                Auxiliary.enterPresser();
                return newPokemon;
            }
            System.out.print("Your " + this.getName() + " did not evolved\n");
            Auxiliary.enterPresser();
        }
        return this;
    }
}
/** a subclass of Pokemon that holds the stats of a Swampert.
 */
class Swampert extends Pokemon{
    public Swampert(int level){
        ArrayList<String> type = new ArrayList<>();
        type.add("Water");
        type.add("Ground");
        setBaseHP(100 + level * 4);
        setCurrentHP(100 + level * 4);
        setDefense(90 + level);
        setSpeed(60 + level/2);
        setName("Swampert");
        setTypes(type);
        setLevel(level);
        setExp(0);
        setBaseExp(50 + level);
        setDamage(110 + level);
        //arraylist of the class skills
    }

    @Override
    public Pokemon levelUp() {
        Pokemon newPokemon;
        PokemonVisitor visitor = new PokemonVisitor();
        while(this.getExp() >= this.getBaseExp()){
            System.out.print("Your " + this.getName() + " was raised to level " + (this.getLevel()+1) + "\n");
            Auxiliary.enterPresser();
            this.setBaseHP(this.getBaseHP() + 2);
            this.setCurrentHP(this.getCurrentHP()+ 2);
            this.setDefense(this.getDefense()+ 1);
            this.setSpeed(this.getSpeed()+ 1);
            this.setExp(this.getExp()-this.getBaseExp());
            this.setLevel(this.getLevel()+1);
            double baseExp = (0.8*(this.getLevel()*this.getLevel()*this.getLevel()));
            this.setBaseExp((int)baseExp);
            Skill newSkill = visitor.skillGenerator(this);
            if(newSkill != null){
                this.setSkillset(visitor.skillSetMaker(this,newSkill));
            }
        }
        return this;
    }


}
/** a subclass of Pokemon that holds the stats of a Beautifly.
 */
class Beautifly extends Pokemon{
    public Beautifly(int level){
        ArrayList<String> type = new ArrayList<>();
        type.add("Bug");
        type.add("Flying");
        setBaseHP(60+ level * 2);
        setCurrentHP(60 + level * 2);
        setDefense(50 + level/2);
        setSpeed(65 + level/2);
        setName("Beautifly");
        setTypes(type);
        setLevel(level);
        setExp(0);
        setBaseExp(50 + level);
        setDamage(70 + level);
        //arraylist of the class skills
    }


    public Pokemon levelUp() {
        return this;
    }

}
/** a subclass of Pokemon that holds the stats of a Geodude.
 */
class Geodude extends Pokemon{
    public Geodude(int level){
        ArrayList<String> type = new ArrayList<>();
        type.add("Rock");
        type.add("Ground");
        setBaseHP(40+ level * 2);
        setCurrentHP(40 + level * 2);
        setDefense(100 + level/2);
        setSpeed(20 + level/2);
        setName("Geodude");
        setTypes(type);
        setLevel(level);
        setExp(0);
        setBaseExp(50 + level);
        setDamage(100 + level);
        //arraylist of the class skills
    }


    public Pokemon levelUp() {
        return this;
    }

}
/** a subclass of Pokemon that holds the stats of a Graveler.
 */
class Graveler extends Pokemon{
    public Graveler(int level){
        ArrayList<String> type = new ArrayList<>();
        type.add("Rock");
        type.add("Ground");
        setBaseHP(55+ level * 2);
        setCurrentHP(55 + level * 2);
        setDefense(115 + level/2);
        setSpeed(35 + level/2);
        setName("Graveler");
        setTypes(type);
        setLevel(level);
        setExp(0);
        setBaseExp(50 + level);
        setDamage( 95+ level);
        //arraylist of the class skills
    }

    public Pokemon levelUp() {
        return this;
    }
}
/** a subclass of Pokemon that holds the stats of a Golem.
 */
class Golem extends Pokemon{
    public Golem(int level){
        ArrayList<String> type = new ArrayList<>();
        type.add("Rock");
        type.add("Ground");
        setBaseHP(80+ level * 2);
        setCurrentHP(80 + level * 2);
        setDefense(130 + level/2);
        setSpeed(45 + level/2);
        setName("Golem");
        setTypes(type);
        setLevel(level);
        setExp(0);
        setBaseExp(50 + level);
        setDamage(120 + level);
        //arraylist of the class skills
    }

    public Pokemon levelUp() {
        return this;
    }
}
/** a subclass of Pokemon that holds the stats of a Ninjask.
 */
class Ninjask extends Pokemon{
    public Ninjask(int level){
        ArrayList<String> type = new ArrayList<>();
        type.add("Bug");
        type.add("Flying");
        setBaseHP(61+ level * 2);
        setCurrentHP(45);
        setDefense(45 + level/2);
        setSpeed(65 + level/2);
        setName("Ninjask");
        setTypes(type);
        setLevel(level);
        setExp(0);
        setBaseExp(50 + level);
        setDamage(90 + level);
        //arraylist of the class skills
    }

    public Pokemon levelUp() {
        return this;
    }
}
