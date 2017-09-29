package dsl.kantin.container

class StockDSL {
    def stock = [:]
    def String bahan
    static def instance

    //init
    static def update(closure) {
        if (instance == null) instance = new StockDSL()
        def stockDSL = instance
        closure.delegate = stockDSL
        closure()
    }

    def bahan(target_bahan) {
        bahan = target_bahan
    }

    def ada_sebanyak(jumlah) {
        if (bahan == null) throw Exception("Bahan apa?")
        stock[bahan] = jumlah
    }

    def diambil_sebanyak(jumlah) {
        if (bahan == null) throw IllegalStateException("Bahan apa?")
        if (jumlah == 0) {
            println(bahan + " sebanyak " + jumlah.toString() + " berhasil diambil")
        } else if (jumlah < 0) {
            throw IllegalStateException("Jumlah yang diambil tidak boleh negatif")
        } else if (stock.containsKey(bahan)) {
            if (stock[bahan] > jumlah) {
                stock[bahan] = stock[bahan] - jumlah
                println(bahan + " sebanyak " + jumlah.toString() + " berhasil diambil")
            } else if (stock[bahan] == jumlah) {
                stock.remove(bahan)
                println(bahan + " sebanyak " + jumlah.toString() + " berhasil diambil")
            } else {
                throw IllegalStateException("Jumlah " + bahan + " di stok kurang dari yang ingin diambil")
            }
        } else {
            throw NoSuchElementException("Tidak ada bahan bernama " + bahan + " di stok")
        }
    }

    def ditambah_sebanyak(jumlah) {
        if (bahan == null) throw IllegalStateException("Bahan apa?")
        if (stock.containsKey(bahan)) {
            stock[bahan] = stock[bahan] + jumlah
            println(bahan + " sebanyak " + jumlah.toString() + " berhasil ditambahkan")
        } else {
            stock[bahan] = jumlah
            println(bahan + " sebanyak " + jumlah.toString() + " berhasil ditambahkan")
        }
    }

    static def getStockAmmount(bahan) {
        if (instance == null) instance = new StockDSL()
        if (instance.stock.containsKey(bahan)) {
            return instance.stock[bahan]
        } else {
            return 0
        }
    }

    static def print() {
        if (instance == null) instance = new StockDSL()
        println("Di stok terdapat  :")
        instance.stock.each {
            k, v ->
                println("  " + v.toString() + " " + k)
        }
    }

    static add(target_bahan, jumlah) {
        update{
            bahan(target_bahan)
            ditambah_sebanyak(jumlah)
        }
    }

    static remove(target_bahan, jumlah) {
        update{
            bahan(target_bahan)
            diambil_sebanyak(jumlah)
        }
    }

}
