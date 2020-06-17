package com.task.moallem.repo.video;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.task.moallem.model.Video;

import java.util.List;

public class VideoRepo {
    private VideoDao videoDao;
    private LiveData<List<Video>> allVideos;

    public VideoRepo(Application application) {
        VideoDB videoDB=VideoDB.getInstance(application);
        videoDao=videoDB.videoDao();
        allVideos=videoDao.getAllVideos();
    }

    public LiveData<List<Video>> getAllVideos() {
        return allVideos;
    }

    public void insertVideos(List<Video> videos) {
        videoDao.insertAllVideos(videos);
    }
}
