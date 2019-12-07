package test;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class switchWindow {

    WebDriverUtil driverUtil = new WebDriverUtil(null);

    String UrlAdmin = "http://10.1.101.121:8703/?#/login?redirect=%2F";
    String UrlPlayer = "http://10.1.101.121:8702/";
    String loginAdmin = "//*[@id=\"app\"]/div/div/form/div[4]/div/div/button/span";

    String code = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[2]/p/span";
    String inputCode = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[2]/p/input";
    String loginPlayer = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[2]/span[1]";
    String sure = "//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/div[2]/span";
    String goGame = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[4]/span[2]";
    String clickAgree = "//*[@id=\"app\"]/div/div/div/div[3]/div/p[1]";
    String clickCloseAnnouncement = "//*[@id=\"app\"]/div/div[2]/div[1]/div[3]/div/span";

    @BeforeTest
    public void loginBefore() throws InterruptedException {
        driverUtil.loginBefore(UrlAdmin);
        driverUtil.adminLogin("achao","123123");
        driverUtil.xpathClick(loginAdmin);
        Thread.sleep(2000);
        System.out.println(driverUtil.getTitle());

        driverUtil.loginBefore(UrlPlayer);
        driverUtil.playerLogin("achy01", "achy01");
        String getCode = driverUtil.getTextByXpath(code);
        System.out.println(getCode);
        driverUtil.xpathClearSendKeys(inputCode,getCode);
        driverUtil.xpathClick(loginPlayer);
        driverUtil.xpathClick(sure);
        Thread.sleep(1000);
        driverUtil.xpathClick(goGame);
        driverUtil.xpathClick(clickAgree);
        Thread.sleep(3000);
        driverUtil.xpathClick(clickCloseAnnouncement);
        driverUtil.switchToWindowUrl("后台管理系统");
        Thread.sleep(2000);

    }

    String UserManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String agentTotal = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[1]/a/li/span";
    String agentNumber = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div/span";
    String clickAgentNumber = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div/span";
    String agentNumberPage = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[2]/div[1]";


    @Test
    public void test1() throws InterruptedException {
            //获取总代理列表代理数
            driverUtil.xpathClick(UserManagement);
            driverUtil.xpathClick(agentTotal);
            Thread.sleep(1000);
            String getAgentNumber = driverUtil.getTextByXpath(agentNumber);
            System.out.println("验证总代理列表代理数数量");
            System.out.println("总代理列表代理数："+getAgentNumber);

            //点击会员跳转会员列表获取代理数
            driverUtil.xpathClick(clickAgentNumber);
            Thread.sleep(2000);
            String getAgentNumberPage = driverUtil.getTextByXpath(agentNumberPage);
            String getAgentNumberPage1 = getAgentNumberPage.substring(1,getAgentNumberPage.indexOf("条"));
            System.out.println("跳转页面代理数："+getAgentNumberPage1);

            //判断是否一致
            Assertion.setFlag(true);
            Assertion.verifyEquals(getAgentNumber, getAgentNumberPage1);
           // Assert.assertTrue(Assertion.currentFlag());
        }



}
