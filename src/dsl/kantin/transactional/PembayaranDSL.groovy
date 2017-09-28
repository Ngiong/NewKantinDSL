package dsl.kantin.transactional

class PembayaranDSL {
    OrderDSL order
    long payment
    long change

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
        cetak_detail_pembayaran()
        return this
    }

    def cetak_detail_pembayaran () {
        println("\nPembayaran order")
        this.order.cetak_detail_pesanan()
        println("dengan uang tunai sejumlah Rp. " + payment + ",-")
        hitung_kembalian()
    }

    def hitung_kembalian () {
        change = (payment > OrderDSL.total) ? payment - OrderDSL.total : 0
        if (payment < OrderDSL.total)
            println("Uang yang dibayarkan belum mencukupi")

        println("Kelebihan uang yang dikembalikan: Rp. " + change + ",-")
    }
}