package com.task.moallem.repo.video;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.task.moallem.R;
import com.task.moallem.model.Subject;
import com.task.moallem.model.Video;

import java.util.ArrayList;
import java.util.Arrays;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

@Database(entities = {Video.class} , version = 1,exportSchema = false)
public abstract class VideoDB extends RoomDatabase {
    private static VideoDB instance;
    public abstract VideoDao videoDao();

    public static synchronized VideoDB getInstance(Context context){
        if (instance == null){
            instance= Room.databaseBuilder(context.getApplicationContext(), VideoDB.class,"videos_db")
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
                instance.videoDao().insertAllVideos(new ArrayList<>(Arrays.asList(new Video(R.raw.video, R.drawable.video_thumb),
                        new Video(R.raw.video,R.drawable.video_thumb),
                        new Video(R.raw.video,R.drawable.video_thumb),
                        new Video(R.raw.video,R.drawable.video_thumb))));
                return "done";
            }).subscribeOn(Schedulers.io())
                    .subscribe();
        }
    };
}
