package com.xapo.githubrepos.view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xapo.githubrepos.R;
import com.xapo.githubrepos.lifecycle.SomeObserver;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_repolist);

        if (savedInstanceState == null) {
            RepolistFragment fragment = new RepolistFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
        getLifecycle().addObserver(new SomeObserver());
    }
}
