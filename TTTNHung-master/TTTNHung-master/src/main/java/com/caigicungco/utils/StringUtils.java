package com.caigicungco.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtils {
    public static String removeAccent(String s) {

        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

    public static String decodeURI(String name){
        String rs = StringUtils.removeAccent(name);
        rs = rs.toLowerCase();
        rs = rs.replaceAll(" ","-");
        return rs;
    }
    public static String removeTypeFile(String name){
        return name.substring(0,name.lastIndexOf("."));
    }


    public int length(String str){

        return str.length();
    }
}
