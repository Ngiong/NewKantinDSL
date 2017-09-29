package dsl.kantin.living

import dsl.kantin.container.RecipeDictionaryDSL
import dsl.kantin.container.StockAction
import dsl.kantin.container.StockDSL
import dsl.kantin.transactional.OrderDSL

class KokiDSL {

    static def mengerjakan(closure) {
        KokiDSL kokiDSL = new KokiDSL()
        closure.delegate = kokiDSL
        closure()
    }

    def order_terdepan() {
        OrderDSL.pesanan.each {
            k,v -> this.memasak(k, v)
        }
    }

    def memasak(menu, jumlah) {
        for (int i = 0; i < jumlah; i++) {
            def recipe = RecipeDictionaryDSL.getRecipe(menu)
            recipe.each {
                k, v ->
                    StockDSL.remove(k, v)
            }
        }
        println("Selesai memasak " + menu + " sejumlah " + jumlah + " porsi")
    }
}
