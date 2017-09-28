package dsl.kantin.Order

import dsl.kantin.living.Gender
import dsl.kantin.living.PelangganDSL

class OrderDSLTest extends GroovyTestCase{
    void testOrderDSL() {
        def robert = new PelangganDSL(
                name: 'Robert',
                gender: Gender.MALE,
                occupation: 'Mahasiswa',
                walletBalance: 100000
        )

        robert.melakukan_pemesanan("Soto")
        robert.melakukan_pemesanan("Susu")

        int count = OrderDSL.semua_order()
        assert(count == 2)
    }
}
