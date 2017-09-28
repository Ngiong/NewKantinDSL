package dsl.kantin.transactional

import dsl.kantin.container.MenuDictionaryDSL

class OrderDSL {
    static def pesanan = [:]
    static int count = 0
    static boolean makanditempat, bungkus

    def static Pesan(closure){
        OrderDSL order = new OrderDSL()
        closure.delegate = order
        closure()
    }

    def tambah(jumlah, produk) {
        println("Dapat pesanan : " + produk + " x" + jumlah)
        if(pesanan.containsValue(produk)) {
            int total = (int)pesanan.get(produk)
            pesanan.replace(produk, total, total+1)
        } else
            pesanan.put(produk, jumlah)
        count += jumlah
    }

    def batal(jumlah, produk) {
        println("Pesanan batal : " + produk + " x" + jumlah)
        int total = (int) pesanan.get(produk)
        if(total > 1){
            pesanan.replace(produk, total, total-1)
        } else {
            pesanan.remove(produk)
        }
        count -= jumlah
    }

    def DineIn() {
        this.makanditempat = true
        this.bungkus = false
        return this
    }

    def TakeAway() {
        this.makanditempat = false
        this.bungkus = true
        return this
    }

    def cetak_detail_pesanan() {
        def total = 0
        for (key in pesanan.keySet()) {
            def subtotal = (int) pesanan.get(key) * MenuDictionaryDSL.getPrice(key)
            println("[*]" + String.format("%30s", (int) pesanan.get(key) + "x " + key) + " | Rp. " + subtotal + ",-")
        }
        println("\n" + String.format("%36s", "TOTAL | ") + "Rp. " + total + ",-")
    }
}
