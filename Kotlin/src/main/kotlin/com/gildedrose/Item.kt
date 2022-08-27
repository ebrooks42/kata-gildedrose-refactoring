package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }

    fun updateSellIn() {
        if (name != "Sulfuras, Hand of Ragnaros") {
            sellIn -= 1
        }
    }



    fun incrementQualityButNoFurtherThanFifty() {
        if (quality < 50) {
            quality += 1
        }
    }
    
    fun decrementQualityButNoFurtherThanZero() {
        if (quality > 0) {
            quality -= 1
        }
    }
}