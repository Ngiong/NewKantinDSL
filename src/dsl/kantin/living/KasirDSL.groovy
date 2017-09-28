package dsl.kantin.living

class KasirDSL {
    String name
    Gender gender
    int age

    static def recruit (closure) {
        KasirDSL kasirDSL = new KasirDSL()
        closure.delegate = kasirDSL
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

    def usia(int age) {
        this.age = age
    }
}