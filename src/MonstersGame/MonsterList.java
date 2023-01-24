package MonstersGame;

public enum MonsterList {
        VAMPIRE(20,100),
        MUMMY(35,100),
        WEREWOLF(25,120);

        private int health;
        private int damage;
        private MonsterList(int damage, int health) {
                this.health = health;
                this.damage = damage;
        }
        public int getHealth() {
                return health;
        }
        public int getDamage() {
                return damage;
        }

}
