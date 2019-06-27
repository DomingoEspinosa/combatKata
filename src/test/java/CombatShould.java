import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CombatShould {
    @Test
    public void initializeAPlayer() {
        Player player = new Player();
        assertThat(player.healt(), is(1000));
        assertThat(player.level(), is(1));
        assertThat(player.isAlive(), is(true));
    }
}
