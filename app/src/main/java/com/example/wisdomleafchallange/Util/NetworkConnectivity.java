package com.example.wisdomleafchallange.Util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.wisdomleafchallange.R;


public class NetworkConnectivity {

    private static boolean response = false;

    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }


    public static void showNetworkConnectivityErrorAlert(final Activity activity) {
        UiUtils.showAlertNetwork(activity, activity.getResources().getString(R.string.error_alert_heading),activity.getResources().getString(R.string.error_network_unavailable));
    }
}
