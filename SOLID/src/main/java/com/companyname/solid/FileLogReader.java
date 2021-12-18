package com.companyname.solid;

import com.companyname.solid.interfaces.SourceReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileLogReader implements SourceReader {

    public FileLogReader(){
    };

    public String readLogsFromSource() throws IOException {
        String logs = Files.readString(Path.of("src","main","java","com","companyname","solid","logs.txt"));
        return logs;
    }
}
