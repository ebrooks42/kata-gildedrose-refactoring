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

        if (sellIn < 0) {
            when (name) {
                "Aged Brie" -> incrementQualityButNoFurtherThanFifty()
                "Backstage passes to a TAFKAL80ETC concert" -> quality = 0
                "Sulfuras, Hand of Ragnaros" -> Unit // quality does not change
                else -> decrementQualityButNoFurtherThanZero()
            }
        }
    }

    private fun updateSellIn() {
        when (name) {
            "Sulfuras, Hand of Ragnaros" -> Unit // sell date does not change/expire
            else -> sellIn -= 1
        }
    }

    private fun updateQualityForBackstagePass() {
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
    }

    private fun updateQualityForAllOtherItems() {
        decrementQualityButNoFurtherThanZero()
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