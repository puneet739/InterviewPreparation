package com.puneet.interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> {
	Node head;
	Node tail;
	final int maxSize ; 
	
	public LRUCache(int maxSize ) {
		this.maxSize= maxSize;
	}
	
	Map<K, V> map = new HashMap<K, V>();

	public V get(K k) {
		return map.get(k);
	}

	public void put(K k, V v) {
		if (!map.containsKey(k)) {
			if(map.size()>=maxSize) {
				map.remove(head);
			}
			Node nodeEntry  = new Node();
			nodeEntry.setKey(k);
			nodeEntry.setValue(v);
			addNodeonTop(nodeEntry);
		}
	}

	private void addNodeonTop(Node nodeEntry) {
		if (tail==null) {
			tail=nodeEntry;
		}else {
			tail.nextNode=nodeEntry;
		}
	}

	public void remove(K k) {
		map.remove(k);
	}

}

class Node<K,V> {
	K key;
	V value;
	Node nextNode;

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

}
