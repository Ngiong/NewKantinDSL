package dsl.kantin.container

import dsl.kantin.living.KaryawanDSL


class StockDSLTest extends GroovyTestCase {
    void testStockDSL() {

        StockDSL.initStock()
        println(StockDSL.stock)
        println()

        KaryawanDSL.menambah_stock{
            bahan_bernama "kucing"
            di_tempat_penyimpanan_sebanyak 10
        }
        assert(StockDSL.getStockAmmount('kucing')== 10)

        println();

        KaryawanDSL.menambah_stock{
            bahan_bernama "kucing"
            di_tempat_penyimpanan_sebanyak 5
        }
        assert(StockDSL.getStockAmmount('kucing') == 15)

        println();

        KaryawanDSL.mengambil_stock{
            bahan_bernama "kucing"
            di_tempat_penyimpanan_sebanyak 16
        }
        assert(StockDSL.getStockAmmount('kucing') == 15)

        println();

        KaryawanDSL.mengambil_stock{
            bahan_bernama "kucing"
            di_tempat_penyimpanan_sebanyak 10
        }
        assert(StockDSL.getStockAmmount('kucing') == 5)

        println();

        KaryawanDSL.mengambil_stock{
            bahan_bernama "kucing"
            di_tempat_penyimpanan_sebanyak 5
        }
        assert(StockDSL.getStockAmmount('kucing') == 0)
        assert(!StockDSL.stock.containsKey('kucing'))

        println();

        KaryawanDSL.mengambil_stock{
            bahan_bernama "kucing"
            di_tempat_penyimpanan_sebanyak 5
        }
        assert(StockDSL.getStockAmmount('kucing') == 0)
        assert(!StockDSL.stock.containsKey('kucing'))
    }
}