package com.ingdirect.customerprofiler.dto;

import java.util.List;

public class CustomerProfileDTO {

    private final String balance;
    private final String classification;
    private List<FileData> transactions;


    public CustomerProfileDTO(String balance, String classification, List<FileData> transactions) {
        this.balance = balance;
        this.classification = classification;
        this.transactions = transactions;
    }

    public String getBalance() {
        return balance;
    }

    public String getClassification() {
        return classification;
    }

    public List<FileData> getTransactions() {
        return transactions;
    }
}
