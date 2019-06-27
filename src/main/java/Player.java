public class Player {
    private int health = 1000;
    private boolean live = true;
    private int level = 1;

    public Player() {
    }

    public Player(int level) {
        this.level = level;
    }

    public int health() {
        return health;
    }

    public int level() {
        return level;
    }

    public boolean isAlive() {
        return live;
    }

    public void dealDamage(Player player, int damage) {
        if (this != player) {
            player.setHealth(calculateDamage(player, damage));
        }
    }

    private int calculateDamage(Player defender, int damage) {
        if (defender.isDefenderOverPowered(this)) {
            damage = increaseDamage50Percent(damage);
        }
        if (this.isDefenderOverPowered(defender)) {
            damage = decreaseDamage50Percent(damage);
        }
        return defender.health() - damage;
    }

    private boolean isDefenderOverPowered(Player defender) {
        return this.level <= defender.level - 5;
    }

    private int decreaseDamage50Percent(int damage) {
        return damage / 2;
    }

    private int increaseDamage50Percent(int damage) {
        return (int) (damage * 1.5);
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
        if (player.isAlive()) {
            player.setHealth(player.health += points);
        }
    }
}
