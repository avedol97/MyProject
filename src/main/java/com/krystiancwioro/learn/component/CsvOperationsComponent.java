package com.krystiancwioro.learn.component;

import com.krystiancwioro.learn.dto.UserDto;

import java.util.ArrayList;

public interface CsvOperationsComponent {

    String PATH = "src/main/resources/learn.csv";

    ArrayList<String> readCsvFile();
}
