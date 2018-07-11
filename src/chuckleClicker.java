import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class chuckleClicker implements ActionListener {
	JPanel p = new JPanel();
	JButton b1 = new JButton();
	JButton b2 = new JButton();

	public static void main(String[] args) {
		chuckleClicker cc = new chuckleClicker();
		cc.makeButtons();

	}

	void makeButtons() {
		JFrame f = new JFrame();
		f.setVisible(true);
		f.add(p);
		p.add(b1);
		p.add(b2);
		b1.setText("Joke");
		b1.setBackground(Color.ORANGE);
		b1.setOpaque(true);
		b2.setText("Punchline");
		b2.setBackground(Color.BLACK);
		b2.setOpaque(true);
		b2.setEnabled(false);

		b1.addActionListener(this);
		b2.addActionListener(this);
		f.pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			JOptionPane.showMessageDialog(null, "What did the pirate say when he turned 80?");

			b2.setBackground(Color.ORANGE);
			b1.setBackground(Color.BLACK);
			b2.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(null, "Ayy-m-atey");
		}
	}
}
