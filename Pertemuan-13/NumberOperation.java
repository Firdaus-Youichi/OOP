import java.util.Scanner;  // Import the Scanner class

public class NumberOperation {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  

    System.out.print("Input Bilangan Pertama: ");
    double number1 = myObj.nextDouble();  

    System.out.print("Input Bilangan Kedua: ");
    double number2 = myObj.nextDouble();  

    // Menampilkan menu operasi
    System.out.println("Pilih operasi:");
    System.out.println("1. Penjumlahan");
    System.out.println("2. Pengurangan");
    System.out.println("3. Perkalian");
    System.out.println("4. Pembagian");

    // Meminta pengguna memilih operasi
    System.out.print("Masukkan pilihan (1-4): ");
    int pilihan = myObj.nextInt();

    double hasil = 0;

    switch (pilihan) {
            case 1:
                hasil = number1 + number2;
                System.out.println("Hasil penjumlahan: " + hasil);
                break;
            case 2:
                hasil = number1 - number2;
                System.out.println("Hasil pengurangan: " + hasil);
                break;
            case 3:
                hasil = number1 * number2;
                System.out.println("Hasil perkalian: " + hasil);
                break;
            case 4:
                if (number2 != 0) {
                    hasil = number1 / number2;
                    System.out.println("Hasil pembagian: " + hasil);
                } else {
                    System.out.println("Error: Bilangan kedua tidak boleh nol untuk pembagian.");
                }
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }

    //scanner.close();
  }
}
