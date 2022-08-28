package com.gildedrose

interface IItem {
    var name: String
    var sellIn: Int
    var quality: Int

    fun isExpired() = sellIn < 0
    fun updateSellIn() {
        sellIn -= 1
    }
    fun updateQuality()
}

class Sulfuras(sellIn: Int) : Item("Sulfuras, Hand of Ragnaros", sellIn, 80) {
    override fun updateSellIn() = Unit // does not expire
    override fun updateQuality() = Unit // does not decay
}

class AgedBrie(sellIn: Int, quality: Int) : Item("Aged Brie", sellIn, quality) {
    override fun updateQuality() {
        incrementQualityButNoFurtherThanFifty()
        if (isExpired()) {
            incrementQualityButNoFurtherThanFifty()
        }
    }
}

class BackstagePass(sellIn: Int, quality: Int) :
    Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) {

    override fun updateQuality() {
        if (isExpired()) {
            quality = 0
            return
        }

        incrementQualityButNoFurtherThanFifty()
        if (sellIn < 11) {
            incrementQualityButNoFurtherThanFifty()
        }
        if (sellIn < 6) {
            incrementQualityButNoFurtherThanFifty()
        }
    }
}

class DefaultItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        decrementQualityButNoFurtherThanZero()
        if (isExpired()) {
            decrementQualityButNoFurtherThanZero()
        }
    }
}

abstract class Item(override var name: String, override var sellIn: Int, override var quality: Int) : IItem {

    protected fun incrementQualityButNoFurtherThanFifty() {
        if (quality < 50) {
            quality += 1
        }
    }

    protected fun decrementQualityButNoFurtherThanZero() {
        if (quality > 0) {
            quality -= 1
        }
    }
}