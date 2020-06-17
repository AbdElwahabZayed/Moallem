package com.task.moallem.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.task.moallem.R;
import com.task.moallem.adapter.SubjectAdapter;
import com.task.moallem.adapter.VideoAdapter;
import com.task.moallem.viewmodel.MainActivityViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;

    @BindView(R.id.subjects_recy)
    RecyclerView subjectRecyclerView;

    @BindView(R.id.videos_recy)
    RecyclerView videosRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mainActivityViewModel=new ViewModelProvider(this).get(MainActivityViewModel.class);
        
        observeSubjectRecy();

        observeVideoRecy();
    }

    private void observeVideoRecy() {
        mainActivityViewModel.getAllVideos().observe(this, videos -> {
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            videosRecyclerView.setLayoutManager(layoutManager);
            VideoAdapter videoAdapter =new VideoAdapter(this);
            videoAdapter.setAapterData(videos);
            videosRecyclerView.setAdapter(videoAdapter);
        });
    }

    private void observeSubjectRecy() {
        mainActivityViewModel.getAllSubjects().observe(this, subjectList -> {
            LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            subjectRecyclerView.setLayoutManager(layoutManager);
            SubjectAdapter subjectAdapter =new SubjectAdapter(this);
            subjectAdapter.setAdapterData(subjectList);
            subjectRecyclerView.setAdapter(subjectAdapter);
        });
    }

}
