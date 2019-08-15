package reflect.cglib2;

/**
 * 被代理的类
 */
public class FacadePrincipal {

    public String addbooks(){
        System.out.print("新写了一首诗文");
        return "\"夜来风雨声，花落知多少。\"";
    }
}
