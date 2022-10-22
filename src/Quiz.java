import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Quiz implements ActionListener{
	//Declaring Objects
    static int totalQues;// = totalQuestion(0);    //Initialize with 0
    static Color cb = new Color(52,219,235);
	Frame quiz = new Frame();

	Button b1=new Button("Insert");
    Button b2=new Button("Modify");
    Button b3=new Button("Delete");
    Button b4=new Button("Generate");
    Button b5=new Button("Exit");
    
    Color clrb = new Color(216,191,216);
    Color clr1 = new Color(253,245,230);
    Color clr2 = new Color(128,0,0);
    Font font2= new Font("lucida bright",Font.BOLD,16);

    Quiz(){
        totalQues = totalQuestion(0);    	//COUNT TOTAL QUESTIONS AT START
    	
    	b1.setBounds(220,250,360,40);
        b2.setBounds(220,300,360,40);
        b3.setBounds(220,350,360,40);
        b4.setBounds(220,400,360,40);
        b5.setBounds(220,450,360,40);
        
        b1.setBackground(cb);
        b2.setBackground(cb);
        b3.setBackground(cb);
        b4.setBackground(cb);
        b5.setBackground(cb);

        quiz.add(b1);
        quiz.add(b2);
        quiz.add(b3);
        quiz.add(b4);
        quiz.add(b5);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
	    b4.addActionListener(this);
        b5.addActionListener(this);

	   quiz.setLayout(null);
	   quiz.setVisible(true);
	   quiz.setTitle("Quiz Menu");
	   quiz.setLocation(343,0);
	   quiz.setSize(800,800); 
	   quiz.setBackground(clrb);
	   quiz.addWindowListener(new MyWindowAdapter());
    }

	public void actionPerformed(ActionEvent e){
        /*THESE THREE FUNCTIONS ARE DONE VIA SAME FRAME*/
		if(e.getSource()==b1){		//Insert
            new Insert();
            quiz.setVisible(false);
        }
            
        if(e.getSource()==b2){		//Modify
            new Insert();
            quiz.setVisible(false);
        }
        
        if(e.getSource()==b3){
            new Insert();			//Delete
            quiz.setVisible(false);
        }
        
        if(e.getSource()==b4){
            new Generate();			//Generate
            quiz.setVisible(false);
        }
        
        if(e.getSource()==b5){
            System.exit(0);
        }
	}

	public static void main(String args[]){
		new Quiz();
	}

    /*COUNT THE NUMBER OF QUESTIONS PRESENT IN EACH QUESTION FILE*/
    public static int totalQuestion(int c){
        int count = 0;
        if(c == 0){
            totalQues = c;
            /*COUNT QUESTIONS ONE BY ONE*/
        try{
            LineNumberReader reader  = new LineNumberReader(new FileReader("TF.txt"));
            String lineRead = "";
            while ((lineRead = reader.readLine()) != null) {}
                count = reader.getLineNumber(); 
            reader.close();
            totalQues = totalQues + count;
        }catch(IOException e){
            e.printStackTrace();
        }
            count = 0;
        try{
            LineNumberReader reader  = new LineNumberReader(new FileReader("FillinTheBlanks.txt"));
            String lineRead = "";
            while ((lineRead = reader.readLine()) != null) {}
                count = reader.getLineNumber(); 
            reader.close();
            totalQues = totalQues + count;
        }catch(IOException e){
            e.printStackTrace();
        }

            count = 0;
        try{
            LineNumberReader reader  = new LineNumberReader(new FileReader("MCQ.txt"));
            String lineRead = "";
            while ((lineRead = reader.readLine()) != null) {}
                count = reader.getLineNumber(); 
            reader.close();
            totalQues = totalQues + count;
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Quiz contains " + totalQues + " Questions.");
    }
        else{
            totalQues = totalQues + c;
            System.out.println(totalQues);
        }
        return totalQues;
    }
}
