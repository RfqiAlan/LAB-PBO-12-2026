public class Recipe { //menyimpan data masakan
    String name; //atribute objek - menyimpan data kalo ada objek recipe yang dibuat
    int taste;

    public Recipe() { //cons default - digunakan pada nilai awal & dipakai kalau gada nilai yang di input
        name = null ;
        taste = 0 ;
    }

    public Recipe(String name, int taste) { //cons parameter -  menerima parameter name dan taste, lalu disimpan ke atribut menggunakan this.
        this.name = name;
        this.taste = taste;
    }
}