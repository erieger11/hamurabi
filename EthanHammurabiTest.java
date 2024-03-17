package hammurabi;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class EthanHammurabiTest {

    @Test
    public void testStarvedToDeath_NoStarvation() {
        EthansHammurabi.totalCitizens = 100;
        EthansHammurabi.userBushelInput = 2000; // Enough food for all citizens
        EthansHammurabi.starvedToDeath();
        assertEquals(0, EthansHammurabi.peopleThatHaveStarvedToDeath);
    }

    @Test
    public void testStarvedToDeath_SomeStarvation() {
        EthansHammurabi.totalCitizens = 100;
        EthansHammurabi.userBushelInput = 1000; // Not enough food for all citizens
        EthansHammurabi.starvedToDeath();
        assertTrue(EthansHammurabi.peopleThatHaveStarvedToDeath > 0);
    }

    @Test
    public void testRatsConsumption_NoRats() {
        EthansHammurabi.bushels = 1000;
        EthansHammurabi.ratsConsumption();
        assertEquals(0, EthansHammurabi.ratsTotalConsumption);
    }

    @Test
    public void testRatsConsumption_RatsAttack() {
        EthansHammurabi.bushels = 1000;
        EthansHammurabi.ratsConsumption();
        assertTrue(EthansHammurabi.ratsTotalConsumption > 0);
    }

    @Test
    public void testDisease_NoDisease() {
        EthansHammurabi.totalCitizens = 100;
        EthansHammurabi.disease();
        assertEquals(0, EthansHammurabi.peopleDiedFromDisease);
    }

    @Test
    public void testDisease_DiseaseStrikes() {
        EthansHammurabi.totalCitizens = 100;
        EthansHammurabi.disease();
        assertTrue(EthansHammurabi.peopleDiedFromDisease > 0);
    }

    @Test
    public void testUprising_NoUprising() {
        EthansHammurabi.totalCitizens = 100;
        EthansHammurabi.peopleThatHaveStarvedToDeath = 20; // Below uprising threshold
        EthansHammurabi.uprising();
        assertFalse(EthansHammurabi.youHaveBeenExiled);
    }

    @Test
    public void testUprising_UprisingOccurs() {
        EthansHammurabi.totalCitizens = 100;
        EthansHammurabi.peopleThatHaveStarvedToDeath = 50; // Above uprising threshold
        EthansHammurabi.uprising();
        assertTrue(EthansHammurabi.youHaveBeenExiled);
    }
}
