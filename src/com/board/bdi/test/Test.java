package com.board.bdi.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Human {
	private int age;
	private int height;

	public Human(int age, int height) {
		super();
		this.age = age;
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Human [age=" + age + ", height=" + height + "]";
	}
}


class Compare<T> implements Comparator<T>{ // <T> T는 Type <Human>으로 해도되지만 공통으로 쓸거라면 <T>가 맞다.

	@Override
	public int compare(T o1, T o2) {
		Human h1 = (Human)o1;
		Human h2 = (Human)o2;
		if(h1.getAge()<h2.getAge()) {
			return 1;
		}
		if(h1.getAge()>h2.getAge()) {
			return -1;
		}
		return 0;
	}
	
}
public class Test {

	public static void main(String[] args) {
		List<Human> hList = new ArrayList<>();
		hList.add(new Human(22, 174));
		hList.add(new Human(34, 182));
		hList.add(new Human(15, 153));
		hList.add(new Human(4, 117));
		hList.add(new Human(28, 176));
		hList.add(new Human(40, 168));

		Collections.sort(hList,new Compare<Human>());
		System.out.println(hList);

		int[] nums = new int[5];
		nums[0] = 10;
		nums[1] = 5;
		nums[2] = 1;
		nums[3] = 8;
		nums[4] = 4;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] < nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println(nums[3]);
		System.out.println(nums[4]);

		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(5);
		intList.add(1);
		intList.add(8);
		intList.add(4);

		for (int i = 0; i < intList.size(); i++) {
			for (int j = i + 1; j < intList.size(); j++) {
				if (intList.get(i) < intList.get(j)) {
					int tmp = intList.get(i);
					intList.set(i, intList.get(j));
					intList.set(j, tmp);
				}
			}
		}
		System.out.println(intList);

		Collections.sort(intList);
		System.out.println(intList);

		Collections.reverse(intList);
		System.out.println(intList);

	}
}
