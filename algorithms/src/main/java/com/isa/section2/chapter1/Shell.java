package com.isa.section2.chapter1;

import com.sedgewick.stdlib.StdOut;

public class Shell {
	public static void sort(Comparable[] a) {
		int h = 1;
		int N = a.length;
		while (h < N / 3) {
			h = 3 * h + 1;
		}

		while (h >= 1) {
			for (int i = h; i < a.length; i++) {
				for (int k = i; k >= h && less(a[k], a[k - h]); k -= h) {
					exch(a, k - h, k);
				}
			}

			h = h / 3;
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void show(Comparable[] a) { // Print the array, on a single line.
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) { // Test whether the array entries are in order.
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		// String[] a = In.readStrings();
		String[] a = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		assert isSorted(a);
		show(a);
	}

}
