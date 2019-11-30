package UtilTest;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.math.BigDecimal;
import java.util.List;

public class testMoneyDetails {

    WebDriverUtil driverUtil = new WebDriverUtil(null);
    String Url = "http://10.1.101.121:8703/";
    //String Url = "https://admin.zs-pre.com/";
    String login = "//*[@id=\"app\"]/div/div/form/div[4]/div/div/button/span";

    @BeforeTest
    public void loginBefore() throws InterruptedException {
        driverUtil.loginBefore(Url);
        driverUtil.adminLogin("achao", "123123");
        driverUtil.xpathClick(login);
        Thread.sleep(2000);

    }

    //用户管理-会员列表-输入账号-查询-资金明细
    String UserManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String vipList = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[3]/a/li/span";
    String inputAccount = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[10]/div/div/input";
    String inquireVip = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[15]/div/button[1]/span";
    String moneyDetails = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr/td[17]/div/button[3]/span";


    @Features("用户管理")
    @Stories("会员列表")
    @Title("验证会员资金明细数据1")
    @Test(priority = 1)
    public void moneyDetails1() throws InterruptedException {
        driverUtil.xpathClick(UserManagement);
        driverUtil.xpathClick(vipList);
        Thread.sleep(1000);
        driverUtil.xpathClearSendKeys(inputAccount, "achy01");
        driverUtil.xpathClick(inquireVip);
        Thread.sleep(2000);
        driverUtil.xpathClick(moneyDetails);
        Thread.sleep(3000);
        //String pageMoneyDetails = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[2]/div[1]";
        //String pageMoneyDetails1 = pageMoneyDetails.substring(1, pageMoneyDetails.indexOf("条"));
        //int b = Integer.valueOf(pageMoneyDetails1).intValue();
        //System.out.println(b);
        for (int a1 = 1; a1 <= 20; a1++) {
            String changeMoney1 = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[" + a1 + "]/td[4]/div";
            List<WebElement> webElement = driverUtil.findElementsByXpath(changeMoney1);
            for (WebElement changeMoney : webElement) {
                System.out.println(changeMoney.getText());
            }
        }
        for (int a1 = 1; a1 <= 20; a1++) {
            String balance1 = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[" + a1 + "]/td[5]/div";
            List<WebElement> webElement = driverUtil.findElementsByXpath(balance1);
            for (WebElement balance : webElement) {
                System.out.println(balance.getText());
            }
        }
        for (int a1 = 2; a1 <= 20; a1++) {
            String changeMoneyBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[" + a1 + "]/td[5]/div";
            List<WebElement> webElement = driverUtil.findElementsByXpath(changeMoneyBefore);
            for (WebElement changeMoneyBefore1 : webElement) {
                System.out.println(changeMoneyBefore1.getText());
            }
        }




    }
}
