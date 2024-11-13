import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.diginamic.utils.StringUtils;

public class StringUtilsTest {

    @Test
    public void testLevenshteinDistance_nominalCases() {
        assertEquals(1, StringUtils.levenshteinDistance("chat", "chats"));
        assertEquals(1, StringUtils.levenshteinDistance("machins", "machine"));
        assertEquals(1, StringUtils.levenshteinDistance("aviron", "avion"));
        assertEquals(2, StringUtils.levenshteinDistance("distance", "instance"));
        assertEquals(2, StringUtils.levenshteinDistance("Chien", "Chine"));
    }

    @Test
    public void testLevenshteinDistance_emptyStrings() {
        assertEquals(4, StringUtils.levenshteinDistance("", "test"));
        assertEquals(4, StringUtils.levenshteinDistance("test", ""));
        assertEquals(0, StringUtils.levenshteinDistance("", ""));
    }

    @Test
    public void testLevenshteinDistance_nullStrings() {
        assertEquals(0, StringUtils.levenshteinDistance(null, null));
        assertEquals(4, StringUtils.levenshteinDistance(null, "test"));
        assertEquals(4, StringUtils.levenshteinDistance("test", null));
    }

    @Test
    public void testLevenshteinDistance_caseSensitivity() {
        assertEquals(1, StringUtils.levenshteinDistance("java", "Java"));
    }

    @Test
    public void testLevenshteinDistance_identicalStrings() {
        assertEquals(0, StringUtils.levenshteinDistance("identique", "identique"));
    }
}
