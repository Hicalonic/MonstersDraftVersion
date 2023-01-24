package MonstersGame;

public abstract class Supernatural {


    protected int damage;

    public Supernatural(){
    }
    public int attack() {
        System.out.println(this + " is attacking!");
        return damage  ;
    }


    public int getDamage() {
        return damage ;
    }


}
