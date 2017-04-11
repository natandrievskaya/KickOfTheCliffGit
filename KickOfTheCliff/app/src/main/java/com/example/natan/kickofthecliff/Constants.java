package com.example.natan.kickofthecliff;

public class Constants {

    public static final int TAB_ONE = 0;
    public static final int TAB_TWO = 1;
    public static final int TAB_THREE = 2;

    public  static class URL{
        private  static final String HOST = "http://192.168.0.105:8080";//локалхост это само устройство; написать порт 8080 и хост компа
        public static final String GET_KICK_ITEM = HOST + "/reminders";
    }
}
