package net.rabiang.utils.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Breadcrumb {

	private List<HashMap<String, String>> breadcrumb = new ArrayList<HashMap<String, String>>();

	public List<HashMap<String, String>> getBreadcrumb() {
		return breadcrumb;
	}

	public void add(String text, String href) {
		HashMap<String, String> link = new HashMap<String, String>();

		link.put("text", text);
		link.put("href", href);

		breadcrumb.add(link);
	}

}
