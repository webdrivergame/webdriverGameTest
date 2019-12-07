package Backstage.admin;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


public class test {

        WebDriverUtil driverUtil = new WebDriverUtil(null);


        String Url = "http://10.1.101.121:8703/?#/login?redirect=%2F";
        String login1 = "//*[@id=\"app\"]/div/div/form/div[4]/div/div/button/span";


        @BeforeTest
        public void loginBefore() throws InterruptedException {
            driverUtil.loginBefore(Url);
            driverUtil.adminLogin("achao","123123");
            driverUtil.xpathClick(login1);
            Thread.sleep(2000);

        }

        String userAccount = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[11]/li/div/span";
        String user = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[11]/li/ul/div[3]/a/li/span";
        String click = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr[1]/td[4]/div/button/span";
        String sure2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[3]/div/div[3]/div/button[2]/span";
        String alert = "/html/body/div[2]/p";

        @Test
        public void getTest() throws InterruptedException {
            driverUtil.switchToWindowUrl("后台管理系统");
            driverUtil.xpathClick(userAccount);
            driverUtil.xpathClick(user);
            Thread.sleep(2000);
            driverUtil.xpathClick(click);
            driverUtil.xpathClick(sure2);
            driverUtil.waitForElement(alert,3);
            String getAlert = driverUtil.getTextByXpath(alert);
            System.out.println("弹出信息："+getAlert);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getAlert,"修改成功！");
          //  Assert.assertTrue(Assertion.currentFlag());


        }

        String UserManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
        String vipList = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[3]/a/li/span";
        String unLoginDay = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[14]/div/div/input";
        String vipInquire = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[15]/div/button[1]/span";
        String pageNumber = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[2]/div";

        @Test
        public void tstVipList() throws InterruptedException {
            driverUtil.xpathClick(UserManagement);
            driverUtil.xpathClick(vipList);
            Thread.sleep(2000);
            driverUtil.xpathClearSendKeys(unLoginDay,"1");
            driverUtil.xpathClick(vipInquire);
            Thread.sleep(2000);
            String getPageNumber = driverUtil.getTextByXpath(pageNumber);
            String a1 = getPageNumber.substring(1,pageNumber.indexOf("条"));
            System.out.println(getPageNumber);
            int b1 = Integer.valueOf(a1).intValue();
            if(b1<=20){
                for (int a = 1; a<= b1; a++){
                    String oneVip = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[+ a +]/td[15]/div";
                    List<WebElement> resultVipList = driverUtil.findElementsByXpath(oneVip);
                    for (WebElement b : resultVipList){

                    }
                }
            }
        }

        String financeManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/div/span";
        String rechargeRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[1]/a/li/span";
        String dateType = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[10]/div/div[1]/div[1]/input";
        String addTime = "/html/body/div[2]/div[1]/div[1]/ul/li[2]/span";
        String inquire = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[12]/div/button[1]/span";
        @Test
        public void click() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(rechargeRecord);
            Thread.sleep(2000);
            driverUtil.xpathClick(dateType);
            driverUtil.waitForElement(addTime,3);
            driverUtil.xpathClick(addTime);
            driverUtil.xpathClick(inquire);



        }

}
