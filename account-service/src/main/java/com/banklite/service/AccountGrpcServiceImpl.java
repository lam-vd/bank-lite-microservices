package com.banklite.service;

import org.lognet.springboot.grpc.GRpcService;

import com.banklite.grpc.AccountServiceGrpc;
import com.banklite.grpc.BalanceRequest;
import com.banklite.grpc.BalanceResponse;

import io.grpc.stub.StreamObserver;

@GRpcService
public class AccountGrpcServiceImpl extends AccountServiceGrpc.AccountServiceImplBase {
  @Override
  public void getBalance(BalanceRequest request, StreamObserver<BalanceResponse> responseObserver) {
    String accountId = request.getAccountId();
    double balance = 5000.00;

    BalanceResponse response = BalanceResponse.newBuilder()
        .setBalance(balance)
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
