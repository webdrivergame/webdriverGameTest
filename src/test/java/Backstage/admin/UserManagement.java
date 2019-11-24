package Backstage.admin;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import UtilTest.StringToNumber;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserManagement {

   WebDriverUtil driverUtil = new WebDriverUtil(null);



        /** 1.进入总代理报表，2.获取总代理代理数，3.点击会员跳转到代理列表，4.获取代理page数量
         *
         * */

    String UserManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String agentTotal = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[1]/a/li/span";
    String agentNumber = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div/span";
    String clickAgentNumber = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div/span";
    String agentNumberPage = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[2]/div[1]";

    @Features("用户管理")
    @Stories("总代理列表")
    @Title("验证总代理列表代理数数量")
    @Test(priority = 1)
        public void agentNumber() throws InterruptedException {
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
            Assert.assertTrue(Assertion.currentFlag());
        }




       /** 1.进入总代理列表，2.获取总代理会员数，3.点击跳转到会员列表，4.获取会员数
        *
        * */

    String vipNumber = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[4]/div/span";
    String vipNumberPage = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[2]/div[1]";

    @Features("用户管理")
    @Stories("总代理列表")
    @Title("验证总代理列表会员数数量")
    @Test(priority = 2)
        public void vipNumber() throws InterruptedException {
            //获取总代理列表会员数
            driverUtil.xpathClick(agentTotal);
            Thread.sleep(1000);
            String getVipNumber = driverUtil.getTextByXpath(vipNumber);
            System.out.println("验证总代理列表会员数数量");
            System.out.println("总代理列表会员数："+getVipNumber);

            //点击跳转会员列表获取会员数
            driverUtil.xpathClick(vipNumber);
            Thread.sleep(2000);
            String getVipNumberPage = driverUtil.getTextByXpath(vipNumberPage);
            String getVipNumberPage1 = getVipNumberPage.substring(1,getVipNumberPage.indexOf("条"));
            System.out.println("跳转页面会员数量："+getVipNumberPage1);

            //判断是否一致
            Assertion.setFlag(true);
            Assertion.verifyEquals(getVipNumber, getVipNumberPage1);
            Assert.assertTrue(Assertion.currentFlag());
        }




     /** 1.进入代理列表，2.获取代理会员数，3.点击跳转会员列表，4.获取会员数
      *
      * */

    String agentList = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[2]/a/li/span";
    String agentListVipNumber = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[4]/div/span";
    String agentListVipNumberPage = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[2]/div[1]";

    @Features("用户管理")
    @Stories("代理列表")
    @Title("验证代理列表会员数数量")
    @Test(priority = 3)
        public void agentVipNumber() throws InterruptedException {
            //获取代理列表会员数
            driverUtil.xpathClick(agentList);
            Thread.sleep(1000);
            String getAgentListVipNumber = driverUtil.getTextByXpath(agentListVipNumber);
            System.out.println("验证代理列表会员数数量");
            System.out.println("代理列表会员数："+getAgentListVipNumber);

            //点击跳转会员列表获取会员数
            driverUtil.xpathClick(agentListVipNumber);
            Thread.sleep(2000);
            String getAgentListVipNumberPage = driverUtil.getTextByXpath(agentListVipNumberPage);
            String agentListVipNumberPage1 = getAgentListVipNumberPage.substring(1,getAgentListVipNumberPage.indexOf("条"));
            System.out.println("点击跳转代理列表会员数："+agentListVipNumberPage1);

            //判断是否一致
            Assertion.setFlag(true);
            Assertion.verifyEquals(getAgentListVipNumber, agentListVipNumberPage1);
            Assert.assertTrue(Assertion.currentFlag());

        }



        /** 1.进入用户管理，2.在线玩家点击提出，3.判断是否提出成功
         *
         * */

    String clickOnlinePlayer = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[4]/a/li/span";
    String shot = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[11]/div/button/span";
    String sure = "/html/body/div[2]/div/div[3]/button[2]/span";
    String success = "/html/body/div[3]/p";

    @Features("用户管理")
    @Stories("在线玩家")
    @Title("验证在线玩家踢出功能")
    @Test(priority = 10)
        public void onlinePlayer() throws InterruptedException {
            driverUtil.switchToParentFrame();//切换表格
            driverUtil.xpathClick(clickOnlinePlayer);
            Thread.sleep(2000);
            driverUtil.xpathClick(shot);
            driverUtil.xpathClick(sure);
            driverUtil.waitForElement(success,5);//显示等待踢出成功弹窗
            String getSuccess = driverUtil.getTextByXpath(success);
            System.out.println(getSuccess);
            System.out.println("验证在线玩家踢出功能");
            System.out.println("踢出信息："+success);

            //判断踢出后弹窗文本是否一致
            Assertion.setFlag(true);
            Assertion.verifyEquals(getSuccess,"踢出成功!");
            Assert.assertTrue(Assertion.currentFlag());
        }


        /** 1.进入用户管理，2.提出在线后台用户，3.判断是否踢出承成功
         *
         * */

    String clickOnlineBackstage = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[5]/a/li/span";
    String agentShot = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[8]/div/button/span";
    String agentSure = "/html/body/div[2]/div/div[3]/button[2]/span";
    String agentSuccess = "/html/body/div[3]/p";

    @Features("用户管理")
    @Stories("在线后台用户")
    @Title("验证后台用户踢出功能")
    @Test(priority = 11)
        public void onlineBackstage() throws InterruptedException {
            driverUtil.xpathClick(clickOnlineBackstage);
            Thread.sleep(1000);
            driverUtil.xpathClick(agentShot);
            driverUtil.xpathClick(agentSure);
            driverUtil.waitForElement(agentSuccess,5);
            String getAgentSuccess = driverUtil.getTextByXpath(agentSuccess);
            System.out.println("验证后台用户踢出功能");
            System.out.println("踢出信息："+agentSuccess);

            //判断是否踢出成功
            Assertion.setFlag(true);
            Assertion.verifyEquals(getAgentSuccess,"踢出成功!");
            Assert.assertTrue(Assertion.currentFlag());

        }




}