package com.example.wisdomleafchallange.Util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.example.wisdomleafchallange.R;

public class UiUtils {

    public static void showAlertNetwork(final Activity activity, final String displayHeader, final String displayBody) {

        try {
            if (!activity.isFinishing()) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AlertDialog.Builder alertDialogBuilder = null;
                        if (alertDialogBuilder == null) {
                            alertDialogBuilder = new AlertDialog.Builder(activity);
                        }
                        // set title
                        alertDialogBuilder.setTitle(displayHeader);

                        // set dialog message
                        alertDialogBuilder
                                .setMessage(displayBody)
                                .setCancelable(false)
                                .setPositiveButton(activity.getString(R.string.ok),
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });
                        // create alert dialog
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        // show it
                        if (!(activity).isFinishing() && !alertDialog.isShowing()) {
                            alertDialog.show();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void showAlert(final Activity activity, final String displayHeader, final String displayBody) {

        try {
            if (!activity.isFinishing()) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
                        // set title
                        alertDialogBuilder.setTitle(displayHeader);

                        // set dialog message
                        alertDialogBuilder
                                .setMessage(displayBody)
                                .setCancelable(false)
                                .setPositiveButton(activity.getString(R.string.ok),
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });
                        // create alert dialog
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        // show it
                        if (!(activity).isFinishing() && !alertDialog.isShowing()) {
                            alertDialog.show();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
