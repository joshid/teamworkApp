package com.teamwork.josehidalgo.ui.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build

/**
 * Created by jnhidalgo on 21/1/18.
 */

class ConnectionDetector(private val mContext: Context) {

    val isConnectingToInternet: Boolean
        get() {

            val connectivityManager = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                val networks = connectivityManager.allNetworks
                var networkInfo: NetworkInfo

                for (mNetwork in networks) {

                    networkInfo = connectivityManager.getNetworkInfo(mNetwork)

                    if (networkInfo.state == NetworkInfo.State.CONNECTED) {
                        return true
                    }
                }

            } else {

                if (connectivityManager != null) {

                    val networksinfo = connectivityManager.allNetworkInfo

                    if (networksinfo != null) {

                        for (aNetworkInfo in networksinfo) {

                            if (aNetworkInfo.state == NetworkInfo.State.CONNECTED) {
                                return true
                            }
                        }
                    }
                }
            }

            return false
        }
}
