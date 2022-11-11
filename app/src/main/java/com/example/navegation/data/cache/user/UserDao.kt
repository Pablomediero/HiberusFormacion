package com.example.navegation.data.cache.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface UserDao {
    /********************************************* User */
    @Insert
    suspend fun insertUser(cachedUser: CachedUser)

    @Query("Select * from user")
    suspend fun getAllUser(): List<CachedUser>

    @Update
    suspend fun updateUser(cachedUser: CachedUser)

    @Delete
    suspend fun deleteUser(cachedUser: CachedUser)

    /********************************************* Address*/
    @Insert
    suspend fun insertAddress(cachedAddress: CachedAddress)

    @Query("Select * from address")
    suspend fun getAllAddress(): List<CachedAddress>

    @Query("Select * from address WHERE idUser = :idUser")
    suspend fun getAddress(idUser: Long): CachedAddress

    /********************************************* Geo*/
    @Insert
    suspend fun insertGeo(geo: CachedGeo)

    @Query("Select * from geo")
    suspend fun getAllGeo(): List<CachedGeo>

    @Query("Select * from geo WHERE idUser = :idUser")
    suspend fun getGeo(idUser: Long): CachedGeo



    /********************************************* Company*/
    @Insert
    suspend fun insertCompany(company: CachedCompany)

    @Query("Select * from company")
    suspend fun getAllCompany(): List<CachedCompany>

    @Query("Select * from company WHERE idUser = :idUser")
    suspend fun getCompany(idUser: Long): CachedCompany
}