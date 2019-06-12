package com.xapo.githubrepos.view.callback;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.xapo.githubrepos.service.model.Items;
import com.xapo.githubrepos.view.ui.RepoDetailActivity;

public class OnClickCallback {
    public void onClick(View view, Items items){
        Context mContext = view.getContext();
        Intent intent = new Intent(mContext, RepoDetailActivity.class);
        intent.putExtra("ItemObj", items);
        mContext.startActivity(intent);
    }
}
