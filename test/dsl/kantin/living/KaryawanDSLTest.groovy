package dsl.kantin.living

class KaryawanDSLTest extends GroovyTestCase {
    void testKaryawanDSL() {

        KaryawanDSL.menambah_stock{
            bahan_bernama "kucing"
            di_tempat_penyimpanan_sebanyak 10
        }
        println();

        KaryawanDSL.menambah_stock{
            bahan_bernama "kucing"
            di_tempat_penyimpanan_sebanyak 5
        }
        println();

        KaryawanDSL.mengambil_stock{
            bahan_bernama "kucing"
            di_tempat_penyimpanan_sebanyak 16
        }
        println();

        KaryawanDSL.mengambil_stock{
            bahan_bernama "kucing"
            di_tempat_penyimpanan_sebanyak 10
        }
        println();

        KaryawanDSL.mengambil_stock{
            bahan_bernama "kucing"
            di_tempat_penyimpanan_sebanyak 5
        }

        println();

        KaryawanDSL.mengambil_stock{
            bahan_bernama "kucing"
            di_tempat_penyimpanan_sebanyak 5
        }
    }
}