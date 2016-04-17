package fr.metarum.Excalia.launcher;

import java.io.File;

import fr.theshark34.openlauncherlib.launcher.GameInfos;
import fr.theshark34.openlauncherlib.launcher.GameTweak;
import fr.theshark34.openlauncherlib.launcher.GameType;
import fr.theshark34.openlauncherlib.launcher.GameVersion;

public class Launcher {

	public static final GameVersion E_VERSION = new GameVersion("1.8.4", GameType.V1_8_HIGHER);
	public static final GameInfos E_INFOS = new GameInfos("Excalia", E_VERSION, true, new GameTweak[]{GameTweak.FORGE});
	public static final File E_DIR = E_INFOS.getGameDir();

}
