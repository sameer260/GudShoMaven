package PageObjects.frontend;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import Resources.Base_setup;


public class PayWall_Objects extends Base_setup {

	static By hoverOnShoStreaming = By
			.xpath("//div[@class='mat-ripple card-img cursor auto-image hover-img vertical-hover-img']");
	static By hoverAndClickOnAddToWatchlist = By.xpath("//span[@mattooltip='Add to watch list']");
	static By miniWatchLaterElement1 = By.xpath("//*[text()='Want to save & watch later?']");
	static By miniWatchLaterElement2 = By.xpath("//*[text()='Sign In to save this video & watch again later']");
	static By miniSignInButton = By.xpath("//button[text()='Sign In']");
	static By miniLaterButton = By.xpath("//*[text()='Later']");
	static By addToWatchlistButton = By.xpath("//*[@class='shocial-ticket-actions']//child::span[2]");
	static By scrollAddToWatchList = By.xpath("//div[@class='promo-desc']//following::li[@class='watch-lists']");
	static By searchIcon = By.xpath("//button[@value='Search']");
	static By searchField = By.xpath("//input[@placeholder='Search']");
	static By newSearchField = By.xpath("//*[@placeholder='Search for Movies, Web Series, Studios, etc.']");
	static By signInPageElement1 = By.xpath("//h1[text()='Hello there!']");
	static By promoCard = By.xpath("//div[@class='mat-ripple card-img']");
	static By shoCard = By.xpath("//*[@alt='Sho Poster']");
	static By gudButton = By.xpath("//div[@class='player-clap singup-pops-player']");
	static By playerTrack = By.xpath("//input[@data-plyr='seek']");
	static By volumeButton = By.xpath("type=\"button\"");
	static By playButton = By.xpath("//button[@aria-label='Pause']");
	static By buyButton = By.xpath("//span[text()=' Buy ']");
	static By scrollAndBuy = By.xpath(
			"//div[@class='promo-desc']//following::li[@class='mat-ripple buy-tickets flex align-items-center cursor small ng-star-inserted']");
	static By firstEpisodeDetailPage = By.xpath("//*[text()=' Full Episodes ']//following::img[1]");
	static By episodesHyperLink = By.xpath("//span[text()=' Full Episodes ']");
	static By episodesCard = By.xpath("//img[@alt='promo Poster']");
	static By promoMiniElement1 = By.xpath("//div[@class='content-wrapper']//child::h5");
	static By promoMiniElement2 = By.xpath("//span[@class='normal']");
	static By followButton = By.xpath("//img[@id='studio']//following::app-follow-studios");
	static By miniFolloElement1 = By.xpath("//h5[text()='Want to follow this studio?']");
	static By miniFolloElement2 = By.xpath("//span[text()='Sign In to Follow this Studio & stay updated']");
	static By streamingButton = By.xpath("//div[text()='Streaming']");
	static By shocialButton = By.xpath("//div[text()='Shocial']");
	static By exploreButton = By.xpath("//h3[text()='Explore Studios']");
	static By studioFollowButton = By.xpath("//span[text()=' Follow ']");
	static By scrollStudioFollowButton = By.xpath("//h6[@class='sub']//following::div[@class='follow-btn']");
	static By fullscreenButton = By.xpath("//button[@data-plyr='fullscreen']//child::*[@class='icon--not-pressed']");
	static By audioCard = By.xpath("//img[@alt='audio Poster']");
	static By audioPlayerminicard = By.xpath("//img[@class='gudsho-author-image']");
	static By miniAudioElement1 = By.xpath("//h5[text()='Liking this audio?']");
	static By miniAudioElement2 = By.xpath("//span[text()='Sign in to make this audio as your favourite']");
	static By audioFav = By.xpath("//button[@data-plyr='heart']");
	static By audioPlayerCloseButton = By.xpath("//button[@data-plyr='close']");
	static By audioPlayAllButton = By.xpath("//*[text()='Play All ']");
	static By gudshoLogo = By.xpath("//img[@alt='Gudsho']");
	static By searchdropdown = By.xpath("//div[@id='mat-autocomplete-0']");
	static By promoRow = By.xpath("//app-gud-card[@class=\"swiper-wrapper defauly-height\"]");
	static By nextPromoButton = By.xpath("//*[text()='Next Promo ']");
	static By getPromoNameFromPlayer = By.xpath("//span[@class='season-details ng-star-inserted']");
	static By playerForwardButton = By.xpath("//div[@class='center_control']/button[4]");
	static By watchFreeButton = By.xpath("//*[text()=' Watch Free ']");
	static By comingSoonButton = By.xpath("//*[text()='Coming soon']");
	static By getGudCount = By.xpath("//span[@class='guds-count ng-star-inserted']");
	static By playerCloseButton = By.xpath("//*[text()='close']");
	static By miniAddToWatchlistButton = By.xpath("//*[text()='add']");
	static By getDuration=By.xpath("//div[@class='center_left']/div[1]");
	static By currentduration=By.xpath("//div[@aria-label='Current time']");
	static By signPageBackButton = By.xpath("//*[@class='back-btn cursor']");
	static By getPlayingshoName = By.xpath("//div[@class='player-title-detail']");
	static By nextEpisodes = By.xpath("//*[text()='Next Episode']");
	static By toasterMessage = By.xpath("//div[@id='toast-container']//div//div");
	
	public static WebElement toasterMessage() {
		return driver.findElement(toasterMessage);

	}
	public static WebElement shoCard() {
		return driver.findElement(shoCard);
		
	}
	
