package dsl.kantin.transactional

import dsl.kantin.container.MenuDictionaryDSL

class PembayaranDSLTest extends GroovyTestCase {
    void testPembayaranDSL() {
        MenuDictionaryDSL.init {
            tambah "Nasi Goreng"
            harga 10000

            tambah "Es Teh Manis"
            harga 2000

            tambah "Nasi Putih"
            harga 3000

            selesai()
        }

        def myOrder = OrderDSL.Pesan {
            tambah (2, "Nasi Goreng")
            tambah (1, "Nasi Putih")
            DineIn()
        }

        def myPayment = PembayaranDSL.lakukan {
            order myOrder
            dibayar_sejumlah 100000
            tunai()
        }

        myPayment.cetak_detail_pembayaran()
    }
}