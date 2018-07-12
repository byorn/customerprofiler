package com.ingdirect.customerprofiler.dao;

import com.ingdirect.customerprofiler.dto.FileData;

import java.util.List;

public interface DataAccess {
    List<FileData> loadData();
}
