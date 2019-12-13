package complex;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.math.BigDecimal;

public class FinanceManagement {

    WebDriverUtil driverUtil = new WebDriverUtil(null);
    /**
    String URL = "https://admin.zs-pre.com/";
    String login = "//*[@id=\"app\"]/div/div/form/div[4]/div/div/button/span";

    @BeforeTest
    public void loginBefore() throws InterruptedException {
        driverUtil.loginBefore(URL);
        driverUtil.adminLogin("achao", "123123");
        driverUtil.xpathClick(login);
        Thread.sleep(2000);

    }
    **/
    String financeManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/div/span";


    /**
     * ----------------------------------财务管理-会员对账-对账差别金额1---------------------------------------------
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
    @Title("验证会员对账差别金额数据第一条数据")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入会员对账，2.计算对账差别金额")
    @Description("验证会员对账差别金额第一条数据")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=20&version=1")
    @Test(priority = 1)
        public void ReconciliationVip() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            Thread.sleep(1000);
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

        //对账差别金额=今日会员余额 - 昨天会员余额 - 充值（在线充值、线下充值） - 实际输赢（报表的值） + 未结算的 + 提款 - 活动金额 - 红包金额
        BigDecimal result = getBalanceVipToday1.subtract(getYesterdayBalanceVip1).subtract(getRechargeInline1).subtract(getRechargeOnline1).subtract(getLoseOrWinActual1).add(getNotAccount1).add(getWithdraw1).subtract(getExerciseMoney1).subtract(getRedPacketMoney1);
        System.out.println("验证会员对账差别金额数据第一条");
        System.out.println("计算会员对账差别金额 = "+getBalanceVipToday1+"-"+getYesterdayBalanceVip1+"-"+getRechargeOnline1+"-"+getRechargeInline1+"-"+getLoseOrWinActual1+"+"+getNotAccount1+"+"+getWithdraw1+"-"+getExerciseMoney1+"-"+getRedPacketMoney1);
        System.out.println("页面会员对账差别金额：" + getReconciliationMoney1);
        Assertion.setFlag(true);
        Assertion.verifyEquals(result, getReconciliationMoney1);
        Assert.assertTrue(Assertion.currentFlag());

    }

    /**
     * ----------------------------------财务管理-会员对账-对账差别金额2---------------------------------------------
     *
     * */


