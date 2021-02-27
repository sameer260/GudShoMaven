package PageObjects.frontend;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Resources.Base_setup;

public class Loginandsignup extends Base_setup {
	
    
    //By signinlink=By.linkText("Sign In");
	By signinlink=By.xpath("//span[contains(text(),'Sign In')]");
    By phoneemailfield=By.id("phoneEmail");
    By placeholderofphemail=By.xpath("//div[@class='form-group']/div/label");
    By passwordfield=By.id("password");
    By placeholderofpassword=By.xpath("//div[@class='form-group trialicon']/div/label");
    By signinutton=By.xpath("//div[@class='login-via-otp']/button");
    By requestOTPbutton=By.xpath("//div[@class='form-submit']/button");
    By facebooklogin=By.xpath("//div[@class='inner-container socialmedia-login']/button[1]");
    By gmaillogin=By.xpath("//div[@class='inner-container socialmedia-login']/button[2]");
    By signuplink=By.linkText("SIGN UP");
    By forgotpasswordlink=By.linkText("Forgot?");
    By OTPinput=By.xpath("//div[@class='otp-input']/input");
    By PhonenumberinOTPPage=By.xpath("//h3[@class='ng-star-inserted']/strong");
    By validateOTPbutton=By.xpath("//div[@class='form-submit']/button");
    By changephnumberlink=By.linkText("Change");
    By phonenumberfieldinsignup=By.name("phoneNumber");
    By getOTPbutton=By.xpath("//div[@class='form-submit']/button");
    By Phonenumberinsignup=By.id("phone");
    By Emailidinsignup=By.id("email");
    By signinlinkinsignup=By.linkText("SIGN IN");
    By eyeicondisplay=By.xpath("//div[@class='form-input']/span[1]");
    By eyeiconblock=By.xpath("//div[@class='form-input']/span[2]");
    By firsttimelogin=By.xpath("//h1[@class='ng-star-inserted']");
    By phonenumberfieldinsignuppage=By.xpath("//div[@class='ngx-mat-tel-input-container']/input");
    By getotpbuttoninsignup=By.xpath("//div[@class='form-submit']/button");
	By geolocationbutton=By.xpath("//div[@class='ngx-mat-tel-input-container']/button");
	By searchingeolocation=By.xpath("//input[@type='text']");
    
    
    public WebElement signinlinkm()
    {
    	return driver.findElement(signinlink);
    }
    public WebElement phoneemailfieldm()
    {
    	return driver.findElement(phoneemailfield);
    }
    public WebElement passwordfieldm()
    {
    	return driver.findElement(passwordfield);
    }
    public WebElement placeholderofphemailm()
    {
    	return driver.findElement(placeholderofphemail);
    }
    public WebElement placeholderofpasswordm()
    {
    	return driver.findElement(placeholderofpassword);
    }
    public WebElement signinutton()
    {
    	return driver.findElement(signinutton);
    }
    public WebElement requestOTPbuttonm()
    {
    	return driver.findElement(requestOTPbutton);
    }
    public WebElement facebookloginm()
    {
    	return driver.findElement(facebooklogin);
    }
    public WebElement gmailloginm()
    {
    	return driver.findElement(gmaillogin);
    }
    public WebElement signuplinkm()
    {
    	return driver.findElement(signuplink);
    }
    public WebElement forgotpasswordlinkm()
    {
    	return driver.findElement(forgotpasswordlink);
    }
    public WebElement OTPinputm()
    {
    	return driver.findElement(OTPinput);
    }
    public WebElement PhonenumberinOTPPagem()
    {
    	return driver.findElement(PhonenumberinOTPPage);
    }
    public WebElement validateOTPbuttonm()
    {
    	return driver.findElement(validateOTPbutton);
    }
    public WebElement changephnumberlinkm()
    {
    	return driver.findElement(changephnumberlink);
    }
    public WebElement phonenumberfieldinsignupm()
    {
    	return driver.findElement(phonenumberfieldinsignup);
    }
    public WebElement getOTPbuttonm()
    {
    	return driver.findElement(getOTPbutton);
    }
    public WebElement Phonenumberinsignupm()
    {
    	return driver.findElement(Phonenumberinsignup);
    }
    public WebElement Emailidinsignupm()
    {
    	return driver.findElement(Emailidinsignup);
    }
    public WebElement signinlinkinsignupm()
    {
    	return driver.findElement(signinlinkinsignup);
    }
    public WebElement eyeicondisplaym()
    {
    	return driver.findElement(eyeicondisplay);
    }
    public WebElement eyeiconblockm()
    {
    	return driver.findElement(eyeiconblock);
    }
    public WebElement firsttimeloginm()
    {
    	return driver.findElement(firsttimelogin);
    }	
    public WebElement phonenumberfieldinsignuppagem()
    {
    	return driver.findElement(phonenumberfieldinsignuppage);
    }
    public WebElement getotpbuttoninsignupm()
    {
    	return driver.findElement(getotpbuttoninsignup);
    }
	public WebElement geolocationbuttonm()
	{
		return driver.findElement(geolocationbutton);
	}
	public WebElement searchingeolocationm()
	{
		return driver.findElement(searchingeolocation);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@FindBy(xpath = "//*[text()='Sign In']")
	public static WebElement flickSignIn;

	@FindBy(xpath = "//*[@id='phoneEmail']")
	public static WebElement userName;

	@FindBy(xpath = "//*[@id='password']")
	public static WebElement passWord;

	@FindBy(xpath = "//*[text()=' Sign In ']")
	public static WebElement SignInButton;

	@FindBy(xpath = "//*[text()='You have logged in successfully']")
	public static WebElement loginToaster;

	@FindBy(xpath = "//h1[text()='Exciting Studios. Unlimited movies.']")
	public static WebElement flictText1;

	@FindBy(xpath = "//h1[text()='Web Series. TV shows and more.']")
	public static WebElement flictText2;

	@FindBy(xpath = "//*[text()='All In One Place.']")
	public static WebElement flictText3;

	@FindBy(xpath = "//h1[@class='ng-star-inserted']")
	public static WebElement Wehavent;
	
	@FindBy(xpath = "//*[text()=' Incorrect Password, Please try again ']")
	public static WebElement incorrectPassword;
	
	@FindBy(xpath = "//*[text()='Request OTP']")
	public static WebElement requestOTP;
	
	
	
	@FindBy(xpath = "//h1[text()='Hello there!']")
	public static WebElement helloThere;
	
	@FindBy(xpath = "//*[text()='Nice to see you! Sign in now & lets get started.']")
	public static WebElement niceTosee;
		
	@FindBy(xpath = "//*[text()=' Email ID/Mobile number ']")
	public static WebElement mobileNumber;
	
	@FindBy(xpath = "//*[text()='Password']")
	public static WebElement password;
	
	@FindBy(xpath = "//*[text()='Forgot? ']")
	public static WebElement forgot;
	
	@FindBy(xpath = "//*[text()='OR   SIGNIN USING']")
	public static WebElement signinUsing;
	
	@FindBy(xpath = "//*[text()='New to GudSho?']")
	public static WebElement newToGudsho;
	
	@FindBy(xpath = "//*[text()='SIGN UP']")
	public static WebElement signUp;
	
	@FindBy(xpath = "//*[text()='Facebook']")
	public static WebElement faceBook;
	
	@FindBy(xpath = "//*[text()='Google']")
	public static WebElement google;
	
	//googleWindow
	
	
	@FindBy(xpath = "//*[text()='Sign in with Google']")
	public static WebElement googleElement;
	
	@FindBy(xpath = "//*[text()='Sign in']")
	public static WebElement googleSignInElement;
	
	
	@FindBy(xpath ="//*[text()='Email address or phone number:']")
	public static WebElement faceElement;
	
	//signUp Page elements
	
	
	@FindBy(xpath ="//h1[@class='ng-star-inserted']")
	public static WebElement createElement;
	
	@FindBy(xpath ="//*[text()='Sign up for free & get wrapped with multiple engagement factors of GudSho!']")
	public static WebElement singupElement;

	@FindBy(xpath ="//*[text()='Mobile number']")
	public static WebElement mobileNumberSignupElement;
	
	@FindBy(xpath ="//*[text()=' Get OTP ']")
	public static WebElement getOTPbutton1;
	
	@FindBy(xpath ="//*[text()='Already on GudSho?']")
	public static WebElement alreadyElement;
	
	@FindBy(xpath ="//*[text()='SIGN IN']")
	public static WebElement signInElement;
	

}
