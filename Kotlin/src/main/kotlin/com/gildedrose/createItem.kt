package com.gildedrose

fun createItem(name: String, sellIn: Int, quality: Int): Item = when (name) {
    "Backstage passes to a TAFKAL80ETC concert" -> BackstagePass(sellIn, quality)
    "Aged Brie" -> AgedBrie(sellIn, quality)
    "Sulfuras, Hand of Ragnaros" -> Sulfuras(sellIn)
    else -> DefaultItem(name, sellIn, quality)
}