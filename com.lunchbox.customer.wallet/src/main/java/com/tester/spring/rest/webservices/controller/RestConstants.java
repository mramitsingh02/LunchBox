package com.tester.spring.rest.webservices.controller;

public interface RestConstants {
    String WALLET_DETAILS_FILTER = "WalletDetailsFilter";
    String[] WALLET_FIELDS = {"walletNumber", "bankAccountNumber", "msisdn", "amount", "walletSpecId", "createUpdateDateTime", "createdTime", "statuses"};

    String ACCOUNT_DETAILS_FILTER = "AccountDetailsFilter";

    String MERCHANT_DETAILS_FILTER = "MerchantDetailsFilter";
    String[] MERCHANT_FIELDS = {
            "merchantId",
            "pin",
            "msisdn",
            "dateOfJoin",
            "emailId",
            "alternateEmailId",
            "hasWallet",
            "hasBank", "walletSpecId", "createUpdateDateTime", "createdTime", "statuses"};


}
