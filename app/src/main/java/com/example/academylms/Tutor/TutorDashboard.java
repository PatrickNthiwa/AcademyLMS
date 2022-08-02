package com.example.academylms.Tutor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.academylms.CourseListAdapter;
import com.example.academylms.ModelCourse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import com.example.academylms.R;

public class TutorDashboard extends AppCompatActivity {
    FloatingActionButton addVideoBtn;

    private ArrayList<ModelCourse> videoArrayList;
    private CourseListAdapter adapterVideo;
    private RecyclerView videosRv;

    String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_dashboard);

        addVideoBtn = findViewById(R.id.addVideoBtn);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        addVideoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TutorDashboard.this, AddCourse.class).putExtra("username", username));
            }
        });

        videosRv = findViewById(R.id.courseRv);

        loadCourseList();
    }

    private void loadCourseList() {
        videoArrayList = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(AddCourse.COURSES).child(username);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    ModelCourse modelVideo = ds.getValue(ModelCourse.class);
                    videoArrayList.add(modelVideo);
                }
                adapterVideo = new CourseListAdapter(TutorDashboard.this, videoArrayList);
                videosRv.setAdapter(adapterVideo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}