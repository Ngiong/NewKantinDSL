package dsl.kantin.container

class RecipeDictionaryDSL {
    def recipe = [:]
    def static instance
    def menu
    def bahan

    static def update(closure) {
        if (instance == null) instance = new RecipeDictionaryDSL()
        RecipeDictionaryDSL recipeDictionaryDSL = instance
        closure.delegate = instance
        closure()
    }

    def menu(target_menu) {
        menu = target_menu
        if (menu != null) {
            if (!recipe.containsKey(menu)) {
                recipe[menu] = [:]
            }
        }
    }

    def menggunakan_bahan(bahan_menu) {
        if (menu != null) {
            bahan = bahan_menu
            if (!recipe[menu].containsKey(bahan)) {
                recipe[menu][bahan] = 0
            }
        }
    }

    def sebanyak(jumlah) {
        recipe[menu][bahan] = jumlah
    }

    static def getRecipe(String target_menu) {
        if (instance == null) instance = new RecipeDictionaryDSL()
        if (!instance.recipe.containsKey(target_menu)) {
            throw Exception("Tidak ada resep untuk " + target_menu)
        } else {
            return instance.recipe[target_menu]
        }

    }

    static def print() {
        if (instance == null) instance = new RecipeDictionaryDSL()
        instance.recipe.each{
            k,v ->
                println(k)
                v.each{
                    k2,v2 ->
                        println("  " + v2.toString() + " " + k2)
                }
                println()
        }
    }
}
