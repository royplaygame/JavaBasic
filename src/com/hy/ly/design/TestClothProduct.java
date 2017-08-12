package com.hy.ly.design;
//静态代理模式

//接口
interface ClothFactory {
	void productCloth();
}

// 被代理类
class NikeClothFactory implements ClothFactory {

	@Override
	public void productCloth() {
		System.out.println("Nike生产一批衣服！");
	}

}

// 代理类
class ProxyFactory implements ClothFactory {
	ClothFactory cf;
	//创建代理类时，实际传入一个被代理的类的对象
	public ProxyFactory(ClothFactory cf) {
		this.cf = cf;
	}

	@Override
	public void productCloth() {
		System.out.println("代理开始执行，开始收代理费￥1000！");
		cf.productCloth();
	}

}

public class TestClothProduct {

	public static void main(String[] args) {
		NikeClothFactory nf=new NikeClothFactory();
		ProxyFactory pf=new ProxyFactory(nf);
		pf.productCloth();
	}
}
