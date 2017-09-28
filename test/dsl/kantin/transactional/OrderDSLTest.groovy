package dsl.kantin.transactional

import dsl.kantin.living.Gender
import dsl.kantin.living.PelangganDSL

class OrderDSLTest extends GroovyTestCase{
    void testOrderDSL() {
        PelangganDSL.datanglah {
            nama "Robert"
            adalah_seorang "Mahasiswa"
            cowok()
            dengan_isi_dompet 100000
            mulai_mengantri()
        }

        def order = OrderDSL.Pesan {
            tambah (2,"Nasi Goreng")
            tambah (1, "Nasi Putih")
            batal (1, "Nasi Putih")
            batal (1, "Nasi Goreng")
            DineIn()
        }

        assert(OrderDSL.count == 1)
        assert(OrderDSL.pesanan.get("Nasi Goreng") == 1)
        assert(OrderDSL.pesanan.get("Nasi Putih") == null)
        assert(OrderDSL.makanditempat == true)
        assert(OrderDSL.bungkus == false)
    }
}
