import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class typingTutor implements KeyListener {
	JFrame f = new JFrame();
	JLabel l = new JLabel();
	Character currentLetter;

	public static void main(String[] args) {
		typingTutor tt = new typingTutor();
		tt.JStuff();

	}

	char generateRandomLetter() {
		Random r = new Random();
		return (char) (r.nextInt(26) + 'a');
	}

	void JStuff() {
		f.setVisible(true);
		f.setTitle("Type or Die");
		currentLetter = generateRandomLetter();
		f.add(l);
		l.setText(currentLetter.toString());
		l.setFont(l.getFont().deriveFont(28.0f));
		l.setHorizontalAlignment(JLabel.CENTER);
		f.addKeyListener(this);
		f.pack();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyChar() == currentLetter) {
			System.out.println("Correct");
			f.setBackground(Color.GREEN);
		} else {
			f.setBackground(Color.RED);
			System.out.println("Wrong");
		}
		currentLetter = generateRandomLetter();
		l.setText(currentLetter.toString());
		System.out.println("You pressed: " + currentLetter);

	}
}
