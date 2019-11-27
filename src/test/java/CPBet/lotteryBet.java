package CPBet;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class lotteryBet {

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

    String timeTimeLottery = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[1]/span[2]";
    String chongqingTimeTimeLottery = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[3]/span[1]";
    String entertainedTime = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[4]/div/div[1]/div[3]/span";//time font
    //总和大，总和小
    String totalBig = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[1]/div/div[1]/span[3]/input";
    String totalSmall = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[1]/div/div[2]/span[3]/input";
    //总和单，总和双
    String totalSheet = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[1]/div/div[3]/span[3]/input";
    String totalDouble = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[1]/div/div[4]/span[3]/input";
    //龙虎和
    String dragon = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[1]/div/div[5]/span[3]/input";
    String tiger = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[1]/div/div[6]/span[3]";
    String total = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[1]/div/div[7]/span[3]/input";

    String sureBet = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[1]/span[1]";
    String sureClick = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[5]/div/div[3]/span[2]";
    String success = "/html/body/div[2]/p";
    @Features("时时彩")
    @Stories("重庆时时彩")
    @Title("重庆时时彩下注")
    @Test(priority = 1)
        public void chongqingTimeTimeLottery() throws InterruptedException {
            driverUtil.xpathClick(timeTimeLottery);
            driverUtil.xpathClick(chongqingTimeTimeLottery);
            Thread.sleep(1000);
            String getEntertainedTime = driverUtil.getTextByXpath(entertainedTime);
            if (getEntertainedTime.equals("未开盘") || getEntertainedTime.equals("time font")){
                System.out.println("已封盘");
                }else {
                    driverUtil.xpathClickSendKeys(totalBig,"10");
                    driverUtil.xpathClickSendKeys(totalSmall,"20");
                    driverUtil.xpathClickSendKeys(totalSheet,"30");
                    driverUtil.xpathClickSendKeys(totalDouble,"40");
                    driverUtil.xpathClickSendKeys(dragon,"50");
                    driverUtil.xpathClickSendKeys(tiger,"40");
                    driverUtil.xpathClickSendKeys(total,"30");
                    driverUtil.xpathClick(sureBet);
                    Thread.sleep(1000);
                    driverUtil.xpathClick(sureClick);
                    driverUtil.waitForElement(success,3);
                    String getSuccess = driverUtil.getTextByXpath(success);
                    System.out.println(getSuccess);
                    Assertion.setFlag(true);
                    Assertion.verifyEquals(getSuccess,"下注成功");
                    Assert.assertTrue(Assertion.currentFlag());
            }

        //元素无法点击
    }





}
