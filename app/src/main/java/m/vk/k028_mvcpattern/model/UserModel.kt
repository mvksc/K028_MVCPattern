package m.vk.k028_mvcpattern.model

import android.os.Parcel
import android.os.Parcelable

class UserModel(var username: String?, var password: String?): Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    fun checkUserValidity(username: String?, password: String?): Boolean {
        return !(username?.trim().equals("") || password?.trim().equals(""))
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserModel> {
        override fun createFromParcel(parcel: Parcel): UserModel {
            return UserModel(parcel)
        }

        override fun newArray(size: Int): Array<UserModel?> {
            return arrayOfNulls(size)
        }
    }
}