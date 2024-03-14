package Latihan1;

public class Soal2b{
	
	public static void main(String[] args) {
		double alas = 6;
		double tinggi = 8;
        
        double luas = hitungLuas(alas, tinggi);
        
        System.out.println("Luas segitiga siku-siku adalah: " + luas);
        
    }
    
    public static double hitungLuas(double alas, double tinggi) {
        return (alas*tinggi)/2;
    }
}