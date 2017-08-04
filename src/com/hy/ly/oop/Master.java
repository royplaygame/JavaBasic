package com.hy.ly.oop;

import org.junit.Test;

public class Master {

	public void feed(Pet p) {
		p.eat();
	}

	public void showInfo(Pet p) {
		p.showPetInfo();
	}

	public void play(Pet p) {
		if (p instanceof Dog) {
			Dog dog = (Dog) p;
			dog.catchingFlyDisc();
		} else if (p instanceof Penguin) {
			Penguin pg = (Penguin) p;
			pg.swimming();
		}
	}

	public Pet getPet(String type) {
		Pet p = null;
		if (type.equals("dog")) {
			p = new Dog("Q妹", 100);
		} else if (type.equals("penguin")) {
			p = new Penguin("Q仔", 99);
		}
		return p;
	}

	public static void main(String[] args) {
		Master master = new Master();

		Pet p = new Dog("花花", 100);
		master.feed(p);
		master.showInfo(p);

		Pet p1 = new Penguin("Q妹", 99);
		master.feed(p1);
		master.showInfo(p1);

		Pet p2 = new Pet();
		master.feed(p2);
		master.showInfo(p2);

		Pet pet = master.getPet("dog");
		System.out.println(pet);

		pet = master.getPet("penguin");
		System.out.println(pet);
	}

	@Test
	public void testPlayWithPet() {
		Master master = new Master();
		Pet p = new Dog("花花", 100);
		Pet p1 = new Penguin("Q妹", 99);
		
		master.play(p);
		System.out.println(p);
		
		master.play(p1);
		System.out.println(p1);
	}
	@Test
	public void testPlayWithPet2() {
		Master master = new Master();
		Pet p = new Dog("花花", 100);
		Pet p1 = new Penguin("Q妹", 99);
		
		for(int i=0;i<3;i++){
			master.play(p);
			System.out.println(p);
			
			master.play(p1);
			System.out.println(p1);
		}
	}
}
