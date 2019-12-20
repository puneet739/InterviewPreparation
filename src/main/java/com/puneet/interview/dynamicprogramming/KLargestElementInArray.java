package com.puneet.interview.dynamicprogramming;

public class KLargestElementInArray {
	public static void main(String[] args) {
		int array[] = new int[] {1,3,5,7,6,10,5,21,1,18};
		int k = 3;
		
		KthElements result  = findLargestk(array, k);
		while(result!=null) {
			System.out.println(result.getNumber());
			result = result.getNextNumber();
		}
	}

	private static KthElements findLargestk(int[] array, int k) {
		KthElements head = new KthElements(array[0]);
		int currentIndex = 1;
		
		for (int i: array) {
			if (i>head.getNumber()) {
				KthElements temp = new KthElements(i);
				KthElements currentElement = head;
				if (currentElement.getNextNumber()!=null) {
					while (currentElement.getNextNumber()!=null) {
						if (currentElement.getNextNumber().getNumber()<i) {
							currentElement=currentElement.getNextNumber();
							continue;
						}else {
							temp.setNextNumber(currentElement.getNextNumber());
							break;
						}
					}currentElement.setNextNumber(temp);
				}else {
					head.setNextNumber(temp);
				}
				currentIndex++;
				if (currentIndex>k) {
					head=head.getNextNumber();
				}
			}
		}
		return head;
	}
	
}

class KthElements{
	int number;
	KthElements nextNumber;
	public KthElements(int number) {
		this.number=number;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public KthElements getNextNumber() {
		return nextNumber;
	}
	public void setNextNumber(KthElements nextNumber) {
		this.nextNumber = nextNumber;
	}
	@Override
	public String toString() {
		return "KthElements [number=" + number + ", nextNumber=" + nextNumber + "]";
	}
	
}