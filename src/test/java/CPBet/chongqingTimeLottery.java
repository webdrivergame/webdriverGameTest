package CPBet;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class chongqingTimeLottery {

    WebDriverUtil driverUtil = new WebDriverUtil(null);

    String Url = "zs-pre.com";
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
        driverUtil.playerLogin("achaohy123","achaohy123");
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





    String timeLottery = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[1]/span[2]";
    String chongqingTimeLottery = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[3]/span[1]";
    String openLotteryResult = "//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/div[1]/span[4]";
    String issue1 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div/table/tbody/tr[1]/td[1]";

    String Url2 = "https://www.caipiaokong.com/lottery/cqssc.html";
    String issue2 = "//*[@id=\"qs_1\"]";
    @Test
    public void chongqingTimeLottery() throws InterruptedException {
        driverUtil.xpathClick(timeLottery);
        driverUtil.xpathClick(chongqingTimeLottery);
        driverUtil.xpathClick(openLotteryResult);
        Thread.sleep(2000);
        String getIssue1 = driverUtil.getTextByXpath(issue1);
        System.out.println("钻石重庆时时彩最新一期："+getIssue1);
        driverUtil.loginBefore(Url2);
        //driverUtil.switchToWindow("重庆福彩时时彩开奖结果 - 彩票控");
        String getIssue2 = driverUtil.getTextByXpath(issue2);
        System.out.println("重庆时时彩："+getIssue2);
        Assertion.setFlag(true);
        Assertion.verifyEquals(getIssue1,getIssue2);
      //  Assert.assertTrue(Assertion.currentFlag());
    }

    String issue3 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div/table/tbody/tr[2]/td[1]";
    String issue4 = "//*[@id=\"qs_2\"]";
    @Test
    public void Test1(){
        driverUtil.switchToWindowUrl("投注-开奖结果");
        String getIssue3 = driverUtil.getTextByXpath(issue3);
        System.out.println("重庆时时彩第二期："+getIssue3);
        driverUtil.switchToWindowUrl("重庆福彩时时彩开奖结果 - 彩票控");
        String getIssue4 = driverUtil.getTextByXpath(issue4);
        System.out.println("官网验证+"+getIssue4);
        Assertion.setFlag(true);
        Assertion.verifyEquals(getIssue3,getIssue4);
      //  Assert.assertTrue(Assertion.currentFlag());
    }



}
