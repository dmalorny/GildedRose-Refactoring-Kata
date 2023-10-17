package com.gildedrose;

public class RegularItem extends Item {

    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        this.decreaseQuality();
        this.decreaseSellIn();
        if (this.sellIn < 0) {
            this.decreaseQuality();
        }
    }

    protected void decreaseSellIn() {
        this.sellIn--;
    }

    protected void decreaseQuality() {
        if (this.quality > 0) {
            this.quality--;
        }
    }

    protected void increaseQuality() {
        if (this.quality < 50) {
            this.quality++;
        }
    }

}
