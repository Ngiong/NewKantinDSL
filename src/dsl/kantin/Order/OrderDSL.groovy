package dsl.kantin.Order

class OrderDSL {
    static def pesanan = []
    static int count = 0

    static def pesan(pelanggan, menu){
        pesanan << [pelanggan, menu]
        count ++
    }

    static def semua_order() {
        println("\nTotal pesanan : " + count)
        println("DETAIL : ")
        for(i in pesanan)
            println(i[0] + " memesan " + i[1])

        return count
    }
}
