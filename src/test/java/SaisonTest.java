import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.diginamic.enumerations.Saison;

public class SaisonTest {

    @Test
    public void testValueOfLibelle_nominalCase() {
        assertEquals(Saison.PRINTEMPS, Saison.valueOfLibelle("Printemps"));
        assertEquals(Saison.ETE, Saison.valueOfLibelle("Eté"));
        assertEquals(Saison.AUTOMNE, Saison.valueOfLibelle("Automne"));
        assertEquals(Saison.HIVER, Saison.valueOfLibelle("Hiver"));
    }

    @Test
    public void testValueOfLibelle_invalidLibelle() {
        assertNull(Saison.valueOfLibelle("Inconnu"));
        assertNull(Saison.valueOfLibelle("été"));
    }

    @Test
    public void testValueOfLibelle_nullLibelle() {
        assertNull(Saison.valueOfLibelle(null));
    }

    @Test
    public void testValueOfLibelle_emptyLibelle() {
        assertNull(Saison.valueOfLibelle(""));
    }
}
