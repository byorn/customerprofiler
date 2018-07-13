package com.ingdirect.customerprofiler.service.bl;

public interface Classification {
    String getClassificationDescription();

    boolean isClassified(int month, Long customerId);
}
