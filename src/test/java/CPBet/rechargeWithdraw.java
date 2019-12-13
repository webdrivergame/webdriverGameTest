package CPBet;

import SeleniumMethod.WebDriverUtil;
import org.testng.annotations.BeforeTest;

public class rechargeWithdraw {
    WebDriverUtil driverUtil = new WebDriverUtil(null);

    String Url = "https://zs-pre.com/";
    String code = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[2]/p/span";
    String inputCode = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[2]/p/input";
    String login = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[2]/span[1]";
    String sure = "//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/div[2]/span";
    String goGame = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[4]/span[2]";
    String clickAgree = "//*[@id=\"app\"]/div/div/div/div[3]/div/p[1]";
    String clickCloseAnnouncement = "//*[@id=\"app\"]/div/div[2]/div[1]/div[3]/div/span";


    @BeforeTest
    public void login() throws InterruptedException {
        driverUtil.loginBefore(Url);
        driverUtil.playerLogin("achy01","achy01");
        String getCode = driverUtil.getTextByXpath(code);
        System.out.println(getCode);
        driverUtil.xpathClearSendKeys(inputCode,getCode);
        driverUtil.xpathClick(login);
        driverUtil.xpathClick(sure);
        Thread.sleep(1000);
        driverUtil.xpathClick(goGame);
        driverUtil.xpathClick(clickAgree);
        Thread.sleep(3000);
        driverUtil.xpathClick(clickCloseAnnouncement);
        Thread.sleep(2000);
    }







}
