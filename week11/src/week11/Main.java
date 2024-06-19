/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week11;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Main {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/BookDB";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            System.out.print("Pilihan Menu: ");
            choice = input.nextInt();
            input.nextLine();

            switch(choice) {
                case 1:
                    insert(input);
                break;
                case 2:
                    update(input);
                break;
                case 3:
                    delete(input);
                break;
                case 4:
                    show();
                break;
                case 5:
                    System.out.println("Exiting...");
                break;
                default:
                    System.out.println("Pilihan Menu Invalid, coba lagi.");
            }
        } while (choice != 5);

        input.close();
    }
    
     public static void showMenu() {
        
        System.out.println("Menu:");
        System.out.println("1. Insert Data");
        System.out.println("2. Update Data");
        System.out.println("3. Delete Data");
        System.out.println("4. Show Data");
        System.out.println("5. Exit");
    }
    
    public static void insert(Scanner scanner) {
        
        System.out.print("Masukkan ID: ");
        int ID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Judul Buku: ");
        String Judul_Buku = scanner.nextLine();
        System.out.print("Masukkan Tahun Terbit: ");
        int Tahun_Terbit = scanner.nextInt();
        System.out.print("Masukkan Stok: ");
        int Stok = scanner.nextInt();
        System.out.print("Masukkan ID Penulis: ");
        int Penulis = scanner.nextInt();
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql = "INSERT INTO buku (ID, Judul_Buku, Tahun_Terbit, Stok, Penulis) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, ID);
            ps.setString(2, Judul_Buku);
            ps.setInt(3, Tahun_Terbit);
            ps.setInt(4, Stok);
            ps.setInt(5, Penulis);

            ps.execute();

            stmt.close();
            conn.close();
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void update(Scanner scanner) {
        
        System.out.print("Masukkan ID Buku untuk di Update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        if (!exists(id)) {
                System.out.println("Data Buku tidak ditemukan.");
            return;
        }
        System.out.print("Masukkan Judul Buku Baru: ");
        String judul_buku = scanner.nextLine();
        System.out.print("Masukkan Tahun Terbit Baru: ");
        int tahun_terbit = scanner.nextInt();
        System.out.print("Masukkan Stok Baru: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan ID Penulis Baru: ");
        int penulis = scanner.nextInt();

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE buku SET judul_buku = ?, tahun_terbit = ?, stok = ?, penulis = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, judul_buku);
            ps.setInt(2, tahun_terbit);
            ps.setInt(3, stok);
            ps.setInt(4, penulis);
            ps.setInt(5, id);

            ps.executeUpdate();

            ps.close();
            conn.close();
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(Scanner scanner) {
        
        System.out.print("Masukkan ID Buku untuk di Delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (!exists(id)) {
                System.out.println("Data Buku tidak ditemukan.");
            return;
        }

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "DELETE FROM buku WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            conn.close();
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void show() {
    
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM buku");
            
            int i = 1;
            while(rs.next()) {
		System.out.println("==============================================");
                System.out.println("Data ke-" + i);
		System.out.println("ID: " + rs.getString("id"));
		System.out.println("Judul Buku: " + rs.getString("judul_buku"));
		System.out.println("Tahun Terbit: " + rs.getString("tahun_terbit"));
		System.out.println("Stok: " + rs.getString("stok"));
		System.out.println("ID Penulis: " + rs.getString("penulis"));
                System.out.println("==============================================");
		i++;
            }
            
            rs.close();
            stmt.close();
            conn.close();
	}
        
	catch(Exception e) {
            e.printStackTrace();
	}
    }
    
    public static boolean exists(int id) {
        
        boolean found = false;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT id FROM buku WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            
            rs = ps.executeQuery();

            found = rs.next();

            rs.close();
            ps.close();
            conn.close();
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }

        return found;
    }
    
}
