package Suhu.Suhu_Elo.Studycase_3;

public abstract class Kendaraan implements Rentable, Displayable {
    private String merk;
    private int tahunKeluaran;
    private double hargaSewa;
    private String tipe;
    private boolean tersedia;

    public Kendaraan(String merk, int tahunKeluaran, double hargaSewa, String tipe) {
        this.merk = merk;
        this.tahunKeluaran = tahunKeluaran;
        this.hargaSewa = hargaSewa;
        this.tipe = tipe;
        this.tersedia = true; // default tersedia saat baru ditambah
    }

    public String getTipe()         { return tipe; }
    public String getMerk()         { return merk; }
    public double getHargaSewa()    { return hargaSewa; }
    public int getTahunKeluaran()   { return tahunKeluaran; }
    public boolean isTersedia()     { return tersedia; }
    public void setTersedia(boolean tersedia) { this.tersedia = tersedia; }

    // Abstract — wajib di-override subclass
    @Override
    public abstract void tampilkanInfo();

    @Override
    public abstract double hitungBiayaSewa(int lamaSewa, double diskon);

    @Override
    public abstract String getStrukSewa(int lamaSewa, double diskon);
}
