package com.baileytye.navcomponentdemo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User(val id: Int = 0, val firstName: String, val lastName: String) : Parcelable{
    override fun toString(): String {
        return "$firstName $lastName"
    }
}