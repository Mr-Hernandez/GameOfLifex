package org.raf.life;

import javax.swing.*;
import java.awt.*;

public class DrawRect extends JPanel {
	    final private int N = Main.getWorldSize();
	    private int W;
	    private int H;
	    private int cellWidth;
	    private int cellHeight;

	   @Override
	   protected void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      // Set up the grid and make it dynamic to panel size
	      //int N = Main.getWorldSize();

		  W = this.getWidth();
		  H = this.getHeight();
		  cellWidth = W / N;
		  cellHeight = H / N;
	      // draw the rectangle here
	      for (int i = 0; i < N; i++) {
	    	  for (int j = 0; j < N; j++) {
	    		  g.drawRect(0 + i * cellWidth + ((W % N) / 2), 0 + j * cellHeight + ((H % N) / 2), cellWidth, cellHeight);		  
	    	  }
	      }
	      updateCells(g);
	      
//	      g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
//	      g.drawRect(20, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
	      
	   }

//	   @Override
//	   public Dimension getPreferredSize() {
//	      // so that our GUI is big enough
//	      return new Dimension(RECT_WIDTH + 2 * RECT_X, RECT_HEIGHT + 2 * RECT_Y);
//	   }
//	   
//	   public void updateWorld(char[][] arr) {
//		      for (int i = 0; i < N; i++) {
//		    	  for (int j = 0; j < N; j++) {
//		    		  g.drawRect(0 + i * cellWidth + ((W % N) / 2), 0 + j * cellHeight + ((H % N) / 2), cellWidth, cellHeight);
//		    	  }
//		      }
//	   }
	   
	   public void updateCells(Graphics g) {
		      for (int i = 0; i < N; i++) {
		    	  for (int j = 0; j < N; j++) {
		    		  g.drawRect(0 + i * cellWidth + ((W % N) / 2), 0 + j * cellHeight + ((H % N) / 2), cellWidth, cellHeight);
		    		  char[][] arr = Main.getWorldArr();
		    		  if (arr[i][j] == 'O') {
		    			  g.setColor(Color.BLACK);
		    			  g.fillRect(0 + i * cellWidth + ((W % N) / 2), 0 + j * cellHeight + ((H % N) / 2), cellWidth, cellHeight);
		    			  
		    		  } else {
		    			  //g.setColor(Color.BLACK);
//		    			  g.clearRect(0 + i * cellWidth + ((W % N) / 2), 0 + j * cellHeight + ((H % N) / 2), cellWidth, cellHeight);

		    		  }
		    		  
		    	  }
		      }
	   }
	   
}
