package com.fcore.base.annation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MyAnnotation {
	/** 
     * 字段注解定义 
     * @author Owner 
     * 
     */  
    @Retention(RetentionPolicy.RUNTIME)     
    @Target(ElementType.FIELD)   
    public @interface UserFieldAnnotation {  
    	String description();
    }  
}
