package com.dbs.web.service;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;


@Service
public class SanctionListService {

	public SanctionListService() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean getNameMatchedInSanctionList(String inputSearch) {
		double count = 0,countBuffer=0,countLine=0;
	    String lineNumber = "";
	    String filePath = "C:\\Users\\Administrator\\Downloads\\SpringShaliniTraining\\SpringShaliniTraining\\PaymentProject\\sdnlist.txt";
	    BufferedReader br;
	    String line = "";

	    try {
	        br = new BufferedReader(new FileReader(filePath));
	        try {
	            while((line = br.readLine()) != null)
	            {
	                countLine++;
	                //System.out.println(line);
	                String[] words = line.split(" ");

	                for (String word : words) {
	                  if (word.equals(inputSearch)) {
	                    count++;
	                    countBuffer++;
	                  }
	                }

	                if(countBuffer > 0)
	                {
	                    countBuffer = 0;
	                    lineNumber += countLine + ",";
	                }

	            }
	            br.close();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    } catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    System.out.print("count"+count);
	    
	    return count>0?true:false;
	}
}