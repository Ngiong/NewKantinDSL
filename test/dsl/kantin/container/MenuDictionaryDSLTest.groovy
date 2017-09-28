package dsl.kantin.container

class MenuDictionaryDSLTest extends GroovyTestCase {
    void testMenuDictionaryDSL() {
        MenuDictionaryDSL.init {
            tambah "Nasi Goreng"
            harga 10000

            tambah "Es Teh Manis"
            harga 2000

            tambah "Nasi Putih"
            harga 3000

            selesai()
        }

        MenuDictionaryDSL.tampilkan()
    }
}