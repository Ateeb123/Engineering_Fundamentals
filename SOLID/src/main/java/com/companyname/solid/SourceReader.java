package com.companyname.solid;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SourceReader {

    private String sourceType;

    public SourceReader(){
    };

    public SourceReader(String sourceType){
        this.sourceType = sourceType;
    }

    public String readLogsFromSource() throws IOException {
        String logs = "";
        if (this.sourceType.equals("textfile")) {
            logs = Files.readString(Path.of("src","main","java","com","companyname","solid","logs.txt"));
        }
        else if (this.sourceType.equals("database")){
            logs = "logs from Database";
        }
        return logs;
    }



}
