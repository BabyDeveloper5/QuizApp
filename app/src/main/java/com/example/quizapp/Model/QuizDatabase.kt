package com.example.quizapp.Model

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters



@Database(entities = [QuestionEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class QuizDatabase: RoomDatabase() {
    abstract fun questionDao(): QuestionDao

}

