package Model;

public class Diary {
    private int id_diary;
    private String judul;
    private String isi;
    public int id_login;
    
    public Diary(int id_diary, String judul, String isi, int id_login) {
        this.id_diary = id_diary;
        this.judul = judul;
        this.isi = isi;
        this.id_login = id_login;
    }
    
    public Diary(String judul, String isi, int id_login) {
        this.judul = judul;
        this.isi = isi;
        this.id_login = id_login;
    }

    // Getters and Setters
    public int getIdDiary() {
        return id_diary;
    }

    public void setIdDiary(int id_diary) {
        this.id_diary = id_diary;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public int getIdUser() {
        return id_login;
    }

    public void setIdUser(int id_login) {
        this.id_login = id_login;
    }
}
