package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") {
                if (item.name != "Sulfuras, Hand of Ragnaros") {
                    item.decrementQuality()
                }
            } else {
                item.incrementQuality()

                if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                    updateBackstagePassQuality(item)
                }
            }

            item.updateSellIn()

            if (item.sellIn < 0) {
                if (item.name == "Aged Brie") {
                    item.incrementQuality()
                } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                    item.quality = 0
                } else {
                    if (item.name != "Sulfuras, Hand of Ragnaros") {
                        item.decrementQuality()
                    }
                }
            }
        }
    }

    private fun updateBackstagePassQuality(item: Item) {
        if (item.sellIn < 11) {
            item.incrementQuality()
        }

        if (item.sellIn < 6) {
            item.incrementQuality()
        }
    }
}

