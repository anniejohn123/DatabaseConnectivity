package com.example.quoraapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact")
data class  Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val phone : String
)
