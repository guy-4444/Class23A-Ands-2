package com.guy.class23a_ands_2;

public class Record {

    private String tag;
    private long time;

    public Record(String tag) {
        this.tag = tag;
        time = System.currentTimeMillis();
    }

    public void stop() {
        time = System.currentTimeMillis() - time;
    }

    public String getTag() {
        return tag;
    }

    public long getTime() {
        return time;
    }
}
