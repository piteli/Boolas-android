package com.rush.wender.boolas;

/**
 * Created by naninaliko on 9/1/2017.
 */

public class apiDays {

    String data;

    public final String DATA_URL = "http://192.168.0.105/blast/getICress.php?value="+data;
    public static final String JSON_ARRAY = "hey";
    public static final String API_COURSE = "Course";
    public static final String API_GROUP = "Group";
    public static final String API_START = "Start";
    public static final String API_END = "End";
    public static final String API_DAY = "Day";
    public static final String API_ROOM = "Room";


    apiDays(String data){

        this.data = data;

    }
}


