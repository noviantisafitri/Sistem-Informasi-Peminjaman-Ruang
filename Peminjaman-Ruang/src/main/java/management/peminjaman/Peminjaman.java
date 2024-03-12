/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.peminjaman;

import java.util.*;

/**
 *
 * @author FLOW
 */

public class Peminjaman {
    ArrayList<String> namaPeminjam = new ArrayList<>();
    ArrayList<String> kodeRuang = new ArrayList<>();
    ArrayList<String> status = new ArrayList<>();

    public Peminjaman() {
        namaPeminjam.add("Novi");
        kodeRuang.add("D401");
        status.add("Disetujui");

        namaPeminjam.add("Tia");
        kodeRuang.add("D402");
        status.add("Pending");
    }

    public void addPeminjaman() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tambah Peminjaman");
        System.out.print("\nMasukkan nama Peminjam : ");
        String peminjam = scanner.next();
        setNamaPeminjam(peminjam);

        System.out.print("Kode Ruang : ");
        String kode = scanner.next();
        setKodeRuang(kode);

        System.out.print("Status Peminjaman : ");
        String stt = scanner.next();
        setStatus(stt);

        // Display updated Peminjaman details
        displayPeminjamanTable();
    }

    public void updatePeminjaman() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===Update Data Peminjaman===");
        System.out.println("\nDaftar Peminjaman yang tersedia");
        displayPeminjamanTable();

        System.out.print("\nMasukkan ID Peminjaman yang ingin di update > ");
        int idBar = scanner.nextInt();

        System.out.print("\nNama Peminjam baru : ");
        String namaEdit = scanner.next();

        System.out.print("\nKode Ruang : ");
        String kodeEdit = scanner.next();

        System.out.print("\nStatus Peminjaman : ");
        String statusEdit = scanner.next();

        editNamaPeminjam(idBar, namaEdit);
        editKodeRuang(idBar, kodeEdit);
        editStatus(idBar, statusEdit);

        // Display updated Peminjaman details
        displayPeminjamanTable();
    }

    public void deletePeminjaman() {
        Scanner input = new Scanner(System.in);

        System.out.println("Hapus Peminjaman");
        System.out.println("\nList yang tersedia");
        displayPeminjamanTable();

        System.out.print("\nMasukkan ID Peminjaman yang mau dihapus > ");
        int idBar = input.nextInt();

        // Check if the provided ID is valid
        if (idBar >= 0 && idBar < getJmlPeminjaman()) {
            // Remove the Peminjaman at the specified index
            namaPeminjam.remove(idBar);
            kodeRuang.remove(idBar);
            status.remove(idBar);

            System.out.println("\nPeminjaman berhasil dihapus.");
        } else {
            System.out.println("ID Peminjaman tidak valid.");
        }
        
        displayPeminjamanTable();
    }

    public void readPeminjaman(Peminjaman peminjaman) {
        System.out.println("\nTabel Peminjaman\n");
        displayPeminjamanTable();
    }

    private void displayPeminjamanTable() {
        System.out.printf("| %-3s | %-15s | %-10s | %-10s |\n", "ID", "Nama Peminjam", "Kode Ruang", "Status");
        for (int j = 0; j < getJmlPeminjaman(); j++) {
            System.out.printf("| %-3d | %-15s | %-10s | %-10s |\n", j, getNamaPeminjam(j), getKodeRuang(j), getStatus(j));
        }
    }

    public int getJmlPeminjaman() {
        return this.namaPeminjam.size();
    }

    public void setNamaPeminjam(String peminjam) {
        this.namaPeminjam.add(peminjam);
    }

    public String getNamaPeminjam(int index) {
        return this.namaPeminjam.get(index);
    }

    public void editNamaPeminjam(int id, String nama) {
        this.namaPeminjam.set(id, nama);
    }

    public void setKodeRuang(String kode) {
        this.kodeRuang.add(kode);
    }

    public String getKodeRuang(int index) {
        return this.kodeRuang.get(index);
    }

    public void editKodeRuang(int id, String kode) {
        this.kodeRuang.set(id, kode);
    }

    public void setStatus(String status) {
        this.status.add(status);
    }

    public String getStatus(int index) {
        return this.status.get(index);
    }

    public void editStatus(int id, String status) {
        this.status.set(id, status);
    }
}

