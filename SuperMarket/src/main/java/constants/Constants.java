package constants;

public class Constants {
	public static final String configFile = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties"; // got the path by ryt clicking config property file then
															// showin then system explorer and ryt click on file and
															// copy as path
	public static final String testDataFile = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx";
	public static final String validCredentialError = "User was unable to login with valid credential";
	public static final String invalidpasswordError = "User was able to login with invalid password";
	public static final String invalidUserNameError = "User was able to login with invalid Username";
	public static final String inValidCredentialError = "User Was Able to login with invalid Username and password";
	public static final String logoutAfterLogin = "User was able not able to logout";
	public static final String adminUserText = "Unable create User";
	public static final String searchMessage=".........RESULT NOT FOUND.......";
	public static final String resetMessage = "Unable to reset";
	public static final String newUserCreation = "user was not able to create nes info";
	public static final String searchExixtingUser ="searched User not found";
	public static final String newNews = "please enter your news";
}
