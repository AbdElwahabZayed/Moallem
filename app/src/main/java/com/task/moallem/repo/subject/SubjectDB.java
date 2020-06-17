package com.task.moallem.repo.subject;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.task.moallem.R;
import com.task.moallem.model.Subject;

import java.util.ArrayList;
import java.util.Arrays;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

@Database(entities = {Subject.class} , version = 1,exportSchema = false)
public abstract class SubjectDB extends RoomDatabase {
    private static SubjectDB instance;
    public abstract SubjectDao subjectDao();

    public static synchronized SubjectDB getInstance(Context context){
        if (instance == null){
            instance= Room.databaseBuilder(context.getApplicationContext(),SubjectDB.class,"subjects_db")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback callback=new Callback() {
        @SuppressLint("CheckResult")
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Observable.fromCallable(() -> {
                instance.subjectDao().insertAllSubject(new ArrayList<>(Arrays.asList(new Subject("Physics", R.drawable.ic_physics),
                                                                                     new Subject("Biology",R.drawable.ic_biology),
                                                                                     new Subject("History",R.drawable.ic_history),
                                                                                     new Subject("Algebra",R.drawable.ic_algebra))));
                return "done";
            }).subscribeOn(Schedulers.io())
                    .subscribe();
        }
    };
}
