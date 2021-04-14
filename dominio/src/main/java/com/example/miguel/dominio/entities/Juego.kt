package com.example.miguel.dominio.entities

import android.os.Parcel
import android.os.Parcelable

class Juego(
        val id: Int,
        val nombre: String,
        val descripcion: String
) : Parcelable {

        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString() ?: "",
                parcel.readString() ?: ""
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeInt(id)
                parcel.writeString(nombre)
                parcel.writeString(descripcion)
        }

        override fun describeContents(): Int = 0

        companion object CREATOR : Parcelable.Creator<Juego> {
                override fun createFromParcel(parcel: Parcel): Juego = Juego(parcel)

                override fun newArray(size: Int): Array<Juego?> = arrayOfNulls(size)
        }
}