	public static WebElement nextEpisodes() {
		return driver.findElement(nextEpisodes);

	}
	
	public static WebElement getPlayingshoName() {
		return driver.findElement(getPlayingshoName);

	}

	public static WebElement hoverOnShoStreaming() {
		return driver.findElement(hoverOnShoStreaming);
	}

	public static WebElement hoverAndClickOnAddToWatchlist() {
		return driver.findElement(hoverAndClickOnAddToWatchlist);
	}

	public static WebElement miniWatchLaterElement1() {
		return driver.findElement(miniWatchLaterElement1);
	}

	public static WebElement miniWatchLaterElement2() {
		return driver.findElement(miniWatchLaterElement2);
	}

	public static WebElement miniSignInButton() {
		return driver.findElement(miniSignInButton);
	}

	public static WebElement miniLaterButton() {
		return driver.findElement(miniLaterButton);
	}

	public static WebElement addToWatchlistButton() {
		return driver.findElement(addToWatchlistButton);
	}

	public static WebElement searchIcon() {
		return driver.findElement(searchIcon);
	}

	public static WebElement searchField() {
		return driver.findElement(searchField);
	}

	public static WebElement signInPageElement1() {
		return driver.findElement(signInPageElement1);

	}

	public static WebElement promoCard() {
		return driver.findElement(promoCard);

	}

	public static WebElement gudButton() {
		return driver.findElement(gudButton);

	}

	public static WebElement playerTrack() {
		return driver.findElement(playerTrack);
	}

	public static WebElement volumeButton() {
		return driver.findElement(volumeButton);

	}

	public static WebElement playButton() {
		return driver.findElement(playButton);
	}

	public static WebElement buyButton() {
		return driver.findElement(buyButton);

	}

	public static WebElement firstEpisodeDetailPage() {
		return driver.findElement(firstEpisodeDetailPage);

	}

	public static WebElement episodesHyperLink() {
		return driver.findElement(episodesHyperLink);

	}

	public static WebElement episodesCard() {
		return driver.findElement(episodesCard);

	}

	public static WebElement promoMiniElement1() {
		return driver.findElement(promoMiniElement1);

	}

	public static WebElement promoMiniElement2() {
		return driver.findElement(promoMiniElement2);

	}

	public static WebElement scrollAddToWatchList() {
		return driver.findElement(scrollAddToWatchList);

	}

	public static WebElement scrollAndBuy() {
		return driver.findElement(scrollAndBuy);

	}

	public static WebElement followButton() {
		return driver.findElement(followButton);
	}

	public static WebElement miniFolloElement1() {
		return driver.findElement(miniFolloElement1);

	}

	public static WebElement miniFolloElement2() {
		return driver.findElement(miniFolloElement2);

	}

	public static WebElement streamingButton() {
		return driver.findElement(streamingButton);

	}

	public static WebElement shocialButton() {
		return driver.findElement(shocialButton);
	}

	public static WebElement exploreButton() {
		return driver.findElement(exploreButton);
	}

	public static WebElement studioFollowButton() {
		return driver.findElement(studioFollowButton);

	}

	public static WebElement scrollStudioFollowButton() {
		return driver.findElement(scrollStudioFollowButton);

	}

	public static WebElement fullscreenButton() {
		return driver.findElement(fullscreenButton);

	}

	public static WebElement audioCard() {
		return driver.findElement(audioCard);

	}

	public static WebElement audioPlayerminicard() {
		return driver.findElement(audioPlayerminicard);

	}

	public static WebElement miniAudioElement1() {
		return driver.findElement(miniAudioElement1);

	}

	public static WebElement miniAudioElement2() {
		return driver.findElement(miniAudioElement2);

	}

	public static WebElement audioFav() {
		return driver.findElement(audioFav);

	}

	public static WebElement audioPlayerCloseButton() {
		return driver.findElement(audioPlayerCloseButton);

	}

	public static WebElement audioPlayAllButton() {
		return driver.findElement(audioPlayAllButton);

	}

	public static WebElement gudshoLogo() {
		return driver.findElement(gudshoLogo);

	}

	public static WebElement searchdropdown() {
		return driver.findElement(searchdropdown);

	}

	public static WebElement promoRow() {
		return driver.findElement(promoRow);

	}

	public static WebElement getDuration() {
		return driver.findElement(getDuration);
	}

	public static WebElement nextPromoButton() {
		return driver.findElement(nextPromoButton);
	}

	public static WebElement getPromoNameFromPlayer() {
		return driver.findElement(getPromoNameFromPlayer);

	}

	public static WebElement playerForwardButton() {
		return driver.findElement(playerForwardButton);

	}

	public static WebElement watchFreeButton() {
		return driver.findElement(watchFreeButton);

	}

	public static WebElement comingSoonButton() {
		return driver.findElement(comingSoonButton);

	}

	public static WebElement getGudCount() {
		return driver.findElement(getGudCount);

	}

	public static WebElement playerCloseButton() {
		return driver.findElement(playerCloseButton);

	}
	public static WebElement miniAddToWatchlistButton() {
		return driver.findElement(miniAddToWatchlistButton);

	}
	public static WebElement currentduration() {
		return driver.findElement(currentduration);

	}
	public static WebElement signPageBackButton() {
		return driver.findElement(signPageBackButton);

	}
	public static WebElement newSearchField() {
		return driver.findElement(newSearchField);

	}

}
