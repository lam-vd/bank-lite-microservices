package com.banklite.transaction_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banklite.grpc.AccountServiceGrpc;
import com.banklite.grpc.BalanceRequest;
import com.banklite.grpc.BalanceResponse;

import net.devh.boot.grpc.client.inject.GrpcClient;

@RestController
@RequestMapping("/balance")
public class BalanceController {

  @GrpcClient("account-service")
  private AccountServiceGrpc.AccountServiceBlockingStub accountServiceStub;

  @GetMapping("/{accountId}")
  public double getBalance(@PathVariable String accountId) {
    System.out.println("Received request for accountId: " + accountId);
    BalanceRequest request = BalanceRequest.newBuilder()
        .setAccountId(accountId)
        .build();
    BalanceResponse response = accountServiceStub.getBalance(request);
    return response.getBalance();
  }
}