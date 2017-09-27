package dsl.kantin.container

import dsl.kantin.living.PelangganDSL;

class AntrianDSLTest extends GroovyTestCase {
    void testAntrianDSL() {
        PelangganDSL.datanglah {
            nama "Robert"
            adalah_seorang "Mahasiswa"
            cowok()
            dengan_isi_dompet 100000
            mulai_mengantri()
        }

        int beforePopSize = AntrianDSL.hitung_panjang_antrian()
        assert(beforePopSize == 1)

        AntrianDSL.keluarkan_dari_antrian()
        int afterPopSize = AntrianDSL.hitung_panjang_antrian()
        assert(afterPopSize == 0)
    }
}