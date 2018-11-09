package com.yujin.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PersonDAOImpl implements PersonDAO {
	private String url;
	private int size;
	private Set<String> sets = new HashSet();
	private List<String> lists = new ArrayList();
	private Map maps = new HashMap();
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("PersonDAOImpl保存Person信息");
		System.out.println("url:" + url);
		System.out.println("size:" + size);
		System.out.println("---set集合内容---");
		for (String str:sets) {
			System.out.println("--->" + str);
		}
		
		System.out.println("---List集合内容---");
		for (String str:lists) {
			System.out.println("--->" + str);
		}
		
		System.out.println("---Map集合内容---");
		Iterator iterator = maps.keySet().iterator();
		while(iterator.hasNext()) {
			String key = (String)iterator.next();
			System.out.println(key + ":" + maps.get(key));
		} 
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public void setSets(Set sets) {
		this.sets = sets;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	public void setMaps(Map maps) {
		this.maps = maps;
	}

	
}
