import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	JFrame f;
	JPanel p;

	public static void main(String[] args) {
		Random r = new Random();
		WhackAMole wam = new WhackAMole();
		wam.drawButtons(r.nextInt(24));

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
			speak("You missed!");
		}
	}
}
