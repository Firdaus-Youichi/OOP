package week9;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        BangunDatar nano = new BangunDatar(0);
        BangunRuang rano = new BangunRuang(0);

        

        System.out.println("Luas Persegi: " + nano.luas(2));
        System.out.println("Luas Persegi Panjang: " + nano.luas(4, 5));
        System.out.println("Luas Lingkaran: " + nano.luas(12.0, 3.0));
        System.out.println("===============");
        System.out.println("Luas Kotak: " + rano.volume(3));
        System.out.println("Luas Balok: " + rano.volume(2,4,6));
        System.out.println("Luas Tabung: " + rano.volume(5.0, 6));
        System.out.println("Luas Bola: " + rano.volume(6.0));
        
    }
}