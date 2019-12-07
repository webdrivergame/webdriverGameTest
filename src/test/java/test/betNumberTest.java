package test;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class betNumberTest {

    WebDriverUtil driverUtil = new WebDriverUtil(null);

    String URL = "http://10.1.101.121:8703/?#/login?redirect=%2F";
    String login = "//*[@id=\"app\"]/div/div/form/div[4]/div/div/button/span";

    @BeforeTest
    public void loginBefore() throws InterruptedException {
        driverUtil.loginBefore(URL);
        driverUtil.adminLogin("achao", "123123");
        driverUtil.xpathClick(login);
        Thread.sleep(2000);

    }


    String reportManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/div/span";
    String reportVip = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[3]/a/li/span";

    String inputVipAccount = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[2]/div/div/input";
    String monthsVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[6]/div/div/label[4]/span";
    String inquireVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[7]/div/button[1]";
    String betNumber = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr/td[6]/div/span";
    String url = "http://10.1.101.121:8703/#/newBetting?uname=achy01&startTime=1575129600000&endTime=1575559167343&filter_test=1";
    String pageBetNumber = "//*[@id=\"app\"]/div/div[2]/div[2]/div";


    @Test
    public void betNumberTest() throws InterruptedException {
        driverUtil.xpathClick(reportManagement);
        driverUtil.xpathClick(reportVip);
        Thread.sleep(1000);
        driverUtil.xpathClearSendKeys(inputVipAccount,"achy01");
        driverUtil.xpathClick(monthsVip);
        driverUtil.xpathClick(inquireVip);
        Thread.sleep(2000);
        String getBetNumber = driverUtil.getTextByXpath(betNumber);
        System.out.println("会员报表投注笔数："+getBetNumber);
        driverUtil.xpathClick(betNumber);
        Thread.sleep(1000);

        driverUtil.switchToWindowUrl(url);
        String getPageBetNumber = driverUtil.getTextByXpath(pageBetNumber);
        System.out.println("投注详情页投注笔数："+getPageBetNumber);
        String getPageBetNumbers = getPageBetNumber.substring(1,getPageBetNumber.indexOf("条"));
        Assertion.setFlag(true);
        Assertion.verifyEquals(getBetNumber,getPageBetNumbers);
        //Assert.assertTrue(Assertion.currentFlag());


    }

    String urlAdmin = "http://10.1.101.121:8703/?#/reportManage/memberReport";
    String betMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr/td[7]/div";

    @Test
    public void test2(){
        driverUtil.switchToWindowUrl(urlAdmin);
        String getBetMoney = driverUtil.getTextByXpath(betMoney);
        System.out.println("投注金额："+getBetMoney);



    }

}
