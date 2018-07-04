import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySurprise implements ActionListener {
	JFrame f = new JFrame();
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JPanel p = new JPanel();

	// Create Panel for buttons.
	public static void main(String[] args) {
		NastySurprise ns = new NastySurprise();
		ns.frame();
	}

	void frame() {
		f.setVisible(true);
		f.add(p);
		p.add(b1);
		p.add(b2);
		b1.setText("Trick");
		b2.setText("Treat");
		b1.addActionListener(this);
		b2.addActionListener(this);
		f.pack();
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
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
		if (e.getSource() == b2) {
			showPictureFromTheInternet(
					"https://media.istockphoto.com/photos/sunny-cat-picture-id508030340?k=6&m=508030340&s=612x612&w=0&h=ri9QYzvZkiuniJPaInHQfW6z1JNNzsNOAWEiLLSTX5o=");
		}
		if (e.getSource() == b1) {
			showPictureFromTheInternet(
					"https://previews.123rf.com/images/lightwise/lightwise1608/lightwise160800108/63825857-halloween-pumpkin-and-scary-jack-o-lantern-character-in-a-side-view-with-an-open-mouth-on-a-white-ba.jpg");
		}
	}
}
