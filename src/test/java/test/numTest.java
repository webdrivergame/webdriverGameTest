package test;

import SeleniumMethod.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class numTest {

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

    String reportManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/div/span";
    String outReport = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[6]/a/li/span";
    String months = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[3]/div/div/label[4]/span";
    String inquire = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[4]/div/button[1]/span";



    @Test
    public void numTest() throws InterruptedException {
        driverUtil.xpathClick(reportManagement);
        driverUtil.xpathClick(outReport);
        Thread.sleep(1000);
        driverUtil.xpathClick(months);
        driverUtil.xpathClick(inquire);
        Thread.sleep(1000);

        int sum = 0;
        double num;
        for (int a1 = 1; a1 <= 15; a1++) {
            String loseWin = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[" + a1 + "]/td[10]/div";
            List<WebElement> loseWin1 = driverUtil.findElementsByXpath(loseWin);
            for (WebElement b1 : loseWin1) {
                java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.000");
                num=Double.parseDouble(String.valueOf(b1));//装换为double类型
                num=Double.parseDouble(myformat.format(num));//保留3位小数
                sum += num;

            }
            System.out.println(sum);
        }
    }









}
