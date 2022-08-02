package com.example.academylms.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.academylms.ModelCourse;
import com.example.academylms.CourseListAdapter;
import com.example.academylms.R;
import  com.example.academylms.Tutor.AddCourse;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DashBoard extends AppCompatActivity {

    private ArrayList<ModelCourse> videoArrayList;
    private CourseListAdapter adapterVideo;
    private RecyclerView videosRv;

    String category = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        videosRv = findViewById(R.id.courseRv);

        Intent intent = getIntent();
        category = intent.getStringExtra(RealDashboard.CATEGORY);

        loadCourseList();

    }

    private void loadCourseList() {
        videoArrayList = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(AddCourse.COURSES);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    for (DataSnapshot dataSnapshot : ds.getChildren()) {
                        ModelCourse modelVideo = dataSnapshot.getValue(ModelCourse.class);
                        if (modelVideo.getCategory().equals(category)) {
                            videoArrayList.add(modelVideo);
                        }
                    }
                }
                adapterVideo = new CourseListAdapter(DashBoard.this, videoArrayList);
                videosRv.setAdapter(adapterVideo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}