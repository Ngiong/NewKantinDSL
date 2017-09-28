package dsl.kantin.living

import dsl.kantin.container.MenuDictionaryDSL
import dsl.kantin.transactional.OrderDSL;

class PelangganDSLTest extends GroovyTestCase {
    void testPelangganDSL() {
        PelangganDSL.datanglah {
            nama "Robert"
            adalah_seorang "Mahasiswa"
            cowok()
            dengan_isi_dompet 100000
            mulai_mengantri()
        }
    }

    void testPembayaran() {
        MenuDictionaryDSL.init {
            tambah "Nasi Goreng"
            harga 10000

            tambah "Es Teh Manis"
            harga 2000

            tambah "Nasi Putih"
            harga 3000

            selesai()
        }

        def robert = PelangganDSL.datanglah {
            nama "Robert"
            adalah_seorang "Mahasiswa"
            cowok()
            dengan_isi_dompet 100000
            mulai_mengantri()
        }

        def order = OrderDSL.Pesan {
            tambah (2,"Nasi Goreng")
            tambah (1, "Nasi Putih")
            DineIn()
        }

        def change = robert.melakukan_pembayaran(order, 50000)
        assert (change == 50000 - 23000)
        assert (robert.walletBalance == 100000 - 50000 + change)

    }
}