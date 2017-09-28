package dsl.kantin.container

@Singleton
class StockDSL {
    static def stock = [:]

    //ntar kl ada yg butuh stock terisi buat testing
    static def initStock() {
        stock['telur'] = 92
        stock['daging ayam'] = 36
        stock['beras'] = 34
        stock['cabe'] = 67
        stock['timun'] = 25
        stock['kubis'] = 84
        stock['jamur'] = 25
        stock['daging sapi'] = 35
        stock['santan'] = 36
        stock['bawang'] = 75
    }

    static def add(bahan, jumlah) {
        if (bahan != "") {
            if (stock.containsKey(bahan)) {
                stock[bahan] = stock[bahan] + jumlah
            } else {
                stock.put(bahan, jumlah)
            }
            println("Berhasil menambahkan stok")
            println("Stok " + bahan+ " saat ini sebanyak " + stock[bahan].toString())
        }
    }

    static def subtract(bahan, jumlah) {
        if (bahan != "") {
            if (stock.containsKey(bahan)) {
                if (stock[bahan] > jumlah) {
                    stock[bahan] = stock[bahan] - jumlah
                    println("Berhasil mengeluarkan stok")
                    println("Stok " + bahan + " saat ini sebanyak " + stock[bahan].toString())
                } else if (stock[bahan] == jumlah) {
                    stock.remove(bahan)
                    println("Berhasil mengeluarkan stok")
                    println("Stok " + bahan+ " saat ini sebanyak 0")
                } else {
                    println("Tidak bisa mengeluarkan bahan dari stok")
                    println("Jumlah yang ingin dikeluarkan lebih dari jumlah yang tersedia")
                    println("Stok " + bahan + " saat ini sebanyak " + stock[bahan].toString())
                    println("Banyak " + bahan + " yang ingin dikeluarkan dari stok sebanyak " + jumlah.toString())
                }
            } else {
                println("Tidak bisa mengeluarkan bahan dari stok")
                println("Jumlah yang ingin dikeluarkan lebih dari jumlah yang tersedia")
                println("Stok " + bahan + " saat ini sebanyak 0")
                println("Banyak " + bahan + " yang ingin dikeluarkan dari stok sebanyak " + jumlah.toString())
            }
        } else {
            println("Bahan apa?")
        }
    }

    static def getStockAmmount(bahan) {
        if (stock.containsKey(bahan)) {
            return stock[bahan]
        } else {
            return 0
        }
    }
}
