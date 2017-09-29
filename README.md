# Kantin DSL dengan Groovy

> IF4150 - Rekayasa Perangkat Lunak Spesifik Domain  
> **(K1) Kelompok 10**:
> - Cendhika Imantoro (**13514037**)
> - Varian Caesar (**13514041**)
> - Robert Sebastian Herlim (**13514061**)

----
## **Table of Content**
- [**I. Definisi Kantin**](#i-definisi-kantin)
- [**II. Daftar Entitas/Kelas**](#ii-daftar-entitaskelas)
- [**III. Penggunaan**](#iii-penggunaan)
    - [1. Mendefinisikan pelanggan](#1-mendefinisikan-pelanggan)
    - [2. Mendefinisikan kasir](#2-mendefinisikan-kasir)
    - [3. Mendefinisikan menu](#3-mendefinisikan-menu)
    - [4. Mendefinisikan resep](#4-mendefinisikan-resep)
    - [5. Mendefinisikan stok](#5-mendefinisikan-stok)
    - [6. Mendefinisikan pesanan](#6-mendefinisikan-pesanan)
    - [7. Menambah/mengurangi stok](#7-menambahmengurangi-stok)
    - [8. Menyiapkan pesanan](#8-menyiapkan-pesanan)
    - [9. Melakukan pembayaran](#9-melakukan-pembayaran)

----

## **I. Definisi Kantin**
Kantin adalah sebuah ruangan dalam sebuah gedung umum yang dapat digunakan pengunjungnya untuk makan, baik makanan yang dibawa sendiri maupun yang dibeli di sana. Kantin sendiri harus mengikuti prosedur tentang cara mengolah dan menjaga kebersihan kantin. Makanan yang disediakan kantin haruslah bersih dan halal. Jenis-jenis makanan yang disediakan pun minimal harus memenuhi 4 sehat 5 sempurna. Biasanya para pembeli harus mengantri dalam sebuah jalur yang disediakan untuk membeli makanan.

## **II. Daftar Entitas/Kelas**
Daftar entitas dan kelas pada *domain specific language* ini diuraikan pada tabel berikut.

| No  | Nama Entitas | Nama DSL            | Package                    |
| --- | ------------ | ------------------- | -------------------------- |
| 1.  | Pelanggan    | PelangganDSL        | `dsl.kantin.living`        |
| 2.  | Kasir        | KasirDSL            | `dsl.kantin.living`        |
| 3.  | Karyawan     | KaryawanDSL         | `dsl.kantin.living`        |
| 4.  | Koki         | KokiDSL             | `dsl.kantin.living`        |
| 5.  | Order        | OrderDSL            | `dsl.kantin.transactional` |
| 6.  | Pembayaran   | PembayaranDSL       | `dsl.kantin.transactional` |
| 7.  | Antrian      | AntrianDSL          | `dsl.kantin.container`     |
| 8.  | Menu         | MenuDictionaryDSL   | `dsl.kantin.container`     |
| 9.  | Buku Resep   | RecipeDictionaryDSL | `dsl.kantin.container`     |
| 10. | Stok         | StockDSL            | `dsl.kantin.container`     |

Deskripsi untuk tiap entitas dapat dilihat pada tabel berikut.

| No  | Nama Entitas | Deskripsi                                                                                      |
| --- | ------------ | ---------------------------------------------------------------------------------------------- |
| 1.  | Pelanggan    | Entitas *lapar* yang mengunjungi kantin untuk mengisi perutnya.                                |
| 2.  | Kasir        | Petugas kantin yang bertugas menerima pembayaran dari `Pelanggan`.                             |
| 3.  | Karyawan     | Petugas kantin yang bertugas mengatur stok bahan baku di kantin.                               |
| 4.  | Koki         | Petugas kantin yang bertugas untuk menyiapkan pesanan, mengubah bahan baku menjadi barang jadi |
| 5.  | Order        | Pesanan-pesanan `Pelanggan` beserta jumlahnya dan metode pemesanannya (*dinein / takeaway*).   |
| 6.  | Pembayaran   | Detail pembayaran dari sebuah `Order` yang dilakukan `Pelanggan`.                              |
| 7.  | Antrian      | Kontainer yang digunakan untuk merepresentasikan antrian di kantin.                            |
| 8.  | Menu         | Kamus yang berisi jenis-jenis makanan beserta harganya yang dijual di kantin.                  |
| 9.  | Buku Resep   | Kamus yang berisi bahan-bahan yang diperlukan untuk membuat pesanan.                           |
| 10. | Stok         | Kontainer yang digunakan untuk menyimpan informasi jumlah stok yang tersedia.                  |

## **III. Penggunaan**
### 1. Mendefinisikan pelanggan
```
def robert = PelangganDSL.datanglah {
    nama "Robert"
    adalah_seorang "Mahasiswa"
    cowok()
    dengan_isi_dompet 100000
    mulai_mengantri()
}
```

### 2. Mendefinisikan kasir
```
KasirDSL.recruit {
    nama "Amanda"
    usia 20
    cewek()
}
```

### 3. Mendefinisikan menu
```
MenuDictionaryDSL.init {
    tambah "Nasi Goreng"
    harga 10000

    tambah "Es Teh Manis"
    harga 2000

    tambah "Nasi Putih"
    harga 3000

    selesai()
}
```

### 4. Mendefinisikan resep
```
RecipeDictionaryDSL.update {
    menu "Nasi Goreng"

    menggunakan_bahan "beras"
    sebanyak 1

    menggunakan_bahan "cabe"
    sebanyak 4

    menggunakan_bahan "bawang"
    sebanyak 2

    menggunakan_bahan "telur"
    sebanyak 1
}
```

### 5. Mendefinisikan stok
```
StockDSL.update {
    bahan "beras"
    ada_sebanyak 100

    bahan "telur"
    ada_sebanyak 10

    bahan "cabe"
    ada_sebanyak 20

    bahan "bawang"
    ada_sebanyak 10

    bahan "cabe"
    ditambah_sebanyak 10

    bahan "telur"
    diambil_sebanyak 5
}
```

### 6. Mendefinisikan pesanan
```
def myOrder = OrderDSL.Pesan {
    tambah (2,"Nasi Goreng")
    tambah (1, "Nasi Putih")
    batal (1, "Nasi Putih")
    DineIn()
}
```

### 7. Menambah/mengurangi stok
```
KaryawanDSL.menambah_stok{
    bahan "kucing"
    sebanyak 10
}

KaryawanDSL.mengambil_stok{
    bahan "kucing"
    sebanyak 5
}
```

### 8. Menyiapkan pesanan
```
KokiDSL.mengerjakan {
    order_terdepan()
}
```

### 9. Melakukan pembayaran
```
robert.melakukan_pembayaran(myOrder, payment)
```