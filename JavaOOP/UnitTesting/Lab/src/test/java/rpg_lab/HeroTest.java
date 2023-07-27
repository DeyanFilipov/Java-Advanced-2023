package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {

    @Test
    public void testHeroGainsExperienceWhenTargetDies() {
        Weapon weapon = Mockito.mock(Weapon.class);
        Hero hero = new Hero("Java", weapon);
        Target target = Mockito.mock(Target.class);

        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(100);

        hero.attack(target);

        assertEquals(100, hero.getExperience());
    }

    @Test
    public void testWhenHeroKillsTargetInventoryShouldAddNewLoot() {
        Weapon weapon = Mockito.mock(Weapon.class);
        Hero hero = new Hero("Java", weapon);
        Target target = Mockito.mock(Target.class);
        when(target.isDead()).thenReturn(true);
        when(target.getLoot()).thenReturn(new Axe(37, 43));

        hero.attack(target);

        List<Weapon> inventory = hero.getInventory();
        assertEquals(1, inventory.size());
        Weapon loot = inventory.get(0);
        assertEquals(37, loot.getAttackPoints());
        assertEquals(43, loot.getDurabilityPoints());

    }
}