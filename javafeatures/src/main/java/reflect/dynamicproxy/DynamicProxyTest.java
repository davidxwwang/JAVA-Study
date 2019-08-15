package reflect.dynamicproxy;

import sun.applet.AppletClassLoader;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLClassLoader;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

public class DynamicProxyTest {

    public static void main(String[] args) {
        new DynamicProxyTest().doTest();
    }

    static class OOObject{}


    void doTest(){
        try {
            String path = this.getClass().getClassLoader().getResources("").toString();
            System.out.print(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = "l am 君山";
        byte[] b;
        char[] charb = new char[s.length()];
        try {
             s.getChars(0,s.length(),charb,0);
             b = s.getBytes("GB2312");
            byte[] bb =b;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        // 一个学生
        Person david = new Student("david");

        /*************** 为一个名叫david的学生去设置一个动态代理 *************************/
        // （1）对于类似HSF这种远程服务，如果对方知道类的全名，那么就可以使用Class.forName()等方法，生成一个动态代理，然后调用它。
        // （2）对于方法的权限，打log日志，计算方法耗时等这种需求，也可以使用动态代理的方法
        //  不足的是，这种方法必须要求类是符合某种interface，也只能动态代理interface的方法，无法对普通的类代理，只能借助cglib了。

        InvocationHandler invocationHandler = new MyInvocationHandler<Person>(david);
        Class<?> studentClassProxy = Proxy.getProxyClass(
                Person.class.getClassLoader(), new Class<?>[] {Person.class});
        try{
            /**
             * 代理对象持有一个InvocationHandler对象，InvocationHandler对象持有一个被代理的对象
             */
            Constructor<?> constructor = studentClassProxy.getConstructor(InvocationHandler.class);
            // 学生的代理，即班长(动态生成的),动态创建的
            Person studentProxy_monitor = (Person) constructor.newInstance(invocationHandler);

            Class clazz1 = studentProxy_monitor.getClass();
//            Class clazz2 = studentProxy_monitor.getClass().get

            // 班长代理名叫david的人去交钱
            String money = studentProxy_monitor.getMoney("理想", 34);
        }catch (Exception ex){
        }


    }

}
