package pokemon_console_package;

/** General framework of the class skills that holds every stat specific sub-class needs.
 */
public class Skill{
    private int damage;
    private String name;
    private String type;

    /** Sets the damage of the skill.
     * @param newDamage the value of damage a specific skill can deal.
     */
    void setDamage(int newDamage){
        damage = newDamage;
    }

    /** Returns the value stored at the field damage.
     * @return returns an integer that represents the damage a skill can deal.
     */
    int getDamage(){
        return damage;
    }

    /** Sets the value of the field name.
     * @param newname new String value to be stored at the field name that will be used as the name of the skill.
     */
    void setName(String newname){
        name = newname;
    }

    /** Returns the String value at the field name.
     * @return a String that serves as the name of the skill.
     */
    String getName(){
        return name;
    }

    /** Sets a new String value at the field type.
     * @param newType new String value to be stored at the field type that represents the Type of the skill.
     */
    void setType(String newType){
        type = newType;
    }

    /** Returns the String value stored at the field type.
     * @return a String value at the field type that represents the type of the skill.
     */
    String getType(){
        return type;
    }
}

/** An object representation of the skill Pound.
 */
class Pound extends Skill{
    public Pound(){
        setDamage(40);
        setName("Pound");
        setType("Normal");
    }
}
/** An object representation of the skill QuickAttack.
 */
class QuickAttack extends Skill{
    public QuickAttack(){
        setDamage(40);
        setName("QuickAttack");
        setType("Normal");
    }
}
/** An object representation of the skill MegaDrain.
 */
class MegaDrain extends Skill{
    public MegaDrain(){
        setDamage(40);
        setName("MegaDrain");
        setType("Grass");
    }
}
/** An object representation of the skill Pursuit.
 */
class Pursuit extends Skill{
    public Pursuit() {
        setDamage(40);
        setName("Pursuit");
        setType("Grass");
    }
}
/** An object representation of the skill GigaDrain.
 */
class GigaDrain extends Skill{
    public GigaDrain(){
        setDamage(75);
        setName("GigaDrain");
        setType("Grass");
    }
}
/** An object representation of the skill Slam.
 */
class Slam extends Skill{
    public Slam(){
        setDamage(40);
        setName("Slam");
        setType("Normal");
    }
}
/** An object representation of the skill EnergyBall.
 */
class EnergyBall extends Skill{
    public EnergyBall(){
        setDamage(90);
        setName("Energyball");
        setType("Grass");
    }
}
/** An object representation of the skill LeafBlade.
 */
class LeafBlade extends Skill{
    public LeafBlade(){
        setDamage(90);
        setName("LeafBlade");
        setType("Grass");
    }
}
/** An object representation of the skill XScissor.
 */
class XScissor extends Skill{
    public XScissor(){
        setDamage(80);
        setName("XScissor");
        setType("Bug");
    }
}
/** An object representation of the skill LeafStorm.
 */
class LeafStorm extends Skill{
    public LeafStorm(){
        setDamage(130);
        setName("Absorb");
        setType("Grass");
    }
}
/** An object representation of the skill Scratch.
 */
class Scratch extends Skill{
    public Scratch(){
        setDamage(40);
        setName("Scratch");
        setType("Normal");
    }
}
/** An object representation of the skill Ember.
 */
class Ember extends Skill{
    public Ember(){
        setDamage(40);
        setName("Ember");
        setType("Fire");
    }
}
/** An object representation of the skill Peck.
 */
class Peck extends Skill{
    public Peck(){
        setDamage(35);
        setName("Peck");
        setType("Flying");
    }
}
/** An object representation of the skill Slash.
 */
class Slash extends Skill{
    public Slash(){
        setDamage(40);
        setName("Slash");
        setType("Normal");
    }
}
/** An object representation of the skill FlameThrower.
 */
class FlameThrower extends Skill{
    public FlameThrower(){
        setDamage(90);
        setName("FlameThrower");
        setType("Fire");
    }
}
/** An object representation of the skill FlameCharge.
 */
class FlameCharge extends Skill{
    public FlameCharge(){
        setDamage(50);
        setName("FlameCharge");
        setType("Fire");
    }
}
/** An object representation of the skill SkyUppercut.
 */
