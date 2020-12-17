package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaghavGildedRoseRefactoredTest {

	public static final int NOT_EXPIRED_SELL_IN = 16;
	public static final int DEFAULT_QUALITY = 4;
	public static final String DEFAULT_ITEM = "DEFAULT_ITEM";
	public static final int EXPIRED_SELL_IN = -2;
	public static final String AGED_BRIE = "Aged Brie";
	public static final int MAXIMUM_QUALITY = 50;
	public static final String BACKSTAGE_PASSES_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	public static final int SELL_IN_BETWEEN_5_AND_10 = 7;
	public static final int SELL_IN_LESS_THAN_5 = 4;
	public static final int SELL_IN_GREATER_THAN_10 = 15;

	@Test
	public void unexpiredDefaultItem_qualityDecreasesBy1() {
		// Setup
		GildedRose app = createGildedRoseWithItem(DEFAULT_ITEM, NOT_EXPIRED_SELL_IN, DEFAULT_QUALITY);

		// Invoke
		app.updateQuality();

		// Verify
		Item expected = new Item(DEFAULT_ITEM, NOT_EXPIRED_SELL_IN - 1, DEFAULT_QUALITY - 1);
		assertItem(expected, app.items[0]);
	}

	@Test
	public void expiredDefaultItem_qualityDecreasesBy2() {
		// Setup
		GildedRose app = createGildedRoseWithItem(DEFAULT_ITEM, EXPIRED_SELL_IN, DEFAULT_QUALITY);

		// Invoke
		app.updateQuality();

		// Verify
		Item expected = new Item(DEFAULT_ITEM, EXPIRED_SELL_IN - 1, DEFAULT_QUALITY - 2);
		assertItem(expected, app.items[0]);
	}

	@Test
	public void notExpired_agedBrie_qualityIncreasesBy1() {
		// Setup
		GildedRose app = createGildedRoseWithItem(AGED_BRIE, NOT_EXPIRED_SELL_IN, DEFAULT_QUALITY);

		// Invoke
		app.updateQuality();

		// Verify
		Item expected = new Item(AGED_BRIE, NOT_EXPIRED_SELL_IN - 1, DEFAULT_QUALITY + 1);
		assertItem(expected, app.items[0]);
	}

	@Test
	public void expired_agedBrie_qualityIncreasesBy2() {
		// Setup
		GildedRose app = createGildedRoseWithItem(AGED_BRIE, EXPIRED_SELL_IN, DEFAULT_QUALITY);

		// Invoke
		app.updateQuality();

		// Verify
		Item expected = new Item(AGED_BRIE, EXPIRED_SELL_IN - 1, DEFAULT_QUALITY + 2);
		assertItem(expected, app.items[0]);
	}

	@Test
	public void notExpired_agedBrie_qualityDoesNotGoBeyondMaximum() {
		// Setup
		GildedRose app = createGildedRoseWithItem(AGED_BRIE, NOT_EXPIRED_SELL_IN, MAXIMUM_QUALITY);

		// Invoke
		app.updateQuality();

		// Verify
		Item expected = new Item(AGED_BRIE, NOT_EXPIRED_SELL_IN - 1, MAXIMUM_QUALITY);
		assertItem(expected, app.items[0]);
	}

	@Test
	public void backstagePasses_notExpired_greaterThan10_qualityIncreasesBy1() {
		// Setup
		GildedRose app = createGildedRoseWithItem(BACKSTAGE_PASSES_CONCERT, SELL_IN_GREATER_THAN_10, DEFAULT_QUALITY);

		// Invoke
		app.updateQuality();

		// Verify
		Item expected = new Item(BACKSTAGE_PASSES_CONCERT, SELL_IN_GREATER_THAN_10 - 1, DEFAULT_QUALITY + 1);
		assertItem(expected, app.items[0]);
	}

	@Test
	public void backstagePasses_notExpired_between5and10_sellIn_qualityIncreasesBy2() {
		// Setup
		GildedRose app = createGildedRoseWithItem(BACKSTAGE_PASSES_CONCERT, SELL_IN_BETWEEN_5_AND_10, DEFAULT_QUALITY);

		// Invoke
		app.updateQuality();

		// Verify
		Item expected = new Item(BACKSTAGE_PASSES_CONCERT, SELL_IN_BETWEEN_5_AND_10 - 1, DEFAULT_QUALITY + 2);
		assertItem(expected, app.items[0]);
	}

	@Test
	public void backstagePasses_notExpired_lessThan5_sellIn_qualityIncreasesBy3() {
		// Setup
		GildedRose app = createGildedRoseWithItem(BACKSTAGE_PASSES_CONCERT, SELL_IN_LESS_THAN_5, DEFAULT_QUALITY);

		// Invoke
		app.updateQuality();

		// Verify
		Item expected = new Item(BACKSTAGE_PASSES_CONCERT, SELL_IN_LESS_THAN_5 - 1, DEFAULT_QUALITY + 3);
		assertItem(expected, app.items[0]);
	}

	private void assertItem(Item expected, Item actual) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}

	private GildedRose createGildedRoseWithItem(String itemType, int sellIn, int defaultQuality) {
		Item item = new Item(itemType, sellIn, defaultQuality);
		Item[] items = new Item[]{item};
		return new GildedRose(items);
	}
}