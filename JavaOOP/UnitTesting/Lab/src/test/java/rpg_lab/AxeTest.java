package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static rpg_lab.Axe.DURABILITY_LOSS;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_EXPERIENCE = 100;

    private Axe axe;
    private Axe brokenAxe;
    private Dummy dummy;

    @Before
    public void setUp() {
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        brokenAxe = new Axe(AXE_ATTACK, 0);
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void testAxeLosesDurabilityAfterEachAttack() {
        axe.attack(dummy);
        assertEquals(AXE_DURABILITY - DURABILITY_LOSS, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackingWithBrokenAxeShouldThrow() {
        brokenAxe.attack(dummy);
    }

}