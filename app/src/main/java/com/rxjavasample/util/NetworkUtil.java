package com.rxjavasample.util;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.rxjavasample.constants.NetworkConstants;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public final class NetworkUtil {
    public static boolean hasNetwork(final Context context) {
        // check if connected to WiFi/data
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    /**
     * returns true if exception was caused by device not able to connect to internet
     * */
    public static boolean isConnectionError(Throwable throwable) {
        return throwable instanceof UnknownHostException ||
                throwable instanceof SocketTimeoutException;
    }

    /**
     * returns error code if throwable is instance of HttpException else returns NetworkConstants.NOT_HTTPEXCEPTION
     * */
    public static int getHttpExceptionErrorCode(Throwable throwable) {
        return throwable instanceof HttpException ? ((HttpException) throwable).code() :
                NetworkConstants.NOT_HTTPEXCEPTION;
    }
}