package Suhu.Suhu_Elo.Studycase_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Kendaraan> rent    = new ArrayList<>();
        ArrayList<String>    riwayat = new ArrayList<>();

        while (true) {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║    RENTAL KENDARAAN          ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║  1. Tambah Motor             ║");
            System.out.println("║  2. Tambah Mobil             ║");
            System.out.println("║  3. Tampilkan Semua Kendaraan║");
            System.out.println("║  4. Sewa Kendaraan           ║");
            System.out.println("║  5. Riwayat Sewa             ║");
            System.out.println("║  6. Keluar                   ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Pilihan : ");

            int pilih;
            try {
                pilih = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[!] Input tidak valid, masukkan angka 1-6.");
                continue;
            }

            // ─── OPSI 1: Tambah Motor ───────────────────────────────────────
            if (pilih == 1) {
                System.out.println("\n--- Tambah Motor ---");
                try {
                    System.out.print("Merk         : ");
                    String merk = sc.nextLine().trim();

                    System.out.print("Tahun keluaran: ");
                    int tahun = Integer.parseInt(sc.nextLine().trim());

                    System.out.print("Harga sewa/hari (Rp): ");
                    double harga = Double.parseDouble(sc.nextLine().trim());

                    System.out.print("Jenis transmisi (Manual/Matic): ");
                    String transmisi = sc.nextLine().trim();

                    System.out.print("Kapasitas CC : ");
                    int cc = Integer.parseInt(sc.nextLine().trim());

                    System.out.print("Tipe mesin   : ");
                    String tipeMesin = sc.nextLine().trim();

                    rent.add(new Motor(merk, tahun, harga, transmisi, new Mesin(cc, tipeMesin)));
                    System.out.println("[✓] Motor " + merk + " berhasil ditambahkan!");

                } catch (NumberFormatException e) {
                    System.out.println("[!] Input angka tidak valid. Motor tidak ditambahkan.");
                }
            }

            // ─── OPSI 2: Tambah Mobil ───────────────────────────────────────
            else if (pilih == 2) {
                System.out.println("\n--- Tambah Mobil ---");
                try {
                    System.out.print("Merk          : ");
                    String merk = sc.nextLine().trim();

                    System.out.print("Tahun keluaran: ");
                    int tahun = Integer.parseInt(sc.nextLine().trim());

                    System.out.print("Harga sewa/hari (Rp): ");
                    double harga = Double.parseDouble(sc.nextLine().trim());

                    System.out.print("Jumlah pintu  : ");
                    int pintu = Integer.parseInt(sc.nextLine().trim());

                    System.out.print("Kapasitas CC  : ");
                    int cc = Integer.parseInt(sc.nextLine().trim());

                    System.out.print("Tipe mesin    : ");
                    String tipeMesin = sc.nextLine().trim();

                    rent.add(new Mobil(merk, tahun, harga, pintu, new Mesin(cc, tipeMesin)));
                    System.out.println("[✓] Mobil " + merk + " berhasil ditambahkan!");

                } catch (NumberFormatException e) {
                    System.out.println("[!] Input angka tidak valid. Mobil tidak ditambahkan.");
                }
            }

            // ─── OPSI 3: Tampilkan Semua Kendaraan ─────────────────────────
            else if (pilih == 3) {
                if (rent.isEmpty()) {
                    System.out.println("[!] Belum ada kendaraan yang terdaftar.");
                } else {
                    System.out.println("\n=== DAFTAR MOTOR ===");
                    boolean adaMotor = false;
                    for (int i = 0; i < rent.size(); i++) {
                        if (rent.get(i).getTipe().equalsIgnoreCase("Motor")) {
                            System.out.println("[" + i + "]");
                            rent.get(i).tampilkanInfo();
                            adaMotor = true;
                        }
                    }
                    if (!adaMotor) System.out.println("  Tidak ada motor.");

                    System.out.println("\n=== DAFTAR MOBIL ===");
                    boolean adaMobil = false;
                    for (int i = 0; i < rent.size(); i++) {
                        if (rent.get(i).getTipe().equalsIgnoreCase("Mobil")) {
                            System.out.println("[" + i + "]");
                            rent.get(i).tampilkanInfo();
                            adaMobil = true;
                        }
                    }
                    if (!adaMobil) System.out.println("  Tidak ada mobil.");
                }
            }

            // ─── OPSI 4: Sewa Kendaraan ─────────────────────────────────────
            else if (pilih == 4) {
                // Exception: cek apakah ada kendaraan sama sekali
                if (rent.isEmpty()) {
                    System.out.println("[!] Tidak ada kendaraan yang terdaftar. Tambah kendaraan terlebih dahulu.");
                    continue;
                }

                // Exception: cek apakah ada kendaraan yang tersedia
                boolean adaYangTersedia = false;
                for (Kendaraan k : rent) {
                    if (k.isTersedia()) { adaYangTersedia = true; break; }
                }
                if (!adaYangTersedia) {
                    System.out.println("[!] Semua kendaraan sedang disewa. Tidak ada yang tersedia saat ini.");
                    continue;
                }

                // Tampilkan hanya yang tersedia
                System.out.println("\n=== KENDARAAN TERSEDIA ===");
                for (int i = 0; i < rent.size(); i++) {
                    if (rent.get(i).isTersedia()) {
                        System.out.println("[" + i + "]");
                        rent.get(i).tampilkanInfo();
                    }
                }

                try {
                    System.out.print("\nPilih nomor kendaraan : ");
                    int pilihan = Integer.parseInt(sc.nextLine().trim());

                    // Exception: index out of range
                    if (pilihan < 0 || pilihan >= rent.size()) {
                        System.out.println("[!] Nomor kendaraan tidak valid.");
                        continue;
                    }

                    // Exception: kendaraan tidak tersedia
                    if (!rent.get(pilihan).isTersedia()) {
                        System.out.println("[!] Kendaraan [" + pilihan + "] sedang disewa, pilih yang lain.");
                        continue;
                    }

                    System.out.print("Lama sewa (hari)      : ");
                    int lamaSewa = Integer.parseInt(sc.nextLine().trim());
                    if (lamaSewa <= 0) {
                        System.out.println("[!] Lama sewa harus lebih dari 0 hari.");
                        continue;
                    }

                    System.out.print("Diskon (Rp, 0 jika tidak ada): ");
                    double diskon = Double.parseDouble(sc.nextLine().trim());
                    if (diskon < 0) diskon = 0;

                    // Cetak struk
                    System.out.println("\n" + rent.get(pilihan).getStrukSewa(lamaSewa, diskon));

                    // Tandai tidak tersedia
                    rent.get(pilihan).setTersedia(false);

                    // Simpan riwayat
                    String catatanDiskon = diskon > 0 ? " | Diskon Rp." + String.format("%,.0f", diskon) : "";
                    riwayat.add(rent.get(pilihan).getTipe() + " " + rent.get(pilihan).getMerk()
                            + " | " + lamaSewa + " hari"
                            + " | Total Rp." + String.format("%,.0f", rent.get(pilihan).hitungBiayaSewa(lamaSewa, diskon))
                            + catatanDiskon);

                } catch (NumberFormatException e) {
                    System.out.println("[!] Input tidak valid. Transaksi dibatalkan.");
                }
            }

            // ─── OPSI 5: Riwayat Sewa ──────────────────────────────────────
            else if (pilih == 5) {
                if (riwayat.isEmpty()) {
                    System.out.println("[!] Belum ada riwayat transaksi.");
                } else {
                    System.out.println("\n=== RIWAYAT SEWA ===");
                    for (int i = 0; i < riwayat.size(); i++) {
                        System.out.println((i + 1) + ". " + riwayat.get(i));
                    }
                }
            }

            // ─── OPSI 6: Keluar ────────────────────────────────────────────
            else if (pilih == 6) {
                System.out.println("Terima kasih telah menggunakan Rental Kendaraan. Sampai jumpa!");
                break;
            }

            else {
                System.out.println("[!] Pilihan tidak valid. Masukkan angka 1-6.");
            }
        }

        sc.close();
    }
}