class SkyUppercut extends Skill{
    public SkyUppercut(){
        setDamage(85);
        setName("SkyUppercut");
        setType("Fighting");
    }
}
/** An object representation of the skill FlareBlitz.
 */
class FlareBlitz extends Skill{
    public FlareBlitz(){
        setDamage(120);
        setName("FlareBlitz");
        setType("Fire");
    }
}
/** An object representation of the skill Tackle.
 */
class Tackle extends Skill{
    public Tackle(){
        setDamage(40);
        setName("Tackle");
        setType("Normal");
    }
}
/** An object representation of the skill WaterGun.
 */
class WaterGun extends Skill{
    public WaterGun(){
        setDamage(40);
        setName("WaterGun");
        setType("Water");
    }
}
/** An object representation of the skill Mud slap.
 */
class MudSlap extends Skill{
    public MudSlap(){
        setDamage(20);
        setName("MudSlap");
        setType("Ground");
    }
}
/** An object representation of the skill Rock throw.
 */
class RockThrow extends Skill{
    public RockThrow(){
        setDamage(50);
        setName("RockThrow");
        setType("Rock");
    }
}
/** An object representation of the skill Take down.
 */
class TakeDown extends Skill{
    public TakeDown(){
        setDamage(40);
        setName("TakeDown");
        setType("Normal");
    }
}
/** An object representation of the Hydro Pump.
 */
class HydroPump extends Skill{
    public HydroPump(){
        setDamage(110);
        setName("HydroPump");
        setType("Water");
    }
}
/** An object representation of the skill Mud shot.
 */
class MudShot extends Skill{
    public MudShot(){
        setDamage(55);
        setName("MudShot");
        setType("Ground");
    }
}
/** An object representation of the Mud bomb.
 */
class MudBomb extends Skill{
    public MudBomb(){
        setDamage(65);
        setName("MudBomb");
        setType("Ground");
    }
}
/** An object representation of the Muddy water.
 */
class MuddyWater extends Skill{
    public MuddyWater(){
        setDamage(90);
        setName("MuddyWater");
        setType("Water");
    }
}
/** An object representation of the skill Earthquake.
 */
class EarthQuake extends Skill{
    public EarthQuake(){
        setDamage(120);
        setName("EarthQuake");
        setType("Ground");
    }
}
/** An object representation of the skill Bite.
 */
class Bite extends Skill{
    public Bite(){
        setDamage(40);
        setName("Bite");
        setType("Dark");
    }
}
/** An object representation of the skill Crunch.
 */
class Crunch extends Skill{
    public Crunch(){
        setDamage(40);
        setName("Crunch");
        setType("Dark");
    }
}
/** An object representation of the skill Play rough.
 */
class PlayRough extends Skill{
    public PlayRough(){
        setDamage(50);
        setName("PlayRough");
        setType("Fairy");
    }
}
/** An object representation of the skill Headbutt.
 */
class HeadButt extends Skill{
    public HeadButt(){
        setDamage(35);
        setName("HeadButt");
        setType("Normal");
    }
}
/** An object representation of the skill Razor leaf.
 */
class RazorLeaf extends Skill{
    public RazorLeaf(){
        setDamage(55);
        setName("RazorLeaf");
        setType("Grass");
    }
}
/** An object representation of the skill BraveBird.
 */
class BraveBird extends Skill{
    public BraveBird(){
        setDamage(120);
        setName("BraveBird");
        setType("Flying");
    }
}
/** An object representation of the skill RockSlide.
 */
class RockSlide extends Skill{
    public RockSlide(){
        setDamage(75);
        setName("RockSlide");
        setType("Rock");
    }
}
/** An object representation of the skill HammerArm.
 */
class HammerArm extends Skill{
    public HammerArm(){
        setDamage(100);
        setName("HammerArm");
        setType("Fighting");
    }
}
/** An object representation of the skill FuryCutter.
 */
class FuryCutter extends Skill{
    public FuryCutter(){
        setDamage(40);
        setName("FuryCutter");
        setType("Bug");
    }
}
