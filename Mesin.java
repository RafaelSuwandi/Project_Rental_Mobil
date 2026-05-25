package Suhu.Suhu_Elo.Studycase_3;

public class Mesin {
    private int kapasitasCC;
    private String tipeMesin;

    // Constructor lengkap
    public Mesin(int kapasitasCC, String tipeMesin) {
        this.kapasitasCC = kapasitasCC;
        this.tipeMesin   = tipeMesin;
    }

    // Overload constructor — hanya CC, tipeMesin default "Standar"
    public Mesin(int kapasitasCC) {
        this.kapasitasCC = kapasitasCC;
        this.tipeMesin   = "Standar";
    }

    public int    getKapasitasCC() { return kapasitasCC; }
    public String getTipeMesin()   { return tipeMesin; }
}
