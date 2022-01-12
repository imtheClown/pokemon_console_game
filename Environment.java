package pokemon_console_package;

import javax.management.BadAttributeValueExpException;
import java.net.PortUnreachableException;
import java.time.temporal.ChronoField;

/**Interface that enables the two Environment to have differenct contexts
 */
public interface Environment {
    public Character battle(Trainer trainer, Character character);
    public Character battle(GrassLandMaster grassLandMaster, Character character);
    public Pokemon pokemonCreator(Character character);



}
