
package Model;

public class Kegiatan {
    private Integer id_kegiatan;
    private String nama;
    private String jenis;
    
    // Getters and Setters
    public Kegiatan() {
    }

    public Kegiatan(int id_kegiatan, String nama, String jenis) {
        this.id_kegiatan = id_kegiatan;
        this.nama = nama;
        this.jenis = jenis;
    }

    public int getIdkegiatan() {
        return id_kegiatan;
    }

    public void setIdkegiatan(int id_kegiatan) {
        this.id_kegiatan = id_kegiatan;
    }

    public String getNamaKegiatan() {
        return nama;
    }

    public void setNamaKegiatan(String nama) {
        this.nama = nama;
    }

    public String getJenisKegiatan() {
        return jenis;
    }

    public void setJenisKegiatan(String jenis) {
        this.jenis = jenis;
    }
}
