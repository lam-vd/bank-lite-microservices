package com.banklite.account_service.service;

import net.devh.boot.grpc.server.service.GrpcService;

import com.banklite.grpc.AccountServiceGrpc;
import com.banklite.grpc.BalanceRequest;
import com.banklite.grpc.BalanceResponse;

import io.grpc.stub.StreamObserver;

@GrpcService
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
