package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }

    fun bumpQuality() {
        if (quality < 50) {
            quality += 1
        }
    }
}