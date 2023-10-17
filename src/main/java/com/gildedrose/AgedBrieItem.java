package com.gildedrose;

public class AgedBrieItem extends RegularItem {

    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        this.increaseQuality();
        this.decreaseSellIn();
    }

}
