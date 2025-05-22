package com.example.bluzone.di

import android.content.Context
import androidx.room.Room
import com.example.bluzone.R
import com.example.bluzone.data.local.AppDatabase
import com.example.bluzone.data.local.dao.ProductDao
import com.example.bluzone.data.local.entity.Product
import com.example.bluzone.data.local.respository.ProductRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context = context,
            name = "products_database",
            klass = AppDatabase::class.java
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesProductsDao(appDatabase: AppDatabase): ProductDao = appDatabase.getProductDao()

     @Provides
     @Singleton
     fun providesProductRepository(productDao: ProductDao): ProductRepository = ProductRepository(productDao)

    @Provides
    @Singleton
    fun provideDummyProducts(): List<Product> {
        return listOf(
            Product(
                id = "1",
                name = "جاكيت رجالي بقلنسوة وبطانة" +
                        "فليس دافئة للشتاء ",
                price = 28.00,
                description = "جاكيت شتوي أنيق للرجال بغطاء قابل للفصل - دافئ، عملي ومتعدد الاستخدامات للأعمال أو الأنشطة الخارجية\n" +
                        "المادة: ألياف البوليستر (البوليستر)\n" +
                        "المكونات: 100% ألياف البوليستر (البوليستر)\n" +
                        "الطول: عادي\n" +
                        "طول الكم: كم طويل\n" +
                        "نوع الأكمام: أكمام راجلان",
                beforeDiscount = 28.000,
                discount = 60,
                rating = 3,
                brand = "عتيج",
                sku = "6974321040059",
                photo = R.drawable.product1
            ),
            Product(
                id = "2",
                name = "جاكيت رجالي بقلنسوة وبطانة" +
                        "فليس دافئة للشتاء ",
                price = 28.00,
                description = "جاكيت شتوي أنيق للرجال بغطاء قابل للفصل - دافئ، عملي ومتعدد الاستخدامات للأعمال أو الأنشطة الخارجية\n" +
                        "المادة: ألياف البوليستر (البوليستر)\n" +
                        "المكونات: 100% ألياف البوليستر (البوليستر)\n" +
                        "الطول: عادي\n" +
                        "طول الكم: كم طويل\n" +
                        "نوع الأكمام: أكمام راجلان",
                beforeDiscount = 28.000,
                discount = 60,
                rating = 3,
                brand = "عتيج",
                sku = "6974321040059",
                photo = R.drawable.product2
            ),
            Product(
                id = "3",
                name = "جاكيت نسائي بقلنسوة وبطانة" +
                        "فليس دافئة للشتاء ",
                price = 28.00,
                description = "جاكيت شتوي أنيق للرجال بغطاء قابل للفصل - دافئ، عملي ومتعدد الاستخدامات للأعمال أو الأنشطة الخارجية\n" +
                        "المادة: ألياف البوليستر (البوليستر)\n" +
                        "المكونات: 100% ألياف البوليستر (البوليستر)\n" +
                        "الطول: عادي\n" +
                        "طول الكم: كم طويل\n" +
                        "نوع الأكمام: أكمام راجلان",
                beforeDiscount = 28.000,
                discount = 60,
                rating = 3,
                brand = "عتيج",
                sku = "6974321040059",
                photo = R.drawable.product3
            ),
            Product(
                id = "4",
                name = "جاكيت نسائي بقلنسوة وبطانة" +
                        "فليس دافئة للشتاء ",
                price = 28.00,
                description = "جاكيت شتوي أنيق للرجال بغطاء قابل للفصل - دافئ، عملي ومتعدد الاستخدامات للأعمال أو الأنشطة الخارجية\n" +
                        "المادة: ألياف البوليستر (البوليستر)\n" +
                        "المكونات: 100% ألياف البوليستر (البوليستر)\n" +
                        "الطول: عادي\n" +
                        "طول الكم: كم طويل\n" +
                        "نوع الأكمام: أكمام راجلان",
                beforeDiscount = 28.000,
                discount = 60,
                rating = 3,
                brand = "عتيج",
                sku = "6974321040059",
                photo = R.drawable.product4
            ),
            Product(
                id = "5",
                name = "جاكيت رجالي أنيق بقلنسوة\n" +
                        "مبطن بالفليس",
                price = 25.0,
                description = "جاكيت شتوي أنيق للرجال بغطاء قابل للفصل - دافئ، عملي ومتعدد الاستخدامات للأعمال أو الأنشطة الخارجية\n" +
                        "المادة: ألياف البوليستر (البوليستر)\n" +
                        "المكونات: 100% ألياف البوليستر (البوليستر)\n" +
                        "الطول: عادي\n" +
                        "طول الكم: كم طويل\n" +
                        "نوع الأكمام: أكمام راجلان",
                beforeDiscount = 63.000,
                discount = 60,
                rating = 3,
                brand = "عتيج",
                sku = "6974321040059",
                photo = R.drawable.product_img
            )
        )
    }
}