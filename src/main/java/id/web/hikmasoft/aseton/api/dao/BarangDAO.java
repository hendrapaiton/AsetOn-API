package id.web.hikmasoft.aseton.api.dao;

import id.web.hikmasoft.aseton.api.model.Barang;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarangDAO extends CrudRepository<Barang, Long> {

    @Override
    List<Barang> findAll();

    List<Barang> findByKodeBarangOrNamaBarang(String kodeBarang, String namaBarang);

}
