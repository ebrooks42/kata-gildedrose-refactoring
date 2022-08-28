package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
    fun updateItemQuality() {
        when (name) {
            "Backstage passes to a TAFKAL80ETC concert" -> bumpNonExpiredBackstagePassQuality()
            "Aged Brie" -> incrementQualityButNoFurtherThanFifty()
            "Sulfuras, Hand of Ragnaros" -> { /* quality does not decay */
            }

            else -> decrementQualityButNoFurtherThanZero()
        }

        updateSellIn()

        if (sellIn < 0) {
            when (name) {
                "Aged Brie" -> incrementQualityButNoFurtherThanFifty()
                "Backstage passes to a TAFKAL80ETC concert" -> quality = 0
                "Sulfuras, Hand of Ragnaros" -> { /* quality does not decay */
                }

                else -> decrementQualityButNoFurtherThanZero()
            }
        }
    }

    private fun bumpNonExpiredBackstagePassQuality() {
        incrementQualityButNoFurtherThanFifty()

        if (sellIn < 11) {
            incrementQualityButNoFurtherThanFifty()
        }

        if (sellIn < 6) {
            incrementQualityButNoFurtherThanFifty()
        }
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