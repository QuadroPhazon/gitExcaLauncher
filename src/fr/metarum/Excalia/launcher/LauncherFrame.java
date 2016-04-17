package fr.metarum.Excalia.launcher;

import javax.swing.JFrame;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.util.WindowMover;

@SuppressWarnings("serial")
public class LauncherFrame  extends JFrame {

	private static LauncherFrame instance;
	private static LauncherPanel launcherPanel;
	
	public LauncherFrame(){
		this.setTitle("Excalia Launcher");
		this.setSize(975, 625);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		
		this.setIconImage(Swinger.getResource("ExcaIcon.png"));
		
		WindowMover mover = new WindowMover(this);
		this.addMouseListener(mover);
		this.addMouseMotionListener(mover);
		
		this.setContentPane(launcherPanel = new LauncherPanel());
		/*try {
			ImageIO.read(getClass().getResourceAsStream("/fr/metarum/Excalia/launcher/ressources/ExcaIcon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {

		Swinger.setSystemLookNFeel();
		Swinger.setResourcePath("/fr/metarum/Excalia/launcher/ressources/");
		instance = new LauncherFrame();
		/*try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	public static LauncherFrame getInstance(){
		return instance;
	}
	
	public static LauncherPanel getLauncherPanel(){
		return launcherPanel;
	}

}
