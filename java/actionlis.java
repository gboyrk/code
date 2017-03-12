import java.awt.*;
import java.awt.event.*;

class actionlis extends Frame implements ActionListener{
TextField tf;
actionlis()
{
tf = new TextField();
tf.setBounds(2,40,200,50);
Button bt = new Button("click me");
bt.setBounds(2,10,10,20);
bt.addActionListener(this);
add(tf);add(bt);
setSize(100,200);
setVisible(true); 
}
public void actionPerformed(ActionEvent e)
{
tf.setText("magic");
}
public static void main(String arg[])
{
new actionlis();
}
}
