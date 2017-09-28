package dsl.kantin.container

class MenuDictionaryDSL {
    def menu = [:]
    def static instance = null

    boolean tambahItem
    String tmpNama

    def static init (closure) {
        if (instance == null) instance = new MenuDictionaryDSL()
        MenuDictionaryDSL menuDictionaryDSL = instance
        closure.delegate = menuDictionaryDSL
        closure()
    }

    def tambah (nama) {
        this.tambahItem = true
        this.tmpNama = nama
    }

    def hapus (nama) {
        this.tambahItem = false
        this.menu.remove(nama)
    }

    def harga (price) {
        if (this.tambahItem) {
            if (this.menu.containsValue(tmpNama))
                this.menu.replace(tmpNama, price)
            else
                this.menu.put(tmpNama, price)
        }
    }

    def selesai () {
        instance = this
    }

    def static tampilkan() {
        def menu = instance.menu
        for (key in menu.keySet()) {
            println("[*]" + String.format("%25s", key) + " | Rp. " + (long) menu.get(key) + ",-")
        }
    }
}