package soonyoong.headfirst.java;

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class java10bQuizCardBuilder {
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private JFrame frame;

	public static void main(String[] args) {
		java10bQuizCardBuilder builder = new java10bQuizCardBuilder();
		builder.go();
	}

	public void go() {
        // build gui
        frame = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);
        question = new JTextArea(6,20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);
       
        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        answer = new JTextArea(6,20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);
       
        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JButton nextButton = new JButton("Next Card");
        
        cardList = new ArrayList<QuizCard>();
        JLabel qLabel = new JLabel("Question:");
        JLabel aLabel = new JLabel("Answer:");
        
        mainPanel.add(qLabel);
        mainPanel.add(qScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());
        JMenuBar menuBar = new JMenuBar();
        JMenu ﬁleMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        
        
        JMenuItem saveMenuItem = new JMenuItem("Save");
        newMenuItem.addActionListener(new NewMenuListener());
        
        saveMenuItem.addActionListener(new SaveMenuListener());
        ﬁleMenu.add(newMenuItem);      
        ﬁleMenu.add(saveMenuItem);
        menuBar.add(ﬁleMenu);
        frame.setJMenuBar(menuBar);   
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500,600);
        frame.setVisible(true);        
    }

	public class NextCardListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {

			QuizCard card = new QuizCard(question.getText(), answer.getText());
			cardList.add(card);
			clearCard();
		}
	}

	public class SaveMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			QuizCard card = new QuizCard(question.getText(), answer.getText());
			cardList.add(card);

			JFileChooser ﬁleSave = new JFileChooser();
			ﬁleSave.showSaveDialog(frame);
			saveFile(ﬁleSave.getSelectedFile());
		}
	}

	public class NewMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			cardList.clear();
			clearCard();
		}
	}

	private void clearCard() {
       question.setText("");
       answer.setText("");
       question.requestFocus();
    }

	private void saveFile(File ﬁle) {             
      try {
          BufferedWriter writer = new BufferedWriter(new FileWriter(ﬁle));
          
          for(QuizCard card:cardList) {
             writer.write(card.getQuestion() + "/");
             writer.write(card.getAnswer() + "\n");
          }
         writer.close();
       } catch(IOException ex) {
           System.out.println("couldn’t write the cardList out");
           ex.printStackTrace();
       }     
    }
}
