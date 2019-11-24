package Backstage.admin;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import UtilTest.StringToNumber;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FinanceManagement {

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


    /** 1.进入充值记录，2.获取列表会员充值金额，余额，3.进入会员列表搜索该会员，4.判断充值金额加余额是否等于会员列表会员余额
     *
     * */

    String financeManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/div/span";
    String rechargeRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[1]/a/li/span";

    String vipAccount = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div/div[1]";
    String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[5]/div";
    String rechargeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[8]/div/span";
    String UserManagement1 = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String vipList = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[3]/a/li/span";
    String inputAccount = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[10]/div/div/input";
    String vipInquire = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[15]/div/button[1]/span";
    String unableUseMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div/span";

    @Features("财务管理")
    @Stories("充值记录")
    @Title("验证充值记录会员余额")
    @Test(priority = 2)
        public void rechargeBalance() throws InterruptedException {
            //财务管理会员充值记录获取余额和充值金额
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(rechargeRecord);
            String getVipAccount = driverUtil.getTextByXpath(vipAccount);
            BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
            BigDecimal getRechargeMoney = new BigDecimal(driverUtil.getTextByXpath(rechargeMoney));
            System.out.println("验证充值记录会员余额");
            System.out.println("充值记录会员余额："+getVipAccount);

            //会员列表获取会员余额
            driverUtil.xpathClick(UserManagement1);
            driverUtil.xpathClick(vipList);
            Thread.sleep(1000);
            driverUtil.xpathClearSendKeys(inputAccount, getVipAccount);
            driverUtil.xpathClick(vipInquire);
            Thread.sleep(1000);
            BigDecimal getUnableUseMoney = new BigDecimal(driverUtil.getTextByXpath(unableUseMoney));
            BigDecimal result = getBalance.add(getRechargeMoney);
            System.out.println("会员列表会员余额："+result);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getUnableUseMoney, result);
            Assert.assertTrue(Assertion.currentFlag());

    }


    /** 1.进入会员对账，2.计算对账差别金额
     *
     * */

    String reconciliationVip = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[4]/a/li/span";

    String yesterdayBalanceVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[2]/div";
    String rechargeOnline = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div";
    String rechargeInline = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[4]/div";
    String loseOrWinActual = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[5]/div";
    String notAccount = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[6]/div";
    String withdraw = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div";
    String exerciseMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[8]/div";
    String redPacketMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[9]/div";
    String BalanceVipToday = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[10]/div";
    String ReconciliationMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[14]";

    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证会员对账差别金额数据")
    @Test(priority = 3)
        public void ReconciliationVip() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(reconciliationVip);
            Thread.sleep(2000);
            String getYesterdayBalanceVip = driverUtil.getTextByXpath(yesterdayBalanceVip);
            String getRechargeOnline = driverUtil.getTextByXpath(rechargeOnline);
            String getRechargeInline = driverUtil.getTextByXpath(rechargeInline);
            String getLoseOrWinActual = driverUtil.getTextByXpath(loseOrWinActual);
            String getNotAccount = driverUtil.getTextByXpath(notAccount);
            String getWithdraw = driverUtil.getTextByXpath(withdraw);
            String getExerciseMoney = driverUtil.getTextByXpath(exerciseMoney);
            String getRedPacketMoney = driverUtil.getTextByXpath(redPacketMoney);
            String getBalanceVipToday = driverUtil.getTextByXpath(BalanceVipToday);
            String getReconciliationMoney = driverUtil.getTextByXpath(ReconciliationMoney);


            BigDecimal getYesterdayBalanceVip1 = new BigDecimal(getYesterdayBalanceVip);//昨日会员余额
            BigDecimal getRechargeOnline1 = new BigDecimal(getRechargeOnline);//线上充值
            BigDecimal getRechargeInline1 = new BigDecimal(getRechargeInline);//线下充值
            BigDecimal getLoseOrWinActual1 = new BigDecimal(getLoseOrWinActual);//实际输赢
            BigDecimal getNotAccount1 = new BigDecimal(getNotAccount);//未结算
            BigDecimal getWithdraw1 = new BigDecimal(getWithdraw);//提款
            BigDecimal getExerciseMoney1 = new BigDecimal(getExerciseMoney);//活动奖金
            BigDecimal getRedPacketMoney1 = new BigDecimal(getRedPacketMoney);//红包金额
            BigDecimal getBalanceVipToday1 = new BigDecimal(getBalanceVipToday);//今日会员余额
            BigDecimal getReconciliationMoney1 = new BigDecimal(getReconciliationMoney);//对账差别金额
            BigDecimal result = getBalanceVipToday1.subtract(getYesterdayBalanceVip1).subtract(getRechargeInline1).subtract(getRechargeOnline1).subtract(getLoseOrWinActual1).add(getNotAccount1).add(getWithdraw1).subtract(getExerciseMoney1).subtract(getRedPacketMoney1);
            System.out.println("验证会员对账差别金额数据");
            System.out.println("计算金额：" + result);
            System.out.println("页面对账差值金额：" + getReconciliationMoney1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(result, getReconciliationMoney1);
            Assert.assertTrue(Assertion.currentFlag());

    }


    /** 1.进入会员对账获取实际输赢金额，2.进入会员报表获取今日实际输赢金额
     *
     * */

    String practiceMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[5]/div";
    String reportManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/div/span";
    String vipReport = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[3]/a/li/span";
    String vipReportMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[4]/table/tbody/tr/td[15]/div";


    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证实际输赢金额")
    @Test(priority = 5)
        public void practiceLoseOrWin() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(reconciliationVip);
            Thread.sleep(2000);
            String getPracticeMoney = driverUtil.getTextByXpath(practiceMoney);

            //进入会员报表获取会员实际输赢金额
            driverUtil.xpathClick(reportManagement);
            Thread.sleep(1000);
            driverUtil.xpathClick(vipReport);
            Thread.sleep(1000);
            String getVipReportMoney = driverUtil.getTextByXpath(vipReportMoney);
            System.out.println("会员对账实际输赢金额：" + getPracticeMoney);
            System.out.println("会员报表今日实际输赢金额：" + getVipReportMoney);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getPracticeMoney, getVipReportMoney);
            Assert.assertTrue(Assertion.currentFlag());

    }

}




























