package dsl.kantin.container

class StockDSLTest extends GroovyTestCase {
    void testStockDSL() {

        StockDSL.update {
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

        StockDSL.print()
    }
}