package fr.metarum.Excalia.launcher;
/****************************
 *         IMPORTS          *
 ***************************/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.theshark34.openlauncherlib.launcher.util.UsernameSaver;
import fr.theshark34.swinger.Swinger;
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
		
		
	} //END LAUNCHERPANEL
	
	@Override
	public void onEvent(SwingerEvent e){
		
		if(e.getSource() == OKButton)
		{
			System.out.println("click!");
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
	
}//END LAUNCHERPANEL
