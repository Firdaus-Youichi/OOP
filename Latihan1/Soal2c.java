package Latihan1;

public class Soal2c{
	
	public static void main(String[] args) {
		double diameter = 5;
		double tinggi = 10;
        
        double luas = hitungVolume(diameter, tinggi);
        
        System.out.println("Volume tabung adalah: " + luas);
        
    }
    
    public static double hitungVolume(double diameter, double tinggi) {
    	double jariJari = diameter/2;
    	double lLingkaran = jariJari * jariJari * Math.PI;
        return lLingkaran * tinggi;
    }
}