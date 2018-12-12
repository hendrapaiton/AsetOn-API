package id.web.hikmasoft.aseton.api.service;

import id.web.hikmasoft.aseton.api.dao.BarangDAO;
import id.web.hikmasoft.aseton.api.exception.BarangExistException;
import id.web.hikmasoft.aseton.api.exception.BarangNotFoundException;
import id.web.hikmasoft.aseton.api.model.Barang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BarangService {

    @Autowired
    private BarangDAO barangDAO;

    public Barang cekBarang(Long id_barang) {
        Optional<Barang> optionalBarang = barangDAO.findById(id_barang);
        if (!optionalBarang.isPresent())
            throw new BarangNotFoundException("Barang tidak ditemukan...");
        return optionalBarang.get();
    }

    public Barang tambahBarang(Barang barang) {
        if(!barangDAO.findByKodeBarangOrNamaBarang(barang.getKode_barang(), barang.getNama_barang()).isEmpty())
            throw new BarangExistException("Barang sudah tersedia...");
        return barangDAO.save(barang);
    }

    public List<Barang> ambilBarang() {
        return barangDAO.findAll();
    }

    public void hapusBarang(Long id_barang) {
        Optional<Barang> optionalBarang = barangDAO.findById(id_barang);
        if (!optionalBarang.isPresent())
            throw new BarangNotFoundException("Barang tidak ditemukan...");
        barangDAO.deleteById(id_barang);
    }

    public Barang ubahBarang(Long id_barang, Barang barang) {
        Optional<Barang> optionalBarang = barangDAO.findById(id_barang);
        if (!optionalBarang.isPresent())
            throw new BarangNotFoundException("Barang tidak ditemukan...");
        barang.setId_barang(id_barang);
        return barangDAO.save(barang);
    }

}
