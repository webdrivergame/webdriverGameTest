package UtilTest;

import SeleniumMethod.WebDriverUtil;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PCDemo {


    WebDriverUtil driverUtil = new WebDriverUtil(null);

    String URL = "http://10.1.101.124:8044/";
    String login = "//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[2]/div[4]";

    @Test
    public void loginBefore() throws InterruptedException {

        driverUtil.loginBefore(URL);

       // Cookie cookie1 = new Cookie("uid","373");
       // Cookie cookie2 = new Cookie("token","7fdb817c7504fa9ff21092b3a268f140");

        driverUtil.addCookie("uid","373");
        driverUtil.addCookie("token","8e73599f39ea9e6050788e5581fac0ae");
        driverUtil.addCookie("curPageUrl","/userManage/members?transtionId=1449");
        driverUtil.addCookie("imgApi","http://10.1.101.124:8700");
        driverUtil.addCookie("invit_code","Z2d6hSyZPj");
        driverUtil.addCookie("time","46");
        driverUtil.addCookie("userDetails","%22agent_href%22:%22http://10.1.101.124:8611/?att=achaodl1%22%2C%22bank_address%22:%22132%22%2C%22bank_no%22:%2261214846545465456456%22%2C%22bank_type%22:%22%E5%BB%BA%E8%AE%BE%E9%93%B6%E8%A1%8C%22%2C%22can_set_odds%22:1%2C%22coin%22:6562.575%2C%22current_login_ip%22:%2210.1.101.3%22%2C%22login_ip%22:%2210.1.101.3%22%2C%22login_time%22:1578421273%2C%22name%22:%22achaodl1%22%2C%22open_third_rebate%22:1%2C%22show_activity%22:1%2C%22show_appdownload%22:1%2C%22show_chatroom%22:1%2C%22show_feedback%22:1%2C%22show_lottery_live%22:1%2C%22show_online_service%22:1%2C%22unsettled_coin%22:0");


        try {
            Thread.sleep(1000);
            driverUtil.refreshPage();
        }catch (InterruptedException e){
            e.printStackTrace();
        }




        Thread.sleep(1000);

    }









}
