import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PlayerShould {

    private Player playerOne;
    private Player playerTwo;

    @BeforeEach
    void setUp() {
        playerOne = new Player();
        playerTwo = new Player();
    }

    @Test
    public void be_created() {
        assertThat(playerOne.health(), is(1000));
        assertThat(playerOne.level(), is(1));
        assertThat(playerOne.isAlive(), is(true));
    }

    @Test
    public void deal_damage_to_other_player() {
        playerOne.dealDamage(playerTwo, 2);
        assertThat(playerTwo.health(), is(998));
    }

    @Test
    public void kill_to_other_player() {
        playerOne.dealDamage(playerTwo, 900);
        playerOne.dealDamage(playerTwo, 101);
        assertThat(playerTwo.health(), is(0));
        assertThat(playerTwo.isAlive(), is(false));
    }

    @Test
    @Disabled
    public void heal_to_other_player() {
        playerOne.dealDamage(playerTwo, 100);
        playerOne.heal(playerTwo, 99);
        assertThat(playerTwo.health(), is(999));
        assertThat(playerTwo.isAlive(), is(true));
    }

    @Test
    public void not_heal_to_player_dead() {
        playerOne.dealDamage(playerTwo, 1000);
        playerOne.heal(playerTwo, 10);
        assertThat(playerTwo.health(), is(0));
        assertThat(playerTwo.isAlive(), is(false));
    }

    @Test
    @Disabled
    public void not_heal_over_1000_health() {
        playerOne.dealDamage(playerTwo, 1);
        playerOne.heal(playerTwo, 200);
        assertThat(playerTwo.health(), is(1000));
    }

    @Test
    @Disabled
    public void heal_200_points() {
        playerOne.dealDamage(playerTwo, 900);
        playerOne.heal(playerTwo, 200);
        assertThat(playerTwo.health(), is(300));
    }

    @Test
    public void not_damage_to_himself() {
        playerOne.dealDamage(playerOne, 500);
        assertThat(playerOne.health(), is(1000));
    }

    @Test
    public void heal_to_himself() {
        playerTwo.dealDamage(playerOne, 200);
        playerOne.heal(playerOne, 100);
        assertThat(playerOne.health(), is(900));
    }

    @Test
    public void increase_damage_because_has_more_level() {
        Player playerOne = new Player(6);
        playerOne.dealDamage(playerTwo, 10);
        assertThat(playerTwo.health(), is(985));
    }
}
