package com.softserve.edu.oms.data;

public final class UrlRepository {

    public static enum Urls {
        LOCAL_HOST("http://localhost:8080/OMS/login.htm"),
        SSU_HOST("http://ssu-oms:8180/OMS/login.htm");

        private String field;

        private Urls(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

    private UrlRepository() {
    }

    // public static String getLocalHost() {
    // return "http://localhost:8080/OMS/login.htm";
    // }
    //
    // public static String getSsuHost() {
    // return "http://ssu-oms:8180/OMS/login.htm";
    // }

}
