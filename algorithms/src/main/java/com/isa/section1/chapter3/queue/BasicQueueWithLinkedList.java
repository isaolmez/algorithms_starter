package com.isa.section1.chapter3.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import com.isa.section1.chapter3.linkedlist.BasicLinkedList;
import com.isa.section1.chapter3.linkedlist.Node;

public class BasicQueueWithLinkedList<Item> implements Iterable<Item> {
	private BasicLinkedList<Item> backingList;

	public BasicQueueWithLinkedList() {
		backingList = new BasicLinkedList<Item>();
	}

	public void enqueue(Item item) {
		backingList.insertToEnd(new Node<Item>(item));
	}

	public Item dequeue() {
		Node<Item> node = backingList.removeFromStart();
		if (node != null) {
			return node.getItem();
		}

		return null;
	}

	public int size() {
		return backingList.size();
	}

	public boolean isEmpty() {
		return backingList.size() == 0;
	}

	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item> {

		@Override
		public boolean hasNext() {
			return backingList.iterator().hasNext();
		}

		@Override
		public Item next() {
			return backingList.iterator().next();
		}
	}

	public static void main(String[] args) throws IOException {
		BasicQueueWithLinkedList<String> queue = new BasicQueueWithLinkedList<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Enter the string: ");
			String input = reader.readLine();
			String[] parts = input.split(" ");
			for (String part : parts) {
				if (part.equals("-")) {
					System.out.println(queue.dequeue());
				} else {
					queue.enqueue(part);
				}
			}

			for (String s : queue) {
				System.out.print(s);
			}
		}
	}
}
