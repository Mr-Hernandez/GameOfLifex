package org.raf.life;

import java.util.Random;

class lifeGenerator {
	final private long seed;
	final private int worldSize;
	Random random;
	char[][] newGen;
	
	public lifeGenerator(int worldSize) {
		this.worldSize = worldSize;
		random = new Random();
		this.seed = 0;
	}
	
	public lifeGenerator(int worldSize, long seed) {
		this.seed = seed;
		this.worldSize = worldSize;
		random = new Random(this.seed);
	}
		
	public boolean getRand() {
		return random.nextBoolean();
	}
	
	public char[][] findNewGen(World world) {
		newGen = new char[world.world.length][world.world.length];
		resetNewGen();
		juliusCeaser(world.world);
		return newGen;
	}
	
	private void juliusCeaser(char[][] oldGen) {
		// survive with 2 or 3 neighbors else death
		// dead cell reborn if exactly 3 live neighbors
		int living = 0;
		for (int i = 0; i < oldGen.length; i++) { // main row
			for (int j = 0; j < oldGen[i].length; j++) { // main column
				// board check order
				// 1 4 7
				// 2 5 8
				// 3 6 9
				for (int k = 0; k < 3; k++) { // row iterator
					for (int z = 0; z < 3; z++) { // column iterator
						try {
						// 4 corner cases
							// top left corner
							if (i == 0 && j == 0) {
								if (k == 0 & z == 0) {
									if(oldGen[oldGen.length-1][oldGen.length-1] == 'O') {
										living++;
									}
								}
								else if (k != 0 && z == 0) {
									if(oldGen[i-1+k][oldGen.length-1] == 'O') {
										living++;
									}
								}
								else if (k == 0 && z != 0) {
									if(oldGen[oldGen.length-1][j-1+z] == 'O') {
										living++;
									}
								}
								else if (k != 0 && z != 0) {
									if(oldGen[i-1+k][j-1+z] == 'O') {
										living++;
									}
								}
							}
							// top right corner
							else if (i == 0 && j == oldGen.length-1) {
								if (k == 0 && z == 2) {
									if (oldGen[oldGen.length-1][0] == 'O') {
										living++;
									}
								}
								else if (k == 0 && z != 2) {
									if (oldGen[oldGen.length-1][j-1+z] == 'O') {
										living++;
									}
								}
								else if (k != 0 && z == 2) {
									if (oldGen[i-1+k][0] == 'O') {
										living++;
									}
								}
								else if (k != 0 && z != 2) {
									if (oldGen[i-1+k][j-1+z] == 'O') {
										living++;
									}
								}
							}
							// bottom left corner
							else if (i == oldGen.length-1 && j == 0) {
								if (k == 2 && z == 0) {
									if (oldGen[0][oldGen.length-1] == 'O') {
										living++;
									}
								}
								else if (k == 2 && z != 0) {
									if (oldGen[0][j-1+z] == 'O') {
										living++;
									}
								}
								else if (k != 2 && z == 0) {
									if (oldGen[i-1+k][oldGen.length-1] == 'O') {
										living++;
									}
								}
								else if (k != 2 && z != 0) {
									if (oldGen[i-1+k][j-1+z] == 'O') {
										living++;
									}
								}
							}
							// bottom right corner
							else if (i == oldGen.length-1 && j == oldGen.length-1) {
								if (k == 2 && z == 2) {
									if (oldGen[0][0] == 'O') {
										living++;
									}
								}
								else if (k != 2 && z == 2) {
									if (oldGen[i-1+k][0] == 'O') {
										living++;
									}
								}
								else if (k == 2 && z != 2) {
									if(oldGen[0][j-1+z] == 'O') {
										living++;
									}
								}
								else if (k !=2 && z != 2) {
									if (oldGen[i-1+k][j-1+z] == 'O') {
										living++;
									}
								}
							}
							// non-corner edge cases
							else if (i == 0 && (j != 0 || j != oldGen.length-1)) {
								if (k == 0) {
									if (oldGen[oldGen.length-1][j-1+z] == 'O') {
										living++;
									}
								}
								if (k != 0) {
									if (oldGen[i-1+k][j-1+z] == 'O') {
										living++;
									}
								}
							}
							else if (i == oldGen.length-1 && (j != 0 || j != oldGen.length-1)) {
								if (k == 2) {
									if (oldGen[0][j-1+z] == 'O') {
										living++;
									}
								}
								if (k != 2) {
									if (oldGen[i-1+k][j-1+z] == 'O') {
										living++;
									}
								}
							}
							else if (j == 0 && (i != 0 || i != oldGen.length-1)) {
								if (z == 0) {
									if (oldGen[i-1+k][oldGen.length-1] == 'O') {
										living++;
									}
								}
								if (z != 0) {
									if (oldGen[i-1+k][j-1+z] == 'O') {
										living++;
									}
								}
							}
							else if (j == oldGen.length-1 && (i != 0 || i != oldGen.length-1)) {
								if (z == 2) {
									if (oldGen[i-1+k][0] == 'O') {
										living++;
									}
								}
								if (z != 2) {
									if (oldGen[i-1+k][j-1+z] == 'O') {
										living++;
									}
								}
							}
							// not edge cases
							else {
								if (oldGen[i-1+k][j-1+z] == 'O') {
								living++;	
								}
							}
							
						} catch (Exception e) {
							System.err.println("Caught IOException: " + e.getMessage());
							System.err.println("Caught IOException: " + e.getStackTrace()[0].getLineNumber());
						}

					}
				}
				// error with the algorithm here
				if (oldGen[i][j] == 'O') {living--;}
				if (living < 2 || living > 3) {newGen[i][j] = ' ';}
				if (oldGen[i][j] == 'O' && (living == 2 || living == 3)) {newGen[i][j] = 'O';}
				if (oldGen[i][j] == ' ' && living == 3) {newGen[i][j] = 'O';}
				
				living = 0;
			}
		}
	}
 
	private void resetNewGen() {
		for (int i = 0; i < newGen.length; i++) {
			for (int j = 0; j < newGen[i].length; j++)
				newGen[i][j] = ' ';
		}	
	}
	
	
}