package Backstage.admin;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.openqa.selenium.remote.server.handler.DeleteSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.math.BigDecimal;


@Description("测试仪表盘总会员数是否等于会员列表的会员数")
@Issue("http://10.1.101.66:890/index.php?m=bug&f=view&bugID=3179")
public class moneyDetails {

    WebDriverUtil driverUtil = new WebDriverUtil(null);
    String Url = "http://10.1.101.121:8703/";
    //String Url = "https://admin.zs-pre.com/";
    String login = "//*[@id=\"app\"]/div/div/form/div[4]/div/div/button/span";

   /** @BeforeTest
        public void loginBefore() throws InterruptedException {
            driverUtil.loginBefore(Url);
            driverUtil.adminLogin("achao", "123123");
            driverUtil.xpathClick(login);
            Thread.sleep(2000);

        }
    */


    //用户管理-会员列表-输入账号-查询-资金明细
    String UserManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String vipList = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[3]/a/li/span";
    String inputAccount = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[10]/div/div/input";
    String inquireVip = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[15]/div/button[1]/span";
    String moneyDetails = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr/td[17]/div/button[3]/span";


    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据1")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 1)
        public void moneyDetails1() throws InterruptedException {
            driverUtil.xpathClick(UserManagement);
            driverUtil.xpathClick(vipList);
            Thread.sleep(2000);
            driverUtil.xpathClearSendKeys(inputAccount,"achy01");
            driverUtil.xpathClick(inquireVip);
            Thread.sleep(2000);
            driverUtil.xpathClick(moneyDetails);
            Thread.sleep(3000);

            //交易类型，交易金额，余额
            String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div";
            String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[4]/div";
            String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[5]/div";
            String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[5]/div";

            String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

            BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
            BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
            BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
            System.out.println("验证会员资金明细数据1");
            System.out.println("交易类型："+getChangeType);
            System.out.println("交易前金额："+getBalanceBefore);
            System.out.println("交易金额："+getChangeMoney);
            System.out.println("余额："+getBalance);
            if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
                BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
                System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getBalance,result);
               // Assert.assertTrue(Assertion.currentFlag());
            }else {
                BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
                System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getBalance,result);
                Assert.assertTrue(Assertion.currentFlag());

            }


    }




    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据2")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 2)
    public void moneyDetails2() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据2");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }

        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }



    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据3")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 3)
    public void moneyDetails3() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[4]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据3");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }

        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }

    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据4")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 4)
    public void moneyDetails4() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[4]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[4]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[4]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[5]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据4");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }

        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }


    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据5")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 5)
    public void moneyDetails5() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[5]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[5]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[5]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[6]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据5");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }


        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }


    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据6")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 6)
    public void moneyDetails6() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[6]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[6]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[6]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[7]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据6");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }

        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }



    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据7")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 7)
    public void moneyDetails7() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[7]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[7]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[7]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[8]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据7");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }


        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }


    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据8")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 8)
    public void moneyDetails8() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[8]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[8]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[8]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[9]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据8");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }

        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }


    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据9")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 9)
    public void moneyDetails9() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[9]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[9]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[9]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[10]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据9");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }

        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }



    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据10")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 10)
    public void moneyDetails10() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[10]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[10]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[10]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[11]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据10");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }

        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }


    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据12")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 11)
    public void moneyDetails11() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[11]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[11]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[11]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[12]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据11");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }

        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }


    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据12")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 12)
    public void moneyDetails12() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[12]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[12]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[12]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[13]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据12");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }

        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }

    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据13")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 13)
    public void moneyDetails13() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[13]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[13]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[13]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[14]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据13");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }
        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }

    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据14")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 14)
    public void moneyDetails14() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[14]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[14]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[14]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[15]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据14");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }
        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }


    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据15")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 15)
    public void moneyDetails15() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[15]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[15]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[15]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[16]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据15");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }
        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }



    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据16")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 16)
    public void moneyDetails16() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[16]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[16]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[16]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[17]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据16");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }
        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }

    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据17")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 17)
    public void moneyDetails17() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[17]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[17]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[17]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[18]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据17");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }
        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }



    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据18")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 18)
    public void moneyDetails18() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[18]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[18]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[18]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[19]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据18");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }
        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }



    @Features("用户管理")
    @Stories("会员列表-achy01会员资金明细")
    @Title("验证会员资金明细数据19")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.用户管理-会员列表，2.输入achy01会员查询；3.查看该会员资金明细")
    @Description("测试achy01的资金明细数据，资金账变是否有误")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=45&version=1")
    @Test(priority = 19)
    public void moneyDetails19() throws InterruptedException {
        //交易类型，交易金额，余额
        String changeType = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[19]/td[3]/div";
        String changeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[19]/td[4]/div";
        String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[19]/td[5]/div";
        String balanceBefore = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[20]/td[5]/div";

        String getChangeType = driverUtil.getTextByXpath(changeType);//交易类型

        BigDecimal getChangeMoney = new BigDecimal(driverUtil.getTextByXpath(changeMoney));
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getBalanceBefore = new BigDecimal(driverUtil.getTextByXpath(balanceBefore));
        System.out.println("验证会员资金明细数据19");
        System.out.println("交易类型："+getChangeType);
        System.out.println("交易前金额："+getBalanceBefore);
        System.out.println("交易金额："+getChangeMoney);
        System.out.println("余额："+getBalance);
        BigDecimal result = getBalanceBefore.add(getChangeMoney);//交易前余额加下注金额(负数)等于余额
        if (getChangeType.equals("奖金") || getChangeType.equals("退水")){
            System.out.println("计算结果余额："+getBalanceBefore+"+"+getChangeMoney+" = "+result);
        }else {
            System.out.println("计算结果余额："+getBalanceBefore + getChangeMoney+" = "+result);
        }
        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalance,result);
        Assert.assertTrue(Assertion.currentFlag());

    }





}
