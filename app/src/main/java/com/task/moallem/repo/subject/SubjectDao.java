package com.task.moallem.repo.subject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.task.moallem.model.Subject;

import java.util.List;

@Dao
public interface SubjectDao {
    @Insert
    void insertAllSubject(List<Subject> subject);

    @Query("SELECT * FROM Subject")
    LiveData<List<Subject>> getAllSubjects();
}
