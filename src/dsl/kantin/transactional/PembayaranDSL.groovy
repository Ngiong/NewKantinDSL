package dsl.kantin.transactional

class PembayaranDSL {
    OrderDSL order
    long payment

    static def lakukan (closure) {
        PembayaranDSL pembayaranDSL = new PembayaranDSL()
        closure.delegate = pembayaranDSL
        closure()
    }

    def order (OrderDSL order) {
        this.order = order
    }

    def dibayar_sejumlah (long payment) {
        this.payment = payment
    }

    def tunai () {
        return this
    }

    def cetak_detail_pembayaran () {
        println("\nPembayaran order")
        this.order.cetak_detail_pesanan()
        println("dengan uang tunai sejumlah Rp. " + payment + ",-")
    }
}