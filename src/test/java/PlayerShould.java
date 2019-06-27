import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PlayerShould {
    @Test
    public void be_created() {
        Player player = new Player();
        assertThat(player.healt(), is(1000));
        assertThat(player.level(), is(1));
        assertThat(player.isAlive(), is(true));
    }

    @Test
    public void deal_damage_to_other_player() {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        playerOne.dealDamage(playerTwo, 2);
        assertThat(playerTwo.healt(), is(998));
    }

    @Test
    public void kill_to_other_player() {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        playerOne.dealDamage(playerTwo, 900);
        playerOne.dealDamage(playerTwo, 101);
        assertThat(playerTwo.healt(), is(0));
        assertThat(playerTwo.isAlive(), is(false));
    }
}
