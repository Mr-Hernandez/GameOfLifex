package org.raf.life;

import java.io.IOException;
import java.util.Scanner;

class Main {
	private static int gen = 1;
	private static int N;
	static World world;
	static lifeGenerator life;
	
	public static void theRealMain() {
		
		System.out.println("Enter size of universe");
		Scanner scnObj = new Scanner(System.in);
		N = scnObj.nextInt();
		GameOfLife gof = new GameOfLife();
//		Long S = scnObj.nextLong();
//		int M = scnObj.nextInt();
//		Long S = 0L;
//		int M = 50;
		
//		lifeGenerator life = new lifeGenerator(N, S);
		life = new lifeGenerator(N);
		world = new World(N, life);
//		if (M == 0) {
//			world.printWorld();
//		}
//		int gen = 1;
		while(true) {
			if (gof.isRunning()) {
	//			System.out.println(M-1 + "-------------------");
//				System.out.println("Generation #" + gen + "\nAlive: " + world.getLiving() + "\n");
				world.setWorld(life.findNewGen(world));
				//world.printWorld();
				gof.updateCells(world.getWorldArr(), gen, world.getLiving());
				//M--;
				gen++;
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				gof.updateCells(world.getWorldArr(), gen, world.getLiving());
			}
			
			if(gof.isRestart()) {
				life.resetSeed();
				world.populateWorld(life);
				gen = 1;
			}
			
			//clrscr();
		}
		//System.out.println("OUT");
		//GameOfLife gamer = new GameOfLife();
		
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
	
	public static int getGeneration() {
		return gen;
	}
	
	public static int getWorldSize() {
		return N;
	}
	
	public static char[][] getWorldArr() {
		return world.getWorldArr();
	}


}
