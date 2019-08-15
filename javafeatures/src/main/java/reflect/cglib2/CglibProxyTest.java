package reflect.cglib2;

public class CglibProxyTest {

    public static void main(String[] args) {
        new CglibProxyTest().doTest();
    }

    public void doTest(){

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        FacadePrincipal Impl = new FacadePrincipal();

        // 代理对象
        FacadeCglibProxy cglibProxy = new FacadeCglibProxy();
        FacadePrincipal proxy = (FacadePrincipal) cglibProxy.getInstance(Impl);
        String xx =  proxy.addbooks();

        System.out.print("");

    }

}
