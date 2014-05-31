package com.hackanooga.devLearn.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hackanooga.devLearn.LanguageListActivity;


/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class LanguageContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<LanguageItem> ITEMS = new ArrayList<LanguageItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, LanguageItem> ITEM_MAP = new HashMap<String, LanguageItem>();

	static {
		// Add The Language List
		addItem(new LanguageItem("1", "HTML", "html_lessons"));
		addItem(new LanguageItem("2", "CSS", "css_lessons"));
		addItem(new LanguageItem("3", "JavaScript", "javascript_lessons"));
		addItem(new LanguageItem("4", "PHP", "php_lessons"));
	}

	private static void addItem(LanguageItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class LanguageItem {
		public String id;
		public String content;
		public String array_name;

		public LanguageItem(String id, String content, String array_name) {
			this.id = id;
			this.content = content;
			this.array_name = array_name;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}
