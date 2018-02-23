package com.geekidea.hystrixSample.hystrixSample;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/rest/")
public class HystricsRestController {

	@HystrixCommand(fallbackMethod="hystricsCircuitBreaker")
	@GetMapping("message")
	public String sampleMessage() throws Exception{
		if(RandomUtils.nextBoolean()){
			throw new Exception();
		}
		return "Sample test message is success....... :)";
	}
	
	public String hystricsCircuitBreaker(){
		return "hystricsCircuitBreaker fallbackMethod called";
	}
}
