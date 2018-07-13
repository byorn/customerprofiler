package com.ingdirect.customerprofiler.service.bl;

public interface Classification {
    String getClassificationDescription();

    boolean isClassified(Long customerId, int month, int year);
}
