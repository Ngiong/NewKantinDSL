package dsl.kantin.living;

class PelangganDSLTest extends GroovyTestCase {
    void testPelangganDSL() {
        PelangganDSL.datanglah {
            nama "Robert"
            adalah_seorang "Mahasiswa"
            cowok()
            dengan_isi_dompet 100000
            mulai_mengantri()
        }
    }
}