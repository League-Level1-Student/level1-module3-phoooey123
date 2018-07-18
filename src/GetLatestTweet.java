import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class GetLatestTweet implements ActionListener {
	JFrame f = new JFrame();
	JPanel l1 = new JPanel();
	JPanel l2 = new JPanel();
	JButton b = new JButton();
	JTextField jtf = new JTextField(15);
	JTextPane jtp;
	JScrollPane jsp;

	public static void main(String[] args) {
		GetLatestTweet glt = new GetLatestTweet();
		glt.JStuff();
	}

	void JStuff() {
		jtp = new JTextPane();
		jsp = new JScrollPane(jtp);
		f.setLayout(new BorderLayout());
		f.add(l1, BorderLayout.NORTH);
		f.add(l2, BorderLayout.SOUTH);
		l1.add(b);
		l1.add(jtf);
		f.setVisible(true);
		b.setText("Search Twitter");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.addActionListener(this);
		jsp.setPreferredSize(new Dimension(300, 400));
		l2.add(jsp);
		jtp.setEditable(false);
		b.setBackground(Color.BLUE);
		b.setOpaque(true);
		jtp.setBackground(Color.CYAN);
		jtp.setOpaque(true);
		jsp.setBackground(Color.RED);
		jsp.setOpaque(true);
		f.pack();
	}

	private String getLatestTweet(String searchingFor) {

		Twitter twitter = new TwitterFactory().getInstance();

		AccessToken accessToken = new AccessToken("2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
				"vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");

		twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN", "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");

		twitter.setOAuthAccessToken(accessToken);

		Query query = new Query(searchingFor);
		try {
			String results = "";
			QueryResult result = twitter.search(query);
			System.out.println(result.getCount());
			for (int i = 0; i < result.getCount() - 1; i++) {
				results += result.getTweets().get(i).getText() + "\n";
			}
			return results;
		} catch (Exception e) {
			System.err.print(e.getMessage());
			return "What the heck is that?";

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String re = getLatestTweet(jtf.getText());
		jtp.setText(re);
	}
}
