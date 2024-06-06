package week9;

public class BangunDatar{
    private int sisi;
    private int panjang;
    private int lebar;
    private double diameter;
    //private static final double pi = 3.14;

    public BangunDatar(int sisi){
        this.sisi = sisi;
    }

    public BangunDatar(int panjang, int lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public BangunDatar(double diameter){
        this.diameter = diameter;
    }

    public int luas(int sisi){
        return sisi * sisi;
    }

    public int luas(int panjang, int lebar){
        return panjang * lebar;
    }

    public double luas(double panjang, double lebar){
        return (panjang * lebar)/2;
    }

    public double luas(double diameter){
        double r = diameter/2;
        return Math.PI * (r * r);
    }

}