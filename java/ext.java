import java.applet.*; 
import java.awt.*;

public class ext extends Applet { 
   Image img;
   MediaTracker tr;
   public void paint(Graphics g) {
      tr = new MediaTracker(this);
      img = getImage(getCodeBase(), "/home/gboy/program/java/sonoo.jpg");
      tr.addImage(img,0);  
      g.drawString("welcome to applet",150,150);  
      g.drawImage(img, 0, 0, this); 
      g.drawString("welcome to applet",150,150);  
   } 
} 
