import java.util.Scanner;

class BangunDatar {
    double hitungLuas() {
        return 0;
    }
    double hitungKeliling() {
        return 0;
    };
}

class BangunRuang {
    double hitungLuas()  {
        return 0; 
    }
    double hitungVolume()  {
        return 0;
    }
}

class Persegi extends BangunDatar {
    double sisi;
    Persegi(double sisi){ 
        this.sisi = sisi;
    }
    double hitungLuas(){ 
        return sisi * sisi; 
    }

    double hitungKeliling(){ 
        return 4 * sisi; 
    }
}

class PersegiPanjang extends BangunDatar {
    double p, l;

    PersegiPanjang(double p, double l) {
        this.p = p; 
        this.l = l; 
    }

    double hitungLuas() { 
        return p*l;
    }
    double hitungKeliling() { 
        return 2*(p+l);
    }
}

class Lingkaran extends BangunDatar {
    double r;
    Lingkaran(double r) { 
        this.r = r;
    }

    double hitungLuas() { 
        return Math.PI*r*r;
    }

    double hitungKeliling() { 
        return 2*Math.PI*r;
    }
}
    
class Trapesium extends BangunDatar {
    double a, b, c, d, t;
    Trapesium(double a, double b, double c, double d, double t){
        this.a=a; 
        this.b=b; 
        this.c=c; 
        this.d=d; 
        this.t=t;
    }

    double hitungLuas(){ 
        return ((a+b)/2) * t; 
    }
    double hitungKeliling(){ 
        return a+b+c+d; 
    }
}

class Kubus extends BangunRuang {
    double sisi;
    Kubus(double sisi) {
        this.sisi=sisi; }

    double hitungLuas(){ 
        return 6 * sisi * sisi; 
    }

    double hitungVolume(){ 
        return sisi * sisi * sisi; 
    }
}

class Balok extends BangunRuang {
    double p,l,t;
    Balok(double p,double l,double t){ 
        this.p=p; 
        this.l=l; 
        this.t=t; 
    }
    double hitungLuas(){ 
        return 2*(p*l+p*t+l*t); 
    }
    double hitungVolume(){ 
        return p*l*t; 
    }
}

class Bola extends BangunRuang {
    double r;
    Bola(double r){ 
        this.r = r; 
    }
    double hitungLuas(){ 
        return 4 * Math.PI * r * r; 
    }
    double hitungVolume(){ 
        return (4.0/3.0) * Math.PI * r * r * r;
    }
}

class Tabung extends BangunRuang {
    double r,t;

    public Tabung(double r, double t) {
        this.r = r;
        this.t = t;
    }
    double hitungLuas() {
        return 2*Math.PI*r*(r+t); 
    }
    double hitungVolume() {
        return  Math.PI*r*r*t; 
    }
    
}

public class no1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("==== BANGUN RUANG ====");
        System.out.println("1. Kubus\n2. Balok\n3. Bola\n4. Tabung\n");
        System.out.println("==== BANGUN DATAR ====");
        System.out.println("5. Persegi\n6.Persegi Panjang\n7. Lingkaran\n8. Trapesium");
        System.out.print("Masukkan pilihan km :  " );
        int pilih;

        try {
            String pilihanStr = input.nextLine();
            pilih = Integer.parseInt(pilihanStr);
        
       switch(pilih){
            case 1: 
                System.out.print("Masukkan sisi: ");
                double s = input.nextDouble();
                Kubus k = new Kubus(s);
                System.out.println("Luas Kubus: " +k.hitungLuas());
                System.out.println("Volume Kubus: "+k.hitungVolume());
                break;
            case 2: 
                System.out.print("Masukkan panjang: "); double p=input.nextDouble();
                System.out.print("Masukkan lebar: "); double l=input.nextDouble();
                System.out.print("Masukkan tinggi: "); double t=input.nextDouble();
                Balok b = new Balok(p,l,t);
                System.out.println("Luas Balok: "+b.hitungLuas());
                System.out.println("Volume Balok: "+b.hitungVolume());
                break;
            case 3: 
                System.out.print("Masukkan jari-jari: "); double r=input.nextDouble();
                Bola bola = new Bola(r);
                System.out.println("Luas Bola: "+bola.hitungLuas());
                System.out.println("Volume Bola: "+bola.hitungVolume());
                break;
            case 4: 
                System.out.print("Masukkan jari-jari: "); double rt=input.nextDouble();
                System.out.print("Masukkan tinggi: "); double tt=input.nextDouble();
                Tabung tab = new Tabung(rt,tt);
                System.out.println("Luas Tabung: "+tab.hitungLuas());
                System.out.println("Volume Tabung: "+tab.hitungVolume());
                break;
            case 5: 
                System.out.print("Masukkan sisi: "); double sp=input.nextDouble();
                Persegi per = new Persegi(sp);
                System.out.println("Luas Persegi: "+per.hitungLuas());
                System.out.println("Keliling Persegi: "+per.hitungKeliling());
                break;
            case 6: 
                System.out.print("Masukkan panjang: "); double pp=input.nextDouble();
                System.out.print("Masukkan lebar: "); double lp=input.nextDouble();
                PersegiPanjang ppj = new PersegiPanjang(pp,lp);
                System.out.println("Luas Persegi Panjang: "+ppj.hitungLuas());
                System.out.println("Keliling Persegi Panjang: "+ppj.hitungKeliling());
                break;
            case 7: 
                System.out.print("Masukkan jari-jari: "); double rl=input.nextDouble();
                Lingkaran ling = new Lingkaran(rl);
                System.out.println("Luas Lingkaran: "+ling.hitungLuas());
                System.out.println("Keliling Lingkaran: "+ling.hitungKeliling());
                break;
            case 8: 
                System.out.print("Masukkan sisi 1: "); double a=input.nextDouble();
                System.out.print("Masukkan sisi 2: "); double bb=input.nextDouble();
                System.out.print("Masukkan sisi 3: "); double c=input.nextDouble();
                System.out.print("Masukkan sisi 4: "); double d=input.nextDouble();
                System.out.print("Masukkan tinggi: "); double tt2=input.nextDouble();
                Trapesium tr = new Trapesium(a,bb,c,d,tt2);
                System.out.println("Luas Trapesium: "+tr.hitungLuas());
                System.out.println("Keliling Trapesium: "+tr.hitungKeliling());
                break;
            default:
                System.out.println("Pilihan tidak valid.");
            } 
        } catch (NumberFormatException e) {
            System.out.println("Maaf pilihan yang km masukkan harus berupa angka!!!");
        }
    }
}

