package com.gildedrose;

public class BackstagePassItem extends RegularItem {

    public BackstagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        this.increaseQuality();
        this.decreaseSellIn();
        if (this.sellIn < 0) {
            this.quality = 0;
        }
    }

    @Override
    protected void increaseQuality() {
        super.increaseQuality();

        if (this.sellIn <= 10) {
            super.increaseQuality();
        }

        if (this.sellIn <= 5) {
            super.increaseQuality();
        }
    }

}
