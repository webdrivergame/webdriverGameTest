package CPBet;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import UtilTest.StringToNumber;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class cycleRacingCar {
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

    String car = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[1]/span[2]";
    String beijingCar = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[3]/span[1]";
    String beijingCarIssue1 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[4]/div/div[1]/div[2]/p/span/i";
    String beijingCarIssue2 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[4]/div/div[1]/div[3]/p/span/i";

    @Features("赛车")
    @Stories("北京赛车")
    @Title("验证开奖期数是否跳期")
    @Test(priority = 1)
    public void issue(){
        driverUtil.xpathClick(car);
        driverUtil.xpathClick(beijingCar);
        String getBeijingCarIssue1 = driverUtil.getTextByXpath(beijingCarIssue1);
        String getBeijingCarIssue2 = driverUtil.getTextByXpath(beijingCarIssue2);
        BigDecimal a1 = new BigDecimal(getBeijingCarIssue1);
        BigDecimal a2 = new BigDecimal(getBeijingCarIssue2);
            System.out.println("当期已开奖期数："+getBeijingCarIssue1);
            System.out.println("下期待开奖期数："+getBeijingCarIssue2);
        BigDecimal result = a2.subtract(a1);
        Assertion.setFlag(true);
        Assertion.verifyEquals(result.intValue(),"1");
        Assert.assertTrue(Assertion.currentFlag());

    }

    String lotteryTime = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[4]/div/div[1]/div[3]/span";
    String nextIssueTime = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[4]/div/div[1]/div[4]/span";


    @Features("赛车")
    @Stories("北京赛车")
    @Title("验证开奖封盘时间是否低于下期开奖时间")
    @Test(priority = 2)
    public void openLotteryTime() {
        String getLotteryTime = driverUtil.getTextByXpath(lotteryTime).substring(0, 5);//截取时间前五位
        String getNextIssueTime = driverUtil.getTextByXpath(nextIssueTime).substring(0, 5);
        BigDecimal getLotteryTime1 = StringToNumber.colonBigDecimal(getLotteryTime);
        BigDecimal getNextIssueTime1 = StringToNumber.colonBigDecimal(getNextIssueTime);
        System.out.println("封盘截取时间："+getLotteryTime1);
        System.out.println("开奖截取时间："+getNextIssueTime1);
        if (getLotteryTime.equals("已封盘")) {
          System.out.println("已封盘");

        } else {
            int resultIssueTimeCompare2 = getLotteryTime1.compareTo(getNextIssueTime1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(resultIssueTimeCompare2, -1);
            Assert.assertTrue(Assertion.currentFlag());
        }


    }


    String carWater = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[1]/span[3]";
    String carBeijing = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[3]/span[1]";
    String lotteryResult = "//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/div[1]/span[4]";

    @Features("赛车")
    @Stories("北京赛车")
    @Title("验证开奖结果期数是否少数据")
    @Test(priority = 3)
    public void lotteryResult() throws InterruptedException {
        driverUtil.xpathClick(carWater);
        driverUtil.xpathClick(carBeijing);
        driverUtil.xpathClick(lotteryResult);
        Thread.sleep(2000);
        for (int a = 1; a <= 15; a++) {
            String firstBeijing = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div/table/tbody/tr[" + a + "]/td[1]";
            List<WebElement> result = driverUtil.findElementsByXpath(firstBeijing);
                for (WebElement beijing : result) {
                    System.out.println(beijing.getText());

                }

        }

    }


        @AfterTest
        public void close () {
            driverUtil.closeCurrentBrowser();


    }



    /**
     * ------------------------------------------------财务管理>充值记录>今日充值人数------------------去重问题--------------------
     */

    String financeManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/div/span";
    String rechargeRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[1]/a/li/span";
    String clickStatus = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[3]/div/div/div/input";
    String selectSuccess = "/html[1]/body[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/span[1]";
    String rechargeInquire = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[12]/div/button[1]/span";
    String rechargeNumberToday = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[14]/div/span[2]/span[1]";
    String rechargeNumberTodayPage = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[2]/div";
    String yesterdayRecharge = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[11]/div/div/label[2]/span";


    @Features("财务管理")
    @Stories("充值记录")
    @Title("验证今日充值人数")
    @Test(priority = 1)
    public void rechargeNumber() throws InterruptedException {
        driverUtil.xpathClick(financeManagement);
        driverUtil.xpathClick(rechargeRecord);
        Thread.sleep(1000);
        driverUtil.xpathClick(clickStatus);
        Thread.sleep(2000);
        driverUtil.xpathClick(selectSuccess);//选择状态-充值成功
        driverUtil.xpathClick(yesterdayRecharge);
        driverUtil.xpathClick(rechargeInquire);
        Thread.sleep(1000);
        String getRechargeNumberToday = driverUtil.getTextByXpath(rechargeNumberToday);
        String getRechargeNumberToday1 = getRechargeNumberToday.substring(6);//截取数据：今日充值人数：X
        System.out.println("今日充值人数总计：" + getRechargeNumberToday1);


        String getRechargeNumberTodayPage = driverUtil.getTextByXpath(rechargeNumberTodayPage);
        String getRechargeNumberTodayPage1 = getRechargeNumberTodayPage.substring(1, getRechargeNumberTodayPage.indexOf("条"));
        int b1 = Integer.valueOf(getRechargeNumberTodayPage1).intValue();
        //获取页面数量
        for (int a = 1; a <= b1; a++) {
            String name = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr["+ a + "]/td[4]/div/span";
            List<WebElement> result = driverUtil.findElementsByXpath(name);
            for (WebElement beijing : result) {
                System.out.println(beijing.getText());

            }
        }

        System.out.println("今日充值人数页数量：" + getRechargeNumberTodayPage1);
        Assertion.setFlag(true);
        Assertion.verifyEquals(getRechargeNumberToday1, getRechargeNumberTodayPage1);
        Assert.assertTrue(Assertion.currentFlag());

    }

}
