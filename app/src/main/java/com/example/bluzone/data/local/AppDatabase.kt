package com.example.bluzone.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.bluzone.data.local.dao.ProductDao
import com.example.bluzone.data.local.entity.Product

@Database(entities = [Product::class] , version = 2 , exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getProductDao(): ProductDao
}