package com.portaldc.impl.service.message;

import java.io.*;
import java.util.*;

public class MessageServiceImpl {

    private Map<String, String> mapOfLanguages;

    public MessageServiceImpl(List<String> listOfLanguages) throws UnsupportedEncodingException {
        mapOfLanguages = new HashMap<String, String>();

        for (String languageName : listOfLanguages) {
            InputStream inputStream = getClass().getResourceAsStream("/" + languageName);
            InputStreamReader is = new InputStreamReader(inputStream, "UTF8");
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(is);

            try {
                String read = bufferedReader.readLine();

                while (read != null) {
                    stringBuilder.append(read);
                    read = bufferedReader.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            mapOfLanguages.put(languageName, stringBuilder.toString());
        }
    }

    public String getLocalizationMessages(String lang) {


        return mapOfLanguages.get(lang);

    }
}
