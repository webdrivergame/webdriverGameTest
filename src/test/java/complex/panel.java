package complex;

import ListenerPackage.Assertion;
import ListenerPackage.TestFailListener;
import SeleniumMethod.WebDriverUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Listeners(TestFailListener.class)
public class panel  {

    //                      C:\Users\Owner\IdeaProjects\seleniumCp


    //private String panel1;

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



    /**1.点击首页仪表盘，2.获取平台总会员数，3.进入会员报表，4.获取会员列表总数
     *
     * */

    String panel = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[1]/a/li/span";
    String playerNumber = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div/div[1]/div/div/div[2]/div[2]/span[2]";
    String userManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String vip = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[3]/a/li/span";
    String playerNumberPage = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]";




    /** 1.点击仪表盘，2.获取平台总注单量，3.进入历史投注记录，4.获取投注笔数
     *
     * */

    String clickNotesNumber = "//*[@id=\"tab-2\"]";
    String totalNotes = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div/div[1]/div/div/div[2]/div[2]/span[2]";
    String betRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[5]/li/div/span";
    String historyBet = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[5]/li/ul/div[2]/a/li/span";
    String clickTime = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/form/div[6]/div/div[2]/i[2]";
    String inquire = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/form/div[7]/div/button[1]";
    String notesPage = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[2]/div[1]";

    @Features("仪表盘")
    @Stories("会员数量")
    @Title("验证仪表盘平台总会员数")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入仪表盘; 2.获取会员数量; 3.进入会员列表；4.获取列表会员总数")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=13&version=1")

    @Test(priority = 1)
        public void playerNumber() throws InterruptedException {
            //仪表盘总会员数
            driverUtil.xpathClick(panel);
            String getPlayerNumber = driverUtil.getTextByXpath(playerNumber);
            //会员列表总会员数
            driverUtil.xpathClick(userManagement);
            driverUtil.xpathClick(vip);
            Thread.sleep(2000);

            String getPlayerNumberPage = driverUtil.getTextByXpath(playerNumberPage);
            String a1 = getPlayerNumberPage.substring(1,getPlayerNumberPage.indexOf("条"));
            System.out.println("验证仪表盘平台总会员数："+getPlayerNumber);
            System.out.println("会员列表会员数："+a1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getPlayerNumber,a1);
            Assert.assertTrue(Assertion.currentFlag());



    }



    @Features("仪表盘")
    @Stories("平台总注单量")
    @Title("验证平台总注单量是否有误")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击仪表盘，2.获取平台总注单量，3.进入历史投注记录，4.获取投注笔数")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=14&version=1")

    @Test(priority = 2)
        public void notesNumber() throws InterruptedException {
            //仪表盘总注单量
            driverUtil.xpathClick(panel);
            driverUtil.xpathClick(clickNotesNumber);
            String getTotalNotes = driverUtil.getTextByXpath(totalNotes);

            //历史投注记录获取总注单量
            driverUtil.xpathClick(betRecord);
            Thread.sleep(1000);
            driverUtil.xpathClick(historyBet);
            Thread.sleep(1000);
            driverUtil.xpathClick(clickTime);
            driverUtil.xpathClick(inquire);
            Thread.sleep(2000);

            String getNotesPage = driverUtil.getTextByXpath(notesPage);
            String getNotesPage1 = getNotesPage.substring(1,getNotesPage.indexOf("条"));
            Assertion.setFlag(true);
            Assertion.verifyEquals(getTotalNotes,getNotesPage1);
            Assert.assertTrue(Assertion.flag);
            Assert.assertTrue(Assertion.currentFlag());

            Thread.sleep(2000);

        }



}
