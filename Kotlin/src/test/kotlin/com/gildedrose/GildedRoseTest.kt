package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {
    @Test
    fun sell_in() {
        assertSellInAfterOneDayElapsed(
            Item("Bean", 2, 10),
            1
        )
        assertSellInAfterOneDayElapsed(
            Item("Bean", 0, 10),
            -1
        )
    }

    @Test
    fun sell_in_sulfuras() {
        assertSellInAfterOneDayElapsed(
            Item("Sulfuras, Hand of Ragnaros", 20, 80),
            20
        )
    }

    @Test
    fun quality_min() {
        assertQualityAfterOneDayElapsed(
            Item("Simple Sword", 5, 0),
            0
        )
    }
    @Test
    fun quality_max() {
        assertQualityAfterOneDayElapsed(
            Item("Aged Brie", 5, 50),
            50
        )
    }
    @Test
    fun quality_degradation() {
        assertQualityAfterOneDayElapsed(
            Item("Skewer of Meat", 10, 10),
            9
        )
    }

    @Test
    fun quality_degradation_after_sell_by() {
        assertQualityAfterOneDayElapsed(
            Item("Skewer of Meat", 0, 10),
            8
        )
    }

    @Test
    fun quality_aged_brie() {
        assertQualityAfterOneDayElapsed(
            Item("Aged Brie", 5, 5),
            6
        )
    }

    @Test
    fun quality_sulfuras() {
        assertQualityAfterOneDayElapsed(
            Item("Sulfuras, Hand of Ragnaros", 20, 80),
            80
        )
    }

    @Test
    fun quality_backstage_passes() {
        assertQualityAfterOneDayElapsed(
            Item("Backstage passes to a TAFKAL80ETC concert", 12, 10),
            11
        )

        assertQualityAfterOneDayElapsed(
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 10),
            12
        )

        assertQualityAfterOneDayElapsed(
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
            13
        )

        assertQualityAfterOneDayElapsed(
            Item("Backstage passes to a TAFKAL80ETC concert", 0, 10),
            0
        )
    }

    private fun assertQualityAfterOneDayElapsed(item: Item, newQuality: Int) {
        val app = GildedRose(arrayOf(item))
        app.updateQuality()
        assertEquals(newQuality, app.items.first().quality)
    }

    private fun assertSellInAfterOneDayElapsed(item: Item, newSellIn: Int) {
        val app = GildedRose(arrayOf(item))
        app.updateQuality()
        assertEquals(newSellIn, app.items.first().sellIn)
    }



}


