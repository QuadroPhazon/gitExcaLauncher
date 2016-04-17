package fr.metarum.Excalia.launcher;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.theshark34.openlauncherlib.launcher.util.UsernameSaver;
import fr.theshark34.swinger.Swinger;

@SuppressWarnings("serial")
public class LauncherPanel extends JPanel {

	private Image background = Swinger.getResource("background.png");
	
	private UsernameSaver saver = new UsernameSaver(Launcher.E_INFOS);
	private JTextField usernameField = new JTextField(saver.getUsername(""));
	
	public LauncherPanel(){
		
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
}
