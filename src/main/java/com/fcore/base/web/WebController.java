package com.fcore.base.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fcore.base.util.MapResult;
import com.fcore.base.util.MapResult.Invoker;

@RestController
@RequestMapping("/rest")
public class WebController {
	
	private static List<String> list = new ArrayList<String>();
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String, Object> add(final String str){
		return MapResult.invoke(new Invoker() {
			@Override
			public void writeBody(Map<String, Object> body) throws Exception {
				list.add(str);
				body.put("str", list.get(list.size()-1));
			}
		});
	}
}
