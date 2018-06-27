import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NastySurprise implements ActionListener {
	JFrame f = new JFrame();
	JButton b1 = new JButton();
	JButton b2 = new JButton();

	// Create Panel for buttons.
	public static void main(String[] args) {
		NastySurprise ns = new NastySurprise();
		ns.frame();
	}

	void frame() {
		f.setVisible(true);
		f.add(b1);
		f.add(b2);
		b1.setText("Trick");
		b2.setText("Treat");
		b1.addActionListener(this);
		b2.addActionListener(this);
		f.pack();
	}

	private void showPictureFromTheInternet(String imageUrl) {
		try {
			URL url = new URL(imageUrl);
			Icon icon = new ImageIcon(url);
			JLabel imageLabel = new JLabel(icon);
			JFrame frame = new JFrame();
			frame.add(imageLabel);
			frame.setVisible(true);
			frame.pack();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
