package com.ingdirect.customerprofiler.dao;

import com.ingdirect.customerprofiler.dto.FileData;
import com.ingdirect.customerprofiler.util.Util;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class FileDataAccessImpl implements DataAccess{

    @Override
    public List<FileData> loadData() {
        return processInputFile("data/data.txt");
    }

    private List<FileData> processInputFile(String inputFilePath) {

        List<FileData> inputList = new ArrayList<>();
        try{
            File inputF = new File(inputFilePath);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            // skip the header of the csv
            inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputList ;
    }

    private Function<String, FileData> mapToItem = (line) -> {
        String[] p = line.split(",");
        FileData item = null;
        try{

            item = new FileData(Long.parseLong(p[0]), Util.parseDate(p[1]), new BigDecimal(p[2]),  p[3]);

        }catch (ArrayIndexOutOfBoundsException a){
            System.out.println("error in line:" + line);
        }

        return item;
    };


}
