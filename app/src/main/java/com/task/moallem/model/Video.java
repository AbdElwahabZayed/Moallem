package com.task.moallem.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Video implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int videoId;
    @ColumnInfo
    private int subjectId;
    @ColumnInfo
    private int image;
    @ColumnInfo
    private int video;

    public Video( int video ,int image) {
        this.image = image;
        this.video = video;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }

    protected Video(Parcel in) {
        videoId = in.readInt();
        subjectId = in.readInt();
        image = in.readInt();
        video = in.readInt();
    }

    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(videoId);
        dest.writeInt(subjectId);
        dest.writeInt(image);
        dest.writeInt(video);
    }
}
