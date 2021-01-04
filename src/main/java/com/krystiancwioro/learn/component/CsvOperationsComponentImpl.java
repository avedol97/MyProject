package com.krystiancwioro.learn.component;

import com.krystiancwioro.learn.dto.UserDto;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvOperationsComponentImpl implements  CsvOperationsComponent{

    private ArrayList<String> lines;

    public CsvOperationsComponentImpl(){
        lines = new ArrayList<>();
    }

    @Override
    public ArrayList<String> readCsvFile() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(PATH));
            String line;
            reader.readLine();
            while ((line = reader.readLine()) !=null){
                lines.add(line);
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
