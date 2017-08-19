package com.hy.ly.po;

@SuppressWarnings("rawtypes")
public class Music implements Comparable{
	private String name;
	private int time;
	private String singer;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public Music(String name, int time, String singer) {
		super();
		this.name = name;
		this.time = time;
		this.singer = singer;
	}

	public Music() {
		super();
	}

	@Override
	public String toString() {
		return "Music [name=" + name + ", time=" + time + ", singer=" + singer + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + (name == null ? 0 : name.hashCode());
		result = result * prime + time;
		result = result * prime + (singer == null ? 0 : singer.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		// 如果为同一对象的不同引用，返回true
		if (this == obj) {
			return true;
		}
		// 如果对象为空，返回false
		if (obj == null) {
			return false;
		}
		// 如果对象类型不一致则返回false
		if (this.getClass() != obj.getClass()) {
			return false;
		}

		// 类型相同，比较内容是否相同
		Music m = (Music) obj;
		return this.name.equals(m.name) && this.time == m.time && this.singer.equals(m.singer);
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Music){
			Music m=(Music)o;
			int n=this.name.compareTo(m.name);
			System.out.println("============"+n);
			if(n==0){
				int k=this.time-m.time;
				if(k==0){
					return this.singer.compareTo(m.singer);
				}else{
					return k;
				}
			}else{
				return n;
			}
		}
		return 0;
	}
}
