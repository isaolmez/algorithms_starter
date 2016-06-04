package com.isa.section4.chapter1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.sedgewick.stdlib.StdIn;
import com.sedgewick.stdlib.StdOut;

public class SymbolGraph implements ISymbolGraph {
	private Graph graph;
	private Map<String, Integer> keysToIndexes = new HashMap<>();
	private String[] indexToKeys;

	public SymbolGraph(String fileName, String delimiter) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		String[] parts = null;
		while ((line = reader.readLine()) != null) {
			parts = line.split(delimiter);
			for (int i = 0; i < parts.length; i++) {
				if (!keysToIndexes.containsKey(parts[i])) {
					keysToIndexes.put(parts[i], keysToIndexes.size());
				}
			}

		}

		this.graph = new Graph(keysToIndexes.size());
		indexToKeys = new String[keysToIndexes.size()];
		for (String key : keysToIndexes.keySet()) {
			indexToKeys[keysToIndexes.get(key)] = key;
		}

		reader = new BufferedReader(new FileReader(fileName));
		while ((line = reader.readLine()) != null) {
			parts = line.split(delimiter);
			for (int i = 1; i < parts.length; i++) {
				graph.addEdge(keysToIndexes.get(parts[0]), keysToIndexes.get(parts[i]));
			}

		}
		
		reader.close();
	}

	@Override
	public boolean contains(String key) {
		return keysToIndexes.containsKey(key);
	}

	@Override
	public int index(String key) {
		return keysToIndexes.get(key);
	}

	@Override
	public String name(int v) {
		if (v >= indexToKeys.length) {
			return null;
		}

		return indexToKeys[v];
	}

	@Override
	public Graph G() {
		return graph;
	}

	public static void main(String[] args) throws IOException {
		String fileName = "movies.txt";
		String filePath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
		SymbolGraph sg = new SymbolGraph(filePath, "/");
		Graph G = sg.G();
		while (StdIn.hasNextLine()) {
			String source = StdIn.readLine();
			for (int w : G.adj(sg.index(source)))
				StdOut.println("   " + sg.name(w));
		}
	}
}
