public class soulswarrior { //penjelasan mngnai back end enemy dan player
    String name;
    int health;
    weapon weapon; 

    public soulswarrior(){
        this.name = "knight";
        this.health = 0;
        this.weapon = weapon;
    }

    public soulswarrior( String name, int health, weapon weapon) { //parameter
        this.name = name; // objek
        this.health = health;
        this.weapon = weapon;
    }
     public void attack(soulswarrior enemy){
        System.out.println(this.name + "attack" + enemy.name + "using" + weapon.name);
        enemy.health -= weapon.damage;

        if (enemy.health < 0){
            enemy.health = 0;
             System.out.println(enemy.name + " has been defeated!");
             System.out.println("Congratulations " + this.name + "! You won the battle!");
        }
     }
     public void showstatus(){
        System.out.println("name:" + name);
        System.out.println("health" + health);
        weapon.showWeapon();
        System.out.println("--------------------");
     }
}
