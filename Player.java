import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Player{
	private JLabel player;
	
	
	public Player() {
		player = new JLabel();
	}
	
	public void setPlayer(int index) {
		String[] name = new String[] {"Matt", "Sophia", "Steve"};
		player.setForeground(new Color(255, 51, 0));
		player.setFont(new Font("Tahoma", 1, 27));
		player.setText(name[index]);
		
		
	}
	public String getName() {
		return player.getText();
	}
	
	public JLabel getPlayer() {
		return player;
	}

}
