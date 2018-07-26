import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	JFrame f;
	JPanel p;
	int whacks = 0;
	Date timeatstart = new Date();
	
	public static void main(String[] args) {
		Random r = new Random();
		WhackAMole wam = new WhackAMole();
		wam.drawButtons(r.nextInt(24));

	}
	private void endGame(Date timeAtStart, int molesWhacked) {
	     Date timeAtEnd = new Date();
	     JOptionPane.showMessageDialog(null, "Your whack rate is "
	          + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	          + " moles per second.");
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void drawButtons(int ran) {
		f = new JFrame();
		p = new JPanel();
		f.add(p);
		f.setVisible(true);
		f.setSize(300, 400);
		System.out.println(ran);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < 24; i++) {
			JButton b = new JButton();
			b.addActionListener(this);
			if (i == ran) {

				b.setText("mole!");
			}
			p.add(b);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
		if (b.getText() != "mole!") {
			speak("You missed");
			
		}
		else {
			Random r = new Random();
			f.dispose();
			drawButtons(r.nextInt(24));
			whacks++;
			if(whacks > 9) {
				f.dispose();
				endGame(timeatstart, whacks);
			}
		}
	}
}
