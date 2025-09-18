package com.javaexpress.accounts.feignclients;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaexpress.accounts.dto.LoansDto;

@FeignClient(name="LOANS")
@LoadBalancerClient("LOANS")
public interface LoansFeignClient {

    @GetMapping("/api/fetch")
    public LoansDto fetchLoanDetails(@RequestParam String mobileNumber);

}
