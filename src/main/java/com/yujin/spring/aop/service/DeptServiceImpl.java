package com.yujin.spring.aop.service;

public class DeptServiceImpl implements DeptService {

	public DeptServiceImpl() {
		System.out.println("DeptServiceImpl Constructor");
	}
	
	@Override
	public void save() {
		System.out.println("保存部门操作");
	}

	@Override
	public void udpate() {
		System.out.println("更新部门操作");
	}

	@Override
	public void delete() {
		System.out.println("删除部门操作");
	}

}
