package com.task.moallem.repo.subject;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.task.moallem.model.Subject;

import java.util.List;

public class SubjectRepo {
    private SubjectDao subjectDao;
    private LiveData<List<Subject>> allSubjects;

    public SubjectRepo(Application application) {
        SubjectDB subjectDB=SubjectDB.getInstance(application);
        subjectDao=subjectDB.subjectDao();
        allSubjects=subjectDao.getAllSubjects();
    }

    public LiveData<List<Subject>> getAllSubjects() {
        return allSubjects;
    }

    public void insertSubjects(List<Subject> subjectList){
        subjectDao.insertAllSubject(subjectList);
    }

}
