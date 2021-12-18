package com.companyname.solid;

import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException, ParseException {

        SourceReader sourceReader = new SourceReader();
        sourceReader.readLogsFromSource("textfile");
        sourceReader.convertToJson();
        sourceReader.dumpLogsToSink();
    }
}
