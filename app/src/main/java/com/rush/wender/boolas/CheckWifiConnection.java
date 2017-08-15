package com.rush.wender.boolas;

import android.content.Context;
import android.net.wifi.WifiManager;

/**
 * Created by Fitri San on 8/15/2017.
 */

public class CheckWifiConnection {

    CheckWifiConnection() {
    }

    public boolean isWifi(Context context) {
        try {
            WifiManager wifi = (WifiManager)

                    context.getSystemService(Context.WIFI_SERVICE);
            if (wifi.isWifiEnabled()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
}
