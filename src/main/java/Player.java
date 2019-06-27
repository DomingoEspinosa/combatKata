public class Player {
    private int health = 1000;
    private boolean live = true;

    public int health() {
        return health;
    }

    public int level() {
        return 1;
    }

    public boolean isAlive() {
        return live;
    }

    public void dealDamage(Player player, int damage) {
        player.setHealth(player.health() - damage);
    }

    private void setLive(boolean alive) {
        this.live = alive;
    }

    private void setHealth(int health) {
        if (health <= 0) {
            this.live = false;
            this.health = 0;
        } else if (this.health > 1000) {
            this.health = 1000;
        } else {
            this.health = health;
        }
    }

    public void heal(Player player, int points) {
        if (player.isAlive()){
            player.setHealth(player.health += points);
        }
    }
}
