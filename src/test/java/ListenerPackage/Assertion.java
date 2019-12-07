package ListenerPackage;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.Contract;
import org.testng.Assert;


    /*为了使我们的Assert验证多条用例或者方法是否正确,
     * 所以需要设定一个boolean值来进行判断识别,私有变量,防止外部访问
     * */

public class Assertion {

    public static boolean flag = true;


    @Contract(pure = true)
    public static boolean currentFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        Assertion.flag = flag;
    }

    public static List<Error> errors = new ArrayList<Error>();

    public static void verifyEquals(Object actual, Object expected){
        try{
            Assert.assertEquals(actual, expected);
        }catch(Error e){

            e.printStackTrace(); //仅仅代表异常消息的输出，打印当前AssertionError日志
            setFlag(false); //抛出异常时记录flag=false; 目的是为了防止用例之间的flag值发生错乱
            //比如上一条用例没有通过验证,在verifyEquals中的catch最后设定的
            //setflag(false)即flage为false，那么下一条用例执行的时候不管通不通过
            //都是false，所以我们需要初始化设定一下

        }
    }








    public static void verifyNotEquals(Object actual, Object expected){
        try{
            Assert.assertNotEquals(actual, expected);
        }catch(Error e){

            e.printStackTrace(); //仅仅代表异常消息的输出
            setFlag(false); //抛出异常时记录flag=false

        }
    }


    public static void verifyNotNull(Object actual, Object expected){
        try{
            Assert.assertNotNull(actual, (String) expected);
        }catch(Error e){

            e.printStackTrace(); //仅仅代表异常消息的输出
            setFlag(false); //抛出异常时记录flag=false

        }
    }



    public static void verifyFalse(Object actual, Object expected){
        try{
            Assert.assertFalse((Boolean) actual, (String) expected);
        }catch(Error e){

            e.printStackTrace(); //仅仅代表异常消息的输出
            setFlag(false); //抛出异常时记录flag=false

        }
    }


    public static void verifySame(Object actual, Object expected){
        try{
            Assert.assertSame(actual, (String) expected);
        }catch(Error e){

            e.printStackTrace(); //仅仅代表异常消息的输出
            setFlag(false); //抛出异常时记录flag=false

        }
    }


    public static void verifyNotSame(Object actual, Object expected){
        try{
            Assert.assertNotSame(actual, (String) expected);

        }catch(Error e){

            e.printStackTrace(); //仅仅代表异常消息的输出
            setFlag(false); //抛出异常时记录flag=false

        }
    }



}