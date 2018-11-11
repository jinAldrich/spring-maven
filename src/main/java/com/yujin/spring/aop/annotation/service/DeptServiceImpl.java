package com.yujin.spring.aop.annotation.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("deptService")
@Scope("prototype")
public class DeptServiceImpl implements DeptService {

	public DeptServiceImpl() {
		System.out.println("DeptServiceImpl Constructor");
	}
	
	@Override
	public void save() {
		System.out.println("保存部门操作");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		System.out.println("更新部门操作");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		System.out.println("删除部门操作");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Exception nullPoint = new NullPointerException();
		nullPoint.printStackTrace();
		
	}

}
