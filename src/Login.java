import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
 
class Login implements ActionListener{
	
    //Declaring Objects
    Frame f=new Frame();
    
    Color clrb,clr1,clr2;
    Border bdr1;
    Font font2,font1;

    Label l1=new Label("Username:",Label.CENTER);
    Label l2=new Label("Password:",Label.CENTER);
    
    TextField t1=new TextField();
    TextField t2=new TextField();
    
    Button b1=new Button("Login");
    Button b2=new Button("Exit");

	
    
    Login()
    {
    	clrb = new Color(216,191,216);
        clr2 = new Color(253,245,230);
        clr1 = new Color(250,165,0,25);
        font2= new Font("lucida bright",Font.BOLD,16);
        
        
        bdr1 = BorderFactory.createLineBorder(Color.BLACK);
        //Giving Coordinates
        l1.setBounds(50,100,100,20);
        l2.setBounds(50,140,100,20);
        
        l1.setBackground(clr1);
        l1.setFont(font2);
        l2.setBackground(clr1);
        l2.setFont(font2);
        
        t1.setBounds(200,100,100,20);
        t2.setBounds(200,140,100,20);
        t2.setEchoChar('*');
        
        b1.setBounds(170,200,50,20);
        b1.setBackground(clr1);
        b1.setFont(font2);
        b2.setBounds(170,250,50,20);
        b2.setBackground(clr1);
        b2.setFont(font2);
        
        //Adding components to the frame
        f.add(l1);
        f.add(l2);
        
        f.add(t1);
        f.add(t2);
        
        f.add(b1);
        f.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        f.addWindowListener(new MyWindowAdapter());
        f.setTitle("Quiz app");
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(400,400);
        f.setBackground(clrb);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1 ){
            if(t1.getText().equals("Khushal") && t2.getText().equals("Magare") )
            {
                new Quiz();
                f.setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please enter correct login details");
            }
        }
        if(e.getSource() == b2 ){
            System.exit(0);
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
class MyWindowAdapter extends WindowAdapter{
	public void windowClosing(WindowEvent w) {
		System.exit(0);
	};
}
