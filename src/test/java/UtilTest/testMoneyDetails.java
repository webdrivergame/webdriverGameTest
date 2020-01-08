package UtilTest;

import SeleniumMethod.WebDriverUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;



public class testMoneyDetails {

    WebDriverUtil driverUtil = new WebDriverUtil(null);
    String URL = "http://10.1.101.124:8653/";
    String login = "//*[@id=\"app\"]/div/div/form/div[4]/div/div/button/span";


    @BeforeTest
    public void loginBefore() throws InterruptedException {
        driverUtil.loginBefore(URL);
        driverUtil.adminLogin("achao", "123123");
        driverUtil.xpathClick(login);
        Thread.sleep(2000);

    }

    //用户管理-会员列表-输入账号-查询-资金明细
    String UserManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String vipList = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[3]/a/li/span";
    String more = "/html//div[@id='app']/div//div[@class='tableContent']/div[1]/div[@class='el-table__body-wrapper is-scrolling-right']/table[@class='el-table__body']/tbody/tr[1]/td[18]/div/span/button[@type='button']/span[1]";
    String more1 = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[18]/div/span/button/span";


    @Test(priority = 1)
    public void moneyDetails1() throws InterruptedException {
        driverUtil.xpathClick(UserManagement);
        driverUtil.xpathClick(vipList);
        Thread.sleep(1000);
        driverUtil.scrollToRight();//滚动到最右边
        driverUtil.xpathClick(more1);


    }


    String reportManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/div/span";
    String reportAgent = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[2]/a/li/span";
    String outGame = "//*[@id=\"tab-outGame\"]";

    String team = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[3]/table/tbody/tr/td[15]/div";
    String loseWin = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[2]/table/thead/tr/th[23]/div";
    @Test(priority = 1)
    public void report() throws InterruptedException {
        driverUtil.xpathClick(reportManagement);
        driverUtil.xpathClick(reportAgent);
        Thread.sleep(1000);
        driverUtil.xpathClick(outGame);
        Thread.sleep(1000);

        //driverUtil.scrollToRight1OneThree();//右边滚动三分之一


        driverUtil.horizontaltoMiddle();
        //driverUtil.scrollToRight();//滚动到最右边
        String loseWins = driverUtil.getTextByXpath(loseWin);
        System.out.println("会员输赢："+loseWins);





    }


}
