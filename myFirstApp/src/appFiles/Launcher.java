package appFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.lang.Character;

public class Launcher extends JFrame implements ActionListener, KeyListener {
	JLabel l1 = new JLabel("English to Morse Code Translator", JLabel.CENTER);
	JButton b1 = new JButton("Clear Text");
	JButton b2 = new JButton("Translate");
	JButton b3 = new JButton("");
	JPanel p1 = new JPanel(new BorderLayout());
	JPanel p2 = new JPanel(new GridLayout(2, 1));
	JPanel p3 = new JPanel(new GridLayout(2, 1));
	JTextArea f1 = new JTextArea(5, 10);
	JTextArea f2 = new JTextArea(5, 10);
	String s;
	int counter = 0;
	Image icon = Toolkit.getDefaultToolkit().getImage(Launcher.class.getResource("/MorseIcon2.png"));
	
	public Launcher() {
		l1.setFont(new Font("Calibri", Font.PLAIN, 30));
		
		b1.addActionListener(this);
		b1.setPreferredSize(new Dimension(50, 50));
		
		b2.addActionListener(this);
		
		p1.add(l1, BorderLayout.NORTH);
		this.add(p1, BorderLayout.NORTH);
		
		f1.addKeyListener(this);
		f1.setLineWrap(true);
		f1.setForeground(Color.LIGHT_GRAY);
		f1.setText("Enter English words here.");
		
		f2.setLineWrap(true);
		// f2.setForeground(Color.LIGHT_GRAY);
		
		p2.add(f1);
		p2.add(f2);
		this.add(p2);
		
		p3.add(b1);
		p3.add(b2);
		this.add(p3, BorderLayout.SOUTH);
		
		setIconImage(icon);
		setSize(500, 500);
		setTitle("Morse Code Translator");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			f1.setForeground(Color.LIGHT_GRAY);
			f1.setText("Enter English words here.");
			f2.setText("");
			counter = 0;
		} else if(e.getSource() == b2) {
			//String string = f1.getText();
			//string = string.toLowerCase();
			//string.body = f1.getText().toLowerCase();
			s = f1.getText();
			s = s.toLowerCase();
			this.toMorse();
		}
	}
	public void keyReleased(KeyEvent e) {
		
		}
	public void keyPressed(KeyEvent e) {
		
	}
	public void keyTyped(KeyEvent e) {
		if(e.getSource() == f1) {
			if(counter == 0) {
				f1.setText("");
				f1.setForeground(Color.BLACK);
				counter++;
			}
			else {
				
			}
		}
	}
	public void toMorse() {
		HashMap<Character, String> morse = new HashMap<Character, String>();
		String x = "";
		morse.put('a', ".-");
		morse.put('b', "-...");
		morse.put('c', "-.-.");
		morse.put('d', "-..");
		morse.put('e', ".");
		morse.put('f', "..-.");
		morse.put('g', "--.");
		morse.put('h', "....");
		morse.put('i', "..");
		morse.put('j', ".---");
		morse.put('k', "-.-");
		morse.put('l', ".-..");
		morse.put('m', "--");
		morse.put('n', "-.");
		morse.put('o', "---");
		morse.put('p', ".--.");
		morse.put('q', "--.-");
		morse.put('r', ".-.");
		morse.put('s', "...");
		morse.put('t', "-");
		morse.put('u', "..-");
		morse.put('v', "...-");
		morse.put('w', ".--");
		morse.put('x', "-..-");
		morse.put('y', "-.--");
		morse.put('z', "--..");
		morse.put('1', ".----");
		morse.put('2', "..---");
		morse.put('3', "...--");
		morse.put('4', "....-");
		morse.put('5', ".....");
		morse.put('6', "-....");
		morse.put('7', "--...");
		morse.put('8', "---..");
		morse.put('9', "----.");
		morse.put('0', "-----");
		morse.put(' ', "|");
		morse.put('.', "|");
		morse.put('?', "?");
		morse.put(',', ",");
		morse.put('!', "!");
		morse.put('\'', "\'");
		morse.put('\n', "\n");
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			x += morse.get(c);
			x += " ";
		}
		f2.setText(x);
	}
	public static void main(String[] args) {
		new Launcher();
	}
	
}
