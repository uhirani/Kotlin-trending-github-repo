package com.xapo.githubrepos.view.adapter;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.xapo.githubrepos.R;
import com.xapo.githubrepos.databinding.RepolistItemBinding;
import com.xapo.githubrepos.service.model.Items;
import com.xapo.githubrepos.view.callback.OnClickCallback;

import java.util.List;

public class RepoItemAdapter extends PagedListAdapter<Items, RepoItemAdapter.ViewHolder> {

    private Context mContext;
    private List<? extends Items> repoList;

    public RepoItemAdapter(Context context){
        super(DIFF_CALLBACK);
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RepolistItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.repolist_item, parent, false);
        binding.setCallback(new OnClickCallback());
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Items item = getItem(position);
        if(item != null)
        {
            holder.binding.setItems(item);
            Glide.with(mContext)
                    .load(item.getOwner().getAvatar_url())
                    .into(holder.binding.userAvtar);
        }else{
            holder.binding.invalidateAll();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final RepolistItemBinding binding;

        public ViewHolder(@NonNull RepolistItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    private static DiffUtil.ItemCallback<Items> DIFF_CALLBACK =
        new DiffUtil.ItemCallback<Items>() {
            @Override
            public boolean areItemsTheSame(Items oldItem, Items newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(Items oldItem, Items newItem) {
                return oldItem.equals(newItem);
            }
        };

}
