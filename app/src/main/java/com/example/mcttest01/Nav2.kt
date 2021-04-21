package com.example.mcttest01

import android.os.Bundle
import androidx.navigation.NavDirections

class Nav2 : NavDirections {
    override fun getActionId(): Int = R.id.action_global_blankFragment3

    override fun getArguments(): Bundle {
        return Bundle()
    }
}