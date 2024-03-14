package Latihan1;

public class Soal2a {
	public static void main(String[] args) {
		double diameter = 10;
        
        double keliling = hitungKeliling(diameter);
        
        System.out.println("Keliling lingkaran adalah: " + keliling);
        
    }
    
    public static double hitungKeliling(double diameter) {
        return Math.PI * diameter;
    }
}

