/* Assignment 5 by Ryan Winter for COP3252 */
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DesktopFrame extends JFrame{
	   public static boolean greenShape = false;
	   public static boolean blueShape = false;
	   public static boolean redShape = false;
	   public static boolean moveShape = false;
	   
	   public static boolean returnGreenShape(){
		   return greenShape;
	   }
	   public static boolean returnBlueShape(){
		   return blueShape;
	   }
	   public static boolean returnRedShape(){
		   return redShape;
	   }
	   public static boolean returnMoveShape(){
		   return moveShape;
	   }
	   private JDesktopPane theDesktop;
	   
	   public DesktopFrame()
	   {
	      super("HW5");
	      JMenuBar bar = new JMenuBar(); // create menu bar
	      
	      JMenu addMenu = new JMenu("Create"); // create menu
	      addMenu.setMnemonic(KeyEvent.VK_C);
	      
	      JMenuItem newFrame = new JMenuItem("Picture");
	      newFrame.setMnemonic(KeyEvent.VK_P);
	      
	      JMenuItem newFrame2 = new JMenuItem("Changeable Picture");
	      newFrame2.setMnemonic(KeyEvent.VK_C);
	      
	      JMenuItem newFrame3 = new JMenuItem("Randomized Picture");
	      newFrame3.setMnemonic(KeyEvent.VK_R);
	      
	      addMenu.add(newFrame); // add new frame to menu
	      bar.add(addMenu); // add frame to menu
	      
	      JMenu addMenu2 = new JMenu("Quit"); // create menu
	      addMenu2.setMnemonic(KeyEvent.VK_Q);
	      
	      JMenuItem newFrame4 = new JMenuItem("Exit Program");
	      newFrame4.setMnemonic(KeyEvent.VK_X);
	      newFrame4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK)); // accelerator that allows user to close program by pressing control+x

	      addMenu.add(newFrame); // add frame to menu   // frame is picture
	      addMenu.add(newFrame2); // add frame2 to menu  // frame 2 is changeable picture
	      addMenu.add(newFrame3); // add frame3 to menu  // frame 3 is randomized picture
	      addMenu2.add(newFrame4); // add frame4 to menu // frame 4 is exit program
	      bar.add(addMenu2);
	      setJMenuBar(bar); 
	      theDesktop = new JDesktopPane(); // create desktop pane
	      add(theDesktop); // add desktop pane to frame
	    
	      newFrame.addActionListener(
	         new ActionListener()
	         {  
	            public void actionPerformed(ActionEvent event) 
	            {
	               JInternalFrame frame = new JInternalFrame( 
	                  "Picture Frame", true, true, true, true );
	               aJPanel panel1 = new aJPanel(); // create panel1
	               frame.add(panel1, BorderLayout.CENTER);
	               panel1.setBackground(Color.BLUE);
	               frame.setSize(300,300);
	               theDesktop.add(frame);      
	               frame.setVisible(true);
	            }
	         }
	      );
	      newFrame2.addActionListener(
	         new ActionListener()
	         {  
	            public void actionPerformed(ActionEvent event) 
	            {
	               JInternalFrame frame2 = new JInternalFrame( 
	                  "Changeable Picture Frame", true, true, true, true );
	               //***************************************************************************** not working..
	               anotherJPanel panel2 = new anotherJPanel();
	               frame2.add(panel2, BorderLayout.CENTER);
	               frame2.setSize(300,300);
	               theDesktop.add(frame2);
	               frame2.setVisible(true);
	               frame2.pack();
	               //***************************************************************************** not working..
	               JRadioButton green = new JRadioButton("Green", true); // sets as default
	               JRadioButton red = new JRadioButton("Red");
	               JRadioButton blue = new JRadioButton("Blue");
	               JCheckBox moveOnDrag;
	               moveOnDrag = new JCheckBox("Move on drag");
	               add(moveOnDrag);
	               ButtonGroup bGroup = new ButtonGroup();
	               bGroup.add(green);
	               bGroup.add(red);
	               bGroup.add(blue);
	               setLayout(new FlowLayout());
	               add(green);
	               add(red);
	               add(blue);
	               boolean moveSelected = moveOnDrag.isSelected();
	               boolean greenSelected = green.isSelected();
	               boolean blueSelected = blue.isSelected();
	               boolean redSelected = red.isSelected();
 
	               if(moveSelected)
	            	   moveShape = true; // code here if moveOnDrag is checked
	               if(greenSelected)
	            	   greenShape = true; // code here for if green is checked
	               else if(blueSelected)
	            	   blueShape = true; // code here for if blue is checked
	               else if(redSelected)
	            	   redShape = true; // code here for if red is checked.
	            }
	         }
	      );
	      
	      newFrame3.addActionListener(
	         new ActionListener()
	         {  
	            public void actionPerformed(ActionEvent event) 
	            {
	               JInternalFrame frame3 = new JInternalFrame( 
	                  "Randomized Picture Frame", true, true, true, true );
	               finalJPanel panel3 = new finalJPanel(); // create new panel
	               frame3.add(panel3, BorderLayout.CENTER); // add panel
	              // frame3.pack();
	               frame3.setSize(300,300);
	               theDesktop.add(frame3);
	               frame3.setVisible(true);
	            }
	         }
	      );

	      newFrame4.addActionListener(
	         new ActionListener()
	         {  
	            public void actionPerformed(ActionEvent event)
	            {
	            	System.exit(0); // closes program if user uses menu option to exit program
	            }
	         }
	      );
	   }
	}

	class aJPanel extends JPanel 
	{
		   public void paintComponent(Graphics g)
		   {
		   	   super.paintComponent(g);
		   	   int height = getSize().height / 4;
		   	   int width = getSize().width / 4;
		   	   int rectHeight = getSize().height / 10;
		   	   int rectWidth = getSize().width;
		   	   g.setColor(Color.YELLOW);
		   	   g.drawOval(160, 25, height, width);
		   	   g.fillOval(160, 25, height, width);
		   	   Color newBrown = new Color(139, 69, 19); // made a brown color called myBrown
		       g.setColor(newBrown);
		   	   g.drawRect(0, 240, 300, 30);
		   	   g.fillRect(0, 240, 300, 30);
		   }
}
	class anotherJPanel extends JPanel 
	{
		boolean moveShapeNEW = false; 
		   public void paintComponent(Graphics g)
		   {
			  // g.setColor(Color.BLUE); // TEST
			   super.paintComponent(g);			   
			   if(DesktopFrame.returnGreenShape())
				   g.setColor(Color.GREEN);
			   if(DesktopFrame.returnBlueShape())
				   g.setColor(Color.BLUE);
			   if(DesktopFrame.returnRedShape())
				   g.setColor(Color.RED);
			   if(DesktopFrame.returnMoveShape())
				   moveShapeNEW = true;  
		   	   
		   	   int height = getSize().height / 4;
		   	   int width = getSize().width / 4;
		   	   g.drawOval(160, 25, 50, 50);
		   	   g.fillOval(160, 25, 50, 50);
		   	   if(moveShapeNEW){
		   		   // code here to handle dragging of oval if checkbox is selected
		   	   }
		   }	  
	}
	
	class finalJPanel extends JPanel 
	{
		   public void paintComponent(Graphics g)
		   {
		   	   super.paintComponent(g);
		   	   Random newRandomNum = new Random();
		   	   int randNumOfRect = newRandomNum.nextInt(6); // generate random number from 1-5
		   	   int randHeight = 0;
		   	   int randWidth = 0; 
		   	   int randColor1 = 0;
		   	   int randColor2 = 0;
		   	   int randColor3 = 0;
		   	   int randX = 0;
		   	   int randY = 0;
		   	   
		   	   for(int i = 0; i < randNumOfRect; i++){
			   	   randHeight = newRandomNum.nextInt(301); // generate random number from 1-300
			   	   randWidth = newRandomNum.nextInt(301); // generate random number from 1-300
			   	   randColor1 = newRandomNum.nextInt(256);
			   	   randColor2 = newRandomNum.nextInt(256);
			   	   randColor3 = newRandomNum.nextInt(256);
			   	   Color newRandColor = new Color(randColor1, randColor2, randColor3); // new rgb random color
			   	   g.setColor(newRandColor);
			   	   randX = newRandomNum.nextInt(301);
			   	   randY = newRandomNum.nextInt(301);
		   		   g.drawRect(randX, randY, randWidth, randHeight); // x, y, width, height 
		   		   g.fillRect(randX, randY, randWidth, randHeight);
		   }
	}
}