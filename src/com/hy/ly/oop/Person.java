package com.hy.ly.oop;

public class Person {

	private byte b;
	private short s;
	private int i;
	private long l;
	private char c;
	private float f;
	private double d;
	private boolean bl;
	private String str;

	public Person(int i){
		this("myStr");  //调用另一个构造器，必须写在首行。否则报错
		this.i=i;
	}
	public Person(String str){
		this.str=str;
	}

	public Person(){
	}


	
	
	public byte getB() {
		return b;
	}
	public void setB(byte b) {
		this.b = b;
	}
	public short getS() {
		return s;
	}
	public void setS(short s) {
		this.s = s;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public long getL() {
		return l;
	}
	public void setL(long l) {
		this.l = l;
	}
	public char getC() {
		return c;
	}
	public void setC(char c) {
		this.c = c;
	}
	public float getF() {
		return f;
	}
	public void setF(float f) {
		this.f = f;
	}
	public double getD() {
		return d;
	}
	public void setD(double d) {
		this.d = d;
	}
	public boolean isBl() {
		return bl;
	}
	public void setBl(boolean bl) {
		this.bl = bl;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	@Override
	public String toString() {
		return "Person [b=" + b + ", s=" + s + ", i=" + i + ", l=" + l + ", c=" + c + ", f=" + f + ", d=" + d + ", bl="
				+ bl + ", str=" + str + "]";
	}
	
	public void showInfo(){
		int i=100;
		System.out.println(i);
		System.out.println(f);
	}
	
	public static void main(String[] args) {
		Person p=new Person();
		System.out.println(p);
		p.showInfo();
	}
}
