package Suhu.Suhu_Elo.Studycase_3;

public class Mobil extends Kendaraan {
    private int   jumlahPintu;
    private Mesin mesin;

    // Constructor lengkap
    public Mobil(String merk, int tahunKeluaran, double hargaSewa,
                 int jumlahPintu, Mesin mesin) {
        super(merk, tahunKeluaran, hargaSewa, "Mobil");
        this.jumlahPintu = jumlahPintu;
        this.mesin       = mesin;
    }

    // Overload constructor — tanpa detail mesin, pintu default 4
    public Mobil(String merk, int tahunKeluaran, double hargaSewa) {
        super(merk, tahunKeluaran, hargaSewa, "Mobil");
        this.jumlahPintu = 4;
        this.mesin       = new Mesin(1500); // default 1500cc
    }

    public int getJumlahPintu() { return jumlahPintu; }

    @Override
    public void tampilkanInfo() {
        System.out.println("  Tipe          : Mobil");
        System.out.println("  Merk          : " + getMerk());
        System.out.println("  Tahun         : " + getTahunKeluaran());
        System.out.println("  Harga Sewa    : Rp." + String.format("%,.0f", getHargaSewa()) + "/hari");
        System.out.println("  Jumlah Pintu  : " + jumlahPintu);
        System.out.println("  Kapasitas CC  : " + mesin.getKapasitasCC() + " cc");
        System.out.println("  Tipe Mesin    : " + mesin.getTipeMesin());
        System.out.println("  Status        : " + (isTersedia() ? "Tersedia" : "Sedang Disewa"));
    }

    @Override
    public double hitungBiayaSewa(int lamaSewa, double diskon) {
        return (getHargaSewa() * lamaSewa) - diskon;
    }

    @Override
    public String getStrukSewa(int lamaSewa, double diskon) {
        double total = hitungBiayaSewa(lamaSewa, diskon);
        return "====== STRUK SEWA ======\n" +
               "Kendaraan  : Mobil " + getMerk() + "\n" +
               "Jumlah Pintu: " + jumlahPintu + "\n" +
               "Lama Sewa  : " + lamaSewa + " hari\n" +
               "Harga/hari : Rp." + String.format("%,.0f", getHargaSewa()) + "\n" +
               "Diskon     : Rp." + String.format("%,.0f", diskon) + "\n" +
               "Total      : Rp." + String.format("%,.0f", total) + "\n" +
               "========================";
    }
}
