package com.companyname.solid;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SourceReader {

    public String logs="";
    public JSONObject jsonLogs;

    public SourceReader(){
    };

    public String readLogsFromSource(String sourceType) throws IOException {
        if (sourceType.equals("textfile")) {
            this.logs = Files.readString(Path.of("src","main","java","com","companyname","solid","logs.txt"));
        }
        else if (sourceType.equals("database")){
            this.logs = "logs from Database";
        }
        return this.logs;
    }

    public JSONObject convertToJson() throws ParseException {

        JSONObject jsonLogs = new JSONObject();
        String[] allLogs = this.logs.split("\n");

        for (String eachRequest: allLogs) {
            JSONObject eachRequestJsonLog = new JSONObject();
            String[] requestParts = eachRequest.split(" ");

            eachRequestJsonLog.put("IP", requestParts[1]);
            eachRequestJsonLog.put("Type", requestParts[2]);
            eachRequestJsonLog.put("Endpoint", requestParts[3]);
            jsonLogs.put(requestParts[0], eachRequestJsonLog);
        };
        this.jsonLogs = jsonLogs;
        return jsonLogs;
    };

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
