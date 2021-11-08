package org.raf.life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {
	private int width = 500;
	private int height = 500;
	private int topPanelHeight = 50;
	JPanel[][] cells;
	JLabel label = new JLabel("Gen");
	JLabel label2 = new JLabel("Alive");
	DrawRect rect;
	boolean[] play = {true};
	boolean[] restart = {false};
	
	
    public GameOfLife() {
    	super("GameOfLife");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);
        
        //setLayout(new GridLayout(2,1));
        //setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLayout(new BorderLayout());
        
        initComponents();
        setVisible(true);
    }
    
    private void initComponents() {
    	JPanel panel = new JPanel();
    	panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    	panel.setBackground(Color.ORANGE);
    	
    	int N = Main.getWorldSize();
    	JPanel panel2 = new JPanel(new GridLayout(N, N, 1, 1));
    	System.out.println(Main.getGeneration());
    	panel2.setBackground(Color.RED);
    	
    	rect = new DrawRect();  
    	
    	label.setName("GenerationLabel");
    	label2.setName("AliveLabel");
    	
    	//Icon pauseIcon = new ImageIcon("images\\pause.png");
//    	JButton pauseButton = new JButton(new ImageIcon(((new ImageIcon("images\\pause.png")).getImage()).getScaledInstance(30, -1, java.awt.Image.SCALE_SMOOTH)));
    	JButton pauseButton = new JButton();
    	ImageIcon pauseIcon = new ImageIcon(((new ImageIcon("images\\pause.png")).getImage()).getScaledInstance(30, 15, java.awt.Image.SCALE_SMOOTH));
    	ImageIcon playIcon = new ImageIcon(((new ImageIcon("images\\play.png")).getImage()).getScaledInstance(30, 15, java.awt.Image.SCALE_SMOOTH));
    	pauseButton.setIcon(pauseIcon);
    	pauseButton.setName("PlayTogglebutton");
    	
    	JButton restartButton = new JButton(new ImageIcon(((new ImageIcon("images\\restart.jpg")).getImage()).getScaledInstance(30, 15, java.awt.Image.SCALE_SMOOTH)));
    	restartButton.setName("ResetButton");
    	
    	JToggleButton playButton = new JToggleButton();
    	playButton.setIcon(pauseIcon);
//    	JButton acceptButton = new JButton(pauseIcon);
//        acceptButton.setBounds(100,70,100,30);
        //panel.add(pauseButton);
    	panel.add(playButton);
    	panel.add(restartButton);
        
    	panel.add(label);
    	panel.add(label2);

    	this.add(panel, BorderLayout.WEST);
//    	this.add(panel2, BorderLayout.CENTER);
    	this.add(rect, BorderLayout.CENTER);
    	
    	//boolean[] play = {false};
        pauseButton.addActionListener(e -> {
        	if(play[0]) {
        		pauseButton.setIcon(playIcon);
        		play[0] = !play[0];
        	} else {
        		pauseButton.setIcon(pauseIcon);
        		play[0] = !play[0];
        	}
        });
        
        restartButton.addActionListener(e -> {
        	restart[0] = true;
        });
        
        playButton.addItemListener(e -> {
        	if(play[0]) {
        		playButton.setIcon(playIcon);
        		play[0] = !play[0];
        	} else {
        		playButton.setIcon(pauseIcon);
        		play[0] = !play[0];
        	}
        });
    	


    }
    
    public void updateCells(char[][] arr, int gen, int alive) {
    	label.setText("Generation #" + gen);
    	label2.setText("Alive: " + alive);
    	rect.repaint();
    }
     
    public boolean isRunning() {
    	return play[0];
    }
    
    public boolean isRestart() {
    	boolean restarter = restart[0];
    	restart[0] = false;
    	return restarter;
    }


}