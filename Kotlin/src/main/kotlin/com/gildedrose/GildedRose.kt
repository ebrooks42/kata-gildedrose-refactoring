package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") {
                if (item.quality > 0) {
                    if (item.name != "Sulfuras, Hand of Ragnaros") {
                        item.quality = item.quality - 1
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.bumpQuality()

                    if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                        updateBackstagePassQuality(item)
                    }
                }
            }

            updateSellIn(item)

            if (item.sellIn < 0) {
                if (item.name != "Aged Brie") {
                    if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (item.quality > 0) {
                            if (item.name != "Sulfuras, Hand of Ragnaros") {
                                item.quality = item.quality - 1
                            }
                        }
                    } else {
                        item.quality = 0
                    }
                } else {
                    updateAgedBrieQuality(item)
                }
            }
        }
    }

    private fun updateBackstagePassQuality(item: Item) {
        if (item.sellIn < 11) {
            item.bumpQuality()
        }

        if (item.sellIn < 6) {
            item.bumpQuality()
        }
    }

    private fun updateAgedBrieQuality(item: Item) {
        item.bumpQuality()
    }

    private fun updateSellIn(item: Item) {
        if (item.name != "Sulfuras, Hand of Ragnaros") {
            item.sellIn = item.sellIn - 1
        }
    }

}

