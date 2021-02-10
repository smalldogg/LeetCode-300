package 哈希表和堆;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangyh
 * @create 2020-03-08 11:22
 */
interface IPeople {

    public void fun();

    public void func();
}


class People implements IPeople {

    @Override
    public void fun() {
        System.out.println("这是fun方法");

    }

    @Override
    public void func() {
        System.out.println("这是func方法");

    }

}


class MyHandle implements InvocationHandler {

    Object object = null;

    public MyHandle(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("111");
        Object result = method.invoke(object, args);

        return result;
    }
}


public class DynamicProxy {
    public static void main(String[] args) {
        IPeople people = new People();
        ClassLoader classLoader = people.getClass().getClassLoader();
        InvocationHandler handler = new MyHandle(people);
        IPeople people1 = (IPeople) Proxy.newProxyInstance(classLoader, people.getClass().getInterfaces(), handler);
        people1.func();
    }
}
