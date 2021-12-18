package com.companyname.solid;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class JsonConverter {

    private String logs;

    public JsonConverter(){

    }

    public JsonConverter(String logs){
        this.logs = logs;
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
        return jsonLogs;
    };

}
