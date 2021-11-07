package org.raf.life;

//import java.util.Arrays;

class World {
	private int worldSize;
	char[][] world;
	
	public World(int worldSize, lifeGenerator life) {
		this.worldSize = worldSize;
		createWorld(this.worldSize);
		populateWorld(life);
//		System.out.println("\n1");
//		printWorld();
		
	}
	
	private void createWorld(int N) {
		world = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				world[i][j] = ' ';
		}	
	}
	
	void populateWorld(lifeGenerator life) {
		for (int i = 0; i < worldSize; i++) {
			for (int j = 0; j < worldSize; j++) {
				if(life.getRand()) {
					world[i][j] = 'O';
				}
			}
		}
	}
	
	void printWorld() {
//		System.out.println(Arrays.deepToString(world));
		
//		for(char[] x: world)
//            System.out.println(Arrays.toString(x));
		
		for (int i = 0; i < worldSize; i++) {
			if(i != 0) {System.out.println();}
			for (int j = 0; j < worldSize; j++) {
				System.out.print(world[i][j]);
			}
		}
		System.out.println("\n");
	}
	
	void setWorld(char[][] newGen) {
		world = newGen;
	}
	
	int getLiving() {
		int alive = 0;
		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[i].length; j++) {
				if (world[i][j] == 'O') {alive++;}
			}
		}
		return alive;
	}
}

