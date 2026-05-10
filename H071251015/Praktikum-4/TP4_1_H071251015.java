// ========================
// SUPERCLASS BANGUN RUANG
// ========================
class BangunRuang {
    double hitungLuas() {
        return 0;
    }
    double hitungVolume() {
        return 0;
    }
}

// ========================
// SUPERCLASS BANGUN DATAR
// ========================
class BangunDatar {
    double hitungLuas() {
        return 0;
    }
    double hitungKeliling() {
        return 0;
    }
}

// ========================
// SUBCLASS BANGUN RUANG
// ========================

class Kubus extends BangunRuang {
    double sisi;

    Kubus(double sisi) {
        this.sisi = sisi;
    }

    double hitungLuas() {
        try {
            return 6 * sisi * sisi;
        } catch (Exception e) {
            System.out.println("Error hitungLuas Kubus: " + e.getMessage());
            return 0;
        }
    }

    double hitungVolume() {
        try {
            return sisi * sisi * sisi;
        } catch (Exception e) {
            System.out.println("Error hitungVolume Kubus: " + e.getMessage());
            return 0;
        }
    }
}

class Balok extends BangunRuang {
    double panjang, lebar, tinggi;

    Balok(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    double hitungLuas() {
        try {
            return 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
        } catch (Exception e) {
            System.out.println("Error hitungLuas Balok: " + e.getMessage());
            return 0;
        }
    }

    double hitungVolume() {
        try {
            return panjang * lebar * tinggi;
        } catch (Exception e) {
            System.out.println("Error hitungVolume Balok: " + e.getMessage());
            return 0;
        }
    }
}

class Bola extends BangunRuang {
    double jariJari;

    Bola(double jariJari) {
        this.jariJari = jariJari;
    }

    double hitungLuas() {
        try {
            return 4 * Math.PI * jariJari * jariJari;
        } catch (Exception e) {
            System.out.println("Error hitungLuas Bola: " + e.getMessage());
            return 0;
        }
    }

    double hitungVolume() {
        try {
            return (4.0 / 3) * Math.PI * jariJari * jariJari * jariJari;
        } catch (Exception e) {
            System.out.println("Error hitungVolume Bola: " + e.getMessage());
            return 0;
        }
    }
}

class Tabung extends BangunRuang {
    double jariJari, tinggi;

    Tabung(double jariJari, double tinggi) {
        this.jariJari = jariJari;
        this.tinggi = tinggi;
    }

    double hitungLuas() {
        try {
            return 2 * Math.PI * jariJari * (jariJari + tinggi);
        } catch (Exception e) {
            System.out.println("Error hitungLuas Tabung: " + e.getMessage());
            return 0;
        }
    }

    double hitungVolume() {
        try {
            return Math.PI * jariJari * jariJari * tinggi;
        } catch (Exception e) {
            System.out.println("Error hitungVolume Tabung: " + e.getMessage());
            return 0;
        }
    }
}

// ========================
// SUBCLASS BANGUN DATAR
// ========================

class Persegi extends BangunDatar {
    double sisi;

    Persegi(double sisi) {
        this.sisi = sisi;
    }

    double hitungLuas() {
        try {
            return sisi * sisi;
        } catch (Exception e) {
            System.out.println("Error hitungLuas Persegi: " + e.getMessage());
            return 0;
        }
    }

    double hitungKeliling() {
        try {
            return 4 * sisi;
        } catch (Exception e) {
            System.out.println("Error hitungKeliling Persegi: " + e.getMessage());
            return 0;
        }
    }
}

class PersegiPanjang extends BangunDatar {
    double panjang, lebar;

    PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    double hitungLuas() {
        try {
            return panjang * lebar;
        } catch (Exception e) {
            System.out.println("Error hitungLuas PersegiPanjang: " + e.getMessage());
            return 0;
        }
    }

    double hitungKeliling() {
        try {
            return 2 * (panjang + lebar);
        } catch (Exception e) {
            System.out.println("Error hitungKeliling PersegiPanjang: " + e.getMessage());
            return 0;
        }
    }
}

class Lingkaran extends BangunDatar {
    double jariJari;

    Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    double hitungLuas() {
        try {
            return Math.PI * jariJari * jariJari;
        } catch (Exception e) {
            System.out.println("Error hitungLuas Lingkaran: " + e.getMessage());
            return 0;
        }
    }

    double hitungKeliling() {
        try {
            return 2 * Math.PI * jariJari;
        } catch (Exception e) {
            System.out.println("Error hitungKeliling Lingkaran: " + e.getMessage());
            return 0;
        }
    }
}

class Trapesium extends BangunDatar {
    double sisi1, sisi2, sisi3, sisi4, tinggi;

    Trapesium(double sisi1, double sisi2, double sisi3, double sisi4, double tinggi) {
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
        this.sisi4 = sisi4;
        this.tinggi = tinggi;
    }

    double hitungLuas() {
        try {
            return 0.5 * (sisi1 + sisi2) * tinggi;
        } catch (Exception e) {
            System.out.println("Error hitungLuas Trapesium: " + e.getMessage());
            return 0;
        }
    }

    double hitungKeliling() {
        try {
            return sisi1 + sisi2 + sisi3 + sisi4;
        } catch (Exception e) {
            System.out.println("Error hitungKeliling Trapesium: " + e.getMessage());
            return 0;
        }
    }
}