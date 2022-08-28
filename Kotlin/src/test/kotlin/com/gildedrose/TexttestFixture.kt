package com.gildedrose

fun main(args: Array<String>) {

    println("OMGHAI!")

    val items = arrayOf(
        ItemFactory.create("+5 Dexterity Vest", 10, 20), //
        ItemFactory.create("Aged Brie", 2, 0), //
        ItemFactory.create("Elixir of the Mongoose", 5, 7), //
        ItemFactory.create("Sulfuras, Hand of Ragnaros", 0, 80), //
        ItemFactory.create("Sulfuras, Hand of Ragnaros", -1, 80),
        ItemFactory.create("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        ItemFactory.create("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        ItemFactory.create("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        // this conjured item does not work properly yet
        ItemFactory.create("Conjured Mana Cake", 3, 6)
    )

    val app = GildedRose(items)

    var days = 2
    if (args.size > 0) {
        days = Integer.parseInt(args[0]) + 1
    }

    for (i in 0..days - 1) {
        println("-------- day $i --------")
        println("name, sellIn, quality")
        for (item in items) {
            println(item)
        }
        println()
        app.updateQuality()
    }


}
