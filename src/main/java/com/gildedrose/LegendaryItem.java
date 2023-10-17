package com.gildedrose;

public class LegendaryItem extends RegularItem {

    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        // Legendary items never changes quality
    }

}
