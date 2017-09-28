package dsl.kantin.living

class KasirDSLTest extends GroovyTestCase {
    void testKasirDSL () {
        KasirDSL.recruit {
            nama "Amanda"
            usia 20
            cewek()
        }
    }
}