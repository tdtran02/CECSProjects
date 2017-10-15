import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.*;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;


public class GameBoard extends JFrame{
	private ImageIcon image;
	private JLabel label;
	private JLabel name1;
	private JLabel name2;
	private JLabel human;
	private JPanel panel1;
	private JPanel panel2;
	private JScrollPane scroll1;
	private JScrollPane scroll2;
	private JScrollPane scroll3;
	private JTextField textField;
	private JList list;
	private JTextArea textArea;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	
	public GameBoard() {
		
		boardComponent();
		
	}
	
	private void boardComponent() {
	    label = new JLabel();
	    name1 = new JLabel();
	    name2 = new JLabel();
	    human = new JLabel();
	    panel1 = new JPanel();
	    panel2 = new JPanel();
		scroll1 = new JScrollPane();
		scroll2 = new JScrollPane();
		scroll3 = new JScrollPane();
	    button1 = new JButton();
	    button2 = new JButton();
	    button3 = new JButton();
	    list = new JList<>();
	    textField = new JTextField();
	    textArea = new JTextArea();
	       
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);

	    scroll1.setPreferredSize(new Dimension(1900, 1500));
	    
	    name1.setForeground(new java.awt.Color(255, 51, 0));
	    name1.setFont(new Font("Tahoma", 1, 27)); //(font = tahoma, 1 = bold, size = 27)
        name1.setText("Matt");
        label.add(name1);
        name1.setBounds(1000, 1000, 100, 50); //(location x, location y, width, height)
        
        name2.setForeground(new java.awt.Color(255, 51, 0));
        name2.setFont(new Font("Tahoma", 1, 27));
        name2.setText("Sophia");
        label.add(name2);
        name2.setBounds(1000, 1040, 100, 50);//(location x, location y, width, height)
        
        human.setForeground(new java.awt.Color(255, 51, 0));
        human.setFont(new Font("Tahoma", 1, 27));
        human.setText("Steve");
        label.add(human);
        human.setBounds(1000, 1080, 100, 50); //(location x, location y, width, height)
	    
	    label.setBounds(20, 30, 2000, 1500);
	    label.setMaximumSize(new Dimension(1900, 1500));
        label.setMinimumSize(new Dimension(1900, 1500));
        label.setPreferredSize(new Dimension(2000, 1500));

	    image = new ImageIcon("CSULBMap5_1200x1437.png"); // NOI18N
	    Image image2 = image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
	    ImageIcon scaledImage = new ImageIcon(image2);  
	    label.setIcon(scaledImage);
	   
	    scroll1.setViewportView(label);

	    panel1.setPreferredSize(new Dimension(2000, 453));

	    button1.setText("Draw Card");	        
	    button1.setPreferredSize(new Dimension(157, 41));
	    button1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	jButton1ActionPerformed(evt);
		    	}
		    });
       
	    button2.setText("Move");
	    button2.setPreferredSize(new Dimension(157, 41));
	    button2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	jButton2ActionPerformed(evt);
		    	}
		    });

	    button3.setText("Play Card");
	    button3.setPreferredSize(new Dimension(157, 41));
	    button3.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {
	    	jButton3ActionPerformed(evt);
	    	}
	    });

	    textField.setText("TextField");
	    
	    list.setModel(new AbstractListModel<String>() {
	    String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
	    public int getSize() { return strings.length; }
	    public String getElementAt(int i) { return strings[i]; }
	    });
	    scroll2.setViewportView(list);

	    textArea.setColumns(20);
	    textArea.setRows(5);
	    scroll3.setViewportView(textArea);

	    GroupLayout panel2Layout = new GroupLayout(panel2);
	    panel2.setLayout(panel2Layout);
	    panel2Layout.setHorizontalGroup(
	    		panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	    		);
	    panel2Layout.setVerticalGroup(
	    		panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	    		);

	    GroupLayout panel1Layout = new GroupLayout(panel1);
	    panel1.setLayout(panel1Layout);
	    panel1Layout.setHorizontalGroup(
	    		panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(panel1Layout.createSequentialGroup().addContainerGap()
	            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(button1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	            .addComponent(button3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	            .addGroup(panel1Layout.createSequentialGroup()
	            .addComponent(scroll2, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
	            .addGap(108, 108, 108)
	            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	            .addComponent(button2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 436, Short.MAX_VALUE)
	            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	            .addComponent(scroll3, GroupLayout.DEFAULT_SIZE, 1111, Short.MAX_VALUE).addComponent(textField))
	            .addContainerGap())
	    		);
	        
	    panel1Layout.setVerticalGroup(
	            panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(panel1Layout.createSequentialGroup()
	            .addComponent(textField).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	            .addComponent(scroll3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	            .addContainerGap()).addGroup(panel1Layout.createSequentialGroup()
	            .addComponent(button1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	            .addComponent(button2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	            .addComponent(button3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(scroll2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
	            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
	            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	            .addGap(155, 155, 155))))
	    		);

	    GroupLayout layout = new GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(
	    	layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
	    	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	        .addComponent(scroll1, GroupLayout.DEFAULT_SIZE, 2025, Short.MAX_VALUE)
	        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        .addGap(0, 25, Short.MAX_VALUE)));
	    layout.setVerticalGroup(
	        layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
	        .addContainerGap().addComponent(scroll1, GroupLayout.DEFAULT_SIZE, 1491, Short.MAX_VALUE)
	        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        );

	    pack();
		
	}
	
	 private void jButton1ActionPerformed(ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }  
	 
	 private void jButton2ActionPerformed(ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }  
	
	 private void jButton3ActionPerformed(ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }  

}
