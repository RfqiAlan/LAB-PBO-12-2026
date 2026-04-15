public class Cook { // menyimpan data orang yang memasak, skill, dan masakan
    String name; // atribute objek - nyimpan data kalo ada objek cook yang dibuat
    int skill;
    Recipe recipe;

    public Cook() { //cons default - digunakan pada nilai awal & dipakai kalau gada nilai yang di input
        name = null ;
        skill = 0 ;
        recipe = new Recipe(); //mengimport data / terhubung dari class recipe 
    }

    public Cook(String name, int skill, Recipe recipe) { //cons parameter - menerima parameter dan menyimpannya ke atribut
        this.name = name;
        this.skill = skill;
        this.recipe = recipe;
    }

    public void cook() { //method 1 - merangcang / mencetak output
        System.out.println(name + " memasak " + recipe.name);
    }

    public void cookingContest(Cook enemy) { //method 2 -  untuk menginteraksikan antar objek
        int score1 = this.skill + this.recipe.taste;
        int score2 = enemy.skill + enemy.recipe.taste;

        if (score1 > score2) {
            System.out.println(name + " menang!");
        } else if (score1 < score2) {
            System.out.println(enemy.name + " menang!");
        } else {
            System.out.println("Seri!");
        }
    }
}