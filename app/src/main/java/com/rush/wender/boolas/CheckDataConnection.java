package com.rush.wender.boolas;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Fitri San on 8/15/2017.
 */

public class CheckDataConnection {
    CheckDataConnection(){}

    public  boolean isOline(Context context){
        try{
            ConnectivityManager cm=(ConnectivityManager)

                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if(cm==null)
                return false;
            NetworkInfo info=cm.getActiveNetworkInfo();
            if(info==null)
                return false;
            return info.isConnectedOrConnecting();
        }
        catch(Exception e){
            e.getMessage();
            return false;
        }
    }
}
