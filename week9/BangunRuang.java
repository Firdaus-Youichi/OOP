package week9;

public class BangunRuang extends BangunDatar {
    private int tinggi;

    // Constructor untuk kubus
    public BangunRuang(int sisi) {
        super(sisi);
    }

    // Constructor untuk balok
    public BangunRuang(int panjang, int lebar, int tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    // Constructor untuk tabung
    public BangunRuang(double diameter, int tinggi) {
        super(diameter);
        this.tinggi = tinggi;
    }

    // Constructor untuk bola
    public BangunRuang(double diameter){
        super(diameter);
    }
         
    // Method untuk menghitung kubus
    public int volume(int sisi) {
        int area = super.luas(sisi);
        return area * sisi;
    }

    // Method untuk menghitung balok
    public int volume(int panjang, int lebar, int tinggi) {
        int area = super.luas(panjang, lebar);
        return area * tinggi;
    }

    //Method untuk menghitung tabung
    public double volume(double diameter, int tinggi) {
        double area = super.luas(diameter);
        return area * tinggi;
    }

    //Method untuk menghitung bola
    public double volume(double diameter){
        double circle = super.luas(diameter);
        double r = diameter/2;
        return (circle * r) * 4/3;
    }
}
