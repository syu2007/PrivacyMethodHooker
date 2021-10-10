package com.lanshifu.privacymethodhooker

import android.content.ContentResolver
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.lanshifu.privacymethodhooker.testcase.*
import com.lanshifu.privacymethodhooker.utils.PrivacyUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        cbAgree.setOnCheckedChangeListener { compoundButton, b ->
            PrivacyUtil.isAgreePrivacy = b
            updateData()
        }

        updateData()

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun updateData() {
        val getRunningAppProcesses = getRunningAppProcesses(this)
        btnGetRunningAppProcesses.text =
            "getRunningAppProcesses size=${getRunningAppProcesses?.size}"

        val getRecentTasks = getRecentTasks(this)
        btnGetRecentTasks.text = ("getRecentTasks size=${getRecentTasks?.size}")

        val getRunningTasks = getRunningTasks(this)
        btnGetRunningTasks.text = ("getRunningTasks size=${getRunningTasks?.size}")

        val getAllCellInfo = getAllCellInfo(this)
        btnGetAllCellInfo.text = ("getAllCellInfo size=${getAllCellInfo?.size}")

        val getDeviceId = getDeviceId(this)
        btnGetDeviceId.text = ("getDeviceId=$getDeviceId")

        val androidId = Settings.System.getString(this.contentResolver, Settings.Secure.ANDROID_ID)
        btnGetIdAndroid.text = ("androidId=$androidId")

        getSSID.text = ("getSSID=${getSSID(this)}")
        getBSSID.text = ("getBSSID=${getBSSID(this)}")
        getMacAddress.text = ("getMacAddress=${getMacAddress(this)}")

        getSensorList.text = ("getSensorList size=${getSensorList(this)?.size}")
        getImei.text = ("getImei=${getImei(this)}")
    }


    private fun print(text: String) {
        tvResult.text = text
    }
}