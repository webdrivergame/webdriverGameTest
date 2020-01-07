package complex;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class UserManagement {

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
         *      用户管理-总代理列表-zdl代理数量         用户管理-代理列表-页面代理数量
         *
         */

    String UserManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String agentTotal = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[1]/a/li/span";
    String agentNumber = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[1]/div[3]/table/tbody/tr[1]/td[3]/div/span";
    String agentList = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[2]/a/li/span";

    String selectAgentTotal = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[1]/form/div[5]/div/div/div/input";
    String selectZDL = "//body/div[2]//ul[@class='el-scrollbar__view el-select-dropdown__list']//span[.='zdl (系统总代理)']";
    String inquire = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[1]/form/div[6]/div/button[1]/span";
    String agentNumberPage = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]";



    @Features("用户管理")
    @Stories("总代理列表")
    @Title("验证总代理列表代理数数量")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入总代理报表，2.获取总代理代理数，3.点击代理列表，4.选择筛选上级代理zdl查询，5.获取页面代理数量")
    @Description("测试总代理列表代理数")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=15&version=1")
    @Test(priority = 1)
        public void agentNumber() throws InterruptedException {

            driverUtil.xpathClick(UserManagement);//点击用户管理
            Thread.sleep(1000);
            driverUtil.xpathClick(agentTotal);//点击总代理列表
            Thread.sleep(1000);
            String getAgentNumber = driverUtil.getTextByXpath(agentNumber);//获取zdl会员数
            System.out.println("验证总代理列表代理数数量");
            System.out.println("总代理列表代理数："+getAgentNumber);

            driverUtil.xpathClick(agentList);//点击代理列表
            Thread.sleep(1000);
            driverUtil.xpathClick(selectAgentTotal);//点击筛选上级代理
            Thread.sleep(1000);
            driverUtil.xpathClick(selectZDL);//选择zdl
            driverUtil.xpathClick(inquire);//查询
            Thread.sleep(1000);

            String getAgentNumberPage = driverUtil.getTextByXpath(agentNumberPage); //获取页面统计代理数量
            String getAgentNumberPage1 = getAgentNumberPage.substring(1,getAgentNumberPage.indexOf("条"));
            System.out.println("代理页面代理数："+getAgentNumberPage1);

            Assertion.setFlag(true);
            Assertion.verifyEquals(getAgentNumber, getAgentNumberPage1);
            Assert.assertTrue(Assertion.currentFlag());
        }




       /** 用户管理-总代理列表-会员数               用户管理-会员列表-会员数
        *
        * */

    String vipNumber = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[1]/div[3]/table/tbody/tr[1]/td[4]/div/span";
    String vipList = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[3]/a/li/span";
    String testUser = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[1]/div/label/span[2]";
    String selectVipAgentTotal = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[1]/form/div[11]/div/div/div/input";
    String selectVipZDL = "//body/div[3]/div[@class='el-scrollbar']//ul[@class='el-scrollbar__view el-select-dropdown__list']//span[.='zdl (系统总代理)']";
    String inquireVip = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[1]/form/div[15]/div/button[1]/span";
    String vipNumberPage = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]";

    @Features("用户管理")
    @Stories("总代理列表")
    @Title("验证总代理列表会员数数量")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入总代理列表，2.获取总代理会员数，3.点击会员列表，4.勾选测试用户，选择上级代理zdl查询，5.获取会员数")
    @Description("测试总代理列表会员数")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=16&version=1")
    @Test(priority = 2)
        public void vipNumber() throws InterruptedException {

            driverUtil.xpathClick(agentTotal); //点击总代理列表
            Thread.sleep(1000);
            String getVipNumber = driverUtil.getTextByXpath(vipNumber);//获取zdl会员数
            System.out.println("验证总代理列表会员数数量");
            System.out.println("总代理列表会员数："+getVipNumber);

            driverUtil.xpathClick(vipList);//点击会员列表
            Thread.sleep(1000);

            driverUtil.xpathClick(selectVipAgentTotal);//点击上级总代理筛选
            Thread.sleep(1000);
            driverUtil.xpathClick(selectVipZDL);//选择zdl
            driverUtil.xpathClick(testUser);//勾选测试用户筛选
            driverUtil.xpathClick(inquireVip);//查询
            Thread.sleep(1000);

            String getVipNumberPage = driverUtil.getTextByXpath(vipNumberPage);//获取会员列表zdl会员数
            String getVipNumberPage1 = getVipNumberPage.substring(1,getVipNumberPage.indexOf("条"));
            System.out.println("会员列表会员数："+getVipNumberPage1);

            Assertion.setFlag(true);
            Assertion.verifyEquals(getVipNumber, getVipNumberPage1);
            Assert.assertTrue(Assertion.currentFlag());
        }




     /** 1.进入代理列表，2.获取代理会员数，3.点击跳转会员列表，4.获取会员数
      *
      * */

    String agentListVipNumber = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[4]/div/section/a/span";
    String agentListVipNumberPage = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]";

    @Features("用户管理")
    @Stories("代理列表")
    @Title("验证代理列表会员数数量")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入代理列表，2.获取代理会员数，3.点击跳转会员列表，4.获取会员数")
    @Description("测试代理会员数是否等于会员列表该会员数量")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=17&version=1")
    @Test(priority = 3)
        public void agentVipNumber() throws InterruptedException {

            driverUtil.xpathClick(agentList);
            Thread.sleep(1000);
            String getAgentListVipNumber = driverUtil.getTextByXpath(agentListVipNumber);
            System.out.println("验证代理列表会员数数量");
            System.out.println("代理列表会员数："+getAgentListVipNumber);


            driverUtil.xpathClick(agentListVipNumber);
            Thread.sleep(2000);
            String getAgentListVipNumberPage = driverUtil.getTextByXpath(agentListVipNumberPage);
            String agentListVipNumberPage1 = getAgentListVipNumberPage.substring(1,getAgentListVipNumberPage.indexOf("条"));
            System.out.println("点击跳转代理列表会员数："+agentListVipNumberPage1);


            Assertion.setFlag(true);
            Assertion.verifyEquals(getAgentListVipNumber, agentListVipNumberPage1);
            Assert.assertTrue(Assertion.currentFlag());

        }



        /** 1.进入用户管理，2.在线玩家点击提出，3.判断是否提出成功
         *
         * */

    String clickOnlinePlayer = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[4]/a/li/span";
    String shot = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[11]/div/section/button/span";
    String sure = "/html/body/div[2]/div/div[3]/button[2]/span";
    String success = "/html/body/div[3]/p";

    @Features("用户管理")
    @Stories("在线玩家")
    @Title("验证在线玩家踢出功能")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入用户管理，2.在线玩家点击提出，3.判断是否提出成功")
    @Description("测试踢出玩家功能")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=18&version=1")
    @Test(priority = 4)
        public void onlinePlayer() throws InterruptedException {
            driverUtil.switchToParentFrame();//切换表格
            driverUtil.xpathClick(clickOnlinePlayer);
            Thread.sleep(2000);

            driverUtil.xpathClick(shot);
            driverUtil.xpathClick(sure);
            driverUtil.waitForElement(success,5);

            String getSuccess = driverUtil.getTextByXpath(success);
            System.out.println(getSuccess);
            System.out.println("验证在线玩家踢出功能");
            System.out.println("踢出信息："+getSuccess);

            //判断踢出后弹窗文本是否一致
            Assertion.setFlag(true);
            Assertion.verifyEquals(getSuccess,"踢出成功!");
            Assert.assertTrue(Assertion.currentFlag());
        }






}