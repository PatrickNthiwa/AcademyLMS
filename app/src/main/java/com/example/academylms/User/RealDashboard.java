package com.example.academylms.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.academylms.R;

public class RealDashboard extends AppCompatActivity {

        CardView cv_web, cv_frontend, cv_backend, cv_database, cv_android, cv_machineLearning;
        String[] courses = {"Web", "Frontend", "Backend", "Database", "Android", "Machine Learning"};

        public static final String CATEGORY = "category";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_real_dashboard);

            cv_web = findViewById(R.id.cv_web);
            cv_frontend = findViewById(R.id.cv_frontend);
            cv_backend = findViewById(R.id.cv_backend);
            cv_database = findViewById(R.id.cv_database);
            cv_android = findViewById(R.id.cv_android);
            cv_machineLearning = findViewById(R.id.cv_machineLearning);

            cv_web.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(RealDashboard.this, DashBoard.class).putExtra(CATEGORY, courses[0]));
                }
            });
            cv_frontend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(RealDashboard.this, DashBoard.class).putExtra(CATEGORY, courses[1]));
                }
            });
            cv_backend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(RealDashboard.this, DashBoard.class).putExtra(CATEGORY, courses[2]));
                }
            });
            cv_database.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(RealDashboard.this, DashBoard.class).putExtra(CATEGORY, courses[3]));
                }
            });
            cv_android.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(RealDashboard.this, DashBoard.class).putExtra(CATEGORY, courses[4]));
                }
            });
            cv_machineLearning.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(RealDashboard.this, DashBoard.class).putExtra(CATEGORY, courses[5]));
                }
            });

        }
    }