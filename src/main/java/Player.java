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
        player.setHealt(player.healt() - damage);
    }

    private void setLive(boolean alive) {
        this.live = alive;
    }

    private void setHealt(int healt) {
        if (healt <= 0) {
            this.live = false;
            this.healt = 0;
        } else {
            this.healt = healt;
        }
    }
}
