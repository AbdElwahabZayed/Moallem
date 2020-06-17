package com.task.moallem.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.task.moallem.model.Subject;
import com.task.moallem.model.Video;
import com.task.moallem.repo.subject.SubjectRepo;
import com.task.moallem.repo.video.VideoRepo;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private SubjectRepo subjectRepo;
    private VideoRepo videoRepo;
    private LiveData<List<Subject>> allSubjects;
    private LiveData<List<Video>> allVideos;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        subjectRepo=new SubjectRepo(application);
        videoRepo=new VideoRepo(application);
        allSubjects=subjectRepo.getAllSubjects();
        allVideos=videoRepo.getAllVideos();
    }

    public LiveData<List<Video>> getAllVideos() {
        return allVideos;
    }

    public LiveData<List<Subject>> getAllSubjects() {
        return allSubjects;
    }

    public void insertSubjects(List<Subject> subjectList){
        subjectRepo.insertSubjects(subjectList);
    }

    public void insertVideos(List<Video> videoList){
        videoRepo.insertVideos(videoList);
    }
}
