# AsetOn-API

>Asset Management System

## Untuk Mulai

>Clone repo ini [AsetOn-API](https://github.com/babeguru/AsetOn-API.git).
```
git clone https://github.com/babeguru/AsetOn-API.git
```

## Lingkungan Pengembangan

>Dapat menggunakan Integrated Development Environment (IDE) dari Jetbrains yaitu [IntelliJ IDEA](https://www.jetbrains.com/idea/) Ultimate ataupun Community.

## Langkah Pembuatan
>Pertama, buat entitas terlebih dahulu. Contoh dalam hal ini adalah BARANG.
```
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long idBarang;
private String kodeBarang;
private String namaBarang;

// Getter and Setter
```

>Kedua, buat Data Access Object (DAO) atau Repository dengan mewariskan dari CrudRepository.
```
public interface BarangDAO extends CrudRepository<Barang, Long> {}
```

>Ketiga,buat Service (layanan) dari DAO tersebut yaitu untuk Create Read Update Delete (CRUD) dari entitas yang telah dibuat.
```
@Autowired
private BarangDAO barangDAO;

public Barang cekBarang(Long idBarang) {
    return barangDAO.findById(idBarang).get();
}

public Barang tambahBarang(Barang barang) {
    return barangDAO.save(barang);
}

public List<Barang> ambilBarang() { return barangDAO.findAll(); }

public void hapusBarang(Long idBarang) {
    barangDAO.deleteById(idBarang);
}

public Barang ubahBaranng(Long idBarang, Barang barang) {
    barang.setIdBarang(idBarang);
    return barangDAO.save(barang);
}
```

>Keempat, buat API untuk service (layanan) tersebut yaitu POST, GET, PUT dan DELETE disesuaikan dengan service (layanan) yang sudah ada.
```
@Autowired
private BarangService barangService;

@GetMapping("/{idBarang}")
public Barang cekBarang(@PathVariable("idBarang") Long idBarang) {
    return barangService.cekBarang(idBarang);
}

@PostMapping
public Barang tambahBarang(@RequestBody Barang barang) {
    return barangService.tambahBarang(barang);
}

@GetMapping
public List<Barang> ambilBarang() { return barangService.ambilBarang(); }

@DeleteMapping("/{idBarang}")
public void hapusBarang(@PathVariable("idBarang") Long idBarang) {
    barangService.hapusBarang(idBarang);
}

@PutMapping("/{idBarang}")
public Barang ubahBarang(@PathVariable("idBarang") Long idBarang, Barang barang) {
    return ubahBarang(idBarang, barang);
}
```

>Kelima, ulangi langkah pertama hingga keempat untuk semua entitas.

## Konsumsi Penggunaan

>Create (POST)
```
curl -d "{\"kodeBarang\":\"PR001\",\"namaBarang\":\"PRINTER\"}" -H "Content-Type: application/json" http://localhost:8080/barang
```

>Read (GET)
```
curl http://localhost:8080/barang
```

>Update (PUT)
```
curl -d "{\"kodeBarang\":\"PR002\",\"namaBarang\":\"PRINTER\"}" -H "Content-Type: application/json" -X PUT http://localhost:8080/barang/1
```

>Delete (DELETE)
```
curl -X DELETE http://localhost:8080/barang/1
```

## Koneksi Basisdata

>Konfigurasi basisdata pada environment sistem dengan url dari server lokal postgresql.
```
DATABASE_URL => postgres://<username>:<password>@localhost:5432/inventaris
```
>Jika menggunakan heroku maka secara otomatis akan dialokasikan oleh heroku.

## Donasi
>Jika anda merasa proyek ini membantu anda, jangan sungkan untuk mendukungnya dengan memberikan sedikit donasi.

[![PayPal](https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=6HBXH72JVPBSQ)
