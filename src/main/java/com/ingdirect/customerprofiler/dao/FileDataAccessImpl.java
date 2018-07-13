package com.ingdirect.customerprofiler.dao;

import com.ingdirect.customerprofiler.dto.FileData;
import com.ingdirect.customerprofiler.util.Util;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class FileDataAccessImpl implements DataAccess{

    private List<FileData> fileDataList;

    public FileDataAccessImpl(String inputFile){
       this.fileDataList = processInputFile(inputFile);
    }

    @Override
    public List<FileData> loadData() {
        return this.fileDataList;
    }

    @Override
    public List<FileData> getAllTransactions(Long customerId, int month, int year) {
        return this.fileDataList.stream()
                .filter(fileData -> fileData.getCustomerId().equals(customerId))
                .filter(fileData -> fileData.getDate().getMonth().getValue()==month && fileData.getDate().getYear()==year)
                .collect(Collectors.toList());
    }


    @Override
    public long getTransactionCount(Long customerId, int month, int year) {
        return this.fileDataList.stream()
                .filter(fileData -> fileData.getCustomerId().equals(customerId))
                .filter(fileData -> fileData.getDate().getMonth().getValue()==month && fileData.getDate().getYear()==year)
                .count();
    }

    @Override
    public long getTransactionCountHavingExcessWithdrawalOver1000(Long customerId, int month, int year) {
        return this.fileDataList.stream()
                .filter(fileData -> fileData.getCustomerId().equals(customerId))
                .filter(fileData -> fileData.getDate().getMonth().getValue()==month && fileData.getDate().getYear()==year)
                .filter(fileData -> fileData.getAmount().compareTo(BigDecimal.valueOf(-1000))<0)
                .count();
    }

    @Override
    public long getCountofTransactionDoneAfterMidDay(Long customerId, int month, int year) {
        return this.fileDataList.stream()
                .filter(fileData -> fileData.getCustomerId().equals(customerId))
                .filter(fileData -> fileData.getDate().getMonth().getValue()==month &&
                        fileData.getDate().getYear()==year &&
                        fileData.getDate().getHour()>12)
                .count();
    }

    @Override
    public long getCountofTransactionDoneBeforeAndOnMidDay(Long customerId, int month, int year) {
        return this.fileDataList.stream()
                .filter(fileData -> fileData.getCustomerId().equals(customerId))
                .filter(fileData -> fileData.getDate().getMonth().getValue()==month &&
                        fileData.getDate().getYear()==year &&
                        fileData.getDate().getHour()<=12)
                .count();
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
            if(p.length == 4) {
                item = new FileData(Long.parseLong(p[0]), Util.parseDate(p[1]), new BigDecimal(p[2]), p[3]);
            }
        }catch (ArrayIndexOutOfBoundsException a){
            a.printStackTrace();
            System.out.println("error in line:" + line);
        }catch (Exception a){
            a.printStackTrace();
            System.out.println("error in line:" + line);
        }finally{
            if(item == null){
                System.out.println("CSV File format is incorrect, check if have spaces in the end");
                throw new IllegalStateException("CSV File format is incorrect");
            }
        }

        return item;
    };


}
