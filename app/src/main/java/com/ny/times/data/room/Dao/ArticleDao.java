package com.ny.times.data.room.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ny.times.data.room.entity.ArticleEntity;

import java.util.List;

@Dao
public interface ArticleDao {
    @Query("SELECT * FROM article")
    LiveData<List<ArticleEntity>> getAllLiveData();

    @Query("SELECT * FROM article")
    List<ArticleEntity> getAll();

    @Query("SELECT * FROM article WHERE `id`=:id")
    ArticleEntity getArticleById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inset(List<ArticleEntity> entities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inset(ArticleEntity entity);

}
