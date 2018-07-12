package com.ingdirect.customerprofiler.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FileData {

    private final Long customerId;
    private final LocalDateTime date;
    private final BigDecimal amount;
    private final String description;


    public FileData(Long customerId, LocalDateTime date, BigDecimal amount, String description) {
        this.customerId = customerId;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

}
