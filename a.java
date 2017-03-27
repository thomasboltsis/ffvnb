import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.io.IOException;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.text.JTextComponent;
import java.net.MalformedURLException;
import java.awt.BorderLayout;
import java.awt.Container;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import javax.swing.JLabel;
import java.awt.Font;



public class OurWebBrowser extends JFrame {

	public JPanel address_p,window;
	public JLabel address_l;
	public JTextField jtf;
	public JEditorPane jep;
	public JButton buttonGo = new JButton("Go");

	private Go go = new Go();


	//kataskeuastis
	public OurWebBrowser() throws IOException {

		super("Little Web Browser!");

		//kathorizoume th grammi me th dieuthinsi
		address_l = new JLabel(" address: ", SwingConstants.CENTER);
		jtf = new JTextField("https://en.wikipedia.org/wiki/Main_Page");
		jtf.addActionListener(go);
		buttonGo = new JButton("Go");
		buttonGo.addActionListener(go);

		jep = new JEditorPane("https://en.wikipedia.org/wiki/Main_Page");
		jep.setEditable(false);

		address_p = new JPanel(new BorderLayout());
		window = new JPanel(new BorderLayout());

		address_p.add(address_l, BorderLayout.WEST);
		address_p.add(jtf, BorderLayout.CENTER);
		address_p.add(buttonGo, BorderLayout.EAST);

		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());

		pane.add(address_p, BorderLayout.NORTH);
		pane.add(window, BorderLayout.CENTER);



		//kaloume ton kataskeuasth ths klashs JFrame


		setSize(700,500);
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}


	public class Go implements ActionListener {

		public void actionPerformed(ActionEvent actionEvent) {

			try {
				URL url = new URL("https://en.wikipedia.org/wiki/Main_Page");
				        BufferedReader in = new BufferedReader(
				        new InputStreamReader(url.openStream()));

				        String inputLine;
						StringBuilder sb = new StringBuilder();
				        while ((inputLine = in.readLine()) != null){

				            //System.out.println(inputLine);
				            sb.append(inputLine);
						}
						String nohtml = sb.toString().replaceAll("\\<.*?>","");

						//System.out.println(nohtml);
        in.close();

			}
			catch (MalformedURLException e) {
				System.out.println("The url is incorrect!");
			}catch (IOException e) {
				System.out.println("The connection failed!");
			}



		}
	}



	public static void main(String args[]) throws IOException {

		OurWebBrowser test = new OurWebBrowser();
	}


}
