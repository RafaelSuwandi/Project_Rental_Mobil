package Suhu.Suhu_Elo.Studycase_3;

public class Motor extends Kendaraan {
    private String jenisTransmisi;
    private Mesin  mesin;

    // Constructor lengkap
    public Motor(String merk, int tahunKeluaran, double hargaSewa,
                 String jenisTransmisi, Mesin mesin) {
        super(merk, tahunKeluaran, hargaSewa, "Motor");
        this.jenisTransmisi = jenisTransmisi;
        this.mesin          = mesin;
    }

    // Overload constructor — tanpa detail mesin, transmisi default "Manual"
    public Motor(String merk, int tahunKeluaran, double hargaSewa) {
        super(merk, tahunKeluaran, hargaSewa, "Motor");
        this.jenisTransmisi = "Manual";
        this.mesin          = new Mesin(110); // default 110cc
    }

    public String getJenisTransmisi() { return jenisTransmisi; }

    @Override
    public void tampilkanInfo() {
        System.out.println("  Tipe          : Motor");
        System.out.println("  Merk          : " + getMerk());
        System.out.println("  Tahun         : " + getTahunKeluaran());
        System.out.println("  Harga Sewa    : Rp." + String.format("%,.0f", getHargaSewa()) + "/hari");
        System.out.println("  Transmisi     : " + jenisTransmisi);
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
               "Kendaraan  : Motor " + getMerk() + "\n" +
               "Transmisi  : " + jenisTransmisi + "\n" +
               "Lama Sewa  : " + lamaSewa + " hari\n" +
               "Harga/hari : Rp." + String.format("%,.0f", getHargaSewa()) + "\n" +
               "Diskon     : Rp." + String.format("%,.0f", diskon) + "\n" +
               "Total      : Rp." + String.format("%,.0f", total) + "\n" +
               "========================";
    }
}
