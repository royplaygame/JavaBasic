package com.hy.ly.generic;

import java.util.List;

public class TestCustomerDao {

	public static void main(String[] args) {
		// 测试CustomerDao
		CustomerDao dao = new CustomerDao();
		Customer cust = new Customer();
		dao.add(cust);
		dao.update(cust);
		dao.delete(cust);
		Customer c = dao.get();
		System.out.println(c);
		List<Customer> list = dao.getList();
		System.out.println(list);

		// 测试StudentDao
		System.out.println();
		StudentDao dao1 = new StudentDao();
		Student stu = new Student();
		dao1.add(stu);
		dao1.delete(stu);
		dao1.get();
		dao1.update(stu);
		dao1.getList();

	}
}
