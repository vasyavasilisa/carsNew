package framework.services;

import java.io.*;
import java.util.List;
import java.util.Properties;


public class CommonFunctions {


    public Properties readProperties(String path) {
        File ff = new File(getClass().getClassLoader().getResource(path).getFile());
        FileInputStream fis = null;
        Properties property = new Properties();
        try {
            fis = new FileInputStream(ff);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return property;
    }


    public static int generateRandDigit(int size) {
        return (int)(2 + (Math.random() * (size - 2)));
    }

    public int getIndMaxDiscount(List<Integer> discounts) {
        int max = discounts.get(0);
        int ind = 0;
        int maxInd = 0;
        for (Integer discount : discounts) {
            if (discount > max) {
                max = discount;
                maxInd = ind;
            }
            ind++;
        }

        return maxInd;
    }

    public boolean isFullDownLoad(String filePath, long size) {
        File f = new File(filePath);
        if (f.exists()) {
            return f.length() == size;
        } else {
            return false;
        }
    }

    public static String convertToUTF8(String string) {
        try {
            return new String(string.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ;
        return null;
    }


}
