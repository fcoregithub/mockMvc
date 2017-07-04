package com.fcore.base.bean;

import java.lang.reflect.Field;

import com.fcore.base.annation.MyAnnotation.UserFieldAnnotation;

public class User {
	@UserFieldAnnotation(description="用户姓名")
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public static void main(String[] args) throws Exception, SecurityException {
		User user = new User();
		user.setName("张三");
		Class clazz = user.getClass();
		
		Field field = clazz.getDeclaredField("name");
        UserFieldAnnotation myFieldAnnotation = field.getAnnotation(UserFieldAnnotation.class);
        System.out.println(myFieldAnnotation.description()+":"+user.getName());
	}*/
}

