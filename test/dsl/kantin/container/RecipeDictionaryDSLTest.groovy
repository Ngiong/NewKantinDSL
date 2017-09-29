package dsl.kantin.container

class RecipeDictionaryDSLTest extends  GroovyTestCase{
    void testRecipeDictionaryDSL() {
        RecipeDictionaryDSL.update {
            menu "Nasi Goreng"
            menggunakan_bahan "beras"
            sebanyak 1
            menggunakan_bahan "cabe"
            sebanyak 4
            menggunakan_bahan "bawang"
            sebanyak 2
            menggunakan_bahan "telur"
            sebanyak 1
        }

        RecipeDictionaryDSL.print()
    }
}
