package complex;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.math.BigDecimal;

public class FinanceManagement {

    WebDriverUtil driverUtil = new WebDriverUtil(null);





    /**  ------------------------------------------财务管理-会员对账-线上充值金额-----------------------------------
     *
     * */


    String financeManagement = "//div[@id='app']/div/div[1]//ul[@role='menubar']/div[3]/li[@role='menuitem']//span[.='财务管理']";
    String vipMoney = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[5]/a/li/span";
    String onlineRecharge = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div";

    String rechargeRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[1]/a/li/span";
    String selectStyle = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/form/div[2]/div/div/div/input";
    String selectOnline = "//body/div[2]/div[@class='el-scrollbar']//ul[@class='el-scrollbar__view el-select-dropdown__list']/li[3]";
    String inquire = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/form/div[12]/div/button[1]/span";
    String rechargeTotal = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/form/div[14]/div/span[2]/span[3]";

    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证会员对账线上充值金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入财务管理-会员对账，2.获取线上充值金额，3.进入充值记录，4.查询今日在线充值")
    @Description("验证会员对账线上充值金额")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=20&version=1")
    @Test(priority = 1)
        public void onlineRecharge() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(vipMoney);
            Thread.sleep(1000);
            String getOnlineRecharge = driverUtil.getTextByXpath(onlineRecharge);
            System.out.println("验证会员对账今日线上充值金额");
            System.out.println("会员对账今日线上充值金额："+getOnlineRecharge);

            //获取充值记录今日在线充值金额
            driverUtil.xpathClick(rechargeRecord);
            Thread.sleep(2000);
            driverUtil.xpathClick(selectStyle);
            Thread.sleep(1000);


            driverUtil.xpathClick(selectOnline);
            driverUtil.xpathClick(inquire);
            Thread.sleep(2000);
            String getRechargeTotalOnline = driverUtil.getTextByXpath(rechargeTotal);
            String getRechargeTotalOnline1 = getRechargeTotalOnline.substring(6);
            System.out.println("充值记录今日在线充值总计："+getRechargeTotalOnline1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getOnlineRecharge, getRechargeTotalOnline1);
            Assert.assertTrue(Assertion.currentFlag());
    }


    /**------------------------------------------财务管理-会员对账-线下充值金额----------------------------------
     *
     * */

    String upRecharge = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[4]/div";

    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证会员对账线下充值金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入财务管理-会员对账，2.获取线下充值金额，3.进入充值记录，4.查询今日后台充值和手动入款金额")
    @Description("验证会员对账线下充值金额")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=20&version=1")
    @Test(priority = 2)
        public void upRecharge() throws InterruptedException {
            driverUtil.xpathClick(vipMoney);
            Thread.sleep(2000);
            BigDecimal getUpRecharge = new BigDecimal(driverUtil.getTextByXpath(upRecharge));
            System.out.println("验证会员对账线下充值金额");
            System.out.println("会员对账今日线下充值金额："+getUpRecharge);

            //充值记录充值总计金额
            driverUtil.xpathClick(rechargeRecord);
            Thread.sleep(1000);
            String rechargeTotal1 = driverUtil.getTextByXpath(rechargeTotal);
            String rechargeTotal2 = rechargeTotal1.substring(6);
            BigDecimal rechargeTotal3 = new BigDecimal(rechargeTotal2);
            System.out.println("充值记录充值总计："+rechargeTotal3);

            //充值总计 - 在线充值 = 后台扣钱 + 手动入款
            driverUtil.xpathClick(selectStyle);
            Thread.sleep(1000);

            driverUtil.xpathClick(selectOnline);
            driverUtil.xpathClick(inquire);
            Thread.sleep(1000);
            String rechargeTotalOnline = driverUtil.getTextByXpath(rechargeTotal);
            String rechargeTotalOnline1 = rechargeTotalOnline.substring(6);
            BigDecimal rechargeTotalOnline2 = new BigDecimal(rechargeTotalOnline1);
            System.out.println("在线充值今日总计："+rechargeTotalOnline);
            BigDecimal handRecharge =rechargeTotal3.subtract(rechargeTotalOnline2);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getUpRecharge, handRecharge);
            Assert.assertTrue(Assertion.currentFlag());
    }


    /**------------------------------------------财务管理-会员对账-彩票实际输赢金额----------------------------------
     *
     * */


    String activityLoseWinLotty = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[5]/div";
    String ReportManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/div/span";
    String vipReport = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[3]/a/li/span";
    String activityLoseWinReport = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[4]/table/tbody/tr/td[15]/div";


    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证会员对账彩票实际输赢金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入财务管理-会员对账，2.获取彩票实际输赢金额，3.进入报表管理-会员报表，4.获取今日实际输赢（包括退水金额）")
    @Description("验证会员对账实际输赢金额")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=20&version=1")
    @Test(priority = 3)
        public void activityLoseWinLotty() throws InterruptedException {
            driverUtil.xpathClick(vipMoney);
            Thread.sleep(1000);
            String getActivityLoseWinLotty = driverUtil.getTextByXpath(activityLoseWinLotty);
            System.out.println("验证会员对账彩票实际输赢金额");
            System.out.println("会员对帐彩票实际输赢金额"+getActivityLoseWinLotty);

            //会员报表获取今日实际输赢（包括退水）
            driverUtil.xpathClick(ReportManagement);
            Thread.sleep(1000);
            driverUtil.xpathClick(vipReport);
            Thread.sleep(1000);
            driverUtil.scrollToWindow();
            String activityLoseWinReport1 = driverUtil.getTextByXpath(activityLoseWinReport);
            System.out.println("会员报表彩票实际输赢(包括退水)："+activityLoseWinReport1);
            driverUtil.scrollToWindowHundred();
            Assertion.setFlag(true);
            Assertion.verifyEquals(getActivityLoseWinLotty, activityLoseWinReport1);
            Assert.assertTrue(Assertion.currentFlag());


    }


    /***
     *    -----------------------------------财务管理-会员对账-外接游戏总输赢--------------------------------------
     *
     *
     * */











}




























