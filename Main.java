package org.raf.life;

import java.io.IOException;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		Long val = new Long("4321");
		Long val2 = new Long(4321);
		Long val3 = 4321L;
		Long val4 = Long.parseLong("4321");
		System.out.println(val + " " + val2 + " " + val3 + " " + val4);
//		Scanner scnObj = new Scanner(System.in);
//		int N = scnObj.nextInt();
//		Long S = scnObj.nextLong();
//		int M = scnObj.nextInt();
//		
//		lifeGenerator life = new lifeGenerator(N, S);
//		World world = new World(N, life);
//		if (M == 0) {
//			world.printWorld();
//		}
//		while(M != 0) {
////			System.out.println(M-1 + "-------------------");
//			world.setWorld(life.findNewGen(world));
////			world.printWorld();
//			M--;
//			
////			waitForEnter();
//			if (M == 0) {
//				world.printWorld();
//			}
//		}
		
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
