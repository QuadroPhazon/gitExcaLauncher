package fr.metarum.Excalia.launcher;

import java.io.File;

import fr.theshark34.openlauncherlib.minecraft.GameInfos;
import fr.theshark34.openlauncherlib.minecraft.GameTweak;
import fr.theshark34.openlauncherlib.minecraft.GameType;
import fr.theshark34.openlauncherlib.minecraft.GameVersion;

public class Launcher {

	public static final GameVersion E_VERSION = new GameVersion("1.8.4", GameType.V1_8_HIGHER);
	public static final GameInfos E_INFOS = new GameInfos("Excalia", E_VERSION, new GameTweak[]{GameTweak.FORGE});
	public static final File E_DIR = E_INFOS.getGameDir();

}
