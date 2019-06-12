package com.xapo.githubrepos.view.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xapo.githubrepos.R;
import com.xapo.githubrepos.databinding.FragmentRepolistBinding;
import com.xapo.githubrepos.service.model.Items;
import com.xapo.githubrepos.view.adapter.RepoItemAdapter;
import com.xapo.githubrepos.viewmodel.ItemViewModel;

public class RepolistFragment extends Fragment {
    private RepoItemAdapter adapter;
    private FragmentRepolistBinding binding;
    private Context mContext;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_repolist, container, false);
        adapter = new RepoItemAdapter(mContext);
        binding.reposList.setAdapter(adapter);
        binding.setIsLoading(true);
        return binding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // getting ItemViewModel
        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        observeItemViewModel(itemViewModel);
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * Observe RepoItem data and set to adapter
     *
     * @param itemViewModel
     */
    private void observeItemViewModel(ItemViewModel itemViewModel) {
        // When a new page is available, we call submitList() method of the PagedListAdapter class
        itemViewModel.getItemLiveData().observe(this, new Observer<PagedList<Items>>() {
            @Override
            public void onChanged(@Nullable PagedList<Items> items) {
                if (items != null) {
                    binding.setIsLoading(false);
                    adapter.submitList(items);
                }
            }
        });
        binding.reposList.setAdapter(adapter);
    }

}
