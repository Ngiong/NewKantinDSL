package dsl.kantin.container

@Singleton
class AntrianDSL {
    static def container = []
    static def front = 0

    static def masuk_antrian (pelanggan) {
        container << pelanggan
    }

    static def keluarkan_dari_antrian() {
        front ++
    }

    static def hitung_panjang_antrian () {
        println("Saat ini, antrian memiliki panjang " + Integer.toString(container.size() - front) + " orang.")
        return container.size() - front
    }
}