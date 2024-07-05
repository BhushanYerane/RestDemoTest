package RESTAssuredTest.config;

public class VideoGameEndpoints 
{
	
	 public static String ALL_VIDEO_GAMES = "/videogame";
	 public static String SINGLE_VIDEO_GAME = "/videogame/{videoGameId}";
	 
	public static String getALL_VIDEO_GAMES() {
		return ALL_VIDEO_GAMES;
	}
	public void setALL_VIDEO_GAMES(String aLL_VIDEO_GAMES) {
		ALL_VIDEO_GAMES = aLL_VIDEO_GAMES;
	}
	public static String getSINGLE_VIDEO_GAME() {
		return SINGLE_VIDEO_GAME;
	}
	public static void setSINGLE_VIDEO_GAME(String sINGLE_VIDEO_GAME) {
		SINGLE_VIDEO_GAME = sINGLE_VIDEO_GAME;
	}
}
