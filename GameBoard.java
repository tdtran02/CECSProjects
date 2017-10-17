import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.*;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.Random;


public class GameBoard extends JFrame{
	private ImageIcon image;
	private JLabel label;
	private Player name1;
	private Player name2;
	private Player human;
	private JPanel panel1;
	private JPanel panel2;
	private JScrollPane scroll1;
	private JScrollPane scroll2;
	private JScrollPane scroll3;
	private JTextField textField;
	private JList list1;
	private JList list2;
	private JList humanList;
	private JTextArea textArea;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private Room mapList;
	
	public GameBoard() {
		
		boardComponent();
		
	}
	
	private void boardComponent() {
	    label = new JLabel();
	    name1 = new Player();
	    name2 = new Player();
	    human = new Player();
	    panel1 = new JPanel();
	    panel2 = new JPanel();
		scroll1 = new JScrollPane();
		scroll2 = new JScrollPane();
		scroll3 = new JScrollPane();
	    button1 = new JButton();
	    button2 = new JButton();
	    button3 = new JButton();
	    list1 = new JList<>();
	    list2 = new JList<>();
	    humanList = new JList<>();
	    textField = new JTextField();
	    textArea = new JTextArea();
	       
	    Random rand = new Random();
		int number = rand.nextInt(3);
		if (number == 0)
		{
			name1.setPlayer(number + 1);
		    name2.setPlayer(number + 2);
		    human.setPlayer(number);
		}
		else if(number == 1)
		{
			name1.setPlayer(number - 1);
		    name2.setPlayer(number + 1);
		    human.setPlayer(number);
		}
		else
		{
			name1.setPlayer(number - 1);
		    name2.setPlayer(number - 2);
		    human.setPlayer(number);
		}
	    
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    

	    scroll1.setPreferredSize(new Dimension(1900, 1500));
	    
        label.add(name1.getPlayer());
        name1.getPlayer().setBounds(600, 960, 100, 50); //(location x, location y, width, height)
        
        label.add(name2.getPlayer());
        name2.getPlayer().setBounds(600, 1000, 100, 50);//(location x, location y, width, height)
        
        label.add(human.getPlayer());
        human.getPlayer().setBounds(600, 1040, 100, 50); //(location x, location y, width, height)
	    
        /*
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

	   
	    textField.setText("TextField");*/
	    
	   
    	
	   
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label.setIcon(new javax.swing.ImageIcon("CSULBMap5_1200x1437.png"));
        scroll1.setViewportView(label);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        button1.setText("Draw Card");	        
        button1.setMaximumSize(new Dimension(120, 25));
	    button1.setMinimumSize(new Dimension(120, 25));
	    button1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	jButton1ActionPerformed(evt);
		    	}
		    });
       
	    button2.setText("Move");
	    button2.setMaximumSize(new Dimension(120, 25));
	    button2.setMinimumSize(new Dimension(120, 25));
	    button2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	jButton2ActionPerformed(evt);
		    	}
		    });

	    button3.setText("Play Card");
	    button3.setMaximumSize(new Dimension(120, 25));
	    button3.setMinimumSize(new Dimension(120, 25));
	    button3.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {
	    	jButton3ActionPerformed(evt);
	    	}
	    });


	    mapList = new Room();
    	mapList.addList("pathways.txt");
    	updateList(mapList, 0, humanList);
    	updateList(mapList, 0, list1);
    	updateList(mapList, 0, list2);
    	scroll2.setViewportView(humanList);

        textField.setText("jTextField");
        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        scroll3.setViewportView(textArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button1)
                    .addComponent(button2)
                    .addComponent(button3)
                    .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(294, 294, 294)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField)
                    .addComponent(scroll3, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(button1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(textField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
		
	}
	
	 private void jButton1ActionPerformed(ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }  
	 
	 private void jButton2ActionPerformed(ActionEvent evt) {                                         
	        // TODO add your handling code here:
		 if (humanList.getSelectedValue() != null) {
			 //human.setLocation(human.getX(), human.getY() - 150);
			 //System.out.print(list.getSelectedValue());
			 String humanRoom = (String)humanList.getSelectedValue();
			 int labelAt = mapList.compareMap(humanRoom);
			 human.movePlayer(humanRoom, 80);
			 updateList(mapList, labelAt, humanList);
			 scroll2.setViewportView(humanList);
		 }
	    }  
	
	 private void jButton3ActionPerformed(ActionEvent evt) {                                         
	        // TODO add your handling code here:
		 Random rand1 = new Random();
		 int number1 = rand1.nextInt(list1.getModel().getSize()-1);
		 String comp1Room = ((String)list1.getModel().getElementAt(number1));
		 int comp1At = mapList.compareMap(comp1Room);
		 name1.movePlayer(comp1Room, 0);
		 updateList(mapList, comp1At, list1);
		 
		 Random rand2 = new Random();
		 int number2 = rand2.nextInt(list2.getModel().getSize()-1);
		 String comp2Room = ((String)list2.getModel().getElementAt(number2));
		 int comp2At = mapList.compareMap(comp2Room);
		 name2.movePlayer(comp2Room, 40);
		 updateList(mapList, comp2At, list2);
		 
	    }  
	 
	 private void updateList(Room mapList, int index, JList usrList) {
		 String[] in = mapList.getList(index).split("\\|+");
	 	    String[] strings = new String[in.length];
	 	    
	 	    for (int i = 1; i < in.length; i++) {
	 	    	strings[i - 1] = in[i];
	 	    }
		    usrList.setModel(new AbstractListModel<String>() {
		    
		    public int getSize(){return strings.length;}
		    public String getElementAt(int i) {return strings[i];}
		    });
		    
	 }
	 
	 private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
	        // TODO add your handling code here:
	    }   

}
