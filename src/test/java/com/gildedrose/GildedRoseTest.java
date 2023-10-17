package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new RegularItem("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }


    @Test
    @DisplayName("The Quality of an item is never more than 50")
    void maxQuality() {
        Item[] items = new Item[] { new AgedBrieItem("Aged Brie", -1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    @DisplayName("\"Aged Brie\" actually increases in Quality the older it gets")
    void agedBrie() {
        Item[] items = new Item[] { new AgedBrieItem("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    @DisplayName("The Quality of an item is never negative")
    void minQualityIsZero() {
        Item[] items = new Item[] { new RegularItem("Foo", -100, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    @DisplayName("Once the sell by date has passed, Quality degrades twice as fast")
    void qualityDegrade() {
        Item[] items = new Item[] { new RegularItem("Foo", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    @DisplayName("\"Sulfuras\", being a legendary item, never has to be sold or decreases in Quality")
    void sulfuras() {
        Item[] items = new Item[] { new LegendaryItem("Sulfuras, Hand of Ragnaros", 1, 23) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }


    @Test
    @DisplayName("Backstage passes Quality increases by 2 when there are 10 days or less")
    void backstagePassOne() {
        Item[] items = new Item[] { new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 11, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }

    @Test
    @DisplayName("Backstage passes Quality increases by 3 when there are 5 days or less")
    void backstagePassTwo() {
        Item[] items = new Item[] { new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 6, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(25, app.items[0].quality);
    }

    @Test
    @DisplayName("Backstage passes Quality drops to 0 after the concert")
    void backstagePassThree() {
        Item[] items = new Item[] { new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 1, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    @DisplayName("\"Conjured\" items degrade in Quality twice as fast as normal items")
    void conjuredItem() {
        Item[] items = new Item[] { new ConjuredItem("Conjured Mana Cake", 1, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}
