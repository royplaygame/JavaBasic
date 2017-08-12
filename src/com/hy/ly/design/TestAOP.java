package com.hy.ly.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
	void info();

	void fly();
}

// 被代理类
class SuperMan implements Human {

	@Override
	public void info() {
		System.out.println("我超人！我会飞！");
	}

	@Override
	public void fly() {
		System.out.println("I believe I can fly");
	}

}

class MyInvocationHandler implements InvocationHandler {
	Object obj;

	public void setObject(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		HumanUtil hu = new HumanUtil();
		hu.method1();
		Object returnVal = method.invoke(obj, args);
		hu.method2();
		return returnVal;
	}

}

class MyProxy {
	// 动态创建一个代理类的对象
	public static Object getProxyInstance(Object obj) {
		MyInvocationHandler handler = new MyInvocationHandler();
		handler.setObject(obj);
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
	}

}

class HumanUtil {
	public void method1() {
		System.out.println("=======方法一========");
	}

	public void method2() {
		System.out.println("=======方法二========");
	}
}

public class TestAOP {

	public static void main(String[] args) {
		SuperMan sm = new SuperMan();
		Object obj = MyProxy.getProxyInstance(sm);
		Human h = (Human) obj;
		h.info();
		System.out.println();
		h.fly();
	}
}
