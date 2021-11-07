package org.raf.life;

import java.io.IOException;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		System.out.println("Enter size of universe");
		Scanner scnObj = new Scanner(System.in);
		int N = scnObj.nextInt();
//		Long S = scnObj.nextLong();
//		int M = scnObj.nextInt();
//		Long S = 0L;
		int M = 20;
		
//		lifeGenerator life = new lifeGenerator(N, S);
		lifeGenerator life = new lifeGenerator(N);
		World world = new World(N, life);
		if (M == 0) {
			world.printWorld();
		}
		int gen = 1;
		while(M != 0) {
//			System.out.println(M-1 + "-------------------");
			System.out.println("Generation #" + gen + "\nAlive: " + world.getLiving() + "\n");
			world.setWorld(life.findNewGen(world));
			world.printWorld();
			M--;
			gen++;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clrscr();
//			waitForEnter();
//			if (M == 0) {
//				world.printWorld();
//			}
			
		}
		
//		System.out.println("\n\nGoodbye");
	}
	
	
	static void waitForEnter() {
		System.out.println("\n\nPress Enter and pass the move to next Gen\n");
//		System.out.println("...\n");
		Scanner keyboard = new Scanner(System.in);
		String enter =  keyboard.nextLine();
		while(!enter.isEmpty()) {
			enter = keyboard.nextLine();
		}
		clrscr();
	}
	
	public static void clrscr(){
	    //Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	}

}
