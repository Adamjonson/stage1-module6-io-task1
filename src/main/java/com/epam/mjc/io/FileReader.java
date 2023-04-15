package com.epam.mjc.io;


import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {
    Logger logger = Logger.getLogger(FileReader.class.getName());


    public Profile getDataFromFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] arrOfStr = null;

        String line = null;
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {

            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            String str = stringBuilder.toString();
            arrOfStr = str.split("\r");
            for (int i = 0; i < arrOfStr.length; i++) {

                String val = arrOfStr[i];
                int spaceIndex = val.indexOf(" ");
                String value = val.substring(spaceIndex + 1, val.length());
                arrOfStr[i] = value;

            }
            return new Profile(arrOfStr[0], Integer.parseInt(arrOfStr[1]), arrOfStr[2], Long.parseLong(arrOfStr[3]));

        } catch (IOException e){
            logger.log(Level.INFO, "Error");
        }        return new Profile();
    }

}
