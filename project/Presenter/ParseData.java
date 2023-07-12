package Presenter;

import java.util.Arrays;

import Exception.DataException;

public class ParseData {
    public static String[] parsUserInfo (String [] data) throws DataException{
        String[] newAnimal = new String[4];
         for (int i = 0; i < data.length; i++) {
            if (data[i].matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
                String [] arrDate = data[i].split("\\.");
                for (int j = 0; j < arrDate.length; j++) {
                    try {
                        newAnimal[j+1] = arrDate[j];
                    } catch (NumberFormatException e) {
                        throw new DataException("Ошибка в дате", 112);
                    }
                }
            } else if (data[i].matches("[A-Za-z]+")) {
                newAnimal[0] = data[i];
            } else throw new DataException("Ошибка в наборе данных", 114);
        }
        return newAnimal;
    }
}
