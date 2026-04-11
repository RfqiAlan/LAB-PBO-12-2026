public class main { //main code tmpt di run ini code
    public static void main(String[] args) {
         weapon sword = new weapon("tusuk gigi", 50);
         weapon axe = new weapon("abyss axe", 25); 

         soulswarrior player = new soulswarrior("knight", 100, sword); 
         soulswarrior enemy = new soulswarrior("undead", 80, axe); 

         System.out.println("=== BEFORE BATTLE ===");
         player.showstatus();
         enemy.showstatus();

         enemy.attack(player);
         player.attack(enemy);
         

         System.out.println("=== AFTER BATTLE ===");
         player.showstatus();
         enemy.showstatus();

         System.out.println(player.health);
         System.out.println(enemy.name);
    }
}
