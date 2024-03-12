package management.user;

import java.util.ArrayList;
import java.util.Scanner;
import management.peminjaman.Ruang;
import management.peminjaman.Peminjaman;

public class Staff implements User {
    
    private String username;
    private String password;
    private final Scanner scanner = new Scanner(System.in);

    // Data staff yang diperbolehkan login
    private final ArrayList<String> usernames = new ArrayList<>();
    private final ArrayList<String> passwords = new ArrayList<>();

    public Staff() {
        usernames.add("staff1");
        passwords.add("admin1");
        
        usernames.add("staff2");
        passwords.add("admin2");
        
    }

    @Override
    public boolean login() {
        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.println("\nLogin sebagai Staff");
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
        Ruang rng = new Ruang();
        Peminjaman pmj = new Peminjaman();
        Scanner input = new Scanner(System.in);
        int pilihMenu; // Declare pilihMenu variable

        System.out.println("========================================================");
        System.out.println("Halo " + getUsername() + "!");
        System.out.println("Selamat datang di Peminjaman Ruang!");
        System.out.println("========================================================\n");

        while (true) {
            System.out.println("\n-----------------MENU-----------------");
            System.out.print("1. Daftar Ruangan\n2. Daftar Peminjaman\n0. Keluar\n> ");
            pilihMenu = input.nextInt();

            switch (pilihMenu) {
                case 1:
                    System.out.print("\nDaftar Ruangan\n1. Lihat Ruang\n2. Add Ruang\n3. Update Ruang\n4. Delete Ruang\n0. Kembali ke Menu Utama\n> ");
                    int pilihan = input.nextInt();
                    switch (pilihan) {
                        case 1:
                            rng.readRuang(rng);
                            break;
                        case 2:
                            rng.addRuang(); 
                            break;
                        case 3:
                            rng.updateRuang();
                            break;
                        case 4:
                            rng.deleteRuang();
                            break;
                        case 0:
                            // Return to the main menu
                            break;
                        default:
                            System.out.println("Tidak ada dipilihan :(");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("\nDaftar Peminjaman\n1. Read Peminjaman\n2. Add Peminjaman\n3. Update Peminjaman\n4. Delete Peminjaman\n0. Kembali ke Menu Utama\n> ");
                    int pilih = input.nextInt();
                    switch (pilih) {
                        case 1:
                            pmj.readPeminjaman(pmj);
                            break;
                        case 2:
                            pmj.addPeminjaman();
                            break;
                        case 3:
                            pmj.updatePeminjaman();
                            break;
                        case 4:
                            pmj.deletePeminjaman();
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Tidak ada dipilihan :(");
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Sedang keluar dari program...");
                    return; // Exit the method (and the loop)
                default:
                    System.out.println("Tidak ada dipilihan :(");
                    break;
            }
        }
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
}