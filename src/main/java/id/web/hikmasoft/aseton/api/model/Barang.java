package id.web.hikmasoft.aseton.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Barang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_barang;
    private String kode_barang;
    private String nama_barang;

    public Long getId_barang() {
        return id_barang;
    }

    public void setId_barang(Long id_barang) {
        this.id_barang = id_barang;
    }

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

}
