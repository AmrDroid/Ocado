package com.amrmustafa.ocado.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import com.amrmustafa.ocado.presentation.utils.NetworkUtil

internal open class BaseActivity : AppCompatActivity() {

    //Observe Network Change
    protected fun onNetworkChange(block: (Boolean) -> Unit) {
        NetworkUtil.getNetworkStatus(this)
            .observe(this) { isConnected ->
                block(isConnected)
            }
    }
}