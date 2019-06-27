import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.Is.is;

public class PlayerShould {
    @Test
    public void be_created() {
        Player player = new Player();
        assertThat(player.health(), is(1000));
        assertThat(player.level(), is(1));
        assertThat(player.isAlive(), is(true));
    }

    @Test
    public void deal_damage_to_other_player() {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        playerOne.dealDamage(playerTwo, 2);
        assertThat(playerTwo.health(), is(998));
    }

    @Test
    public void kill_to_other_player() {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        playerOne.dealDamage(playerTwo, 900);
        playerOne.dealDamage(playerTwo, 101);
        assertThat(playerTwo.health(), is(0));
        assertThat(playerTwo.isAlive(), is(false));
    }

    @Test
    public void heal_to_other_player() {
        Player player = new Player();
        Player playerTwo = new Player();
        player.dealDamage(playerTwo, 100);
        player.heal(playerTwo, 99);
        assertThat(playerTwo.health(), is(999));
        assertThat(playerTwo.isAlive(), is(true));
    }

    @Test
    public void not_heal_to_player_dead() {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        playerOne.dealDamage(playerTwo, 1000);
        playerOne.heal(playerTwo, 10);
        assertThat(playerTwo.health(), is(0));
        assertThat(playerTwo.isAlive(), is(false));
    }

    @Test
    public void not_heal_over_1000_health() {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        playerOne.dealDamage(playerTwo, 1);
        playerOne.heal(playerTwo, 200);
        assertThat(playerTwo.health(), is(1000));
    }

    @Test
    public void heal_200_points() {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        playerOne.dealDamage(playerTwo, 900);
        playerOne.heal(playerTwo, 200);
        assertThat(playerTwo.health(), is(300));
    }


}
