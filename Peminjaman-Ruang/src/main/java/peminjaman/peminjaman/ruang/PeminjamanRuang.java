/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package peminjaman.peminjaman.ruang;

import management.user.*;
import java.util.*;

/**
 *
 * @author FLOW
 */
final class PeminjamanRuang {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose user type:");
        System.out.println("1. Mahasiswa");
        System.out.println("2. Staff");
        System.out.print("Enter your choice: ");

        int choice;
        try {
            choice = scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        User user = null;

        switch (choice) {
            case 1:
                user = new Mahasiswa();
                break;
            case 2:
                user = new Staff();
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        if (user.login()) {
            user.displayMenu();
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }
}