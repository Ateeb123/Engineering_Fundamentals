package com.companyname.solid;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class LogSinker {

    private JSONObject jsonLogs;

    public LogSinker() {
    }

    public LogSinker(JSONObject jsonLogs) {
        this.jsonLogs = jsonLogs;
    }

    public void dumpLogsToSink() {
        try (FileWriter file = new FileWriter("logs.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(this.jsonLogs.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
