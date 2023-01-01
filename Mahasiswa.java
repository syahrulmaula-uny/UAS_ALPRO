// Kelas Mahasiswa untuk menyimpan data nama, NIM, dan jurusan
class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;
    
    public void setNim(String nim){
        this.nim = nim;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setJurusan(String jurusan){
        this.jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    @Override
    public String toString() {
        return "Mahasiswa{nama='" + nama + "', nim='" + nim + "', jurusan='" + jurusan + "'}";
    }
}