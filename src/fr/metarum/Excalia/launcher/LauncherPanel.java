package fr.metarum.Excalia.launcher;
/****************************
 *         IMPORTS          *
 ***************************/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.theshark34.openauth.AuthenticationException;
import fr.theshark34.openlauncherlib.launcher.util.UsernameSaver;
import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.colored.SColoredBar;
import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import fr.theshark34.swinger.textured.STexturedButton;


/****************************
 *       DEBUT CLASS        *
 ***************************/
@SuppressWarnings("serial")
public class LauncherPanel extends JPanel implements SwingerEventListener{

	private Image background = Swinger.getResource("background.png");
	
	private UsernameSaver saver = new UsernameSaver(Launcher.E_INFOS);
	
	private JTextField usernameField = new JTextField(saver.getUsername("")); 	//champ username
	private JPasswordField passwordField = new JPasswordField();				//champ password
	
	private STexturedButton OKButton = new STexturedButton(Swinger.getResource("OK.png"));//bouton jouer
	
	private STexturedButton quitButton = new STexturedButton(Swinger.getResource("quit.png"));
	private STexturedButton reductButton = new STexturedButton(Swinger.getResource("reduct.png"));
	
	
	private SColoredBar progressBar = new SColoredBar(Swinger.getTransparentWhite(100), new Color(0,255,0,175));
	//private JLabel infoLabel = new JLabel("Clique sur OK !", SwingConstants.CENTER);
	
	public LauncherPanel(){
		this.setLayout(null);
		
		/****************************
		 *      CHAMP USERNAME      *
		 ***************************/
		usernameField.setForeground(Color.BLUE);
		usernameField.setFont(usernameField.getFont().deriveFont(20F));
		usernameField.setCaretColor(Color.BLUE);
		usernameField.setOpaque(false);
		usernameField.setBorder(null);
		usernameField.setBounds(766, 497, 177, 32);
		this.add(usernameField);
		/****************************
		 *        CHAMP MDP         *
		 ***************************/
		passwordField.setForeground(Color.BLUE);
		passwordField.setFont(usernameField.getFont().deriveFont(20F));
		passwordField.setCaretColor(Color.BLUE);
		passwordField.setOpaque(false);
		passwordField.setBorder(null);
		passwordField.setBounds(766, 556, 177, 32);
		this.add(passwordField);
		
		/****************************
		 *        BOUTON OK         *
		 ***************************/
		
		OKButton.setBounds(890, 594);
		OKButton.addEventListener(this);
		this.add(OKButton);
		
		/****************************
		 *       BOUTON QUIT        *
		 ***************************/
		quitButton.setBounds(935,0);
		quitButton.addEventListener(this);
		this.add(quitButton);
		
		/****************************
		 *      BOUTON REDUCT       *
		 ***************************/
		reductButton.setBounds(900,0);
		reductButton.addEventListener(this);
		this.add(reductButton);
		
		
		progressBar.setBounds(33, 603, 850, 13);
		this.add(progressBar);
		
		/*infoLabel.setForeground(Color.BLUE);
		infoLabel.setFont(usernameField.getFont());
		infoLabel.setBounds(33, 573, 850, 18);
		this.add(infoLabel);*/
		
	} //END LAUNCHERPANEL
	
	@Override
	public void onEvent(SwingerEvent e){
		
		if(e.getSource() == OKButton)
		{
			setFieldsEnabled(false);
			
			if(usernameField.getText().replaceAll(" ", "").length()==0 || passwordField.getText().length() == 0)
			{
				JOptionPane.showMessageDialog(this, "Erreur, merci d'entrer un pseudo et/ou un mot de passe valides", "Erreur", JOptionPane.ERROR_MESSAGE);
				setFieldsEnabled(true);
				return;
			}
			
			Thread t = new Thread(){
				@Override
				public void run(){
					try {
						Launcher.auth(usernameField.getText(), passwordField.getText());
					} catch (AuthenticationException e) {
						JOptionPane.showMessageDialog(LauncherPanel.this, "Erreur, impossible de se connecter : " + e.getErrorModel().getErrorMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
						setFieldsEnabled(true);
						return;
					}
					
				}
			};
			t.start();
		}
		else if(e.getSource() == quitButton)
		{
			System.exit(0);
		}
		else if(e.getSource() == reductButton)
		{
			LauncherFrame.getInstance().setState(JFrame.ICONIFIED);
		}
	} //END ONEVENT
	
	
	/****************************
	 *     PAINTCOMPONENT       *
	 *    DESSIN BACKGROUND     *
	 ***************************/
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
	} //END PAINTCOMPONENT
	
	public void setFieldsEnabled(boolean enabled)
	{
		usernameField.setEnabled(enabled);
		passwordField.setEnabled(enabled);
		OKButton.setEnabled(enabled);
	}
	
	
	public SColoredBar getProgressBar(){
		return progressBar;
	}
	
	/*public void setInfoText(String text){
		infoLabel.setText(text);
	}*/
	
}//END LAUNCHERPANEL
