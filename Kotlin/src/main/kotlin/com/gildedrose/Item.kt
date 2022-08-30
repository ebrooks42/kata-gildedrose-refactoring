package com.gildedrose

class Sulfuras(sellIn: Int) : Item("Sulfuras, Hand of Ragnaros", sellIn, 80) {
    override fun updateState() = Unit
}

class AgedBrie(sellIn: Int, quality: Int) : Item("Aged Brie", sellIn, quality) {
    override fun updateState() {
        decrementSellIn()
        incrementQuality()
        if (isExpired()) {
            incrementQuality()
        }
    }
}

class BackstagePass(sellIn: Int, quality: Int) :
    Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) {

    override fun updateState() {
        decrementSellIn()

        if (isExpired()) {
            quality = 0
            return
        }

        incrementQuality()
        if (sellIn < 11) {
            incrementQuality()
        }
        if (sellIn < 6) {
            incrementQuality()
        }
    }
}

class DefaultItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateState() {
        decrementSellIn()
        decrementQuality()
        if (isExpired()) {
            decrementQuality()
        }
    }
}

abstract class Item(var name: String, var sellIn: Int, var quality: Int) {
    abstract fun updateState()
    fun isExpired() = sellIn < 0

    protected fun decrementSellIn() {
        sellIn -= 1
    }

    protected fun incrementQuality() {
        if (quality < 50) {
            quality += 1
        }
    }

    protected fun decrementQuality() {
        if (quality > 0) {
            quality -= 1
        }
    }
}