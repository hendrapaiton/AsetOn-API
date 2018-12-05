package id.web.hikmasoft.aseton.api.service;

import id.web.hikmasoft.aseton.api.dao.BarangDAO;
import id.web.hikmasoft.aseton.api.model.Barang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BarangService {

    @Autowired
    private BarangDAO barangDAO;

    public Barang cekBarang(Long id_barang) {
        return barangDAO.findById(id_barang).get();
    }

    public Barang tambahBarang(Barang barang) {
        return barangDAO.save(barang);
    }

    public List<Barang> ambilBarang() {
        return barangDAO.findAll();
    }

    public void hapusBarang(Long id_barang) {
        barangDAO.deleteById(id_barang);
    }

    public Barang ubahBarang(Long id_barang, Barang barang) {
        barang.setId_barang(id_barang);
        return barangDAO.save(barang);
    }

}
