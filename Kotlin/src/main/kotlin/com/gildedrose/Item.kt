package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
    fun updateQuality() {
        updateSellIn()

        when (name) {
            "Backstage passes to a TAFKAL80ETC concert" -> updateQualityForBackstagePass()
            "Aged Brie" -> updateQualityForAgedBrie()
            "Sulfuras, Hand of Ragnaros" -> Unit // quality does not change
            else -> updateQualityForAllOtherItems()
        }
    }
    private fun isExpired() = sellIn < 0

    private fun updateSellIn() {
        when (name) {
            "Sulfuras, Hand of Ragnaros" -> Unit // sell date does not change/expire
            else -> sellIn -= 1
        }
    }

    private fun updateQualityForBackstagePass() {
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

    private fun updateQualityForAgedBrie() {
        incrementQualityButNoFurtherThanFifty()
        if (isExpired()) {
            incrementQualityButNoFurtherThanFifty()
        }
    }

    private fun updateQualityForAllOtherItems() {
        decrementQualityButNoFurtherThanZero()
        if (isExpired()) {
            decrementQualityButNoFurtherThanZero()
        }
    }

    private fun incrementQualityButNoFurtherThanFifty() {
        if (quality < 50) {
            quality += 1
        }
    }
    
    private fun decrementQualityButNoFurtherThanZero() {
        if (quality > 0) {
            quality -= 1
        }
    }
}