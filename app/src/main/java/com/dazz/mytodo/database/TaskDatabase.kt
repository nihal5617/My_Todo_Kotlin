package com.dazz.mytodo.database

import android.content.Context
import androidx.room.*
import androidx.room.TypeConverter

@Database(entities = [Task::class],version =1,exportSchema = false)
@TypeConverters(value = [TodoTypeConverter::class])
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao() : TaskDao
    companion object {
        @Volatile
        private var INSTANCE: TaskDatabase? = null

        fun getDatabase(context: Context): TaskDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "task_database2"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }

    }
}