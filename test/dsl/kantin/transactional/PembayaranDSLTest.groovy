package dsl.kantin.transactional

class PembayaranDSLTest extends GroovyTestCase {
    void testPembayaranDSL() {
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