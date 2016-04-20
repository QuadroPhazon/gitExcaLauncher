package fr.metarum.Excalia.launcher;

import java.io.File;

import fr.theshark34.openauth.AuthPoints;
import fr.theshark34.openauth.AuthenticationException;
import fr.theshark34.openauth.Authenticator;
import fr.theshark34.openauth.model.AuthAgent;
import fr.theshark34.openauth.model.response.AuthResponse;
import fr.theshark34.openlauncherlib.launcher.AuthInfos;
import fr.theshark34.openlauncherlib.launcher.GameInfos;
import fr.theshark34.openlauncherlib.launcher.GameTweak;
import fr.theshark34.openlauncherlib.launcher.GameType;
import fr.theshark34.openlauncherlib.launcher.GameVersion;
import fr.theshark34.supdate.SUpdate;

public class Launcher {

	public static final GameVersion E_VERSION = new GameVersion("1.8.4", GameType.V1_8_HIGHER);
	public static final GameInfos E_INFOS = new GameInfos("Excalia", E_VERSION, true, new GameTweak[]{GameTweak.FORGE});
	public static final File E_DIR = E_INFOS.getGameDir();
	
	private static AuthInfos authInfos;
	
	public static void auth(String username, String password) throws AuthenticationException
	{
		Authenticator authenticator = new Authenticator(Authenticator.MOJANG_AUTH_URL, AuthPoints.NORMAL_AUTH_POINTS);
		AuthResponse response = authenticator.authenticate(AuthAgent.MINECRAFT, username, password, "");
		authInfos = new AuthInfos(response.getSelectedProfile().getName(), response.getAccessToken(), response.getSelectedProfile().getId());
		
	}
	
	public static void update() throws Exception
	{
		SUpdate su = new SUpdate("");
	}
	
}
