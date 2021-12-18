package com.companyname.solid;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException, ParseException {

        SourceReader sourceReader = new SourceReader("textfile");
        String logsRead = sourceReader.readLogsFromSource();

        JsonConverter jsonConverter = new JsonConverter(logsRead);
        JSONObject jsonedLogs = jsonConverter.convertToJson();

        new LogSinker(jsonedLogs).dumpLogsToSink();

    }
}
