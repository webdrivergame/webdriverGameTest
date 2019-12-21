package complex;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.math.BigDecimal;

public class ReportManagement {

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



    /**
     * -------------------------------------------报表管理-总代理报表-会员数-----------------------------------------
     *
     * */

    String reportManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/div/span";
    String reportAgentTotal = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[1]/a/li/span";

    String mothsAgentTotal = "//*[@id=\"pane-lottery\"]/div[1]/form/div[5]/div/div[1]/div/div/label[4]/span";
    String inquireAgentTotal = "//*[@id=\"pane-lottery\"]/div[1]/form/div[5]/div/div[2]/div/button[1]/span";

    String vipNumberMonths = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[2]/div";
    String accountAgentTotal = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[1]/div/span";
    String totalVip = "//*[@id=\"pane-lottery\"]/div[2]/div/div[4]/table/tbody/tr/td[2]/div";

    @Features("报表管理")
    @Stories("总代理报表-彩票")
    @Title("验证总代理报表本月会员数")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取zdl本月会员数；3.点击zdl跳转；4.获取跳转后代理报表会员总数")
    @Description("测试仪表盘总会员数是否等于会员列表的会员数")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=25&version=1")
    @Test(priority = 1)
         public void vipNumberMonthsLotty() throws InterruptedException {
            driverUtil.xpathClick(reportManagement);
            Thread.sleep(1000);
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(2000);
            driverUtil.xpathClick(mothsAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getVipNumberMonths = driverUtil.getTextByXpath(vipNumberMonths);
            System.out.println("验证总代理报表本月会员数");
            System.out.println("总代理报表本月会员数："+getVipNumberMonths);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getTotalVip = driverUtil.getTextByXpath(totalVip);
            System.out.println("代理报表本月会员数："+getTotalVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getVipNumberMonths,getTotalVip);
            Assert.assertTrue(Assertion.currentFlag());
    }

    /**
     * -------------------------------------------报表管理-总代理报表-笔数-----------------------------------------
     *
     * */

    String countTotal = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[3]/div";
    String countAgentTotal = "//*[@id=\"pane-lottery\"]/div[2]/div/div[4]/table/tbody/tr/td[5]/div";

    @Features("报表管理")
    @Stories("总代理报表-彩票")
    @Title("验证总代理报表本月充值金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取zdl本月充值笔数；3.点击zdl跳转；4.获取跳转后代理报表充值总数")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=26&version=1")
    @Description("测试总代理报表本月充值笔数是否等于跳转后的代理报表的充值笔数总和")
    @Test(priority = 2)
        public void countTotalLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(mothsAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getCountTotal = driverUtil.getTextByXpath(countTotal);
            System.out.println("验证总代理报表本月充值金额");
            System.out.println("总代理报表本月下注笔数："+getCountTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getCountAgentTotal = driverUtil.getTextByXpath(countAgentTotal);
            System.out.println("代理报表本月投注笔数："+getCountAgentTotal);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getCountTotal,getCountAgentTotal);
            Assert.assertTrue(Assertion.currentFlag());
    }

    /**
     * -------------------------------------------报表管理-总代理报表-投注金额-----------------------------------------
     *
     * */

    String betMoneyAgentTotal = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[4]/div";
    String betMoneyAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[6]/div";

    @Features("报表管理")
    @Stories("总代理报表-彩票")
    @Title("验证总代理报表本月投注金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取zdl本月投注金额；3.点击zdl跳转；4.获取跳转后代理报表投注金额")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=27&version=1")
    @Description("判断总代理报表的投注金额是否等于跳转后的代理报表投注金额总和")
    @Test(priority = 3)
        public void betMoneyAgentTotalLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(mothsAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getBetMoneyAgentTotal = driverUtil.getTextByXpath(betMoneyAgentTotal);
            System.out.println("验证总代理报表本月投注金额");
            System.out.println("总代理列表本月投注金额："+getBetMoneyAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getBetMoneyAgent = driverUtil.getTextByXpath(betMoneyAgent);
            System.out.println("代理列表本月投注金额："+getBetMoneyAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getBetMoneyAgentTotal,getBetMoneyAgent);
            Assert.assertTrue(Assertion.currentFlag());
        }



    /**
     * -------------------------------------------报表管理-总代理报表-赢利投注金额-----------------------------------------
     *
     * */

    String winBetMoneyAgentTotal = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[5]/div/span";
    String winBetMoneyAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[7]/div/span";

    @Features("报表管理")
    @Stories("总代理报表-彩票")
    @Title("验证总代理报表本月赢利投注金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取zdl本月盈利投注金额；3.点击zdl跳转；4.获取跳转后代理报表赢利投注金额")
    @Description("判断总代理报表的赢利投注金额是否等于跳转后的代理报表赢利投注金额总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=28&version=1")
    @Test(priority = 4)
        public void winBetMoneyAgentTotalLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(mothsAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getWinBetMoneyAgentTotal = driverUtil.getTextByXpath(winBetMoneyAgentTotal);
            System.out.println("验证总代理报表本月赢利投注金额");
            System.out.println("总代理列表本月赢利投注金额："+getWinBetMoneyAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getWinBetMoneyAgent = driverUtil.getTextByXpath(winBetMoneyAgent);
            System.out.println("代理列表本月赢利投注金额："+getWinBetMoneyAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWinBetMoneyAgentTotal,getWinBetMoneyAgent);
            Assert.assertTrue(Assertion.currentFlag());
    }

    /**
     * -------------------------------------------报表管理-总代理报表-充值优惠/手续费金额-----------------------------------------
     *
     * */

    String serviceChargeAgentTotal = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[7]/div";
    String serviceChargeAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[4]/table/tbody/tr/td[9]/div";

    @Features("报表管理")
    @Stories("总代理报表-彩票")
    @Title("验证总代理报表本月充值优惠/服务费金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取zdl本月盈利投注金额；3.点击zdl跳转；4.获取跳转后代理报表赢利投注金额")
    @Description("判断总代理报表的充值优惠/手续费金额是否等于跳转后的代理报表充值优惠/手续费金额总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=29&version=1")
    @Test(priority = 5)
        public void serviceChargeAgentTotalLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(mothsAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getServiceChargeAgentTotal = driverUtil.getTextByXpath(serviceChargeAgentTotal);
            System.out.println("验证总代理报表本月充值优惠/服务费金额");
            System.out.println("总代理列表本月充值优惠/服务费金额："+getServiceChargeAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getServiceChargeAgent = driverUtil.getTextByXpath(serviceChargeAgent);
            System.out.println("代理列表本月充值优惠/服务费金额："+getServiceChargeAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getServiceChargeAgentTotal,getServiceChargeAgent);
            Assert.assertTrue(Assertion.currentFlag());
    }


    /**
     * -------------------------------------------报表管理-总代理报表-代理退水金额-----------------------------------------
     *
     * */

    String waterBreakAgentTotal = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[9]/div";
    String waterBreakAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[4]/table/tbody/tr/td[11]/div";

    @Features("报表管理")
    @Stories("总代理报表-彩票")
    @Title("验证总代理报表本月代理退水金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取zdl本月代理退水金额；3.点击zdl跳转；4.获取跳转后代理报表代理退水金额")
    @Description("判断总代理报表的代理退水金额是否等于跳转后的代理报表代理退水金额总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=30&version=1")
    @Test(priority = 6)
        public void waterBreakAgentTotalLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(mothsAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getWaterBreakAgentTotal = driverUtil.getTextByXpath(waterBreakAgentTotal);
            System.out.println("验证总代理报表本月代理退水金额");
            System.out.println("总代理列表本月代理退水金额："+getWaterBreakAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getWaterBreakAgent = driverUtil.getTextByXpath(waterBreakAgent);
            System.out.println("代理列表本月代理退水金额："+getWaterBreakAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWaterBreakAgentTotal,getWaterBreakAgent);
            Assert.assertTrue(Assertion.currentFlag());
    }


    /**
     * -------------------------------------------报表管理-总代理报表-代理赔率金额-----------------------------------------
     *
     * */

    String oddsMoneyAgentTotal = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[8]/div";
    String oddsMoneyAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[4]/table/tbody/tr/td[10]/div";

    @Features("报表管理")
    @Stories("总代理报表-彩票")
    @Title("验证总代理报表本月代理赔率金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取zdl本月代理赔率金额；3.点击zdl跳转；4.获取跳转后代理报表代理赔率金额")
    @Description("判断总代理报表的代理赔率金额是否等于跳转后的代理报表代理赔率金额总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=31&version=1")
    @Test(priority = 7)
        public void oddsMoneyAgentTotalLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(mothsAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getOddsMoneyAgentTotal = driverUtil.getTextByXpath(oddsMoneyAgentTotal);
            System.out.println("验证总代理报表本月代理赔率金额");
            System.out.println("总代理列表本月代理赔率金额："+getOddsMoneyAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getOddsMoneyAgent = driverUtil.getTextByXpath(oddsMoneyAgent);
            System.out.println("代理列表本月代理赔率金额："+getOddsMoneyAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getOddsMoneyAgentTotal,getOddsMoneyAgent);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-总代理报表-会员输赢（不包括退水）金额-----------------------------------------
     *
     * */

    String loseWinAgentTotal = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[10]/div";
    String loseWinAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[4]/table/tbody/tr/td[12]/div";

    @Features("报表管理")
    @Stories("总代理报表-彩票")
    @Title("验证总代理报表本月会员输赢(不包括退水)金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取zdl本月会员输赢（不包括退水）金额；3.点击zdl跳转；4.获取跳转后代理报表会员输赢（不包括退水）金额")
    @Description("判断总代理报表的会员输赢（不包括退水）金额是否等于跳转后的代理报表会员输赢（不包括退水）金额总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=32&version=1")
    @Test(priority = 8)
        public void loseWinAgentTotalLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(mothsAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getLoseWinAgentTotal = driverUtil.getTextByXpath(loseWinAgentTotal);
            System.out.println("验证总代理报表本月会员输赢(不包括退水)金额");
            System.out.println("总代理列表本月会员输赢(不包括退水)金额："+getLoseWinAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getLoseWinAgent = driverUtil.getTextByXpath(loseWinAgent);
            System.out.println("代理列表本月会员输赢(不包括退水)金额："+getLoseWinAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getLoseWinAgentTotal,getLoseWinAgent);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-总代理报表-实际退水金额-----------------------------------------
     *
     * */

    String waterBreakPracticeAgentTotal = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[11]/div";
    String waterBreakPracticeAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[4]/table/tbody/tr/td[13]/div";

    @Features("报表管理")
    @Stories("总代理报表-彩票")
    @Title("验证总代理报表本月实际退水金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取zdl本月实际退水金额；3.点击zdl跳转；4.获取跳转后代理报表实际退水金额")
    @Description("判断总代理报表的实际退水金额是否等于跳转后的代理报表实际退水金额总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=33&version=1")
    @Test(priority = 9)
        public void waterBreakPracticeAgentTotalLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(mothsAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getWaterBreakPracticeAgentTotal = driverUtil.getTextByXpath(waterBreakPracticeAgentTotal);
            System.out.println("验证总代理报表本月实际退水金额");
            System.out.println("总代理列表本月实际退水金额："+getWaterBreakPracticeAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(2000);
            driverUtil.scrollToRight();
            String getWaterBreakPracticeAgent = driverUtil.getTextByXpath(waterBreakPracticeAgent);
            System.out.println("代理列表本月实际退水金额："+getWaterBreakPracticeAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWaterBreakPracticeAgentTotal,getWaterBreakPracticeAgent);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-总代理报表-实际输赢(包括退水)金额-----------------------------------------
     *
     * */

    String loseWinAndWaterAgentTotal = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[12]/div";
    String loseWinAndWaterAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[4]/table/tbody/tr/td[14]/div";

    @Features("报表管理")
    @Stories("总代理报表-彩票")
    @Title("验证总代理报表本月实际输赢(包括退水)金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取zdl本月实际输赢(包括退水)金额；3.点击zdl跳转；4.获取跳转后代理报表实际输赢(包括退水)金额")
    @Description("判断总代理报表的实际输赢(包括退水)金额是否等于跳转后的代理报表实际输赢(包括退水)金额总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=34&version=1")
    @Test(priority = 10)
        public void loseWinAndWaterAgentTotalLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(mothsAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getLoseWinAndWaterAgentTotal = driverUtil.getTextByXpath(loseWinAndWaterAgentTotal);
            System.out.println("验证总代理报表本月实际输赢(包括退水)金额");
            System.out.println("总代理列表本月实际输赢(包括退水)金额："+getLoseWinAndWaterAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(2000);
            String getLoseWinAndWaterAgent = driverUtil.getTextByXpath(loseWinAndWaterAgent);
            System.out.println("代理列表本月实际输赢(包括退水)金额："+getLoseWinAndWaterAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getLoseWinAndWaterAgentTotal,getLoseWinAndWaterAgent);
            Assert.assertTrue(Assertion.currentFlag());
    }









    /** -------------------------------------报表管理-总代理报表-外接游戏-会员数--------------------------------
     *
     **/

    String clickGame = "//*[@id=\"tab-outGame\"]";
    String GameMonthsAgentTotal = "//*[@id=\"pane-outGame\"]/div/div[1]/form/div[2]/div/div[1]/div/div/label[4]/span";
    String inquireGameAgentTotal = "//*[@id=\"pane-outGame\"]/div/div[1]/form/div[2]/div/div[2]/div/button[1]/span";
    String vipNumberGameTotal = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div";
    String clickGameAgentTotal = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[3]/table/tbody/tr/td[1]/div/span";
    String vipTotalAgentJump = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[2]/div";

    @Features("报表管理")
    @Stories("总代理报表-外接游戏")
    @Title("验证总代理报表会员数")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取本月会员数，3.点击跳转代理列表，4.获取代理报表总的会员数")
    @Description("测试总代理报表会员总数")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=34&version=1")
    @Test(priority = 11)
        public void vipNumberGame() throws InterruptedException {
            driverUtil.xpathClick(reportManagement);
            Thread.sleep(1000);
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(clickGame);
            Thread.sleep(1000);
            driverUtil.xpathClick(GameMonthsAgentTotal);
            driverUtil.xpathClick(inquireGameAgentTotal);
            Thread.sleep(1000);

            //总代理列表外接游戏zdl会员总数是否等于跳转的代理会员总数
            String vipNumberOutGameTotal1 = driverUtil.getTextByXpath(vipNumberGameTotal);
            System.out.println("测试总代理报表会员总数");
            System.out.println("总代理报表外接游戏会员总数："+vipNumberOutGameTotal1);
            driverUtil.xpathClick(clickGameAgentTotal);
            Thread.sleep(1000);
            String vipTotalAgentJump1 = driverUtil.getTextByXpath(vipTotalAgentJump);
            System.out.println("跳转到的代理列表会员总计："+vipTotalAgentJump1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(vipNumberOutGameTotal1,vipTotalAgentJump1);
            Assert.assertTrue(Assertion.currentFlag());

    }


    /** -------------------------------------报表管理-总代理报表-外接游戏-会员实际投注总额--------------------------------
     *
     **/

    String betTotalGame = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[3]/table/tbody/tr/td[3]/div";

    String betMoneyRealPeople = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[3]/div";
    String betMoneyElectronicGame  = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[7]/div";
    String betMoneyChess = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[11]/div";//棋牌
    String betMoneySport = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[15]/div";
    String betMoneyElectronicSport = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[19]/div";//电竞

    @Features("报表管理")
    @Stories("总代理报表-外接游戏")
    @Title("验证总代理报表会员实际投注总额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取本月会员实际投注总额，3.点击跳转代理列表，4.获取代理报表会员实际投注总额")
    @Description("测试会员实际投注总额是否等于跳转的代理下实际投注总额相加")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=34&version=1")
    @Test(priority = 12)
        public void betTotalGame() throws InterruptedException {
            driverUtil.xpathClick(clickGame);
            Thread.sleep(1000);
            driverUtil.xpathClick(GameMonthsAgentTotal);
            driverUtil.xpathClick(inquireGameAgentTotal);
            Thread.sleep(1000);


            BigDecimal betTotalGame1 = new BigDecimal(driverUtil.getTextByXpath(betTotalGame));
            System.out.println("验证总代理报表会员实际投注总额");
            System.out.println("外接游戏总代理报表实际投注金额："+betTotalGame1);
            driverUtil.xpathClick(clickGameAgentTotal);
            Thread.sleep(1000);

            BigDecimal betMoneyRealPeople1 = new BigDecimal(driverUtil.getTextByXpath(betMoneyRealPeople));//真人
            BigDecimal betMoneyElectronicGame1 = new BigDecimal(driverUtil.getTextByXpath(betMoneyElectronicGame));//电子
            BigDecimal betMoneyChess1 = new BigDecimal(driverUtil.getTextByXpath(betMoneyChess));//棋牌
            BigDecimal betMoneySport1 = new BigDecimal(driverUtil.getTextByXpath(betMoneySport));//体育
            BigDecimal betMoneyElectronicSport1 = new BigDecimal(driverUtil.getTextByXpath(betMoneyElectronicSport));//电竞


            BigDecimal betMoneyAddAgentGame = betMoneyRealPeople1.add(betMoneyElectronicGame1).add(betMoneyChess1).add(betMoneySport1).add(betMoneyElectronicSport1);
            System.out.println("代理列表计算投注总额："+betMoneyAddAgentGame);

            Assertion.setFlag(true);
            Assertion.verifyEquals(betTotalGame1,betMoneyAddAgentGame);
            Assert.assertTrue(Assertion.currentFlag());


    }


    /** -------------------------------------报表管理-总代理报表-外接游戏-会员实际反水总额--------------------------------
     *
     **/

    String vipBackWaterAgentTotal = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[3]/table/tbody/tr/td[4]/div";

    String VipBackWaterRealPeople = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[4]/div";
    String vipBackWaterElectronicGame  = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[8]/div";
    String vipBackWaterChess = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[12]/div";//棋牌
    String vipBackWaterSport = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[16]/div";
    String vipBackWaterElectronicSport = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[20]/div";//电竞


    @Features("报表管理")
    @Stories("总代理报表-外接游戏")
    @Title("验证总代理报表会员实际反水总额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取本月会员实际反水总额，3.点击跳转代理列表，4.获取代理报表会员实际反水总额")
    @Description("测试会员实际反水总额是否等于跳转的代理下实际反水总额相加")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=34&version=1")
    @Test(priority = 13)
        public void backWaterTotalGame() throws InterruptedException {
            driverUtil.xpathClick(clickGame);
            Thread.sleep(1000);
            driverUtil.xpathClick(GameMonthsAgentTotal);
            driverUtil.xpathClick(inquireGameAgentTotal);
            Thread.sleep(1000);


            BigDecimal vipBackWaterAgentTotal1 = new BigDecimal(driverUtil.getTextByXpath(vipBackWaterAgentTotal));
            System.out.println("验证总代理报表会员实际反水总额");
            System.out.println("总代理报表外接游戏实际反水总额："+vipBackWaterAgentTotal1);
            driverUtil.xpathClick(clickGameAgentTotal);
            Thread.sleep(1000);

        BigDecimal VipBackWaterRealPeople1 = new BigDecimal(driverUtil.getTextByXpath(VipBackWaterRealPeople));//真人
        BigDecimal vipBackWaterElectronicGame1 = new BigDecimal(driverUtil.getTextByXpath(vipBackWaterElectronicGame));//电子
        BigDecimal vipBackWaterChess1 = new BigDecimal(driverUtil.getTextByXpath(vipBackWaterChess));//棋牌
        BigDecimal vipBackWaterSport1 = new BigDecimal(driverUtil.getTextByXpath(vipBackWaterSport));//体育
        BigDecimal vipBackWaterElectronicSport1 = new BigDecimal(driverUtil.getTextByXpath(vipBackWaterElectronicSport));//电竞

        BigDecimal backWaterAddAgentGame = VipBackWaterRealPeople1.add(vipBackWaterElectronicGame1).add(vipBackWaterChess1).add(vipBackWaterSport1).add(vipBackWaterElectronicSport1);
        System.out.println("代理列表计算反水总额："+backWaterAddAgentGame);
        Assertion.setFlag(true);
        Assertion.verifyEquals(vipBackWaterAgentTotal1,backWaterAddAgentGame);
        Assert.assertTrue(Assertion.currentFlag());


    }



    /** -------------------------------------报表管理-总代理报表-外接游戏-会员实际输赢总额--------------------------------
     *
     **/

    String loseWinAgentGameTotal = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[3]/table/tbody/tr/td[5]/div";

    String loseWinRealPeople = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[5]/div";
    String loseWinElectronicGame  = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[9]/div";
    String loseWinChess = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[13]/div";//棋牌
    String loseWinSport = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[17]/div";
    String loseWinElectronicSport = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[21]/div";//电竞


    @Features("报表管理")
    @Stories("总代理报表-外接游戏")
    @Title("验证总代理报表会员实际输赢总额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取本月会员实际输赢总额，3.点击跳转代理列表，4.获取代理报表会员实际输赢总额")
    @Description("测试会员实际输赢总额是否等于跳转的代理下实际输赢总额相加")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=34&version=1")
    @Test(priority = 14)
    public void loseWinTotalGame() throws InterruptedException {
        driverUtil.xpathClick(clickGame);
        Thread.sleep(1000);
        driverUtil.xpathClick(GameMonthsAgentTotal);
        driverUtil.xpathClick(inquireGameAgentTotal);
        Thread.sleep(1000);


        BigDecimal loseWinAgentGameTotal1 = new BigDecimal(driverUtil.getTextByXpath(loseWinAgentGameTotal));
        System.out.println("验证总代理报表会员实际输赢总额");
        System.out.println("总代理报表外接游戏实际输赢总额："+loseWinAgentGameTotal1);
        driverUtil.xpathClick(clickGameAgentTotal);
        Thread.sleep(1000);

        BigDecimal loseWinRealPeople1 = new BigDecimal(driverUtil.getTextByXpath(loseWinRealPeople));//真人
        BigDecimal loseWinElectronicGame1 = new BigDecimal(driverUtil.getTextByXpath(loseWinElectronicGame));//电子
        BigDecimal loseWinChess1 = new BigDecimal(driverUtil.getTextByXpath(loseWinChess));//棋牌
        BigDecimal loseWinSport1 = new BigDecimal(driverUtil.getTextByXpath(loseWinSport));//体育
        BigDecimal loseWinElectronicSport1 = new BigDecimal(driverUtil.getTextByXpath(loseWinElectronicSport));//电竞

        BigDecimal loseWinAddAgentGame = loseWinRealPeople1.add(loseWinElectronicGame1).add(loseWinChess1).add(loseWinSport1).add(loseWinElectronicSport1);
        System.out.println("代理列表计算输赢总额："+loseWinAddAgentGame);
        Assertion.setFlag(true);
        Assertion.verifyEquals(loseWinAgentGameTotal1,loseWinAddAgentGame);
        Assert.assertTrue(Assertion.currentFlag());


    }



    /** -------------------------------------报表管理-总代理报表-外接游戏-会员实际输赢总额(无返水)--------------------------------
     *
     **/

    String loseWinNoWaterGameAgentTotal = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[3]/table/tbody/tr/td[6]/div";
    String loseWinTotalNoWaterGameAgent = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[23]/div";


    @Features("报表管理")
    @Stories("总代理报表-外接游戏")
    @Title("验证总代理报表会员实际输赢总额(无反水)")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取本月会员实际输赢总额(无反水)，3.点击跳转代理列表，4.获取代理报表会员实际输赢总额(无反水)")
    @Description("测试会员实际输赢总额(无反水)是否等于跳转的代理下实际输赢总额(无反水)")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=34&version=1")
    @Test(priority = 15)
    public void loseWinTotalNoWaterGame() throws InterruptedException {
        driverUtil.xpathClick(clickGame);
        Thread.sleep(1000);
        driverUtil.xpathClick(GameMonthsAgentTotal);
        driverUtil.xpathClick(inquireGameAgentTotal);
        Thread.sleep(1000);

        String loseWinNoWaterGameAgentTotal1 = driverUtil.getTextByXpath(loseWinNoWaterGameAgentTotal);
        System.out.println("验证总代理报表会员实际输赢总额(无反水)");
        System.out.println("总代理报表会员实际输赢总额(无反水)："+loseWinNoWaterGameAgentTotal1);
        driverUtil.xpathClick(clickGameAgentTotal);
        Thread.sleep(1000);

        String loseWinTotalNoWaterGameAgent1 = driverUtil.getTextByXpath(loseWinTotalNoWaterGameAgent);
        System.out.println("代理报表实际输赢总额(无反水)"+loseWinTotalNoWaterGameAgent1);
        Assertion.setFlag(true);
        Assertion.verifyEquals(loseWinNoWaterGameAgentTotal1,loseWinTotalNoWaterGameAgent1);
        Assert.assertTrue(Assertion.currentFlag());


    }



    /** -------------------------------------报表管理-总代理报表-外接游戏-代理反水总额--------------------------------
     *
     **/

    String agentBackWaterGame = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[3]/table/tbody/tr/td[7]/div";

    String agentBackWaterRealPeople = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[6]/div";
    String agentBackWaterElectronicGame  = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[10]/div";
    String agentBackWaterChess = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[14]/div";//棋牌
    String agentBackWaterSport = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[18]/div";
    String agentBackWaterElectronicSport = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[22]/div";//电竞


    @Features("报表管理")
    @Stories("总代理报表-外接游戏")
    @Title("验证总代理报表代理反水总额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取本月会代理反水总额，3.点击跳转代理列表，4.获取代理报表代理反水总额")
    @Description("测试代理反水总额是否等于跳转的代理代理反水总额相加")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=34&version=1")
    @Test(priority = 16)
    public void agentBackWaterGame() throws InterruptedException {
        driverUtil.xpathClick(clickGame);
        Thread.sleep(1000);
        driverUtil.xpathClick(GameMonthsAgentTotal);
        driverUtil.xpathClick(inquireGameAgentTotal);
        Thread.sleep(1000);


        BigDecimal agentBackWaterGame1 = new BigDecimal(driverUtil.getTextByXpath(agentBackWaterGame));
        System.out.println("验证总代理报表会员实际反水总额");
        System.out.println("总代理报表外接游戏实际反水总额："+agentBackWaterGame1);
        driverUtil.xpathClick(clickGameAgentTotal);
        Thread.sleep(1000);

        BigDecimal agentBackWaterRealPeople1 = new BigDecimal(driverUtil.getTextByXpath(agentBackWaterRealPeople));//真人
        BigDecimal agentBackWaterElectronicGame1 = new BigDecimal(driverUtil.getTextByXpath(agentBackWaterElectronicGame));//电子
        BigDecimal agentBackWaterChess1 = new BigDecimal(driverUtil.getTextByXpath(agentBackWaterChess));//棋牌
        BigDecimal agentBackWaterSport1 = new BigDecimal(driverUtil.getTextByXpath(agentBackWaterSport));//体育
        BigDecimal agentBackWaterElectronicSport1 = new BigDecimal(driverUtil.getTextByXpath(agentBackWaterElectronicSport));//电竞

        BigDecimal loseWinAddAgentGame = agentBackWaterRealPeople1.add(agentBackWaterElectronicGame1).add(agentBackWaterChess1).add(agentBackWaterSport1).add(agentBackWaterElectronicSport1);
        System.out.println("代理报表外接游戏实际反水总额"+loseWinAddAgentGame);
        Assertion.setFlag(true);
        Assertion.verifyEquals(agentBackWaterGame1,loseWinAddAgentGame);
        Assert.assertTrue(Assertion.currentFlag());

    }



    /** -------------------------------------报表管理-总代理报表-外接游戏-代理额外反水总额-------------------------------
     *
     **/

    String agentAddedBackWaterGame = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[3]/table/tbody/tr/td[8]/div";
    String agentAddedBackWaterGameAgent = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[25]/div";


    @Features("报表管理")
    @Stories("总代理报表-外接游戏")
    @Title("验证总代理报表代理额外反水总额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取本月代理额外反水总额，3.点击跳转代理列表，4.获取代理报表代理额外反水总额")
    @Description("测试代理额外反水总额是否等于跳转的代理下代理额外反水总额")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=34&version=1")
    @Test(priority = 15)
    public void agentAddedBackWaterGame() throws InterruptedException {
        driverUtil.xpathClick(clickGame);
        Thread.sleep(1000);
        driverUtil.xpathClick(GameMonthsAgentTotal);
        driverUtil.xpathClick(inquireGameAgentTotal);
        Thread.sleep(1000);

        String agentAddedBackWaterGame1 = driverUtil.getTextByXpath(agentAddedBackWaterGame);
        System.out.println("验证总代理报表代理额外反水总额");
        System.out.println("总代理报表代理额外反水总额："+agentAddedBackWaterGame1);
        driverUtil.xpathClick(clickGameAgentTotal);
        Thread.sleep(1000);

        String agentAddedBackWaterGameAgent1 = driverUtil.getTextByXpath(agentAddedBackWaterGameAgent);
        System.out.println("代理报表代理额外反水总额"+agentAddedBackWaterGameAgent);
        Assertion.setFlag(true);
        Assertion.verifyEquals(agentAddedBackWaterGame1,agentAddedBackWaterGameAgent);
        Assert.assertTrue(Assertion.currentFlag());


    }



    /** -------------------------------------报表管理-总代理报表-外接游戏-代理实际佣金总额-------------------------------
     *
     **/

    String agentCommissionGame = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[3]/table/tbody/tr/td[9]/div";
    String agentCommissionGameAgent = "//*[@id=\"pane-outGame\"]/div/div[2]/div/div[4]/table/tbody/tr/td[26]/div";


    @Features("报表管理")
    @Stories("总代理报表-外接游戏")
    @Title("验证总代理报表代理实际佣金总额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-总代理报表；2.获取本月代理代理实际佣金总额，3.点击跳转代理列表，4.获取代理报表代理实际佣金总额")
    @Description("测试代理代理实际佣金总额是否等于跳转的代理下代理实际佣金总额")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=34&version=1")
    @Test(priority = 15)
    public void agentCommissionGame() throws InterruptedException {
        driverUtil.xpathClick(clickGame);
        Thread.sleep(1000);
        driverUtil.xpathClick(GameMonthsAgentTotal);
        driverUtil.xpathClick(inquireGameAgentTotal);
        Thread.sleep(1000);

        String agentCommissionGame1 = driverUtil.getTextByXpath(agentCommissionGame);
        System.out.println("验证总代理报表代理实际佣金总额");
        System.out.println("总代理报表代理实际佣金总额："+agentCommissionGame1);
        driverUtil.xpathClick(clickGameAgentTotal);
        Thread.sleep(1000);

        String agentCommissionGameAgent1 = driverUtil.getTextByXpath(agentCommissionGameAgent);
        System.out.println("代理报表代理实际佣金总额"+agentCommissionGameAgent1);
        Assertion.setFlag(true);
        Assertion.verifyEquals(agentCommissionGame1,agentCommissionGameAgent1);
        Assert.assertTrue(Assertion.currentFlag());


    }









    /**
     * -------------------------------------------报表管理-代理报表-本月会员数-----------------------------------------
     *
     * */

    String reportAgent = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[2]/a/li/span";
    String accountAgent = "//*[@id=\"pane-lottery\"]/div[1]/form/div[2]/div/div/input";
    String mothsAgent = "//*[@id=\"pane-lottery\"]/div[1]/form/div[5]/div/div/label[4]/span";
    String inquireAgent = "//*[@id=\"pane-lottery\"]/div[1]/form/div[6]/div/button[1]";
    String clickAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[1]/div/span[1]";
    String vipNumberAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[2]/div";
    String vipNumberVip = "//*[@id=\"pane-lottery\"]/div[2]/div[2]/div";

    @Features("报表管理")
    @Stories("代理报表-彩票")
    @Title("验证代理报表本月会员数量")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-代理报表；2.获取账号dl本月会员数；3.点击dl跳转；4.获取跳转后会员报表本月会员数")
    @Description("判断代理报表的本月会员数是否等于跳转后的代理报表本月会员数总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=35&version=1")
    @Test(priority = 11)
        public void vipNumberAgentLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(mothsAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getVipNumberAgent = driverUtil.getTextByXpath(vipNumberAgent);
            System.out.println("验证代理报表本月会员数量");
            System.out.println("代理报表本月会员数："+getVipNumberAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getVipNumberVip = driverUtil.getTextByXpath(vipNumberVip);
            String getVipNumberVip1 = getVipNumberVip.substring(1,getVipNumberVip.indexOf("条"));
            System.out.println("代理列表本月会员数："+getVipNumberVip1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getVipNumberAgent,getVipNumberVip1);
            Assert.assertTrue(Assertion.currentFlag());
    }






    /**
     * -------------------------------------------报表管理-代理报表-充值金额-----------------------------------------
     *
     * */

    String rechargeMoneyAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[3]/div";
    String rechargeMoneyVip = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[4]/table/tbody/tr/td[4]/div";

    @Features("报表管理")
    @Stories("代理报表-彩票")
    @Title("验证代理报表本月充值金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-代理报表；2.获取账号dl本月充值金额；3.点击dl跳转；4.获取跳转后会员报表本月充值金额")
    @Description("判断代理报表的本月充值金额是否等于跳转后的代理报表本月充值金额总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=36&version=1")
    @Test(priority = 12)
        public void rechargeMoneyAgentLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(mothsAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getRechargeMoneyAgent = driverUtil.getTextByXpath(rechargeMoneyAgent);
            System.out.println("验证代理报表本月充值金额");
            System.out.println("代理报表本月充值金额："+getRechargeMoneyAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getRechargeMoneyVip = driverUtil.getTextByXpath(rechargeMoneyVip);
            System.out.println("会员报表本月充值金额："+getRechargeMoneyVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getRechargeMoneyAgent,getRechargeMoneyVip);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-代理报表-笔数-----------------------------------------
     *
     * */

    String countAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr[1]/td[5]/div";
    String countVip = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[4]/table/tbody/tr/td[6]/div";

    @Features("报表管理")
    @Stories("代理报表-彩票")
    @Title("验证代理报表本月充值笔数")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-代理报表；2.获取账号dl本月笔数；3.点击dl跳转；4.获取跳转后会员报表本月笔数金额")
    @Description("判断代理报表的本月笔数是否等于跳转后的代理报表本月笔数总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=37&version=1")
    @Test(priority = 13)
        public void countAgentLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(mothsAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getCountAgent = driverUtil.getTextByXpath(countAgent);
            System.out.println("验证代理报表本月充值笔数");
            System.out.println("代理报表本月充值笔数："+getCountAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getCountVip = driverUtil.getTextByXpath(countVip);
            System.out.println("会员报表本月充值笔数总计："+getCountVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getCountAgent,getCountVip);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-代理报表-投注金额-----------------------------------------
     *
     * */

    String betMoneyAgentReport = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[6]/div";
    String betMoneyVip = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[4]/table/tbody/tr/td[7]/div";

    @Features("报表管理")
    @Stories("代理报表-彩票")
    @Title("验证代理报表本月投注金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-代理报表；2.获取账号dl本月投注金额；3.点击dl跳转；4.获取跳转后会员报表本月投注金额")
    @Description("判断代理报表的本月投注金额是否等于跳转后的代理报表本月投注金额总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=38&version=1")
    @Test(priority = 14)
        public void betMoneyAgentReportLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(mothsAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getBetMoneyAgentReport = driverUtil.getTextByXpath(betMoneyAgentReport);
            System.out.println("验证代理报表本月投注金额");
            System.out.println("代理报表本月充值笔数："+getBetMoneyAgentReport);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getBetMoneyVip = driverUtil.getTextByXpath(betMoneyVip);
            System.out.println("会员报表本月充值笔数总计："+getBetMoneyVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getBetMoneyAgentReport,getBetMoneyVip);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-代理报表-赢利投注金额-----------------------------------------
     *
     * */

    String winBetMoneyAgentReport = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[7]/div";
    String winBetMoneyVip = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[4]/table/tbody/tr/td[8]/div";

    @Features("报表管理")
    @Stories("代理报表-彩票")
    @Title("验证代理报表本月赢利投注金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-代理报表；2.获取账号dl本月赢利投注金额；3.点击dl跳转；4.获取跳转后会员报表本月赢利投注金额")
    @Description("判断代理报表的本月赢利投注金额是否等于跳转后的代理报表本月赢利投注金额总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=39&version=1")
    @Test(priority = 15)
        public void winBetMoneyAgentReportLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(mothsAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getWinBetMoneyAgentReport = driverUtil.getTextByXpath(winBetMoneyAgentReport);
            System.out.println("验证代理报表本月赢利投注金额");
            System.out.println("代理报表本月赢利投注金额："+getWinBetMoneyAgentReport);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getWinBetMoneyVip = driverUtil.getTextByXpath(winBetMoneyVip);
            System.out.println("会员报表本月赢利投注金额总计："+getWinBetMoneyVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWinBetMoneyAgentReport,getWinBetMoneyVip);
            Assert.assertTrue(Assertion.currentFlag());
    }


    /**
     * -------------------------------------------报表管理-代理报表-充值优惠/手续费金额-----------------------------------------
     *
     * */

    String serviceMoneyAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[9]/div";
    String serviceMoneyVipTotal = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[4]/table/tbody/tr/td[10]/div";

    @Features("报表管理")
    @Stories("代理报表-彩票")
    @Title("验证代理报表本月充值优惠/手续费")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-代理报表；2.获取账号dl本月充值优惠/手续费金额；3.点击dl跳转；4.获取跳转后会员报表本月充值优惠/手续费金额")
    @Description("判断代理报表的本月充值优惠/手续费金额是否等于跳转后的代理报表本月充值优惠/手续费金额总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=40&version=1")
    @Test(priority = 16)
        public void serviceMoneyAgentLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(mothsAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getServiceMoneyAgent = driverUtil.getTextByXpath(serviceMoneyAgent);
            System.out.println("验证代理报表本月充值优惠/手续费");
            System.out.println("代理报表本月充值优惠/手续费："+getServiceMoneyAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getServiceMoneyVipTotal = driverUtil.getTextByXpath(serviceMoneyVipTotal);
            System.out.println("会员报表本月充值优惠手续费："+getServiceMoneyVipTotal);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getServiceMoneyAgent,getServiceMoneyVipTotal);
            Assert.assertTrue(Assertion.currentFlag());
    }




    /**
     * -------------------------------------------报表管理-代理报表-代理赔率金额-----------------------------------------
     *
     * */

    String oddsAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[10]/div";
    String oddsVip = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[4]/table/tbody/tr/td[11]/div";

    @Features("报表管理")
    @Stories("代理报表-彩票")
    @Title("验证代理报表本月代理赔率金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-代理报表；2.获取账号dl本月代理赔率金额；3.点击dl跳转；4.获取跳转后会员报表本月代理赔率金额")
    @Description("判断代理报表的本月代理赔率金额是否等于跳转后的代理报表本月代理赔率金额总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=41&version=1")
    @Test(priority = 17)
        public void oddsAgentLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(mothsAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getOddsAgent = driverUtil.getTextByXpath(oddsAgent);
            System.out.println("验证代理报表本月代理赔率金额");
            System.out.println("代理报表本月代理赔率金额："+getOddsAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getOddsVip = driverUtil.getTextByXpath(oddsVip);
            System.out.println("会员报表本月代理赔率金额："+getOddsVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getOddsAgent,getOddsVip);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-代理报表-代理退水金额-----------------------------------------
     *
     * */

    String waterBreakMoneyAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[11]/div";
    String waterBreakMoneyVip = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[4]/table/tbody/tr/td[12]/div";

    @Features("报表管理")
    @Stories("代理报表-彩票")
    @Title("验证代理报表本月代理退水金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-代理报表；2.获取账号dl本月代理退水金额；3.点击dl跳转；4.获取跳转后会员报表本月代理退水金额")
    @Description("判断代理报表的本月代理退水金额是否等于跳转后的代理报表本月代理退水金额总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=42&version=1")
    @Test(priority = 18)
        public void waterBreakMoneyAgentLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(mothsAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getWaterBreakMoneyAgent = driverUtil.getTextByXpath(waterBreakMoneyAgent);
            System.out.println("验证代理报表本月代理退水金额");
            System.out.println("代理报表本月代理退水金额："+getWaterBreakMoneyAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getWaterBreakMoneyVip = driverUtil.getTextByXpath(waterBreakMoneyVip);
            System.out.println("会员报表本月代理退水金额："+getWaterBreakMoneyVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWaterBreakMoneyAgent,getWaterBreakMoneyVip);
            Assert.assertTrue(Assertion.currentFlag());
    }


    /**
     * -------------------------------------------报表管理-代理报表-会员输赢（不包括退水）-----------------------------------------
     *
     * */

    String winLoseNotWaterAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[12]/div";
    String winLoseNotWaterVip = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[4]/table/tbody/tr/td[13]/div";

    @Features("报表管理")
    @Stories("代理报表-彩票")
    @Title("验证代理报表本月实际输赢（不包括退水）")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-代理报表；2.获取账号dl本月代理退水金额；3.点击dl跳转；4.获取跳转后会员报表本月代理退水金额")
    @Description("判断代理报表的本月会员输赢（不包括退水）是否等于跳转后的代理报表本月会员输赢（不包括退水）总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=43&version=1")
    @Test(priority = 19)
        public void winLoseNotWaterAgentLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(mothsAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getWinLoseNotWaterAgent = driverUtil.getTextByXpath(winLoseNotWaterAgent);
            System.out.println("验证代理报表本月实际输赢（不包括退水）");
            System.out.println("代理报表本月实际输赢（不包括退水）："+getWinLoseNotWaterAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getWinLoseNotWaterVip = driverUtil.getTextByXpath(winLoseNotWaterVip);
            System.out.println("会员报表本月实际输赢（不包括退水）："+getWinLoseNotWaterVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWinLoseNotWaterAgent,getWinLoseNotWaterVip);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-代理报表-会员输赢（包括退水）-----------------------------------------
     *
     * */

    String winLoseWaterAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[14]/div";
    String winLoseWaterVip = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[4]/table/tbody/tr/td[15]/div";

    @Features("报表管理")
    @Stories("代理报表-彩票")
    @Title("验证代理报表本月实际输赢（包括退水）")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-代理报表；2.获取账号dl本月代理退水金额；3.点击dl跳转；4.获取跳转后会员报表本月代理退水金额")
    @Description("判断代理报表的本月会员输赢（包括退水）是否等于跳转后的代理报表本月会员输赢（包括退水）总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=44&version=1")
    @Test(priority = 20)
        public void winLoseWaterAgentLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(mothsAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getWinLoseWaterAgent = driverUtil.getTextByXpath(winLoseWaterAgent);
            System.out.println("验证代理报表本月实际输赢（包括退水）");
            System.out.println("代理报表本月实际输赢（包括退水）："+getWinLoseWaterAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(2000);
            driverUtil.scrollToRight();
            String getWinLoseWaterVip = driverUtil.getTextByXpath(winLoseWaterVip);
            System.out.println("会员报表本月实际输赢（包括退水）："+getWinLoseWaterVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWinLoseWaterAgent,getWinLoseWaterVip);
            Assert.assertTrue(Assertion.currentFlag());
    }

    /**
     * -------------------------------------------报表管理-代理报表-实际退水-------------------------------
     *
     * */

    String waterBreakMoneyActivityAgent = "//*[@id=\"pane-lottery\"]/div[2]/div/div[3]/table/tbody/tr/td[13]/div";
    String waterBreakMoneyActivityVip = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[4]/table/tbody/tr/td[14]/div";

    @Features("报表管理")
    @Stories("代理报表-彩票")
    @Title("验证代理报表本月实际退水金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-代理报表；2.获取账号dl本月代理退水金额；3.点击dl跳转；4.获取跳转后会员报表本月代理退水金额")
    @Description("判断代理报表的本月代理实际退水是否等于跳转后的代理报表本月代理实际退水总和")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 21)
        public void waterBreakMoneyActivityAgentLotty() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(mothsAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getWaterBreakMoneyActivityAgent = driverUtil.getTextByXpath(waterBreakMoneyActivityAgent);
            System.out.println("验证代理报表本月实际退水金额");
            System.out.println("代理报表本月实际退水金额："+getWaterBreakMoneyActivityAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(2000);
            driverUtil.scrollToRight();
            String getWaterBreakMoneyActivityVip = driverUtil.getTextByXpath(waterBreakMoneyActivityVip);
            System.out.println("会员报表本月实际退水金额："+getWaterBreakMoneyActivityVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWaterBreakMoneyActivityAgent,getWaterBreakMoneyActivityVip);
            Assert.assertTrue(Assertion.currentFlag());
    }





    /**
     * -------------------------------------报表管理-会员报表-充值金额-----------------------------------------------
     *
     * */

    //会员报表获取会员本月充值总计
    String reportVip = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[3]/a/li/span";
    String inputVipAccount = "//*[@id=\"pane-lottery\"]/div[1]/form/div[2]/div/div/input";
    String monthsVip = "//*[@id=\"pane-lottery\"]/div[1]/form/div[6]/div/div/label[4]/span";
    String inquireVip = "//*[@id=\"pane-lottery\"]/div[1]/form/div[7]/div/button[1]/span";
    String getRechargeMoneyVip = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[3]/table/tbody/tr/td[4]/div";
    //充值记录获取充值总计
    String financeManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/div/span";
    String rechargeRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[1]/a/li/span";
    String inputVipRechargeRecord = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[5]/div/div/input";
    String monthsRechargeRecord = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[11]/div/div/label[3]/span";
    String inquireRechargeRecord = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[12]/div/button[1]/span";
    String rechargeTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[14]/div/span[2]/span[3]";

    @Features("报表管理")
    @Stories("会员报表-彩票")
    @Title("验证会员报表本月充值金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-会员报表；2.获取账号achy01本月充值金额；3.进入充值记录；4.获取充值记录achy01的本月充值总计")
    @Description("判断会员报表的充值金额是否等于该会员充值记录的充值总计")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 22)
        public void rechargeMoneyVipLotty() throws InterruptedException {
            //driverUtil.xpathClick(reportManagement);
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClick(reportVip);
            Thread.sleep(2000);
            driverUtil.xpathClearSendKeys(inputVipAccount,"achy05");
            driverUtil.xpathClick(monthsVip);
            driverUtil.xpathClick(inquireVip);
            Thread.sleep(2000);
            String getRechargeMoneyVip1 = driverUtil.getTextByXpath(getRechargeMoneyVip);
            System.out.println("验证会员报表本月充值金额");
            System.out.println("会员报表会员充值金额："+getRechargeMoneyVip1);

            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(rechargeRecord);
            Thread.sleep(2000);
            driverUtil.xpathClearSendKeys(inputVipRechargeRecord,"achy05");
            driverUtil.xpathClick(monthsRechargeRecord);
            driverUtil.xpathClick(inquireRechargeRecord);
            Thread.sleep(2000);
            String getRechargeTotal = driverUtil.getTextByXpath(rechargeTotal);
            String getRechargeTotals = getRechargeTotal.substring(6);
            System.out.println("充值记录充值总计："+getRechargeTotals);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getRechargeMoneyVip1,getRechargeTotals);
            Assert.assertTrue(Assertion.currentFlag());


    }

    /**
     * -------------------------------------报表管理-会员报表-提现金额-----------------------------------------------
     *
     * */

    String withdrawMoney = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[3]/table/tbody/tr/td[5]/div";
    String withdrawRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[2]/a/li/span";
    String inputWithdraw = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[3]/div/div/input";
    String monthsWithdraw = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[11]/div/div/label[3]/span";
    String inquireWithdraw = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[12]/div/button[1]";
    String withdrawTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[15]/div/span/span";

    @Features("报表管理")
    @Stories("会员报表-彩票")
    @Title("验证会员报表本月提现金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-会员报表；2.获取账号achy01本月提现金额；3.进入提现记录；4.获取充值记录achy01的本月提现总计")
    @Description("判断会员报表的提现金额是否等于该会员提现记录的提现总计")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 23)
        public void withdrawMoneyVipLotty() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);//收起财务管理防止点到投注记录
            Thread.sleep(1000);
            driverUtil.xpathClick(reportManagement);
            driverUtil.xpathClick(reportVip);
            Thread.sleep(2000);
            driverUtil.xpathClearSendKeys(inputVipAccount,"achy05");
            driverUtil.xpathClick(monthsVip);
            driverUtil.xpathClick(inquireVip);
            Thread.sleep(2000);
            String getWithdrawMoney = driverUtil.getTextByXpath(withdrawMoney);
            System.out.println("验证会员报表本月提现金额");
            System.out.println("会员报表会员提现金额："+getWithdrawMoney);

            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(withdrawRecord);
            Thread.sleep(2000);
            driverUtil.xpathClearSendKeys(inputWithdraw,"achy05");
            driverUtil.xpathClick(monthsWithdraw);
            driverUtil.xpathClick(inquireWithdraw);
            Thread.sleep(2000);
            String getWithdrawTotal = driverUtil.getTextByXpath(withdrawTotal);
            String getWithdrawTotals = getWithdrawTotal.substring(3);
            System.out.println("提现记录提现总计："+getWithdrawTotals);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWithdrawMoney,getWithdrawTotals);
            Assert.assertTrue(Assertion.currentFlag());


    }

    /**
     * -------------------------------------报表管理-会员报表-本月投注笔数-----------------------------------------------
     *
     * */

    String betNumber = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[3]/table/tbody/tr/td[6]/div/span";
    String pageBetNumber = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div";

    @Features("报表管理")
    @Stories("会员报表-彩票")
    @Title("验证会员报表本月投注笔数")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-会员报表；2.获取账号achy01本月投注笔数；3.点击投注笔数跳转；4.获取投注详情页页面数量")
    @Description("判断会员报表的投注笔数是否等于投注详情页的投注数量")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 24)
        public void betNumberLotty() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);//收起财务管理防止点到投注记录
            Thread.sleep(1000);
            driverUtil.xpathClick(reportManagement);
            driverUtil.xpathClick(reportVip);
            Thread.sleep(2000);
            driverUtil.xpathClearSendKeys(inputVipAccount,"achy05");
            driverUtil.xpathClick(monthsVip);
            driverUtil.xpathClick(inquireVip);
            Thread.sleep(2000);
            String getBetNumber = driverUtil.getTextByXpath(betNumber);
            System.out.println("验证会员报表本月投注笔数");
            System.out.println("会员报表投注笔数："+getBetNumber);
            driverUtil.xpathClick(betNumber);
            Thread.sleep(2000);

            driverUtil.switchToWindowTitle("注单明细");
            String getPageBetNumber = driverUtil.getTextByXpath(pageBetNumber);
            System.out.println("投注详情页投注笔数："+getPageBetNumber);
            String getPageBetNumbers = getPageBetNumber.substring(1,getPageBetNumber.indexOf("条"));
            Assertion.setFlag(true);
            Assertion.verifyEquals(getBetNumber,getPageBetNumbers);
            Assert.assertTrue(Assertion.currentFlag());

    }

    /**
     * -------------------------------------报表管理-会员报表-投注金额------------------------------------------------
     *
     * */

    String betMoney = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[3]/table/tbody/tr/td[7]/div";
    String betMoney1 = "//*[@id=\"app\"]/div/div[2]/div/div[1]/form[2]/div[11]/div/span[1]/span[2]";

    @Features("报表管理")
    @Stories("会员报表-彩票")
    @Title("验证会员报表本月投注金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-会员报表；2.获取账号achy01本月投注金额；3.点击投注笔数跳转；4.获取投注详情页页面总投注金额")
    @Description("判断会员报表的投注金额是否等于投注详情页的投注金额总计")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 25)
        public void betMoneyLotty() throws InterruptedException {
            driverUtil.switchToWindowTitle("后台管理系统");
            Thread.sleep(2000);
            String getBetMoney = driverUtil.getTextByXpath(betMoney);
            System.out.println("验证会员报表本月投注金额");
            System.out.println("会员报表投注金额："+getBetMoney);
            driverUtil.switchToWindowTitle("注单明细");
            Thread.sleep(1000);
            String getBetMoney1 = driverUtil.getTextByXpath(betMoney1);
            System.out.println("投注详情页下注总金额："+getBetMoney1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getBetMoney,getBetMoney1);
            Assert.assertTrue(Assertion.currentFlag());

    }

    /**
     * -------------------------------------报表管理-会员报表-充值优惠/手续费-----------------------------------------------
     *
     * */

    String rechargeDiscount = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[3]/table/tbody/tr/td[10]/div";
    String rechargeDiscount1 = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[14]/div/span[2]/span[2]";

    @Features("报表管理")
    @Stories("会员报表-彩票")
    @Title("验证会员报表本月充值优惠金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-会员报表；2.获取账号achy01本月充值优惠金额；3.进入充值记录；4.获取该会员本月充值优惠金额总计")
    @Description("判断会员报表的充值优惠金额是否等于充值记录本月充值优惠金额总计")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 26)
        public void rechargeDiscountLotty() throws InterruptedException {
            driverUtil.switchToWindowTitle("后台管理系统");
            Thread.sleep(2000);
            String getRechargeDiscount = driverUtil.getTextByXpath(rechargeDiscount);
            System.out.println("验证会员报表本月充值优惠金额");
            System.out.println("会员报表本月充值优惠金额："+getRechargeDiscount);
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(rechargeRecord);
            Thread.sleep(1000);
            driverUtil.xpathClearSendKeys(inputVipRechargeRecord,"achy05");
            driverUtil.xpathClick(monthsRechargeRecord);
            driverUtil.xpathClick(inquireRechargeRecord);
            Thread.sleep(2000);
            String getRechargeDiscount1 = driverUtil.getTextByXpath(rechargeDiscount1);
            String getRechargeDiscounts = getRechargeDiscount1.substring(6);
            System.out.println("充值记录充值优惠/手续费："+getRechargeDiscounts);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getRechargeDiscount,getRechargeDiscounts);
            Assert.assertTrue(Assertion.currentFlag());

    }

    /**
     * -------------------------------------报表管理-会员报表-代理赔率金额-----------------------------------------------
     *
     * */

    String agentMoney = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[3]/table/tbody/tr/td[11]/div";

    @Features("报表管理")
    @Stories("会员报表-彩票")
    @Title("验证会员报表本月代理赔率金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-会员报表；2.获取账号achy01本月代理赔率金额；")
    @Description("判断会员报表的代理赔率金额是否等于0")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 27)
        public void agentMoneyLotty() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(reportManagement);
            driverUtil.xpathClick(reportVip);
            Thread.sleep(2000);
            driverUtil.xpathClearSendKeys(inputVipAccount,"achy05");
            driverUtil.xpathClick(monthsVip);
            driverUtil.xpathClick(inquireVip);
            Thread.sleep(2000);

            String getAgentMoney = driverUtil.getTextByXpath(agentMoney);
            System.out.println("验证会员报表本月代理赔率金额");
            System.out.println("代理赔率金额："+getAgentMoney);
            System.out.println("验证默认代理赔率金额为0");
            Assertion.setFlag(true);
            Assertion.verifyEquals(getAgentMoney,"0");
            Assert.assertTrue(Assertion.currentFlag());

    }

    /**
     * -------------------------------------报表管理-会员报表-代理退水金额-----------------------------------------------
     *
     * */

    String agentWater = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[3]/table/tbody/tr/td[12]/div";

    @Features("报表管理")
    @Stories("会员报表-彩票")
    @Title("验证会员报表本月代理退水金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-会员报表；2.获取账号achy01本月代理退水金额；")
    @Description("判断会员报表的代理退水金额是否等于0")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 28)
        public void agentWaterLotty() throws InterruptedException {
            String getAgentWater = driverUtil.getTextByXpath(agentWater);
            System.out.println("验证会员报表本月代理退水金额");
            System.out.println("代理退水金额："+getAgentWater);
            System.out.println("该代理为系统代理退水默认为0");
            Assertion.setFlag(true);
            Assertion.verifyEquals(getAgentWater,"0");
            Assert.assertTrue(Assertion.currentFlag());

        }

    /**
     * -------------------------------------报表管理-会员报表-实际输赢（不包括退水）-----------------------------------------------
     *
     * */


    String activityLoseWinNotWater = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[3]/table/tbody/tr/td[13]/div";
    String loseWinMoneyTotal = "//*[@id=\"app\"]/div/div[2]/div/div[1]/form[2]/div[11]/div/span[2]/span[2]";
    String activityWater = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[3]/table/tbody/tr/td[14]/div";

    @Features("报表管理")
    @Stories("会员报表-彩票")
    @Title("验证会员报表本月实际输赢（不包括退水）金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-会员报表；2.获取账号achy01本月实际输赢（不包括退水）金额；3.进入投注详情；4.获取该会员本月实际输赢（不包括退水）金额")
    @Description("判断会员报表的实际输赢（不包括退水）金额是否等于投注详情的实际输赢金额减去退水金额")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 29)
        public void activityLoseWinLotty() throws InterruptedException {
            BigDecimal activityLoseWinNotWaters = new BigDecimal(driverUtil.getTextByXpath(activityLoseWinNotWater));
            BigDecimal ActivityWaters = new BigDecimal(driverUtil.getTextByXpath(activityWater));
            System.out.println("验证会员报表本月实际输赢（不包括退水）金额");
            System.out.println("会员报表本月实际输赢（不包括退水）金额："+activityLoseWinNotWaters);
            System.out.println("会员报表实际退水："+ActivityWaters);

            driverUtil.switchToWindowTitle("注单明细");
            Thread.sleep(2000);
            BigDecimal loseWinMoneyTotals= new BigDecimal(driverUtil.getTextByXpath(loseWinMoneyTotal));
            System.out.println("投注详情输赢总金额："+loseWinMoneyTotals);
            BigDecimal result = activityLoseWinNotWaters.add(ActivityWaters);//会员输赢（不包括退水）+实际退水=输赢总金额
            Assertion.setFlag(true);
            Assertion.verifyEquals(result,loseWinMoneyTotals);
            Assert.assertTrue(Assertion.currentFlag());

    }


    /**
     * -------------------------------------报表管理-会员报表-实际输赢（包括退水）-----------------------------------------------
     *
     * */

    String activityLoseWinWater = "//*[@id=\"pane-lottery\"]/div[2]/div[1]/div[3]/table/tbody/tr/td[15]/div";

    @Features("报表管理")
    @Stories("会员报表-彩票")
    @Title("验证会员报表本月实际输赢（包括退水）")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-会员报表；2.获取账号achy01本月实际输赢（包括退水）；3.进入投注详情；4.获取输赢总金额")
    @Description("判断会员报表的实际输赢（包括退水）是否等于投注详情的输赢总金额")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 30)
        public void activityLoseWinWaterLotty() throws InterruptedException {
            driverUtil.switchToWindowTitle("后台管理系统");
            Thread.sleep(2000);
            String getActivityLoseWinWater = driverUtil.getTextByXpath(activityLoseWinWater);
            System.out.println("验证会员报表本月实际输赢（包括退水）");
            System.out.println("会员报表本月实际输赢（包括退水）："+getActivityLoseWinWater);
            driverUtil.switchToWindowTitle("注单明细");
            Thread.sleep(2000);
            String getLoseWinMoneyTotal = driverUtil.getTextByXpath(loseWinMoneyTotal);
            System.out.println("投注详情输赢总金额："+getLoseWinMoneyTotal);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getActivityLoseWinWater,getLoseWinMoneyTotal);
            Assert.assertTrue(Assertion.currentFlag());

    }


    /**
     * -------------------------------------报表管理-会员报表-实际退水-----------------------------------------------
     *
     * */


    @Features("报表管理")
    @Stories("会员报表-彩票")
    @Title("验证会员报表本月实际退水金额")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入报表管理-会员报表；2.获取账号achy01本月实际退水金额；3.用投注金额*0.5%")
    @Description("判断会员报表的实际退水金额是否等于投注金额*0.5%")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 31)
        public void activityWaterMoneyLotty() throws InterruptedException {
            driverUtil.switchToWindowTitle("后台管理系统");
            Thread.sleep(2000);
            BigDecimal ActivityWaters = new BigDecimal(driverUtil.getTextByXpath(activityWater));
            BigDecimal betMoneys = new BigDecimal(driverUtil.getTextByXpath(betMoney));
            BigDecimal result = betMoneys.multiply(BigDecimal.valueOf(0.005));
            System.out.println("验证会员报表本月实际退水金额");
            System.out.println("会员报表实际退水金额："+ActivityWaters);
            System.out.println("投注金额*0.5% = "+result);
            Assertion.setFlag(true);
            Assertion.verifyEquals(result,ActivityWaters);
            Assert.assertTrue(Assertion.currentFlag());

    }









}
