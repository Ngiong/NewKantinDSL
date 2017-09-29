package dsl.kantin.living

import dsl.kantin.container.MenuDictionaryDSL
import dsl.kantin.container.StockDSL
import dsl.kantin.container.RecipeDictionaryDSL
import dsl.kantin.transactional.OrderDSL

class KokiDSLTest extends GroovyTestCase{
    void testKokiDSL() {
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

        RecipeDictionaryDSL.update {
            menu "Nasi Goreng"
            menggunakan_bahan "beras"
            sebanyak 5
            menggunakan_bahan "cabe"
            sebanyak 4
            menggunakan_bahan "bawang"
            sebanyak 2
            menggunakan_bahan "telur"
            sebanyak 1

            menu "Nasi Putih"
            menggunakan_bahan "beras"
            sebanyak 5
        }

        MenuDictionaryDSL.init {
            tambah "Nasi Goreng"
            harga 10000

            tambah "Nasi Putih"
            harga 3000

            selesai()
        }

        def order = OrderDSL.Pesan {
            tambah (2,"Nasi Goreng")
            tambah (3, "Nasi Putih")
            batal (1, "Nasi Putih")
            batal (1, "Nasi Goreng")
            DineIn()
        }

        KokiDSL.mengerjakan {
            order_terdepan()
        }
    }
}
