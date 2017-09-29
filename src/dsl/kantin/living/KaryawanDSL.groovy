package dsl.kantin.living


import dsl.kantin.container.StockAction
import dsl.kantin.container.StockDSL

class KaryawanDSL {

    //Handling Stock
    StockAction stockAction = StockAction.NONE
    String stockIngredient = ""

    def static menambah_stok(closure) {
        KaryawanDSL karyawanDSL = new KaryawanDSL()
        karyawanDSL.stockAction = StockAction.ADD
        closure.delegate = karyawanDSL
        closure()
        println("Stok berhasil ditambahkan")
    }

    def static mengambil_stok(closure) {
        KaryawanDSL karyawanDSL = new KaryawanDSL()
        karyawanDSL.stockAction = StockAction.SUBTRACT
        closure.delegate = karyawanDSL
        closure()
        println("Stok berhasil diambil")
    }

    def static membuang_stok(closure) {
        KaryawanDSL karyawanDSL = new KaryawanDSL()
        karyawanDSL.stockAction = StockAction.SUBTRACT
        closure.delegate = karyawanDSL
        closure()
        println("Stok berhasil dibuang")
    }

    def bahan(String bahan) {
        stockIngredient = bahan
    }

    def sebanyak(int jumlah) {
        if (stockAction == StockAction.ADD) {
            StockDSL.add(stockIngredient,jumlah)
        } else if (stockAction == StockAction.SUBTRACT) {
            StockDSL.remove(stockIngredient,jumlah)
        }
    }

}
