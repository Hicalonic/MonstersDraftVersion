package MonstersGame;

public class Fairy extends Supernatural{

    private String name;
    public Fairy() {
        super();
        this.damage = 10;
        this.name = "Fairy";
    }

    @Override
    public int getDamage() {
        return super.getDamage();
    }

    @Override
    public int attack() {
        return super.attack();
    }

    public String getName() {
        return name;
    }
}
