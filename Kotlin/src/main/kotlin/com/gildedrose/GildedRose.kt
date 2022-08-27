package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                bumpNonExpiredBackstagePassQuality(item)
            } else if (item.name == "Aged Brie") {
                item.incrementQuality()
            } else {
                if (item.name != "Sulfuras, Hand of Ragnaros") {
                    item.decrementQuality()
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

    private fun bumpNonExpiredBackstagePassQuality(item: Item) {
        item.incrementQuality()

        if (item.sellIn < 11) {
            item.incrementQuality()
        }

        if (item.sellIn < 6) {
            item.incrementQuality()
        }
    }
}

