public class Player {
    private int healt = 1000;
    private boolean live = true;

    public int healt() {
        return healt;
    }

    public int level() {
        return 1;
    }

    public boolean isAlive() {
        return live;
    }

    public void dealDamage(Player player, int damage) {
        if (damage >= 1000) {
            player.setHealt(0);
            player.setLive(false);
        } else {
            player.setHealt(player.healt() - damage);
        }
    }

    private void setLive(boolean alive) {
        this.live = alive;
    }

    private void setHealt(int healt) {
        this.healt = healt;
    }
}
