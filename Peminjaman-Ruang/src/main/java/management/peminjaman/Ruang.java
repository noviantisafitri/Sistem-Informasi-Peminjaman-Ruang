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
public class Ruang {
    ArrayList<String> namaRuang = new ArrayList<String>();
    ArrayList<Integer> kapasitas = new ArrayList<Integer>();
    ArrayList<String> status = new ArrayList<String>();

    public Ruang () {
        namaRuang.add("D401");
        kapasitas.add(100);
        status.add("Kosong");
        
        namaRuang.add("D402");
        kapasitas.add(50);
        status.add("Kosong");
        
        namaRuang.add("D403");
        kapasitas.add(100);
        status.add("Kosong");
        
        namaRuang.add("D404");
        kapasitas.add(50);
        status.add("Kosong");
    }
    
    public void addRuang(){
        Scanner i = new Scanner(System.in);
        
        System.out.println("Tambah Ruang");
        System.out.print("\nMasukkan nama Ruang : ");
        String bar = i.next();
        setNamaRuang(bar);
        System.out.print("Kapasitas Ruang : ");
        int stonk = i.nextInt();
        setKapasitas(stonk);
        System.out.print("Status Ruang : ");
        String stt = i.next();
        setStatus(stt);
        
        System.out.println("\n");
        int ban = getJmlRuang();
        System.out.println("\nTabel Ruang\n\n| ID |\t| Nama Ruang |\t| kapasitas |\t| Harga |");
        for (int j = 0; j < ban; j++) {
            System.out.println("| "+j+" |\t| "+getNamaRuang(j) + " |\t| " + getKapasitas(j)+ " |\t\t| " + getStatus(j)+" |");
        }
    }
    
    public void updateRuang() {
        Scanner i = new Scanner(System.in);
        
        System.out.println("===Update Data Ruang===");
        System.out.println("\nDaftar Ruang yang tersedia");
        int ban = getJmlRuang();
        System.out.printf("| %-3s | %-15s | %-10s | %-10s |\n", "ID", "Nama Ruang", "Kapasitas", "Status");
        for (int j = 0; j < getJmlRuang(); j++) {
            System.out.printf("| %-3d | %-15s | %-10d | %-10s |\n", j, getNamaRuang(j), getKapasitas(j), getStatus(j));
        }
        
        System.out.print("\nMasukkan ID Ruang yang ingin di update > ");
        int idBar = i.nextInt();
        System.out.print("\nNama Ruang baru : ");
        String namaEdit = i.next();
        System.out.print("\nKapasitas Ruang : ");
        int kapasitasedit = i.nextInt();
        System.out.print("\nRuang baru : ");
        String statusedit = i.next();
        editNamaRuang(idBar, namaEdit);
        editKapasitas(idBar, kapasitasedit);
        editStatus(idBar, statusedit);
        
        System.out.println("\nReview");
        System.out.printf("| %-3s | %-15s | %-10s | %-10s |\n", "ID", "Nama Ruang", "Kapasitas", "Status");
        for (int j = 0; j < getJmlRuang(); j++) {
            System.out.printf("| %-3d | %-15s | %-10d | %-10s |\n", j, getNamaRuang(j), getKapasitas(j), getStatus(j));
        }
    }
    
    public void deleteRuang() {
        Scanner input = new Scanner(System.in);

        System.out.println("Hapus Ruang");
        System.out.println("\nList yang tersedia");
        int count = getJmlRuang();
        System.out.printf("| %-3s | %-15s | %-10s | %-10s |\n", "ID", "Nama Ruang", "Kapasitas", "Status");
        for (int j = 0; j < getJmlRuang(); j++) {
            System.out.printf("| %-3d | %-15s | %-10d | %-10s |\n", j, getNamaRuang(j), getKapasitas(j), getStatus(j));
        }

        System.out.print("\nMasukkan ID Ruang yang mau dihapus > ");
        int idBar = input.nextInt();

        // Check if the provided ID is valid
        if (idBar >= 0 && idBar < count) {
            // Remove the Ruang at the specified index
            namaRuang.remove(idBar);
            kapasitas.remove(idBar);
            status.remove(idBar);

            System.out.println("\nRuang berhasil dihapus.");
        } else {
            System.out.println("ID Ruang tidak valid.");
        }

        // Display the updated list after deletion
        System.out.println("\nReview");
        System.out.printf("| %-3s | %-15s | %-10s | %-10s |\n", "ID", "Nama Ruang", "Kapasitas", "Status");
        for (int j = 0; j < getJmlRuang(); j++) {
            System.out.printf("| %-3d | %-15s | %-10d | %-10s |\n", j, getNamaRuang(j), getKapasitas(j), getStatus(j));
        }        
    }
  
    public void readRuang(Ruang rng){
        System.out.println("\nTabel Ruang\n");
        System.out.printf("| %-3s | %-15s | %-10s | %-10s |\n", "ID", "Nama Ruang", "Kapasitas", "Status");
        for (int j = 0; j < getJmlRuang(); j++) {
            System.out.printf("| %-3d | %-15s | %-10d | %-10s |\n", j, getNamaRuang(j), getKapasitas(j), getStatus(j));
        }
    }



    public int getJmlRuang () {
        return this.namaRuang.size();
    }

    public void setNamaRuang (String ruang) {
        this.namaRuang.add(ruang);
    }

    public String getNamaRuang (int rng) {
        return this.namaRuang.get(rng);
    }
    
    public void editNamaRuang (int id, String nama) {
        this.namaRuang.set(id, nama);
    }

    public void setKapasitas (int kapasitas) {
        this.kapasitas.add(kapasitas);
    }

    public int getKapasitas (int stk) {
        return this.kapasitas.get(stk);
    }

    public void editKapasitas (int a, int b) {
        this.kapasitas.set(a, b);
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

