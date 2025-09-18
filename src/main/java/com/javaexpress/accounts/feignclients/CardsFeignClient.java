package com.javaexpress.accounts.feignclients;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaexpress.accounts.dto.CardsDto;

@FeignClient(name="CARDS") // http://localhost:9004
@LoadBalancerClient("CARDS") //
public interface CardsFeignClient {

    @GetMapping(value="/api/fetch",produces = "application/json")
    public CardsDto fetchCardDetails(@RequestParam String mobileNumber);
    // http://localhost:9004/fetch
}
