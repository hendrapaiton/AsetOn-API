package id.web.hikmasoft.aseton.api.api;

import id.web.hikmasoft.aseton.api.model.Barang;
import id.web.hikmasoft.aseton.api.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/barang")
public class BarangResource {

    @Autowired
    private BarangService barangService;

    @GetMapping(value = "/{id_barang}")
    public Barang cekBarang(@PathVariable("id_barang") Long id_barang) {
        return barangService.cekBarang(id_barang);
    }

    @PostMapping
    public Barang tambahBarang(@RequestBody Barang barang) {
        return barangService.tambahBarang(barang);
    }

    @GetMapping
    public List<Barang> ambilBarang() {
        return barangService.ambilBarang();
    }

    @DeleteMapping(value = "/{id_barang}")
    public void hapusBarang(@PathVariable("id_barang") Long id_barang) {
        barangService.hapusBarang(id_barang);
    }

    @PutMapping(value = "/{id_barang}")
    public Barang ubahBarang(@PathVariable("id_barang") Long id_barang, @RequestBody Barang barang) {
        return barangService.ubahBarang(id_barang, barang);
    }
}
