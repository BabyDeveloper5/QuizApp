package com.example.quizapp.Model

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    private var instance: QuizDatabase? = null

    fun getDatabase(context: Context): QuizDatabase{
        if (instance == null){
            instance = Room.databaseBuilder(
                context.applicationContext,
                QuizDatabase::class.java,
                "quiz_db"
            ).build()
        }
        return instance!!
    }
}