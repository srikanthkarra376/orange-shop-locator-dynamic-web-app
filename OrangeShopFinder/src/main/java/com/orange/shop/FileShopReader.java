package com.orange.shop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileShopReader {

	private static final String NAME_FILE = "orange_shop.csv";

	public List<Line> setAllLine() {
		List<String> allLines = readShopFile();

		removeHeaderLine(allLines);

		return createListShops(allLines);
		//return null;

	}

	private static List<String> readShopFile() {
		URI uri = null;
		List<String> lines = new ArrayList<String>();
		try {
			ClassLoader classLoader = FileShopReader.class.getClassLoader();

	       uri = classLoader.getResource(NAME_FILE).toURI();
			//uri = getClass.get(NAME_FILE).toURI();
			lines = Files.readAllLines(Paths.get(uri));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lines;
	}

	private void removeHeaderLine(List<String> allLines) {
		allLines.remove(0);
	}

	private List<Line> createListShops(List<String> allLines) {
		return allLines.stream().map(line -> line.split(";")) //
				.map(line -> new Line(line[0], line[1], line[2], line[3], line[4], line[5])) //
				.collect(Collectors.toList());
	}
}
