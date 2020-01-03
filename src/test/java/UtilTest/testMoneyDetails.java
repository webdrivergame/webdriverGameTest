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

    String more = "tr:nth-of-type(1) > .editColumn.el-table_1_column_17.is-center .el-button.el-button--default.el-button--mini";
    //String balance = "//*[@id=\"el-popover-2038\"]/button[2]/span";
    String balance2 = "//body/div[@role='tooltip']/button[2]/span[1]";
    String inputBalance = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[5]/div/div[2]/form/div[3]/div/div/input";


    @Features("用户管理")
    @Stories("会员列表")
    @Title("验证会员资金明细数据1")
    @Test(priority = 1)
    public void moneyDetails1() throws InterruptedException {
        driverUtil.xpathClick(UserManagement);
        driverUtil.xpathClick(vipList);
        Thread.sleep(1000);
        driverUtil.scrollToWindow();
        driverUtil.findElementByLinkTextAndClick("更多");
        Thread.sleep(1000);
        driverUtil.xpathClick(balance2);
        driverUtil.xpathClearSendKeys(inputBalance,"100");



    }
}
