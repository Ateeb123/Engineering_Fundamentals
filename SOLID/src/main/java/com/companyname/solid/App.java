package com.companyname.solid;

import com.companyname.solid.interfaces.SourceReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws Exception {

        SourceReader sourceReader = new FileLogReader();
        String logsRead = sourceReader.readLogsFromSource();

        JsonConverter jsonConverter = new JsonConverter(logsRead);
        JSONObject jsonedLogs = jsonConverter.convertToJson();

        new LogSinker(jsonedLogs).dumpLogsToSink();

    }
}