    String yesterdayBalanceVip2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[2]/div";
    String rechargeOnline2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[3]/div";
    String rechargeInline2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[4]/div";
    String loseOrWinActual2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[5]/div";
    String notAccount2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[6]/div";
    String withdraw2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[7]/div";
    String exerciseMoney2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[8]/div";
    String redPacketMoney2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[9]/div";
    String BalanceVipToday2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[10]/div";
    String ReconciliationMoney2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[14]/div";

    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证对账差别金额第二条数据")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入会员对账，2.计算对账差别金额第二条数据")
    @Description("验证会员对账差别金额第一条数据")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=21&version=1")
    @Test(priority = 2)
    public void ReconciliationVip2() throws InterruptedException {
        String getYesterdayBalanceVip2 = driverUtil.getTextByXpath(yesterdayBalanceVip2);
        String getRechargeOnline2 = driverUtil.getTextByXpath(rechargeOnline2);
        String getRechargeInline2 = driverUtil.getTextByXpath(rechargeInline2);
        String getLoseOrWinActual2 = driverUtil.getTextByXpath(loseOrWinActual2);
        String getNotAccount2 = driverUtil.getTextByXpath(notAccount2);
        String getWithdraw2 = driverUtil.getTextByXpath(withdraw2);
        String getExerciseMoney2 = driverUtil.getTextByXpath(exerciseMoney2);
        String getRedPacketMoney2 = driverUtil.getTextByXpath(redPacketMoney2);
        String getBalanceVipToday2 = driverUtil.getTextByXpath(BalanceVipToday2);
        String getReconciliationMoney2 = driverUtil.getTextByXpath(ReconciliationMoney2);


        BigDecimal getYesterdayBalanceVip22 = new BigDecimal(getYesterdayBalanceVip2);//昨日会员余额
        BigDecimal getRechargeOnline22 = new BigDecimal(getRechargeOnline2);//线上充值
        BigDecimal getRechargeInline22 = new BigDecimal(getRechargeInline2);//线下充值
        BigDecimal getLoseOrWinActual22 = new BigDecimal(getLoseOrWinActual2);//实际输赢
        BigDecimal getNotAccount22 = new BigDecimal(getNotAccount2);//未结算
        BigDecimal getWithdraw22 = new BigDecimal(getWithdraw2);//提款
        BigDecimal getExerciseMoney22 = new BigDecimal(getExerciseMoney2);//活动奖金
        BigDecimal getRedPacketMoney22 = new BigDecimal(getRedPacketMoney2);//红包金额
        BigDecimal getBalanceVipToday22 = new BigDecimal(getBalanceVipToday2);//今日会员余额
        BigDecimal getReconciliationMoney22 = new BigDecimal(getReconciliationMoney2);//对账差别金额

        //对账差别金额=今日会员余额 - 昨天会员余额 - 充值（在线充值、线下充值） - 实际输赢（报表的值） + 未结算的 + 提款 - 活动金额 - 红包金额
        BigDecimal result = getBalanceVipToday22.subtract(getYesterdayBalanceVip22).subtract(getRechargeInline22).subtract(getRechargeOnline22).subtract(getLoseOrWinActual22).add(getNotAccount22).add(getWithdraw22).subtract(getExerciseMoney22).subtract(getRedPacketMoney22);
        System.out.println("验证对账差别金额第二条");
        System.out.println("计算会员对账差别金额2 = "+getBalanceVipToday22+"-"+getYesterdayBalanceVip22+"-"+getRechargeOnline22+"-"+getRechargeInline22+"-"+getLoseOrWinActual22+"+"+getNotAccount22+"+"+getWithdraw22+"-"+getExerciseMoney22+"-"+getRedPacketMoney22+"="+result);
        System.out.println("页面会员对账差别金额2：" + getReconciliationMoney22);
        Assertion.setFlag(true);
        Assertion.verifyEquals(result, getReconciliationMoney22);
        Assert.assertTrue(Assertion.currentFlag());

    }


    /**
     * ----------------------------------财务管理-会员对账-对账差别金额3---------------------------------------------
     *
     * */

    String yesterdayBalanceVip3 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[2]/div";
    String rechargeOnline3 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[3]/div";
    String rechargeInline3 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[4]/div";
    String loseOrWinActual3 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[5]/div";
    String notAccount3 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[6]/div";
    String withdraw3 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[7]/div";
    String exerciseMoney3 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[8]/div";
    String redPacketMoney3 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[9]/div";
    String BalanceVipToday3 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[10]/div";
    String ReconciliationMoney3 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[14]/div";

    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证会员对账差别金额第三条数据")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入会员对账，2.计算对账差别金额第三条数据")
    @Description("验证会员对账差别金额第三条数据")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=22&version=1")
    @Test(priority = 3)
    public void ReconciliationVip3() throws InterruptedException {
        String getYesterdayBalanceVip3 = driverUtil.getTextByXpath(yesterdayBalanceVip3);
        String getRechargeOnline3 = driverUtil.getTextByXpath(rechargeOnline3);
        String getRechargeInline3 = driverUtil.getTextByXpath(rechargeInline3);
        String getLoseOrWinActual3 = driverUtil.getTextByXpath(loseOrWinActual3);
        String getNotAccount3 = driverUtil.getTextByXpath(notAccount3);
        String getWithdraw3 = driverUtil.getTextByXpath(withdraw3);
        String getExerciseMoney3 = driverUtil.getTextByXpath(exerciseMoney3);
        String getRedPacketMoney3 = driverUtil.getTextByXpath(redPacketMoney3);
        String getBalanceVipToday3 = driverUtil.getTextByXpath(BalanceVipToday3);
        String getReconciliationMoney3 = driverUtil.getTextByXpath(ReconciliationMoney3);


        BigDecimal getYesterdayBalanceVip33 = new BigDecimal(getYesterdayBalanceVip3);//昨日会员余额
        BigDecimal getRechargeOnline33 = new BigDecimal(getRechargeOnline3);//线上充值
        BigDecimal getRechargeInline33 = new BigDecimal(getRechargeInline3);//线下充值
        BigDecimal getLoseOrWinActual33 = new BigDecimal(getLoseOrWinActual3);//实际输赢
        BigDecimal getNotAccount33 = new BigDecimal(getNotAccount3);//未结算
        BigDecimal getWithdraw33 = new BigDecimal(getWithdraw3);//提款
        BigDecimal getExerciseMoney33 = new BigDecimal(getExerciseMoney3);//活动奖金
        BigDecimal getRedPacketMoney33 = new BigDecimal(getRedPacketMoney3);//红包金额
        BigDecimal getBalanceVipToday33 = new BigDecimal(getBalanceVipToday3);//今日会员余额
        BigDecimal getReconciliationMoney33 = new BigDecimal(getReconciliationMoney3);//对账差别金额

        //对账差别金额=今日会员余额 - 昨天会员余额 - 充值（在线充值、线下充值） - 实际输赢（报表的值） + 未结算的 + 提款 - 活动金额 - 红包金额
        BigDecimal result = getBalanceVipToday33.subtract(getYesterdayBalanceVip33).subtract(getRechargeInline33).subtract(getRechargeOnline33).subtract(getLoseOrWinActual33).add(getNotAccount33).add(getWithdraw33).subtract(getExerciseMoney33).subtract(getRedPacketMoney33);
        System.out.println("验证对账差别金额第二条");
        System.out.println("计算会员对账差别金额3 = "+getBalanceVipToday33+"-"+getYesterdayBalanceVip33+"-"+getRechargeOnline33+"-"+getRechargeInline33+"-"+getLoseOrWinActual33+"+"+getNotAccount33+"+"+getWithdraw33+"-"+getExerciseMoney33+"-"+getRedPacketMoney33+"="+result);
        System.out.println("页面会员对账差别金额3：" + getReconciliationMoney33);
        Assertion.setFlag(true);
        Assertion.verifyEquals(result, getReconciliationMoney33);
        Assert.assertTrue(Assertion.currentFlag());

    }


    /**
     * ----------------------------------财务管理-代理对账-对账差别金额1---------------------------------------------
     *
     * */

    String ReconciliationAgent = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[5]/a/li/span";

    String yesterdayBalanceAgent1 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[2]/div";
    String todaySettlementCommission1 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div";
    String todayBackWater1 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[4]/div";
    String todayOddsMoney1 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[5]/div";
    String todayOutMoney1 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[6]/div";
    String todayAddSubtractMoney1 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div";
    String todayAgentBalance1 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[8]/div";
    String ReconciliationAgent1 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[9]/div";
    @Features("财务管理")
    @Stories("代理对账")
    @Title("验证代理对账差别金额数据第一条数据")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入财务管理-代理对账，2.验证第一条数据的对账差别金额")
    @Description("验证代理对账差别金额第一条数据")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=23&version=1")
    @Test(priority = 4)
        public void ReconciliationAgent1() throws InterruptedException {
            driverUtil.xpathClick(ReconciliationAgent);
            Thread.sleep(1000);
            String getYesterdayBalanceAgent1 = driverUtil.getTextByXpath(yesterdayBalanceAgent1);
            String getTodaySettlementCommission1 = driverUtil.getTextByXpath(todaySettlementCommission1);
            String getTodayBackWater1 = driverUtil.getTextByXpath(todayBackWater1);
            String getTodayOddsMoney1 = driverUtil.getTextByXpath(todayOddsMoney1);
            String getTodayOutMoney1 = driverUtil.getTextByXpath(todayOutMoney1);
            String getTodayAddSubtractMoney1 = driverUtil.getTextByXpath(todayAddSubtractMoney1);
            String getTodayAgentBalance1 = driverUtil.getTextByXpath(todayAgentBalance1);
            String getReconciliationAgent1 = driverUtil.getTextByXpath(ReconciliationAgent1);

            BigDecimal getYesterdayBalanceAgent11 = new BigDecimal(getYesterdayBalanceAgent1);//昨日代理余额
            BigDecimal getTodaySettlementCommission11 = new BigDecimal(getTodaySettlementCommission1);//今日结算佣金
            BigDecimal getTodayBackWater11 = new BigDecimal(getTodayBackWater1);//今日返水
            BigDecimal getTodayOddsMoney11 = new BigDecimal(getTodayOddsMoney1);//今日赔率金额
            BigDecimal getTodayOutMoney11 = new BigDecimal(getTodayOutMoney1);//今日出款
            BigDecimal getTodayAddSubtractMoney11 = new BigDecimal(getTodayAddSubtractMoney1);//今日后台增减金额
            BigDecimal getTodayAgentBalance11 = new BigDecimal(getTodayAgentBalance1);//今日代理余额
            BigDecimal getReconciliationAgent11 = new BigDecimal(getReconciliationAgent1);//对账差别金额

        //"对账差别金额 = 今日代理余额 - 昨日代理余额 - 今日结算佣金 - 今日返水 - 今日赔率金额 - 今日后台增减金额 + 今日出款"
        BigDecimal result1 = getTodayAgentBalance11.subtract(getYesterdayBalanceAgent11).subtract(getTodaySettlementCommission11).subtract(getTodayBackWater11).subtract(getTodayOddsMoney11).subtract(getTodayAddSubtractMoney11.add(getTodayOutMoney11));
        System.out.println("验证代理对账差别金额数据第一条");
        System.out.println("计算的代理对账差别金额 = "+getTodayAgentBalance11+"-"+getYesterdayBalanceAgent11+"-"+getTodaySettlementCommission11+"-"+getTodayBackWater11+"-"+getTodayOddsMoney11+"-"+getTodayAddSubtractMoney11+"+"+getTodayOutMoney11+"="+result1);
        System.out.println("报表的代理对账差别金额："+getReconciliationAgent11);
        Assertion.setFlag(true);
        Assertion.verifyEquals(result1, getReconciliationAgent11);
        Assert.assertTrue(Assertion.currentFlag());

    }


    String yesterdayBalanceAgent2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[2]/div";
    String todaySettlementCommission2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[3]/div";
    String todayBackWater2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[4]/div";
    String todayOddsMoney2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[5]/div";
    String todayOutMoney2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[6]/div";
    String todayAddSubtractMoney2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[7]/div";
    String todayAgentBalance2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[8]/div";
    String ReconciliationAgent2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[9]/div";
    @Features("财务管理")
    @Stories("代理对账")
    @Title("验证代理对账第二条数据")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入财务管理-代理对账，2.验证第二条数据的对账差别金额")
    @Description("验证代理对账差别金额第二条数据")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=24&version=1")
    @Test(priority = 5)
    public void ReconciliationAgent2() throws InterruptedException {
        driverUtil.xpathClick(ReconciliationAgent);
        Thread.sleep(1000);
        String getYesterdayBalanceAgent2 = driverUtil.getTextByXpath(yesterdayBalanceAgent2);
        String getTodaySettlementCommission2 = driverUtil.getTextByXpath(todaySettlementCommission2);
        String getTodayBackWater2 = driverUtil.getTextByXpath(todayBackWater2);
        String getTodayOddsMoney2 = driverUtil.getTextByXpath(todayOddsMoney2);
        String getTodayOutMoney2 = driverUtil.getTextByXpath(todayOutMoney2);
        String getTodayAddSubtractMoney2 = driverUtil.getTextByXpath(todayAddSubtractMoney2);
        String getTodayAgentBalance2 = driverUtil.getTextByXpath(todayAgentBalance2);
        String getReconciliationAgent2 = driverUtil.getTextByXpath(ReconciliationAgent2);

        BigDecimal getYesterdayBalanceAgent22 = new BigDecimal(getYesterdayBalanceAgent2);//昨日代理余额
        BigDecimal getTodaySettlementCommission22 = new BigDecimal(getTodaySettlementCommission2);//今日结算佣金
        BigDecimal getTodayBackWater22 = new BigDecimal(getTodayBackWater2);//今日返水
        BigDecimal getTodayOddsMoney22 = new BigDecimal(getTodayOddsMoney2);//今日赔率金额
        BigDecimal getTodayOutMoney22 = new BigDecimal(getTodayOutMoney2);//今日出款
        BigDecimal getTodayAddSubtractMoney22 = new BigDecimal(getTodayAddSubtractMoney2);//今日后台增减金额
        BigDecimal getTodayAgentBalance22 = new BigDecimal(getTodayAgentBalance2);//今日代理余额
        BigDecimal getReconciliationAgent22 = new BigDecimal(getReconciliationAgent2);//对账差别金额

        //"对账差别金额 = 今日代理余额 - 昨日代理余额 - 今日结算佣金 - 今日返水 - 今日赔率金额 - 今日后台增减金额 + 今日出款"
        BigDecimal result2 = getTodayAgentBalance22.subtract(getYesterdayBalanceAgent22).subtract(getTodaySettlementCommission22).subtract(getTodayBackWater22).subtract(getTodayOddsMoney22).subtract(getTodayAddSubtractMoney22.add(getTodayOutMoney22));
        System.out.println("验证代理对账差别金额数据第二条");
        System.out.println("计算的代理对账差别金额 = "+getTodayAgentBalance22+"-"+getYesterdayBalanceAgent22+"-"+getTodaySettlementCommission22+"-"+getTodayBackWater22+"-"+getTodayOddsMoney22+"-"+getTodayAddSubtractMoney22+"+"+getTodayOutMoney22+"="+result2);
        System.out.println("报表的代理对账差别金额："+getReconciliationAgent22);
        Assertion.setFlag(true);
        Assertion.verifyEquals(result2, getReconciliationAgent22);
        Assert.assertTrue(Assertion.currentFlag());
        Thread.sleep(2000);

    }

}




























