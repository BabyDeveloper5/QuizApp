package com.example.quizapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

@Entity(tableName = "questions")
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

class Converters{
    @TypeConverter
    fun fromStringList(list: List<String>): String{
        return list.joinToString(separator = "||")
    }

    @TypeConverter
    fun toStringList(data: String): List<String>{
        return data.split("||")
    }
}
