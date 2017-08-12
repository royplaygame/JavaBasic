package com.hy.ly.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理

interface Subject {
	void action();
}

// 被代理类
class RealSubject implements Subject {

	@Override
	public void action() {
		System.out.println("我是一个被代理的类哟！记得要执行我哟！么么~~!");
	}

}

class MyInvoacationHandler implements InvocationHandler {
	// 实现了接口的被代理类的对象的声明
	Object obj;

	// 1.给被代理类实例化 2.返回一个代理类的对象
	public Object blind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}

	// 当通过代理类对象发起对被重写的方法调用时，都会转化对如下invoke方法的调用
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnVal = method.invoke(obj, args);
		return returnVal;
	}

}

// 代理类

public class TestDynamicProxy {
	public static void main(String[] args) {
		// 1.被代理类的对象
		RealSubject real = new RealSubject();
		// 2.创建一个实现InvocationHandler接口的类
		MyInvoacationHandler handler = new MyInvoacationHandler();
		// 3.调用blind(real),动态的返回一个实现了real类的接口Subject的代理类对象
		Object obj = handler.blind(real);

		Subject sub = (Subject) obj;// 此时的sub就是代理类的对象
		sub.action();

		// 例子二
		NikeClothFactory nf = new NikeClothFactory();
		ClothFactory cf = (ClothFactory) handler.blind(nf);
		cf.productCloth();

	}
}
