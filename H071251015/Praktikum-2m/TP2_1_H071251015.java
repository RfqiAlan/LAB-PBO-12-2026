public class weapon { //sistem senjata
    String name;
    int damage;

    public weapon(String name, int damage) { 
        this.name = name;
        this.damage = damage; 
    }
        public void showWeapon(){
        System.out.println("Weapon:" + name +" | damage:" + damage); 
     }
}
