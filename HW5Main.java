/* Assignment 5 by Ryan Winter for COP3252 */
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HW5Main {
	public static void main( String args[] )
	{ 
		
	   DesktopFrame desktopFrame = new DesktopFrame();  
	   desktopFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	   desktopFrame.setSize( 600, 480 ); // set frame size
	   desktopFrame.setVisible( true ); // display frame
		/*
	// need to check the size of window each time the paint frame is called so do it inside that method!
	   DesktopFrame dFrame = new DesktopFrame();  
	   dFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	   dFrame.setSize( 800, 600 ); // set frame size
	   dFrame.setVisible( true ); // display frame
	   
	   */
	}
}
