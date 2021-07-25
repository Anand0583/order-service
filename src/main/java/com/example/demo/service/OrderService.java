package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.vo.Customer;
import com.example.demo.vo.Order;

@Component
public class OrderService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${customer.server.url}")
	String customerServiceURL;
	
	public Order getOrderDetails(String orderId) {
		Order order = new Order();
		order.setOrderId(orderId);
		
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("customerId", orderId);
		
		HttpHeaders headers = initializehttpHeaders();
		HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers, headers);
		Customer customer = restTemplate.getForObject(customerServiceURL,Customer.class,vars);
		order.setCustomerName(customer.getCustomerName());
		return order;
	}
	
	
	/**
	 * initializehttpHeaders
	 */
	protected HttpHeaders initializehttpHeaders()  {
		HttpHeaders headers = new HttpHeaders();
		return headers;
	}

}
