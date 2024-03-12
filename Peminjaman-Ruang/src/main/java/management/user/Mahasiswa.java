/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.user;

import java.util.ArrayList;
import java.util.Scanner;
import management.peminjaman.Peminjaman;

/**
 *
 * @author FLOW
 */

public class Mahasiswa implements User {
    private String username;
    private String password;
    private final Scanner scanner = new Scanner(System.in);

    // Data mahasiswa yang diperbolehkan login
    private final ArrayList<String> usernames = new ArrayList<>();
    private final ArrayList<String> passwords = new ArrayList<>();
    private final ArrayList<Boolean> status = new ArrayList<>();

    public Mahasiswa() {
        usernames.add("mahasiswa1");
        passwords.add("pass123");
        status.add(true);
    }

    public int getJmlSiswa() {
        return this.usernames.size();
    }

    public String getUsername(int a) {
        return this.usernames.get(a);
    }

    public boolean getStatus(int a) {
        return this.status.get(a);
    }

    public void setStatus(int a, boolean b) {
        this.status.set(a, b);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean login() {
        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.println("\nLogin sebagai Mahasiswa");
            System.out.print("Masukkan Username (atau ketik 'exit' untuk keluar): ");
            String enteredUsername = scanner.nextLine();

            // Check if the user wants to exit
            if (enteredUsername.equalsIgnoreCase("exit")) {
                System.out.println("Sedang proses keluar dari program...");
                return false;  // Return false to indicate the user chose to exit
            }

            // Check if the entered username exists
            if (usernames.contains(enteredUsername)) {
                // Find the index of the entered username
                int userIndex = usernames.indexOf(enteredUsername);

                System.out.print("Masukkan Password: ");
                String enteredPassword = scanner.nextLine();

                // Check if the entered password matches the password for the entered username
                isLoggedIn = passwords.get(userIndex).equals(enteredPassword);

                if (!isLoggedIn) {
                    System.out.println("Password tidak valid. Silakan coba lagi.");
                }
            } else {
                System.out.println("Username tidak valid. Silakan coba lagi.");
            }
        }

        System.out.println("Login berhasil!");
        return true;  // Return true to indicate successful login
    }


    @Override
    public void displayMenu() {
        Peminjaman pmj = new Peminjaman();
        Scanner input = new Scanner(System.in);
        
        System.out.println("========================================================");
        System.out.println("Halo " + getUsername() + "!");
        System.out.println("Selamat datang di Peminjaman Ruang!");
        System.out.println("========================================================\n");

        while (true) {
            System.out.println("\n-----------------MENU-----------------");
            System.out.print("\nLihat Ruangan\n1. Lihat Peminjaman\n0. Keluar\n> ");
            int pilihMenu = input.nextInt();

            switch (pilihMenu) {
                case 1:
                    pmj.readPeminjaman(pmj);
                    break;
                case 2:
                    // Add functionality for case 2 if needed
                    break;
                case 0:
                    System.out.println("Sedang keluar dari program...");
                    return; 
                default:
                    System.out.println("Tidak ada dipilihan :(");
                    break;
            }
        }
    }
}