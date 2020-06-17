package com.task.moallem.repo.video;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.task.moallem.model.Subject;
import com.task.moallem.model.Video;

import java.util.List;

@Dao
public interface VideoDao {

    @Insert
    void insertAllVideos(List<Video> videos);

    @Query("SELECT * FROM Video")
    LiveData<List<Video>> getAllVideos();
}
