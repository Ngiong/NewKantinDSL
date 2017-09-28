package dsl.kantin.living

import dsl.kantin.container.StockAction
import dsl.kantin.container.StockDSL

class KaryawanDSL {

    //Handling Stock
    StockAction stockAction = StockAction.NONE
    String stockIngredient = ""

    def static menambah_stock(closure) {
        KaryawanDSL karyawanDSL = new KaryawanDSL()
        karyawanDSL.stockAction = StockAction.ADD
        closure.delegate = karyawanDSL
        closure()
    }

    def static mengambil_stock(closure) {
        KaryawanDSL karyawanDSL = new KaryawanDSL()
        karyawanDSL.stockAction = StockAction.SUBTRACT
        closure.delegate = karyawanDSL
        closure()
    }

    def bahan_bernama(String bahan) {
        stockIngredient = bahan
    }

    def di_tempat_penyimpanan_sebanyak(int jumlah) {
        if (stockAction == StockAction.ADD) {
            StockDSL.add(stockIngredient, jumlah)
        } else if (stockAction == StockAction.SUBTRACT) {
            StockDSL.subtract(stockIngredient, jumlah)
        }
    }
}
