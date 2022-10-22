import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
import javax.swing.*; 

class TrueFalse implements ActionListener{
    Frame truefalse = new Frame();
    static String subject;

    Label topic = new Label("TRUE AND FALSE");
    Label labelInsert = new Label("INSERT New Question here");
	TextField tfInsert = new TextField();

	Label labelModifyDelete = new Label("Modify or Delete from here.");
    Choice choiceQuesList = new Choice();
    
    Label labelOption = new Label("Write all the Options here");
    Choice choiceOption = new Choice();
    
	Button buttonInsert = new Button("Insert");
	Button buttonModify = new Button("Modify");
	Button buttonDelete = new Button("Delete");
	Button bMenu = new Button("Back to Menu");

	TrueFalse(){
		
		buttonInsert.setBackground(Quiz.cb);
		buttonModify.setBackground(Quiz.cb);
		buttonDelete.setBackground(Quiz.cb);
		bMenu.setBackground(Quiz.cb);
		
		Color clrb = new Color(216,191,216);
	    Color clr1 = new Color(253,245,230);
	    Color clr2 = new Color(128,0,0);
	    Font font2= new Font("lucida bright",Font.BOLD,16);
		/*IDENTIFY THE SUBJECT*/
		subject = Insert.SubjectName();
		if(subject.equals("Technology"))
			subject = "Technology";
		else if(subject.equals("Indian Geogrophy"))
			subject = "Indian Geogrophy";
		else
			subject = "Indian History";

		topic.setBounds(325,40,150,20);
        labelInsert.setBounds(50,100,300,20);
        tfInsert.setBounds(50,130,300,20);

        labelModifyDelete.setBounds(450,100,300,20);
        choiceQuesList.setBounds(450,130,300,20);
        
        labelOption.setBounds(270,250,300,20);
        choiceOption.setBounds(250,300,300,20);

        buttonInsert.setBounds(220,400,80,25);
        buttonModify.setBounds(350,400,80,25);
        buttonDelete.setBounds(480,400,80,25);
        bMenu.setBounds(250,600,300,25);

  		truefalse.add(topic);
        truefalse.add(labelInsert);
        truefalse.add(tfInsert);
        truefalse.add(labelModifyDelete);
        truefalse.add(choiceQuesList);
        addQuestionsToList();
        truefalse.add(labelOption);
        
        truefalse.add(choiceOption);
        choiceOption.add("T");
        choiceOption.add("F");     
        
        truefalse.add(buttonInsert);
        truefalse.add(buttonModify);
        truefalse.add(buttonDelete);
        truefalse.add(bMenu);

        buttonInsert.addActionListener(this);
        buttonModify.addActionListener(this);
        buttonDelete.addActionListener(this);
        bMenu.addActionListener(this);

        truefalse.setLayout(null);
        truefalse.setVisible(true);
        truefalse.setLocation(343, 0);
        truefalse.setSize(800,800);
        truefalse.setBackground(clrb);
        truefalse.addWindowListener(new MyWindowAdapter());
	}

	public void actionPerformed(ActionEvent e){

		if(e.getSource() == buttonInsert){	//Insert Button
			Insertion();
			JOptionPane.showMessageDialog(null, "Saved");
			new Quiz();
			truefalse.setVisible(false);
		}
		else if(e.getSource() == buttonModify){	//BACK TO MENU BUTTON
			Modification();
			JOptionPane.showMessageDialog(null, "Modified");
			new Quiz();
			truefalse.setVisible(false);
		}
		else if(e.getSource() == buttonDelete){
			Deletion();
			JOptionPane.showMessageDialog(null, "Deleted");
			new Quiz();
			truefalse.setVisible(false);
		}
		else if(e.getSource() == bMenu){
			new Quiz();
			truefalse.setVisible(false);
		}
	}

	public static void main(String args[]){
		new TrueFalse();
	}

	public void Insertion(){
		String newQues = tfInsert.getText();
		String option = choiceOption.getItem(choiceOption.getSelectedIndex());
			try{
				String filepath = "TF.txt";
				//int c =  QuesCount(filepath); c++;
				FileWriter fw = new FileWriter(filepath,true);
				PrintWriter pw = new PrintWriter(fw);

				pw.println(subject + "," + newQues + ","  + option);
				pw.flush();
				pw.close();
				fw.close();

				//JOptionPane.showMessageDialog(null, "Saved");
				Quiz.totalQuestion(1);	//to increment the question by one
			}catch(Exception ae){
				JOptionPane.showMessageDialog(null, "NOT Saved");
			}
	}

	public void Modification(){
		Deletion();
		Insertion();
	}

	public void Deletion(){
		String ques = choiceQuesList.getItem(choiceQuesList.getSelectedIndex());

	try{
		File inputFile = new File("TF.txt");
		File tempFile = new File("TempTF.txt");
		FileReader fread = new FileReader(inputFile);
		FileWriter fwrite = new FileWriter(tempFile);

		BufferedReader reader = new BufferedReader(fread);
		BufferedWriter writer = new BufferedWriter(fwrite);
		ques = subject + "," + ques;
		String currentLine;

		//System.out.println("Org " + ques);
		while((currentLine = reader.readLine()) != null) {
    		String trimmedLine = currentLine.trim();
	   		if(trimmedLine.equals(ques)) {    			
    			continue;
    		}
    		writer.write(currentLine + System.getProperty("line.separator"));
		}
		//System.out.println("CLOSE ");
		try{
			writer.close(); 
			reader.close();
			fread.close();
			fwrite.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		//System.out.println("CLOSE DONE ");
		inputFile.delete();
		//System.out.println(s);
		tempFile.renameTo(inputFile);
//		choiceQuesList.remove(ques);
		Quiz.totalQuestion(-1);	//to decrement the question by one
		//JOptionPane.showMessageDialog(null, "Deleted");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/*ADD QUESTIONS TO THE LIST*/
	public void addQuestionsToList(){
		try{
			File f = new File("TF.txt");
			BufferedReader b = new BufferedReader(new FileReader(f));
			String readLine = "";
			while((readLine = b.readLine()) != null){
				String[] subStr = readLine.split(",");
				//System.out.println(subject);
				if(subStr[0].equals(subject)){
					String ques = subStr[1].concat("," + subStr[2]);
					choiceQuesList.add(ques);
				}
			}
			b.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
	

	