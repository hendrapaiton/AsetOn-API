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

    @GetMapping(value = "/{idBarang}")
    public Barang cekBarang(@PathVariable("idBarang") Long idBarang) {
        return barangService.cekBarang(idBarang);
    }

    @PostMapping
    public Barang tambahBarang(@RequestBody Barang barang) {
        return barangService.tambahBarang(barang);
    }

    @GetMapping
    public List<Barang> ambilBarang() {
        return barangService.ambilBarang();
    }

    @DeleteMapping(value = "/{idBarang}")
    public void hapusBarang(@PathVariable("idBarang") Long idBarang) {
        barangService.hapusBarang(idBarang);
    }

    @PutMapping(value = "/{idBarang}")
    public Barang ubahBarang(@PathVariable("idBarang") Long idBarang, @RequestBody Barang barang) {
        return barangService.ubahBarang(idBarang, barang);
    }
}
