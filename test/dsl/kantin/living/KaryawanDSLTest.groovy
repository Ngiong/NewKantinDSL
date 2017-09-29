package dsl.kantin.living

import dsl.kantin.container.StockDSL

class KaryawanDSLTest extends GroovyTestCase {
    void testKaryawanDSL() {

        KaryawanDSL.menambah_stok{
            bahan "kucing"
            sebanyak 10
        }
        println();

        KaryawanDSL.menambah_stok{
            bahan "kucing"
            sebanyak 5
        }
        println();

        KaryawanDSL.mengambil_stok{
            bahan "kucing"
            sebanyak 12
        }
        println();

        StockDSL.print()
    }
}