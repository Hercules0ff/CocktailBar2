package com.example.cocktailbar2.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Cocktails")
class Cocktails(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "cocktailName")
    var cocktailName: String,

    @ColumnInfo(name = "cocktailDescription")
    var cocktailDescription: String? = null,

    @ColumnInfo(name = "cocktailReceipt")
    var cocktailReceipt: String? = null,

    @ColumnInfo(name = "cocktailImage")
    var cocktailImage: ByteArray? = null
): Serializable