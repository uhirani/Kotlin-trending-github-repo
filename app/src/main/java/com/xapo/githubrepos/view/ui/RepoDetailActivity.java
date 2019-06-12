package com.xapo.githubrepos.view.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.xapo.githubrepos.R;
import com.xapo.githubrepos.databinding.ActivityRepodetailsBinding;
import com.xapo.githubrepos.service.model.Items;

public class RepoDetailActivity extends AppCompatActivity {
    private ActivityRepodetailsBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Items item = getIntent().getExtras().getParcelable("ItemObj");

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(item !=null ? item.getName(): "");
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_repodetails);
        if(item != null) {
            binding.setItems(item);
            Glide.with(this).load(item.getOwner().getAvatar_url()).into(binding.avtar);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
