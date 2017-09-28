package dsl.kantin.living

import dsl.kantin.transactional.OrderDSL
import dsl.kantin.container.AntrianDSL

class PelangganDSL {
    String name
    Gender gender
    String occupation
    long walletBalance

    def static datanglah (closure) {
        PelangganDSL pelangganDSL = new PelangganDSL()
        closure.delegate = pelangganDSL
        closure()
    }

    def nama (String name) {
        this.name = name
    }

    def cowok () {
        this.gender = Gender.MALE
    }

    def cewek () {
        this.gender = Gender.FEMALE
    }

    def adalah_seorang (String occupation) {
        this.occupation = occupation
    }

    def dengan_isi_dompet (long balance) {
        this.walletBalance = balance
    }

    def mulai_mengantri () {
        println(this.name + " masuk antrian.")
        AntrianDSL.masuk_antrian(this)
    }

    def melakukan_pemesanan(menu) {
        println(this.name + " memesan " + menu)
        OrderDSL.pesan(this.name, menu)
    }

}