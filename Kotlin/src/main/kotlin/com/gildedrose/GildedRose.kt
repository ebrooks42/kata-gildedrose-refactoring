package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            when (item.name) {
                "Backstage passes to a TAFKAL80ETC concert" -> bumpNonExpiredBackstagePassQuality(item)
                "Aged Brie" -> item.incrementQualityButNoFurtherThanFifty()
                "Sulfuras, Hand of Ragnaros" -> { /* quality does not decay */ }
                else -> item.decrementQualityButNoFurtherThanZero()
            }

            item.updateSellIn()

            if (item.sellIn < 0) {
                when (item.name) {
                    "Aged Brie" -> item.incrementQualityButNoFurtherThanFifty()
                    "Backstage passes to a TAFKAL80ETC concert" -> {
                        item.quality = 0
                    }
                    "Sulfuras, Hand of Ragnaros" -> { /* quality does not decay */ }
                    else -> item.decrementQualityButNoFurtherThanZero()
                }
            }
        }
    }

    private fun bumpNonExpiredBackstagePassQuality(item: Item) {
        item.incrementQualityButNoFurtherThanFifty()

        if (item.sellIn < 11) {
            item.incrementQualityButNoFurtherThanFifty()
        }

        if (item.sellIn < 6) {
            item.incrementQualityButNoFurtherThanFifty()
        }
    }
}

