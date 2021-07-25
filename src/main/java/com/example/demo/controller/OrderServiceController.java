package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OrderService;
import com.example.demo.vo.Order;

@RestController
@RequestMapping("/order/v1")
@Validated
public class OrderServiceController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrderService orderService;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<Order> getOrderDetail(HttpServletRequest httpRequest,
			@Size(min = 1, max = 80, message = "orderId size must be between 1 and 80") @RequestParam(value = "orderId", required = true) String orderId,
			HttpServletResponse httpResponse) {
		log.info("Entering into OrderController ::: getOrder - start");
		String transactionId = MDC.get("trackingId");
		Order order = orderService.getOrderDetails(orderId);
		log.info("Entering into OrderController ::: getOrder - end");
		return new ResponseEntity<>(order, HttpStatus.OK);

	}
	

}
