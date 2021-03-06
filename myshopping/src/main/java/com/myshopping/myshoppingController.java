package com.myshopping;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class myshoppingController {
	@Autowired
private RestTemplate template;
	
	@GetMapping("/myshopping/{price}")
	public String shop(@PathVariable long price)
	{
		String URL="http://Orderservices/order-now"+"/{price}";
		Map<String,String> params=new HashMap<>();
		params.put("price", String.valueOf(price));
		return template.getForObject(URL,String.class,params);
	}
}
